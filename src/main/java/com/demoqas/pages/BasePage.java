package com.demoqas.pages;

import com.demoqas.drivers.DriverManager;
import com.demoqas.helper.DropdownHelper;
import com.demoqas.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;
public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public WebElementActions webElementActions = new WebElementActions();



}
