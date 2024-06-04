import com.demoqas.drivers.DriverManager;
import com.demoqas.helper.AlertHelper;
import com.demoqas.helper.BrowserHelper;
import com.demoqas.helper.DropdownHelper;
import com.demoqas.helper.WebElementActions;
import com.demoqas.pages.DemoQAPages;
import com.demoqas.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected RandomUtils randomUtils;
    protected WebDriverWait wait;
    protected DemoQAPages demoQAPages;
    protected WebElementActions webElementActions;
    protected AlertHelper alertHelper;
    protected BrowserHelper browserHelper;
    protected DropdownHelper dropdownHelper;


    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = DriverManager.getDriver();
        randomUtils = new RandomUtils();
        webElementActions = new WebElementActions();
        alertHelper = new AlertHelper(driver);
        browserHelper = new BrowserHelper(driver);
        demoQAPages = new DemoQAPages();
        demoQAPages.setUp();
        dropdownHelper = new DropdownHelper(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
}

@AfterClass(alwaysRun = true)
    public void thearDown(){
        driver.close();
      driver.quit();
}

}