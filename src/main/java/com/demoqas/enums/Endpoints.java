package com.demoqas.enums;

import lombok.Getter;

public enum Endpoints {

    DEMO("/select-menu"),
    ALERT("/buttons"),
    PRACTICE("/automation-practice-form");

    @Getter
    private final String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }
}
