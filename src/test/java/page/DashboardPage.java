package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }
    public void handleDashboard(){
        chooseDomain("JCB");
        Assert.assertTrue(navBarLogo(), "Page didn't load properly");
        Assert.assertTrue(isNavBarLocated(), "Nav bar is not located");
        createOrder();
    }
    public void chooseDomain(String domain){
        sendKeyAction(searchBar, domain);
        clickAction(searchButton);
        By list = By.xpath(
                "//div[@class='p-dialog p-component rygen-modal p-input-filled size-md change-domain-modal']//span[text()='" + domain + "']"
        );
        clickAction(list);
        wait.until(ExpectedConditions.urlContains("/dashboard"));
    }

    public void createOrder(){
        clickAction(orderButton);
        clickAction(newOrderButton);
        clickAction(By.xpath("//span[text()='Cancel']"));
    }

    public boolean isNavBarLocated(){
        return isDisplayed(navBar);
    }

    public boolean navBarLogo(){
        return isDisplayed(appLogo);
    }
}
