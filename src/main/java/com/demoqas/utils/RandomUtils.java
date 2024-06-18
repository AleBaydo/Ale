package com.demoqas.utils;

import com.demoqas.entities.EmployeeEntity;
import com.demoqas.entities.OrangeLoginEntity;
import com.demoqas.entities.PracticeFormEntity;
import com.demoqas.entities.TextBoxEntity;
import com.github.javafaker.Faker;

public class RandomUtils {

    Faker faker = new Faker();

    public TextBoxEntity generateRandomTextBoxEntity(){
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }

    public PracticeFormEntity generateRandomPracticeFormEntity() throws InterruptedException {
        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
       practiceFormEntity.setFirstName(faker.name().firstName());
       practiceFormEntity.setLastName(faker.name().lastName());
       practiceFormEntity.setEmail(faker.internet().emailAddress());
        practiceFormEntity.setMobileNumber(faker.phoneNumber().subscriberNumber(10));
        practiceFormEntity.setSubjects("Maths");
        practiceFormEntity.setSubjects2("Chemistry");
        practiceFormEntity.setUploadPicture("C:\\Users\\1\\Downloads\\TN.jpg");
       practiceFormEntity.setCurrentAddress(faker.address().fullAddress());
       return practiceFormEntity;

    }

    public EmployeeEntity createMockEmployee(){
        EmployeeEntity employee = new EmployeeEntity();
        employee.setFirstname(faker.name().firstName());
        employee.setLastname(faker.name().lastName());
        employee.setAge(faker.number().numberBetween(18,100));
        employee.setEmail(faker.internet().emailAddress());
        employee.setSalary(faker.number().numberBetween(1000000l,2000000000l));
        employee.setDepartment(faker.job().position());

        return employee;


    }
    public OrangeLoginEntity createOrangeLogin(){
        OrangeLoginEntity orange = new OrangeLoginEntity();
        orange.setUserName("Admin");
        orange.setPassword("admin123");
        return orange;
    }
}

