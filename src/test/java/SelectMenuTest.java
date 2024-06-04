import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectMenuTest extends BaseTest{

    @BeforeMethod
    void setUp2() {
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    void testSelect() {
        System.out.println("Select Value___");
        dropdownHelper.printSelect(demoQAPages.getSelectPage().selectValue, demoQAPages.getSelectPage().selectValueOptions);
    }

    @Test
    void testSelectOne() {
        System.out.println("Select One___");
        dropdownHelper.printSelect(demoQAPages.getSelectPage().selectOne, demoQAPages.getSelectPage().selectValueOptions);
    }

    @Test
    void testSelectOldStyle() {
        System.out.println("Old Style Select Menu___");
        dropdownHelper.printSelect2(demoQAPages.getSelectPage().oldSelectMenu);
    }

    @Test
    void testSelectMulti() {
        System.out.println("Multiselect drop down___");
        dropdownHelper.printSelect(demoQAPages.getSelectPage().selrctMultiselectDropDown, demoQAPages.getSelectPage().selectValueOptions);
    }

    @Test
    void testSelectStandart() {
        System.out.println("Standard multi select___");
        dropdownHelper.printSelect2(demoQAPages.getSelectPage().StandardMultiSelect);
    }
}
