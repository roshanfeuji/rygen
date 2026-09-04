package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    By searchBar = By.cssSelector("input[placeholder='Search Domains']");
    By searchButton = By.cssSelector("button[aria-label='Submit Search']");
    By orderButton = By.xpath("//span[text()=\"Order\"]");
    By newOrderButton = By.xpath("//span[text()=\"New Order\"]");


    WebDriver driver;
    WebDriverWait wait;

    public DashboardPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void chooseDomain(String domain){
        wait.until(
                ExpectedConditions.elementToBeClickable(searchBar)
        ).sendKeys(domain);

        wait.until(
                ExpectedConditions.elementToBeClickable(searchButton)
        ).click();

        By list = By.xpath(
                "//div[@class='p-dialog p-component rygen-modal p-input-filled size-md change-domain-modal']//span[text()='"
                        + domain + "']"
        );

        wait.until(
                ExpectedConditions.elementToBeClickable(list)
        ).click();

        wait.until(
                ExpectedConditions.urlContains("/dashboard")
        );
    }

    public void createOrder() {
        wait.until(
                ExpectedConditions.elementToBeClickable(orderButton)
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(newOrderButton)
        ).click();

        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Cancel']"))
        ).click();


    }
}
