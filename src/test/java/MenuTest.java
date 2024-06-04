import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest extends BaseTest {

    @Test(description = "Verify move to element methods is working")
    public void MoveToElementTest() throws InterruptedException {
        browserHelper.open("https://demoqa.com/menu");
        webElementActions.moveToElement(demoQAPages.getMenuPage().mainItem2);
        webElementActions.moveToElement(demoQAPages.getMenuPage().sublist);
        webElementActions.moveToElementAndClick(demoQAPages.getMenuPage().subItem2);

    }

}
