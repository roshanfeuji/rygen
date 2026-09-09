package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);

    }
    public void handleLogin(){
        Assert.assertTrue(corsairLogo(), " The login page didn't load properly");
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
    public boolean corsairLogo(){
        return isDisplayed(companyLogo);
    }

}
