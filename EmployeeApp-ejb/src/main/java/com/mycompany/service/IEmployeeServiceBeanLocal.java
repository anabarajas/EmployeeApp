package com.mycompany.service;

import com.mycompany.entity.EDepartment;
import com.mycompany.entity.EEmployeePosition;
import com.mycompany.entity.EEmployeeStatus;
import com.mycompany.entity.Employee;

import java.util.Date;

/**
 * Created by AnaCris on junio/22/17.
 */
public interface IEmployeeServiceBeanLocal {

    public void updateEmployee(Employee employee , String firstName, String lastName, String country, Date dateOfBirth, EDepartment department, EEmployeePosition position, EEmployeeStatus status);
}
