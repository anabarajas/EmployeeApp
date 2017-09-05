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
public enum EEmployeeStatus {
    ACTIVE("ACTIVE"),
    PENDING("PENDING"),
    DISABLED("DISABLED");

    String name;

    EEmployeeStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static EEmployeeStatus getEEmployeeStatusFromString(String stringName) {
        return Arrays.stream(EEmployeeStatus.values()).filter(s -> s.name.equalsIgnoreCase(stringName)).findAny().orElse(null);
    }
}
