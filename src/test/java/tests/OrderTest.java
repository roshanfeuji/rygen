package tests;

import base.BaseTest;
import data.OrderDataProvider;
import org.testng.annotations.*;
import page.DashboardPage;
import page.LoginPage;
import page.OrdersPage;

import java.util.List;

public class OrderTest extends BaseTest {

    LoginPage login;
    DashboardPage dashboard;
    OrdersPage orders;


    @BeforeMethod
    public void initializePages() {
        login = new LoginPage(driver, wait);
        dashboard = new DashboardPage(driver, wait);
        orders = new OrdersPage(driver, wait);


    }

    @Test(dataProvider = "orderData", dataProviderClass = OrderDataProvider.class)
    public void login(List<String> data) throws InterruptedException {
        login.handleLogin();
        dashboard.handleDashboard();
        orders.createNewOrder(data);
//        Thread.sleep(6000);
    }




}
