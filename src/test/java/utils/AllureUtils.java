package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public final class AllureUtils {

    private AllureUtils() {
    }

    public static void step(String stepName, Runnable action) {
        Allure.step(stepName, action::run);
    }

    public static void attachScreenshot(WebDriver driver, String name) {
        if (driver == null) {
            return;
        }
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, "image/png", new ByteArrayInputStream(screenshot), ".png");
        } catch (Exception e) {
            Allure.addAttachment("Screenshot Capture Error", "text/plain", "Unable to capture screenshot: " + e.getMessage());
        }
    }

    public static void attachPageSource(WebDriver driver, String name) {
        if (driver == null) {
            return;
        }
        try {
            byte[] source = driver.getPageSource().getBytes(StandardCharsets.UTF_8);
            Allure.addAttachment(name, "text/html", new ByteArrayInputStream(source), ".html");
        } catch (Exception e) {
            Allure.addAttachment("Page Source Capture Error", "text/plain", "Unable to capture page source: " + e.getMessage());
        }
    }

    public static void attachText(String name, String content) {
        Allure.addAttachment(name, "text/plain", content);
    }

    public static void attachUrl(WebDriver driver) {
        if (driver == null) {
            return;
        }
        try {
            attachText("Current URL", driver.getCurrentUrl());
        } catch (Exception e) {
            attachText("Current URL", "Unable to get current URL: " + e.getMessage());
        }
    }

    public static void attachFailureDetails(
            WebDriver driver,
            Throwable throwable
    ) {
        attachScreenshot(driver, "Failure Screenshot");
        attachUrl(driver);
        attachPageSource(driver, "Failure Page Source");
        if (throwable != null) {
            attachText("Exception", throwable.toString());
        }
    }
}