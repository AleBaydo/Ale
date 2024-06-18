package com.demoqas.listener;

import com.demoqas.drivers.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            saveScreenshotPNG(driver);
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Hello OnStart");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Hello on TestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Hello onTestSuccess");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Hello onFinish");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Hello onTestSkipped");
    }
}
