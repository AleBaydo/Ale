import com.demoqas.enums.Endpoints;
import com.demoqas.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.demoqas.enums.Endpoints.ALERT;
import static com.demoqas.enums.Endpoints.DEMO;

public class SelectDemo extends BaseTest{
   @Test(groups = {"E2E", "UI", "0404"}, description = "Verify double click button is working propertl")
    @Owner("Alejandro")
    @Tag("E2E")
    @Severity(SeverityLevel.CRITICAL)
    @Story("GCPINT-0404")
    @Epic("Select")
    @Link("www.demoqa.com")

  void test123() throws InterruptedException {
      browserHelper.open(ConfigReader.getValue("baseURL")+ DEMO.getEndpoint());
      WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));
      dropdownHelper.getAllselectedOptions(selectMenu);
      System.out.println(selectMenu.getText());
      webElementActions.pause(4);
  }

}
