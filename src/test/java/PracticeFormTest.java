import com.demoqas.entities.PracticeFormEntity;
import org.testng.annotations.Test;

public class PracticeFormTest extends BaseTest {
    @Test
    public void testFormFill() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        PracticeFormEntity practiceFormEntity = randomUtils.generateRandomPracticeFormEntity();
        demoQAPages.getPracticeFormPage().fillForm(practiceFormEntity);

    }

}
