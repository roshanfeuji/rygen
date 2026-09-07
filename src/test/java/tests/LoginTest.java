package tests;

import base.BaseTest;
import data.OrderDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import page.DashboardPage;
import page.Login;
import page.LoginPage;
import page.OrdersPage;

import java.util.List;

public class LoginTest extends BaseTest {


    Login login1;
    LoginPage login2;
    DashboardPage dashboard;
    OrdersPage orders;


//    DataProvider
    @BeforeMethod
    public void initializePages() {
        login1 = new Login(driver, wait);
        login2 = new LoginPage(driver, wait);
        dashboard = new DashboardPage(driver, wait);
        orders = new OrdersPage(driver, wait);


    }

    @Test(dataProvider = "orderData", dataProviderClass = OrderDataProvider.class)
    public void login(List<String> data) throws InterruptedException {
        login1.enterUsername("3PLAdminUser");

        login1.clickContinue();

        login2.enterPassword("3plAdmin@2026");

        login2.clickSignIn();

        dashboard.chooseDomain("JCB");

        dashboard.createOrder();

        orders.createNewOrder(data);



        Thread.sleep(6000);
    }

//    @Test(dataProvider = "")
//    public void login(String username, String password){
//        login1.enterUsername(username);
//        login1.clickContinue();
//        login2.enterPassword(password);
//        login2.clickSignIn();
//    }



}
