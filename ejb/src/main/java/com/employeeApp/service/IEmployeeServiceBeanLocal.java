package com.employeeApp.service;

import com.employeeApp.entity.Employee;
import com.employeeApp.entity.EDepartment;
import com.employeeApp.entity.EEmployeePosition;
import com.employeeApp.entity.EEmployeeStatus;

import java.util.Date;

/**
 * Created by AnaCris on junio/22/17.
 */
public interface IEmployeeServiceBeanLocal {

    public void updateEmployee(Employee employee , String firstName, String lastName, String country, Date dateOfBirth, EDepartment department, EEmployeePosition position, EEmployeeStatus status);
}
