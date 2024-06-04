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
import org.testng.annotations.Test;
import java.time.Duration;

public class TextBoxButton {

    WebDriver driver;
    Actions actions;
    String SpanXpath = "//span[text()='%s']";
    @BeforeMethod
    public void OpenWeb(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @AfterMethod
    public void CloseWeb(){
        driver.quit();


    }

    @Test
    void TextBoxAuto() throws InterruptedException {

        driver.get("https://demoqa.com/");

        WebElement elements = driver.findElement(By.xpath("//h5[text()='Elements']"));
        actions.moveToElement(elements).click().perform();
        WebElement ChekBox = driver.findElement(By.xpath(String.format(SpanXpath,"Check Box")));
        actions.moveToElement(ChekBox).click().perform();
        WebElement ButtonCheck = driver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']"));
        actions.moveToElement(ButtonCheck).click().perform();
        WebElement DesktopCheck = driver.findElement(By.xpath("//label[@for='tree-node-desktop']"));
        actions.moveToElement(DesktopCheck).click().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='result']")));
        String resultText = resultElement.getText();

        Assert.assertTrue(resultText.contains("desktop"));
        Assert.assertTrue(resultText.contains("notes"));
        Assert.assertTrue(resultText.contains("commands"));

        WebElement ChekBox2 = driver.findElement(By.xpath("//label[@for='tree-node-documents']"));
        actions.moveToElement(ChekBox2).click().perform();


        resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='result']")));
        resultText = resultElement.getText();

        Assert.assertTrue(resultText.contains("desktop"));
        Assert.assertTrue(resultText.contains("notes"));
        Assert.assertTrue(resultText.contains("commands"));
        Assert.assertTrue(resultText.contains("documents"));
        Assert.assertTrue(resultText.contains("workspace"));
        Assert.assertTrue(resultText.contains("react"));
        Assert.assertTrue(resultText.contains("angular"));
        Assert.assertTrue(resultText.contains("veu"));
        Assert.assertTrue(resultText.contains("office"));
        Assert.assertTrue(resultText.contains("public"));
        Assert.assertTrue(resultText.contains("private"));
        Assert.assertTrue(resultText.contains("classified"));
        Assert.assertTrue(resultText.contains("general"));


        WebElement ChekBox3 = driver.findElement(By.xpath("//label[@for='tree-node-downloads']"));
        actions.moveToElement(ChekBox3).click().perform();

        resultElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='result']")));
        resultText = resultElement.getText();

        Assert.assertTrue(resultText.contains("desktop"));
        Assert.assertTrue(resultText.contains("notes"));
        Assert.assertTrue(resultText.contains("commands"));
        Assert.assertTrue(resultText.contains("documents"));
        Assert.assertTrue(resultText.contains("workspace"));
        Assert.assertTrue(resultText.contains("react"));
        Assert.assertTrue(resultText.contains("angular"));
        Assert.assertTrue(resultText.contains("veu"));
        Assert.assertTrue(resultText.contains("office"));
        Assert.assertTrue(resultText.contains("public"));
        Assert.assertTrue(resultText.contains("private"));
        Assert.assertTrue(resultText.contains("classified"));
        Assert.assertTrue(resultText.contains("general"));
        Assert.assertTrue(resultText.contains("downloads"));
        Assert.assertTrue(resultText.contains("wordFile"));
        Assert.assertTrue(resultText.contains("excelFile"));

        WebElement Button = driver.findElement(By.xpath("//button[@class='rct-option rct-option-collapse-all']"));
        actions.moveToElement(Button).click().perform();

        WebElement Button2 = driver.findElement(By.xpath("//button[@class='rct-option rct-option-expand-all']"));
        actions.moveToElement(Button2).click().perform();

        WebElement Button3 = driver.findElement(By.xpath("//label[@for='tree-node-home']"));
        actions.moveToElement(Button3).click().perform();

        WebElement Button4 = driver.findElement(By.xpath("//button[@class='rct-option rct-option-collapse-all']"));
        actions.moveToElement(Button4).click().perform();

    }

    }


