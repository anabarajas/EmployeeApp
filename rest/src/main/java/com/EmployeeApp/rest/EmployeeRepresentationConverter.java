package com.EmployeeApp.rest;

import com.employeeApp.entity.Employee;

/**
 * Created by abarajas on 6/23/17.
 */
public class EmployeeRepresentationConverter {

    public static EmployeeRepresentation getEmployeeRepresentationFromEmployee(Employee e) {
        EmployeeRepresentation employeeRepresentation = null;
        if (e != null) {
            employeeRepresentation = new EmployeeRepresentation();
            employeeRepresentation.setId(e.getId());
            employeeRepresentation.setFirstName(e.getFirstName());
            employeeRepresentation.setLastName(e.getLastName());
            employeeRepresentation.setCountry(e.getCountry());
            employeeRepresentation.setDepartment(e.getDepartment());
            employeeRepresentation.setDateOfBirth(e.getDateOfBirth());
            employeeRepresentation.setPosition(e.getPosition());
            employeeRepresentation.setStartDate(e.getStartDate());
            employeeRepresentation.setStatus(e.getStatus());
        }
        return employeeRepresentation;
    }

    public static Employee getEmployeeFromEmployeeRepresentation(EmployeeRepresentation e) {
        Employee employee = new Employee();
        employee.setId(e.getId());
        employee.setFirstName(e.getFirstName());
        employee.setLastName(e.getLastName());
        employee.setCountry(e.getCountry());
        employee.setDateOfBirth(e.getDateOfBirth());
        employee.setDepartment(e.getDepartment());
        employee.setPosition(e.getPosition());
        employee.setStatus(e.getStatus());
        employee.setStartDate(e.getStartDate());
        return employee;
    }

}
