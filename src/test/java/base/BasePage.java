package base;

import exceptions.ElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;

public class BasePage {
    protected By username = By.cssSelector("input[placeholder='Enter your username or email address']");
    protected By continueButton = By.cssSelector("button[type='submit']");
    protected By password =By.cssSelector("input[placeholder='Password']");
    protected By signIn = By.cssSelector("button[form='localAccountForm']");


    protected By searchBar = By.cssSelector("input[placeholder='Search Domains']");
    protected By searchButton = By.cssSelector("button[aria-label='Submit Search']");
    protected By orderButton = By.xpath("//span[text()='Order']");
    protected By newOrderButton = By.xpath("//span[text()='New Order']");


    protected By newOrder = By.cssSelector("a[href='/corsair/order/entry']");
    protected By createOrder = By.xpath("//button[contains(@aria-label,'Create Order') or .//span[contains(text(),'Create Order')]]");

    protected By companyLogo = By.cssSelector(".companyLogo");
    protected By navBar = By.cssSelector(".app-nav-top-container");
    protected By successPopUp = By.cssSelector(".p-toast-summary");
    protected By appLogo = By.cssSelector(".app-header-logo");
    protected By earlyPickUp = By.xpath("//div[@id='stop-1']//label[normalize-space()='Requested Earliest Pickup']/..//*[self::input]");
    protected By earlyDropOff = By.xpath("//div[@id='stop-2']//label[normalize-space()='Requested Earliest Dropoff']/..//*[self::input]");

    protected WebDriver driver;
    protected WebDriverWait wait;




    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickAction(By locator) {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

        } catch ( TimeoutException | ElementClickInterceptedException  e) {
            throw new ElementException("Failed to click the element "+locator,e);
        }


    }

    public void sendKeyAction(By locator, Object value) {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch(TimeoutException | ElementClickInterceptedException e){
            throw new ElementException("Failed to click the element"+locator, e);
        }

        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
            wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(String.valueOf(value));
        }
        catch (TimeoutException | ElementClickInterceptedException e){
            throw new ElementException("Failed to pass the keys inside the element"+locator, e);
        }


    }

    public void dropDowns(String field, String values, String str) {
        By a = By.xpath("//*[@id='" + field + "']//label[normalize-space()='" + values + "']/..//*[self::span]");
        By b = By.xpath("//*[@id='" + field + "']//label[normalize-space()='" + values + "']/..//*[self::input]");
        By c = By.xpath("//div[@class='p-select-list-container']//li[1]");
        clickAction(a);
        sendKeyAction(b, str);
        clickAction(c);
    }

    public void selectDate(){
        LocalDate today = LocalDate.now();
        String day = String.valueOf(today.getDayOfMonth());
        By date = By.xpath(
                "//td[@aria-label='" + day + "']/span"
        );
        clickAction(earlyPickUp);
        clickAction(date);
    }

    public void selectFutureDate(){
        LocalDate today = LocalDate.now().plusDays(4);
        String day = String.valueOf(today.getDayOfMonth());
        By date = By.xpath(
                "//td[@aria-label='" + day + "']/span"
        );
        clickAction(earlyDropOff);
        clickAction(date);
    }
    public void scrollIntoView(By locator) {

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", element);
    }

    public boolean isDisplayed(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }


}