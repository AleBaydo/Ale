package com.demoqa.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NambaFood {

    WebDriver driver;
    Actions actions;
    String kitchensXpath = "//div[text()='%s']";

    @BeforeMethod
    public void OpenWeb() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @AfterMethod
    public void CloseWeb() {
        driver.close();
        driver.quit();

    }

    @Test
    void NambaFoodClick() throws InterruptedException {
        driver.get("https://nambafood.kg/");
        WebElement elementFood = driver.findElement(By.xpath("//a[normalize-space()='Еда']"));
        actions.moveToElement(elementFood).click().perform();
        WebElement CocaColakitchen = driver.findElement(By.xpath(String.format(kitchensXpath,"Coca-Cola")));
        actions.moveToElement(CocaColakitchen).click().perform();
        Thread.sleep(5000);
        driver.navigate().back();
        WebElement NationalKitchen = driver.findElement(By.xpath(String.format(kitchensXpath,"Национальная кухня")));
        actions.moveToElement(NationalKitchen).click().perform();
        Thread.sleep(5000);
    }


}
