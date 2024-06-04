package com.demoqas.helper;
import com.demoqas.drivers.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class WebElementActions {

    public Actions actions = new Actions(DriverManager.getDriver());

    @BeforeClass(alwaysRun = true)
    public void init(){
        actions = new Actions(DriverManager.getDriver());
    }

    public WebElementActions click(WebElement element){
        waitElementToBeClickAble(element);
        scrollToElement(element);
        highLightElement(element);
        element.click();
        return this;

    }

    public WebElementActions sendKeys(WebElement element, String txt){
        waitElementToBeClickAble(element);
        scrollToElement(element);
        highLightElement(element);
        element.sendKeys(txt);
        return this;

    }
    public WebElementActions sendKeysWithEnter(WebElement element, String txt){
        waitElementToBeClickAble(element);
        scrollToElement(element);
        element.sendKeys(txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }


    public WebElementActions waitElementToBeClickAble(WebElement element){
        new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public WebElementActions waitElementToBeVisible(WebElement element){
        new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(element));
        return this;
    }
    public WebElementActions scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);
        return this;
    }

    public WebElementActions jsClick(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript( "arguments[0].click();",element);
        return this;
    }
    public WebElementActions highLightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        return this;
    }

    public WebElementActions jsSendKeys(WebElement element, String txt){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value = arguments[1];" ,element, txt);
        return this;

    }

    public WebElementActions jsSendKeysWithEnter(WebElement element, String txt){
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].value = arguments[1];" ,element, txt);
        element.sendKeys(Keys.ENTER);
        return this;
    }
    public WebElementActions doubleClick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.doubleClick(element).perform();
        return this;
    }

    public WebElementActions rightclick(WebElement element){
        waitElementToBeVisible(element);
        waitElementToBeClickAble(element);
        actions.contextClick(element).perform();
        return this;
    }

    public WebElementActions moveToElement(WebElement element){
        waitElementToBeVisible(element);
        actions.moveToElement(element).perform();
        return this;
    }

    public WebElementActions moveToElementAndClick(WebElement element){
        waitElementToBeVisible(element);
        actions.moveToElement(element).click().perform();
        return this;
    }
}



