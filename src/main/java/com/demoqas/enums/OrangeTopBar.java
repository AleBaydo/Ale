package com.demoqas.enums;
import lombok.Getter;

import java.util.Random;

@Getter
public enum OrangeTopBar {
    USER_MANAGEMENT("User Management", new String[]{"Users"}),
    JOB("Job", new String[]{"Job Titles", "Pay Grades", "Employment Status", "Job Categories", "Work Shifts"}),
    ORGANIZATION("Organization",new String[]{"General Information", "Locations", "Structure"}),
    QUALIFICATIONS("Qualifications",new String[]{"Skills", "Education", "Licenses", "Languages", "Memberships"}),
    NATIONALITIES("Nationalities",new String[]{""}),
    CORPORATE_BRANDING("Corporate Branding",new String[]{""}),
    CONFIGURATION("Configuration", new String[]{"Email Configuration", "Email Subscriptions",
            "Localization", "Language Packages", "Modules","Social Media Authentication",
            "Register OAuth Client","LDAP Configuration"});

    private String Menu;
    private String[] SubMenu;

    OrangeTopBar (String menu, String[] subMenu){
        this.Menu = menu;
        this.SubMenu = subMenu;
    }
    public static OrangeTopBar getRandom() {
        Random random = new Random();
        OrangeTopBar[] values = OrangeTopBar.values();
        return values[random.nextInt(values.length)]; }
}
