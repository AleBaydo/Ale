package com.demoqas.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SelectPage extends BasePage{

        @FindBy(xpath = "//div[text()='Select Option']")
        public WebElement selectValue;

        @FindBy(xpath = "//div[contains(@class,'option')]")
        public List<WebElement> selectValueOptions;

        @FindBy(id = "selectOne")
        public WebElement selectOne;

        @FindBy(xpath = "//div[text() =  'Select...']")
        public WebElement selrctMultiselectDropDown;

        @FindBy (id = "oldSelectMenu")
        public WebElement oldSelectMenu;

        @FindBy (id = "cars")
        public WebElement StandardMultiSelect;

    }

