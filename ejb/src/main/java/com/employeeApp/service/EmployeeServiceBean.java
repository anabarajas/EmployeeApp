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
import java.io.Serializable;
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

    public Employee updateEmployeeById(Long id, Employee updatedFieldsEmployee) {
        Employee currentEmployee = employeeManagerBean.findById(id);
        employeeManagerBean.updateEmployee(currentEmployee, updatedFieldsEmployee.getFirstName(), updatedFieldsEmployee.getLastName(),
                updatedFieldsEmployee.getCountry(), updatedFieldsEmployee.getDateOfBirth(), updatedFieldsEmployee.getDepartment(),
                updatedFieldsEmployee.getPosition(), updatedFieldsEmployee.getStartDate(), updatedFieldsEmployee.getStatus());
        return currentEmployee;
    }


}
