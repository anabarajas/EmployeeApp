/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.entity;

import java.util.Arrays;

/**
 *
 * @author AnaCris
 */
public enum EEmployeePosition {
    MANAGER("MANAGER"),
    ANALYST("ANALYST"),
    TECH_TEAM_LEAD("TECHNICAL TEAM LEAD"),
    PRODUCT_OWNER("PRODUCT OWNER"),
    JAVA_DEVELOPER("JAVA DEVELOPER"),
    QA("QA"),
    DEV_OPS("DEV OPS"),
    SUPERVISOR("SUPERVISOR"),
    COOP_DEVELOPER("COOP DEVELOPER"),
    COOP_QA("COOP QA");

    String name;

    EEmployeePosition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static EEmployeePosition getEEmployeePositionFromString(String stringName) {
        return Arrays.stream(EEmployeePosition.values()).filter(p -> p.getName().equalsIgnoreCase(stringName)).findFirst().orElse(null);
    }
}
