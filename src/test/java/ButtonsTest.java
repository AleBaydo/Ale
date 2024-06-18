import com.demoqas.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;

import org.testng.Assert;
import org.testng.annotations.Test;

import static com.demoqas.enums.Endpoints.ALERT;

public class ButtonsTest extends BaseTest {

    @Test(description = "Verify double click button is working propertly")
    @Owner("Alejandro")
    @Tag("Smoke")
    @Severity(SeverityLevel.CRITICAL)
    @Story("GCPINT-0401")
    @Epic("Buttons")
    @Link("www.google.com")

    public void doubleClickTest(){
        browserHelper.open(ConfigReader.getValue("baseURL")+ ALERT.getEndpoint());
        webElementActions.doubleClick(demoQAPages.getButtonsPage().doubleClickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().doubleClickMessage.getText(),"You have done a double click");

    }

    @Test(description = "Verify right click button is work propertly")
    public void rightclickTest(){
        browserHelper.open(ConfigReader.getValue("baseURL")+ ALERT.getEndpoint());
        webElementActions.rightclick(demoQAPages.getButtonsPage().rightClickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().rightClickMessage.getText(),"You have done a right click");

    }
    /**
     * Тест проверяет корректность работы кнопки "Click".
     * <p>
     * Открывает страницу с кнопками, выполняет клик по кнопке и проверяет сообщение о клике.
     * </p>
     */
    @Test(description = "Verify click button is work propertly")
    public void clickTest(){
        browserHelper.open(ConfigReader.getValue("baseURL")+ ALERT.getEndpoint());
        webElementActions.click(demoQAPages.getButtonsPage().clickBtn);
        Assert.assertEquals(demoQAPages.getButtonsPage().clickMessage.getText(),"You have done a dynamic click");

}

}