package com.employeeApp.service;

import com.employeeApp.entity.Employee;

import javax.ejb.Local;

/**
 * Created by AnaCris on junio/22/17.
 */
@Local
public interface IEmployeeServiceBeanLocal {

    public String removeEmployee(Employee e);
}
