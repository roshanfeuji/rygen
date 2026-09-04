package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
     WebDriver driver;
     WebDriverWait wait;

    By username = By.cssSelector("input[placeholder='Enter your username or email address']");
    By continueButton = By.cssSelector("button[type='submit']");


    public Login(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void enterUsername(String user) {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(username)
        ).sendKeys(user);
    }

    public void clickContinue(){
        wait.until(
                ExpectedConditions.elementToBeClickable(continueButton)
        ).click();
    }
}
