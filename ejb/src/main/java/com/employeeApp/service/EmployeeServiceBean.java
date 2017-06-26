/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.service;

import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.Employee;
import com.employeeApp.eao.IEmployeeManagerBeanLocal;
import com.employeeApp.entity.EDepartment;
import com.employeeApp.entity.EEmployeePosition;
import com.employeeApp.entity.EEmployeeStatus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Date;

/**
 *
 * @author AnaCris
 */

@Stateless
public class EmployeeServiceBean implements IEmployeeServiceBeanLocal {

    @EJB
    EmployeeManagerBean employeeManagerBean;

    public void updateEmployee(Employee employee , String firstName, String lastName,
                               String country, Date dateOfBirth, EDepartment department,
                               EEmployeePosition position, EEmployeeStatus status) {
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
