package com.demoqas.pages;

import com.demoqas.entities.PracticeFormEntity;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static com.demoqas.drivers.DriverManager.getDriver;

public class PracticeFormPage extends BasePage {

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(xpath = "//label[text()='Male']")
    private WebElement genderMaleInput;

    @FindBy(xpath = "//label[text()='Female']")
    private WebElement genderFemaleInput;

    @FindBy(xpath = "//label[text()='Other']")
    private WebElement genderOtherInput;

    @FindBy(id = "userNumber")
    private WebElement mobileNumberInput;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthInput;

    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearSelect;

    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthSelect;

    @FindBy(className = "react-datepicker__day")
    private List<WebElement> dayOptions;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(xpath = "//label[text()='Sports']")
    private WebElement hobbiesSportsInput;

    @FindBy(xpath = "//label[text()='Reading']")
    private WebElement hobbiesReadingInput;

    @FindBy(xpath = "//label[text()='Music']")
    private WebElement hobbiesMusicInput;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPictureInput;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    private WebElement SelectStateInput;

    @FindBy(id = "react-select-4-input")
    private WebElement SelectCityInput;

    @FindBy(id = "submit")
    private WebElement submitButtonInput;

    @FindBy(id = "closeLargeModal")
    private WebElement closeLargeInput;

    private String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    private String[][] cities = {
            {"Delhi", "Gurgaon", "Noida"},
            {"Agra", "Lucknow", "Merrut"},
            {"Karnal", "Panipat"},
            {"Jaipur", "Jaiselmer"}
    };

    public PracticeFormPage fillForm(PracticeFormEntity practiceFormEntity) throws InterruptedException {
        webElementActions.sendKeys(firstNameInput, practiceFormEntity.getFirstName())
                .sendKeys(lastNameInput, practiceFormEntity.getLastName())
                .sendKeys(emailInput, practiceFormEntity.getEmail())
                .click(getRandomGenderInput())
                .sendKeys(mobileNumberInput, practiceFormEntity.getMobileNumber())
                .click(dateOfBirthInput)
                .sendKeysWithEnter(subjectsInput, practiceFormEntity.getSubjects())
                .sendKeysWithEnter(subjectsInput, practiceFormEntity.getSubjects2())
                .jsClick(getRandomHobbiesInput())
                .sendKeys(uploadPictureInput, practiceFormEntity.getUploadPicture())
                .sendKeys(currentAddressInput, practiceFormEntity.getCurrentAddress());

        selectRandomDate();
        String randomState = getRandomState();
        webElementActions.sendKeysWithEnter(SelectStateInput, randomState);
        String randomCity = getRandomCityForState(randomState);
        webElementActions.sendKeysWithEnter(SelectCityInput, randomCity);
        webElementActions.click(submitButtonInput);
        Thread.sleep(10000);
        webElementActions.click(closeLargeInput);
        Thread.sleep(3000);
        return this;
    }

    private void selectRandomDate() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        Select year = new Select(yearSelect);
        wait.until(ExpectedConditions.elementToBeClickable(yearSelect));
        List<WebElement> yearOptions = year.getOptions();
        WebElement randomYear = yearOptions.get(new Random().nextInt(yearOptions.size()));
        year.selectByVisibleText(randomYear.getText());

        Select month = new Select(monthSelect);
        wait.until(ExpectedConditions.elementToBeClickable(monthSelect));
        List<WebElement> monthOptions = month.getOptions();
        WebElement randomMonth = monthOptions.get(new Random().nextInt(monthOptions.size()));
        month.selectByVisibleText(randomMonth.getText());

        wait.until(ExpectedConditions.visibilityOfAllElements(dayOptions));
        List<WebElement> days = new ArrayList<>();
        for (WebElement day : dayOptions) {
            if (!day.getAttribute("class").contains("react-datepicker__day--outside-month")) {
                days.add(day);
            }
        }

        WebElement randomDay = days.get(new Random().nextInt(days.size()));
        wait.until(ExpectedConditions.elementToBeClickable(randomDay));
        randomDay.click();
    }

    private WebElement getRandomGenderInput() {
        WebElement[] genderInputs = {genderMaleInput, genderFemaleInput, genderOtherInput};
        int randomIndex = new Random().nextInt(genderInputs.length);
        return genderInputs[randomIndex];
    }

    private WebElement getRandomHobbiesInput() {
        WebElement[] hobbiesInputs = {hobbiesSportsInput, hobbiesReadingInput, hobbiesMusicInput};
        int randomIndex = new Random().nextInt(hobbiesInputs.length);
        return hobbiesInputs[randomIndex];
    }

    private String getRandomState() {
        Random random = new Random();
        int index = random.nextInt(states.length);
        return states[index];
    }

    private String getRandomCityForState(String state) {
        int stateIndex = -1;
        for (int i = 0; i < states.length; i++) {
            if (states[i].equals(state)) {
                stateIndex = i;
                break;
            }
        }

        if (stateIndex == -1) {
            return "";
        }

        String[] citiesForState = cities[stateIndex];
        Random random = new Random();
        int index = random.nextInt(citiesForState.length);
        return citiesForState[index];
    }

}
