import com.demoqas.entities.EmployeeEntity;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest extends BaseTest {
 @Test
    public void tes123(){
   driver.get("https://demoqa.com/webtables");
  EmployeeEntity employeeEntity = randomUtils.createMockEmployee();
  demoQAPages.getWebTablePage().addNewEmployee(employeeEntity);
     List<EmployeeEntity> employeeEntities = demoQAPages.getWebTablePage().getEmployeesFromTable();
     for (EmployeeEntity employee: employeeEntities){
         System.out.println(employee);
     }
 }

}
