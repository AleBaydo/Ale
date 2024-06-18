package com.demoqas.pages;

import com.demoqas.drivers.DriverManager;
import com.demoqas.entities.EmployeeEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebTablePage extends BasePage {
    @FindBy(id = "addNewRecordButton")
    public WebElement addNewBtn;
    @FindBy(id = "firstName")
    public WebElement firstNameInput;
    @FindBy(id = "lastName")
    public WebElement lastNameInput;
    @FindBy(id = "age")
    public WebElement ageInput;
    @FindBy(id = "userEmail")
    public WebElement emailInput;
    @FindBy(id = "salary")
    public WebElement salaryInput;
    @FindBy(id = "department")
    public WebElement departmentInput;
    @FindBy(id = "submit")
    public WebElement submitBtn;

    public WebTablePage addNewEmployee(EmployeeEntity employee){
        webElementActions.click(addNewBtn)
                .sendKeys(firstNameInput,employee.getFirstname())
                .sendKeys(lastNameInput,employee.getLastname())
                .sendKeys(ageInput,String.valueOf(employee.getAge()))
                .sendKeys(emailInput, employee.getEmail())
                .sendKeys(salaryInput, String.valueOf(employee.getSalary()))
                .sendKeys(departmentInput,employee.getDepartment())
                .click(submitBtn);
        return this;

    }
    public ArrayList<EmployeeEntity> getEmployeesFromTable(){
        List<WebElement> rows = DriverManager.getDriver().findElements(By.cssSelector(".ReactTable .rt-tr-group"));
        ArrayList<EmployeeEntity> employees = new ArrayList<>();
        for (WebElement row : rows){
            List<WebElement> cells = row.findElements(By.cssSelector(".rt-td"));
            String firstName = cells.get(0).getText();
            String lastName = cells.get(1).getText();
            String ageText = cells.get(2).getText().replaceAll("[^0-9]", "");
            String email = cells.get(3).getText();
            String salaryText = cells.get(4).getText().replaceAll("[^0-9]","");
            String department = cells.get(5).getText();
            if (firstName.isEmpty() || lastName.isEmpty() || ageText.isEmpty() || email.isEmpty() ||
                    salaryText.isEmpty() || department.isEmpty()){
                continue;
            }

            int age = Integer.parseInt(ageText.trim());
            Long salary = Long.parseLong(salaryText.trim());

            employees.add(new EmployeeEntity(firstName,lastName,age,email,salary,department));


        }
        return employees;
    }

    public WebTablePage editEmployeeData(String email, EmployeeEntity newEmployeeData) throws InterruptedException {
        // Получаем всех сотрудников из таблицы
        List<EmployeeEntity> existingEmployees = getEmployeesFromTable();
        // Перебираем каждого сотрудника через цикл for с использованием индекса, чтобы найти сотрудника с заданным email
        for (int i = 0; i < existingEmployees.size(); i++) {
            // Если email сотрудника совпадает с переданным значением
            if (existingEmployees.get(i).getEmail().equals(email)) {
                // Находим кнопку редактирования для строки с соответствующим индексом
                WebElement editBtn = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                        .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#edit-record-" + i)));
                webElementActions.click(editBtn);
                // Заполняем форму новыми данными из объекта newEmployeeData, если поле не null
                if (newEmployeeData.getFirstname() != null) {
                    webElementActions.clearAndSendKeys(firstNameInput, newEmployeeData.getFirstname());
                }
                if (newEmployeeData.getLastname() != null) {
                    webElementActions.clearAndSendKeys(lastNameInput, newEmployeeData.getLastname());
                }
                if (newEmployeeData.getAge() != 0) {
                    webElementActions.clearAndSendKeys(ageInput, String.valueOf(newEmployeeData.getAge()));
                }
                if (newEmployeeData.getEmail() != null) {
                    webElementActions.clearAndSendKeys(emailInput, newEmployeeData.getEmail());
                }
                if (newEmployeeData.getSalary() != 0) {
                    webElementActions.clearAndSendKeys(salaryInput, String.valueOf(newEmployeeData.getSalary()));
                }
                if (newEmployeeData.getDepartment() != null) {
                    webElementActions.clearAndSendKeys(departmentInput, newEmployeeData.getDepartment());
                }
                // Нажимаем кнопку отправки, чтобы сохранить изменения
                webElementActions.click(submitBtn);
                // Прерываем цикл после нахождения и редактирования нужного сотрудника
                return this;
            }
        }
        // Если сотрудник с заданным email не найден, то выбрасываем исключение
        throw new IllegalArgumentException("Сотрудник с email " + email + " не найден.");
    }

}

