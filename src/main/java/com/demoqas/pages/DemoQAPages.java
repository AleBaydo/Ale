package com.demoqas.pages;
import lombok.*;
import org.testng.annotations.BeforeClass;


@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Builder
public class DemoQAPages {

        protected TextBoxPage textBoxPage;
        protected AlertPage alertPage;
        protected PracticeFormPage practiceFormPage;
        protected ButtonsPage buttonsPage;
        protected MenuPage menuPage;
        protected ProgressBarPage progressBarPage;
        protected SelectPage selectPage;
        protected WebTablePage webTablePage;
        protected OrangeLoginPage orangeLoginPage;
        protected OrangeAdminPage orangeAdminPage;

        @BeforeClass(alwaysRun = true)
        public void setUp() {
        textBoxPage = new TextBoxPage();
        alertPage = new AlertPage();
        practiceFormPage = new PracticeFormPage();
        buttonsPage = new ButtonsPage();
        menuPage = new MenuPage();
        progressBarPage = new ProgressBarPage();
        selectPage = new SelectPage();
        webTablePage = new WebTablePage();
        orangeLoginPage = new OrangeLoginPage();
        orangeAdminPage = new OrangeAdminPage();

         }
}