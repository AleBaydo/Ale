import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SelectDemo extends BaseTest{
  @Test
  void test123() throws InterruptedException {
      driver.get("https://demoqa.com/select-menu");
      WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));
      dropdownHelper.getAllselectedOptions(selectMenu);
      System.out.println(selectMenu.getText());
      Thread.sleep(4000);
  }

}
