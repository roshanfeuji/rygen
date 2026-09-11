package listeners;

import base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        Object instance = result.getInstance();
        if (instance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) instance;
            AllureUtils.attachScreenshot(baseTest.getDriver(), "Success Screenshot");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        if (instance instanceof BaseTest) {
            BaseTest baseTest = (BaseTest) instance;
            AllureUtils.attachFailureDetails(baseTest.getDriver(), result.getThrowable());
        }
    }
}