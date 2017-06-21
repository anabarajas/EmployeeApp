/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.eao.IEmployeeManagerBeanLocal;
import com.mycompany.entity.EDepartment;
import com.mycompany.entity.EEmployeePosition;
import com.mycompany.entity.EEmployeeStatus;
import com.mycompany.entity.Employee;

import javax.ejb.EJB;
import java.util.Date;

/**
 *
 * @author AnaCris
 */
public class EmployeeServiceBean {

    @EJB
    IEmployeeManagerBeanLocal employeeManagerBean;

    public void updateEmployee(Employee employee , String firstName, String lastName, String country, Date dateOfBirth, EDepartment department, EEmployeePosition position, EEmployeeStatus status) {
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setCountry(country);
        employee.setDateOfBirth(dateOfBirth);
        employee.setDepartment(department);
        employee.setPosition(position);
        employee.setStatus(status);
        employeeManagerBean.edit(employee);
    }
}
