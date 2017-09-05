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
public enum EDepartment {
    HR("HUMAN RESOURCES"),
    ACCOUNTING("ACCOUNTING"),
    SALES("SALES"),
    DEVELOPMENT("DEVELOPMENT"),
    QA("QUALITY ASSURANCE");

    String name;

    EDepartment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static EDepartment getEDepartmentFromString(String stringName) {
        return Arrays.stream(EDepartment.values()).filter(d -> d.name.equalsIgnoreCase(stringName)).findFirst().orElse(null);
    }
}
