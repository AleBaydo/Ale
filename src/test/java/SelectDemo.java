
import com.demoqas.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import static com.demoqas.enums.Endpoints.DEMO;

public class SelectDemo extends BaseTest {

    @Test(groups = {"E2E_Test", "UI", "0403"}, description = "Verify double click button is working propertly")
    @Owner("Alejandro")
    @Tag("E2E_Test")
    @Severity(SeverityLevel.NORMAL)
    @Story("GCPINT-0403")
    @Epic("SelectDemo")
    @Link("www.demoqa.com")
    void test123() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL") + DEMO.getEndpoint());
        WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));
        dropdownHelper.getAllselectedOptions(selectMenu);
        System.out.println(selectMenu.getText());
        webElementActions.pause(4);
    }

}
