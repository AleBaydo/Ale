package com.demoqas.drivers;

import com.demoqas.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            switch (ConfigReader.getValue("browser").toLowerCase()){
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("You provided wrong Driver name");
            }
        }

        return driver;
    }

    public static void quitDriver(){
        try {
            if (driver != null){
              driver.close();
              driver.quit();
              driver=null;
            }
        }catch (Exception e){
            System.err.println("Error while closing driver");
        }

    }
}