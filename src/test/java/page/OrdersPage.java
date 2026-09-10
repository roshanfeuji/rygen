package page;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrdersPage extends BasePage {

    JavascriptExecutor js;
    public OrdersPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        js = (JavascriptExecutor) driver;

    }


    public void createNewOrder(List<String> data) {

        clickAction(newOrder);
        handleOriginDes(data);
        handleLineItem(data);
        fillBasicInformation(data);
        saveOrder();
        Assert.assertTrue(orderSuccessPopUp(),"Your order didn't get created, please enter mandatory fields");

    }
    public By dynamicTextX(String field, String values){
        return By.xpath("//div[@id='"+ field +"']//label[normalize-space()='"+values+"']/..//*[self::input]");
    }
    public By dynamicCommentX(String field, String values){
        return By.xpath("//*[@id='"+ field +"']//label[normalize-space()='"+values+"']/..//*[self::textarea]");
    }


    int dataIndex = 0;

    public void handleOriginDes(List<String> data){

        Map<String, List<String>> map = new LinkedHashMap<>();
        map.put("stop-1_content", Arrays.asList(
                "Location Name",
                "Address Line 1",
                "Address Line 2",
                "Address Line 3",
                "City",
                "Postal Code",
                "Location Code",
                "Contact Name",
                "Contact Email",
                "Company Name")
        );
        map.put("stop-2_content", Arrays.asList(
                "Location Name",
                "Address Line 1",
                "Address Line 2",
                "Address Line 3",
                "City",
                "Postal Code",
                "Location Code",
                "Contact Name",
                "Contact Email",
                "Company Name")
        );

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String temp = entry.getKey();
            List<String> fields = entry.getValue();
            for (String field : fields) {

                String value = data.get(dataIndex);

                By locator = dynamicTextX(temp, field);
                sendKeyAction(locator, value);
                dataIndex++;
            }
            sendKeyAction(dynamicCommentX(temp, "Internal Notes"), data.get(dataIndex));
            dataIndex++;
            sendKeyAction(dynamicCommentX(temp, "Carrier Special Instructions"), data.get(dataIndex));
            dataIndex++;
            if(temp.equals("stop-1_content")){
                selectDate();
            }
            else{
                selectFutureDate();
            }
            dropDowns(temp,"State", data.get(dataIndex));
            dataIndex++;



        }



    }

    public void handleLineItem(List<String> data){
        List<String> list = Arrays.asList(
                "Description",
                "Handling",
                "Weight",
                "Length",
                "Width",
                "Height",
                "Packaging",
                "NMFC Number",
                "Linear Feet",
                "Product Number",
                "Density",
                "Value",
                "Sales Order Number"
        );

        for(String i : list){
            By locator = dynamicTextX("line-item-num-1", i);
            String value = data.get(dataIndex);
            sendKeyAction(locator, value);
            dataIndex++;
        }
    }

    public void fillBasicInformation(List<String> data) {
        String field = "information";
        sendKeyAction(dynamicCommentX(field, "Internal Notes"),data.get(dataIndex));
        dataIndex++;
        sendKeyAction(dynamicCommentX(field, "Carrier Notes"),data.get(dataIndex));
        dataIndex++;
        dropDowns(field,"Direction", "Inbound");
        dataIndex++;
        dropDowns(field,"Billing Terms", data.get(dataIndex));
        dataIndex++;
        dropDowns(field,"Requested Mode", data.get(dataIndex));
        dataIndex++;
        dropDowns(field,"Equipment Type", data.get(dataIndex));
        dataIndex++;

    }
    public void saveOrder(){
        clickAction(createOrder);
    }

    public boolean orderSuccessPopUp(){
        return isDisplayed(successPopUp);
    }

}