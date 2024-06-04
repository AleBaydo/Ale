import com.demoqas.helper.WebElementActions;
import com.demoqas.pages.BasePage;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {

    @Test
    void aLertTest() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        webElementActions.click(demoQAPages.getAlertPage().confirmAlertBtn);
        alertHelper.acceptAlert();

    }


}
