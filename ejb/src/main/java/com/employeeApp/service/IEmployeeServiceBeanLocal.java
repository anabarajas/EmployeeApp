package com.employeeApp.service;

import com.employeeApp.entity.Employee;

import javax.ejb.Local;
import java.io.Serializable;

/**
 * Created by AnaCris on junio/22/17.
 */
@Local
public interface IEmployeeServiceBeanLocal extends Serializable {

    public String removeEmployee(Employee e);
}
