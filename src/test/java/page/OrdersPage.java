package page;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class OrdersPage extends BasePage {

    By newOrder = By.cssSelector("a[href='/corsair/order/entry']");

    By addAcc1 = By.xpath("//div[@id='stop-1_content']//span[text()='Add Accessorial']");
    By lco = By.xpath("//div[@id='stop-1_content']//label[text()='Location Name']/..//*[self::input]");
    By adds = By.xpath("//div[@id='stop-1_content']//label[text()='Address Line 1']/following-sibling::div/input");
    By locCod = By.xpath("//div[@id='stop-1_content']//label[text()='Location Code']/following-sibling::div/input");
    By adl2 = By.xpath("//div[@id='stop-1_content']//label[text()='Address Line 2']/..//*[self::input]");
    By adl3 = By.xpath("//div[@id='stop-1_content']//label[text()='Contact Phone Number']/..//*[self::input] ");
    By lco2 = By.xpath("//div[@id='stop-2_content']//label[text()='Location Name']/following-sibling::div/input");
    By adds2 = By.xpath("//div[@id='stop-2_content']//label[text()='Address Line 1']/following-sibling::div/input");
    By locCod2 = By.xpath("//div[@id='stop-2_content']//label[text()='Location Code']/following-sibling::div/input");

    By a = By.xpath("//div[@id='stop-1_content']//label[text()='Requested Earliest Pickup']/..//*[self::input]");
    By b = By.xpath("//div[@id='stop-1_content']//label[text()='Carrier Special Instructions']/..//*[self::input]");
    By tz = By.xpath("//div[@id='stop-1_content']//label[text()='State']/..//*[self::span]");
    //By a = By.xpath("//div[@id='stop-1_content']//label[text()='Carrier Special Instructions']/..//*[self::span/input or self::input]");


    public OrdersPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public void createNewOrder() {

        clickAction(newOrder);
        List<String> list = Arrays.asList("Description", "Handling", "Weight", "Length", "Width", "Height","Value", "Product Number");

        for(String items : list){
            By loc = dynamicTextX(items);
            sendKeyAction(loc,10);
        }

        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='line-item-num-1']//label[text()='Stackable']/following-sibling::div/div/input")
                )
        );



//        sendKeyAction(adl2, "dvauv");
//        sendKeyAction(adl3 , "7981299691");
//        sendKeyAction(a , "09/09/2026 05:00 pm");
//
//        sendKeyAction(lco2, "dvauv");
//        sendKeyAction(adds2, "dvauv");
//        sendKeyAction(locCod2, "dvauv");
//        sendKeyAction(tz, "California");
//        sendKeyAction(lco, "dvauv");
//        sendKeyAction(adds, "dvauv");
//        sendKeyAction(locCod, "dvauv");
//
//
//        //sendKeyAction(b , "09/09/2026 05:00 pm");



    }
    public By dynamicTextX(String values){
        return By.xpath("//div[@id='line-item-num-1']//label[normalize-space()='"+values+"']/..//*[self::input]");
    }

    public void handleTextDropDown(){

    }

}