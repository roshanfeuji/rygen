package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
     WebDriver driver;
     WebDriverWait wait;

    By password =By.cssSelector("input[placeholder='Password']");
    By signIn = By.cssSelector("button[form='localAccountForm']");

    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver=driver;
        this.wait= wait;

    }

    public void enterPassword(String pass){
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(password)
        ).sendKeys(pass);
    }

    public void clickSignIn(){
        wait.until(
                ExpectedConditions.elementToBeClickable(signIn)
        ).click();

    }

//    public void selectDomain(){
//        wait.until(
//                ExpectedConditions.
//        )
//    }
}
