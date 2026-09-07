package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickAction(By locator) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).click();

    }

    public void sendKeyAction(By locator, Object value) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).clear();
        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).sendKeys(String.valueOf(value));
    }

    public void dropDowns(String field, String values, String str) {
        By a = By.xpath("//*[@id='" + field + "']//label[normalize-space()='" + values + "']/..//*[self::span]");
        By b = By.xpath("//*[@id='" + field + "']//label[normalize-space()='" + values + "']/..//*[self::input]");
        By c = By.xpath("//div[@class='p-select-list-container']//li[1]");
        clickAction(a);
        sendKeyAction(b, str);
        clickAction(c);
    }
    public void scrollIntoView(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'nearest'});",
                element
        );
    }


}