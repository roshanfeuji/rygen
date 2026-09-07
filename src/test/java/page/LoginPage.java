package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    By username = By.cssSelector("input[placeholder='Enter your username or email address']");
    By continueButton = By.cssSelector("button[type='submit']");
    By password =By.cssSelector("input[placeholder='Password']");
    By signIn = By.cssSelector("button[form='localAccountForm']");

    public LoginPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);

    }
    public void handleLogin(){
        enterUsername("3PLAdminUser");
        clickContinue();
        enterPassword("3plAdmin@2026");
        clickSignIn();
    }
    public void enterUsername(String user) {
        sendKeyAction(username, user);
    }

    public void clickContinue(){
        clickAction(continueButton);
    }

    public void enterPassword(String pass){
        sendKeyAction(password, pass);
    }

    public void clickSignIn(){
        clickAction(signIn);

    }

}
