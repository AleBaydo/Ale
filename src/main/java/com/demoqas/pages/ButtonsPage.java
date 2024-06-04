package com.demoqas.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage{
    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickBtn;
    @FindBy(id = "doubleClickMessage")
    public  WebElement doubleClickMessage;
    @FindBy(id = "rightClickBtn")
    public WebElement rightClickBtn;
    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;
    @FindBy(xpath = "//button[text()='Click Me']")
    public WebElement clickBtn;
    @FindBy(id = "dynamicClickMessage")
    public WebElement clickMessage;



}
