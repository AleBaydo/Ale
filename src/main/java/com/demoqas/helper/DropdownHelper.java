package com.demoqas.helper;

import com.demoqas.drivers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DropdownHelper {
    public WebDriver driver;
    WebElementActions webElementActions = new WebElementActions();
    public DropdownHelper(WebDriver driver){
        this.driver = driver;

    }

    public DropdownHelper selectByVisibleText(WebElement element, String value){
        Select select = new Select(element);
        select.selectByVisibleText(value);
        return this;

    }
    public DropdownHelper getAllselectedOptions(WebElement element){
        Select select = new Select(element);
        select.getAllSelectedOptions();
        return this;
}

    public void printSelect(WebElement element, List<WebElement> dropdownItems) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        webElementActions.waitElementToBeClickAble(element).click(element);
        ArrayList<String> itemList = new ArrayList<>();
        for (WebElement item : dropdownItems) {
            itemList.add(item.getText());
        }
        for (String text : itemList) {
            System.out.println("Option: " + text);
        }
    }

    public void printSelect2(WebElement element) {
        Select select = new Select(element);
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println("Option: " + option.getText());
        }

}


}
