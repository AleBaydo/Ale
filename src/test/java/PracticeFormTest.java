import com.demoqas.entities.PracticeFormEntity;
import com.demoqas.utils.ConfigReader;
import org.testng.annotations.Test;

import static com.demoqas.enums.Endpoints.*;

public class PracticeFormTest extends BaseTest {
    @Test
    public void testFormFill() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL")+ PRACTICE.getEndpoint());
        PracticeFormEntity practiceFormEntity = randomUtils.generateRandomPracticeFormEntity();
        demoQAPages.getPracticeFormPage().fillForm(practiceFormEntity);

    }



}
