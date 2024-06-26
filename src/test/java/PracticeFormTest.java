import com.demoqas.entities.PracticeFormEntity;
import com.demoqas.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;

import static com.demoqas.enums.Endpoints.*;

public class PracticeFormTest extends BaseTest {
    @Test(groups = {"Regression", "UI", "0405"}, description = "Verify double click button is working propertly")
    @Owner("Alejandro")
    @Tag("Regression")
    @Severity(SeverityLevel.NORMAL)
    @Story("GCPINT-0405")
    @Epic("PracticeFormTest")
    @Link("www.demoqa.com")
    public void testFormFill() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL")+ PRACTICE.getEndpoint());
        PracticeFormEntity practiceFormEntity = randomUtils.generateRandomPracticeFormEntity();
        demoQAPages.getPracticeFormPage().fillForm(practiceFormEntity);

    }
}
