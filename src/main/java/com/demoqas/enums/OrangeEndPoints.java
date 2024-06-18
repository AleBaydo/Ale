package com.demoqas.enums;

import lombok.Getter;
public enum OrangeEndPoints {
    ORANGEADMIN("/web/index.php/auth/login");

    @Getter
    private final String endpoint;
    OrangeEndPoints(String endpoint){
        this.endpoint=endpoint;
    }

}
