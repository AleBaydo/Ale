import com.demoqas.pages.DemoQAPages;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ButtonsTest extends BaseTest {

    @Test(description = "Verify double click button is working propertly")
    public void doubleClickTest(){
        browserHelper.open("https://demoqa.com/buttons");
        webElementActions.doubleClick(demoQAPages.getButtonsPage().doubleClickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().doubleClickMessage.getText(),"You have done a double click");

    }

    @Test(description = "Verify right click button is work propertly")
    public void rightclickTest(){
        browserHelper.open("https://demoqa.com/buttons");
        webElementActions.rightclick(demoQAPages.getButtonsPage().rightClickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().rightClickMessage.getText(),"You have done a right click");

    }

    @Test(description = "Verify click button is work propertly")
    public void clickTest(){
        browserHelper.open("https://demoqa.com/buttons");
        webElementActions.click(demoQAPages.getButtonsPage().clickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().clickMessage.getText(),"You have done a dynamic click");

}
}