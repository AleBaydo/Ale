package com.demoqas.pages;
import com.demoqas.drivers.DriverManager;
import com.demoqas.enums.OrangeTopBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class OrangeAdminPage extends BasePage {
    public WebElement getBar() {
            return DriverManager.getDriver().findElement(By.className("oxd-topbar-body-nav"));
        }
    public OrangeAdminPage clickMainMenu(OrangeTopBar menuItem) {
        WebElement menuBar = getBar();
        WebElement mainMenuItem = menuBar.findElement
                (By.xpath(".//li/span[contains(text(), '" + menuItem.getMenu() + "')]"));
        mainMenuItem.click();
        return this;
    }
    public OrangeAdminPage clickSubMenu(String subMenuItem) {
        WebElement subMenuItemElement = DriverManager.getDriver().findElement
                (By.xpath("//ul[@class='oxd-dropdown-menu']/li/a[contains(text(), '" + subMenuItem + "')]"));
        subMenuItemElement.click();
        return this;
    }

    
    public OrangeAdminPage clickRandomMenuAndSubMenu() {

        OrangeTopBar randomMainMenu = OrangeTopBar.getRandom();
        clickMainMenu(randomMainMenu);

        String[] subMenuItems = randomMainMenu.getSubMenu();

        if (subMenuItems != null && subMenuItems.length > 0) {
            Random random = new Random();
            String randomSubMenu = subMenuItems[random.nextInt(subMenuItems.length)];
            clickSubMenu(randomSubMenu);
        }

        return this;
    }

}

