/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.service;

import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.Employee;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolationException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnaCris
 */

@LocalBean
@Stateless
public class EmployeeServiceBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(EmployeeServiceBean.class.getName());

    @EJB
    private EmployeeManagerBean employeeManagerBean;

    public void removeEmployeeById(Long employeeId) {
        Employee currentEmployee = employeeManagerBean.findById(employeeId);
        if (currentEmployee != null) {
            employeeManagerBean.removeEmployee(currentEmployee);
        }
    }

    public Employee updateEmployeeById(Long currentEmployeeId, Employee updatedEmployee) {
        Employee currentEmployee = employeeManagerBean.findById(currentEmployeeId);
        try {
            if (currentEmployee != null) {
                employeeManagerBean.updateEmployee(currentEmployee, updatedEmployee.getFirstName(), updatedEmployee.getLastName(),
                        updatedEmployee.getCountry(), updatedEmployee.getDateOfBirth(), updatedEmployee.getDepartment(),
                        updatedEmployee.getPosition(), updatedEmployee.getStartDate(), updatedEmployee.getStatus());
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "EmployeeServiceBean:: error while updating employee {0}, error message: {1}", new Object[]{currentEmployee.getId(), ex.getMessage()});
        }
        return currentEmployee;
    }
}

