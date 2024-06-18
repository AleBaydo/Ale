package com.demoqa.elements;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

public class FoodList {

    @Test
    void findFoodList(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://dostavka312.kg/category/11/38");

        WebElement EuropeanFood = driver.findElement(By.xpath("//div[@class='art-blockcontent']/parent::div/div[@class='art-blockcontent']" +
                "/div[@class='custom kafenew']/p[@style='text-align: center;'][3]/a[@href='https://dostavka312.kg/category/11/38']/span"));
        EuropeanFood.click();


        List<WebElement> foodList = driver.findElements(By.xpath("//div[@class='col-sm-6']/parent::div"));

        for (WebElement food:foodList){
            System.out.println(food.getText());
        }

        System.out.println("____________________________");
        System.out.println(foodList.size());


//        List<WebElement> muesliAndFruitsList = driver.findElements(By.xpath(""));
//        List<WebElement> croissants = driver.findElements(By.xpath(""));
    }
}