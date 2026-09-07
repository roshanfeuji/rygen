package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
    By searchBar = By.cssSelector("input[placeholder='Search Domains']");
    By searchButton = By.cssSelector("button[aria-label='Submit Search']");
    By orderButton = By.xpath("//span[text()=\"Order\"]");
    By newOrderButton = By.xpath("//span[text()=\"New Order\"]");



    public DashboardPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }
    public void handleDashboard(){
        chooseDomain("JCB");
        createOrder();
    }
    public void chooseDomain(String domain){
        sendKeyAction(searchBar, domain);
        clickAction(searchButton);
        By list = By.xpath(
                "//div[@class='p-dialog p-component rygen-modal p-input-filled size-md change-domain-modal']//span[text()='" + domain + "']"
        );
        clickAction(list);
        wait.until(
                ExpectedConditions.urlContains("/dashboard")
        );
    }

    public void createOrder() {
        clickAction(orderButton);
        clickAction(newOrderButton);
        clickAction(By.xpath("//span[text()='Cancel']"));
    }
}
