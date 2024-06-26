
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test(groups = {"E2E", "UI", "1011"}, description = "Alert test")
    @Owner("Zhyldyz")
    @Tag("E2E")
    @Severity(SeverityLevel.NORMAL)
    @Story("1011")
    @Epic("Alerts")
    @Link("www.demoqa.com")
    void aLertTest() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        alertHelper.acceptAlert();

    }


}
