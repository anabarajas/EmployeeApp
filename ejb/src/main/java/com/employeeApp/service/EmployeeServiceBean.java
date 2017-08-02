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

    public void removeEmployee(Employee e) throws RuntimeException {
        employeeManagerBean.remove(e);
    }

    public void updateEmployeeById(Long currentEmployeeId, Employee updatedEmployee) {
        Employee currentEmployee = employeeManagerBean.findById(currentEmployeeId);
        try{
            employeeManagerBean.updateEmployee(currentEmployee, updatedEmployee.getFirstName(), updatedEmployee.getLastName(),
                updatedEmployee.getCountry(), updatedEmployee.getDateOfBirth(), updatedEmployee.getDepartment(),
                updatedEmployee.getPosition(), updatedEmployee.getStartDate(), updatedEmployee.getStatus());

        } catch (ConstraintViolationException e) {
            LOG.log(Level.SEVERE,"Exception: ");
            e.getConstraintViolations().forEach(err->LOG.log(Level.SEVERE,err.toString()));
        }
    }

}
