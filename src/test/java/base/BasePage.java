package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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



    public String getText(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getText();
    }

    public boolean isDisplayed(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).isDisplayed();
    }

    public void clearAndSendKeys(By locator, String value) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).clear();

        wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        ).sendKeys(value);
    }
}