import com.demoqas.entities.OrangeLoginEntity;
import com.demoqas.enums.OrangeSideBarMenuEnum;
import com.demoqas.utils.ConfigReader;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;



public class OrangePageTest extends BaseTest{
    @Test(groups = {"Smoke","UI","0406"}, description = "verify is admin select")
    @Owner("Alejandro")
    @Link("www.orangehrm.com")
    @Epic("OrangePageTest")
    @Story("GCPINT-0406")
    @Tag("Smoke")
    @Severity(SeverityLevel.NORMAL)

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
