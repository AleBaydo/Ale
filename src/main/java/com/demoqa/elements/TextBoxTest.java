package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class TextBoxTest {

    WebDriver driver;

    @BeforeMethod
    public void openWeb() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeWeb() {
        driver.quit();
    }

    @Test(dataProvider = "BrowsTest")
    void textBoxTest(String url, String fullName, String email, String currentAddress, String permanentAddress) {
        driver.get(url);

        fillTextBox(By.id("userName"), fullName);
        fillTextBox(By.id("userEmail"), email);
        fillTextBox(By.id("currentAddress"), currentAddress);
        fillTextBox(By.id("permanentAddress"), permanentAddress);

        WebElement submitButton = driver.findElement(By.id("submit"));
        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).click().perform();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement outputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));

        String outputText = outputElement.getText();

        Assert.assertTrue(outputText.contains(fullName));
        Assert.assertTrue(outputText.contains(email));
        Assert.assertTrue(outputText.contains(currentAddress));
        Assert.assertTrue(outputText.contains(permanentAddress));
    }

    private void fillTextBox(By id, String fill) {
        WebElement element = driver.findElement(id);
        element.clear();
        element.sendKeys(fill);
    }

    @DataProvider
    public Object[][] BrowsTest() {
        return new Object[][]{
                {"https://demoqa.com/text-box", "Алихан", "alibaydolotov@gmail.com",
                        "Каракол, Кыргызстан", "Тельмана 45"}
        };
    }
}
