import com.demoqas.entities.OrangeLoginEntity;
import com.demoqas.enums.OrangeSideBarMenuEnum;
import com.demoqas.utils.ConfigReader;
import org.testng.annotations.Test;

public class OrangePageTest extends BaseTest{

     @Test(groups = {"Smoke", "UI", "0406"}, description = "Thank you Star eje")
    @Owner("Alejandro")
    @Tag("Smoke")
    @Severity(SeverityLevel.CRITICAL)
    @Story("GCPINT-0406")
    @Epic("Orange")
    @Link("www.demoqa.com")
    public void OrangeFillFormTest(){

        browserHelper.open(ConfigReader.getValue("baseOrangeURL"));
        OrangeLoginEntity orangeLoginEntity = randomUtils.createOrangeLogin();
        demoQAPages.getOrangeLoginPage().fillForm(orangeLoginEntity);
        demoQAPages.getOrangeLoginPage().chooseSideBarMenu(OrangeSideBarMenuEnum.ADMIN);
        webElementActions.pause(5);
        demoQAPages.getOrangeAdminPage().clickRandomMenuAndSubMenu();
        webElementActions.pause(5);
    }
}
