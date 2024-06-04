package com.demoqas.pages;
import com.demoqas.entities.TextBoxEntity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class TextBoxPage extends BasePage {

    @FindBy(id = "userName")
    public WebElement fullNameInput;
    @FindBy(id = "userEmail")
    public WebElement emailInput;
    @FindBy(id = "currentAddress")
    public WebElement currentAddressInput;
    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressInput;

    @FindBy(id = "submit")
    public WebElement submitBtn;

    public TextBoxPage fillUpTextBoxForm(TextBoxEntity textBoxEntity){
        webElementActions.sendKeys(fullNameInput,textBoxEntity.getFullName())
                .jsSendKeys(emailInput,textBoxEntity.getEmail())
                .jsSendKeys(currentAddressInput,textBoxEntity.getCurrentAddress())
                .jsSendKeys(permanentAddressInput, textBoxEntity.getEmail())
                .click(submitBtn);
        return this;
    }

}
