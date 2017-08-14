/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.entity;

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
}
