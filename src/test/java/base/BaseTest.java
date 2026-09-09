package base;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://qa.rygen.com/corsair/");

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            dumpFailureArtifacts(result.getMethod().getMethodName());
        }
        driver.quit();
    }

    private void dumpFailureArtifacts(String testName) {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String dir = "target/failure-artifacts/";
        new File(dir).mkdirs();
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), new File(dir + testName + "_" + timestamp + ".png").toPath());
        } catch (Exception e) {
            System.err.println("Screenshot capture failed: " + e.getMessage());
        }
        try (PrintWriter out = new PrintWriter(dir + testName + "_" + timestamp + ".html")) {
            out.println(driver.getPageSource());
        } catch (Exception e) {
            System.err.println("Page source dump failed: " + e.getMessage());
        }
    }

}