package com.demoqas.pages;

import com.demoqas.drivers.DriverManager;
import com.demoqas.entities.OrangeLoginEntity;
import com.demoqas.enums.OrangeSideBarMenuEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrangeLoginPage extends BasePage{
    @FindBy(xpath = "//input[@placeholder='Username']")

    private WebElement userNameInput;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(className = "oxd-sidepanel-body")
    public WebElement sidePanelBody;

    public OrangeLoginPage fillForm(OrangeLoginEntity orangeLoginEntity){
        webElementActions.sendKeys(userNameInput, orangeLoginEntity.getUserName())
                .sendKeys(passwordInput,orangeLoginEntity.getPassword())
                .click(loginButton);

        return this;
    }

    public void chooseSideBarMenu(OrangeSideBarMenuEnum sideBarMenuName){

        sidePanelBody.findElement(By.xpath("//ul/li"));
        WebElement element = DriverManager.getDriver().findElement(By.xpath(
                "//ul[@class='oxd-main-menu']/li/a/span[text()= '"
                + sideBarMenuName.getMenu() + "']"));
        element.click();
        //div[@class='oxd-sidepanel-body']/ul/li/a/span[text()='Leave']

    }
}
