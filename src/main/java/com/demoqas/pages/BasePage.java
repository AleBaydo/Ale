package com.demoqas.pages;

import com.demoqas.drivers.DriverManager;
import com.demoqas.helper.WebElementActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public WebElementActions webElementActions = new WebElementActions();

}
