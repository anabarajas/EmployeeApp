package com.EmployeeApp.rest;

import com.employeeApp.entity.Employee;

/**
 * Created by abarajas on 6/22/17.
 */
public class EmployeeResourceService {

    private EmployeeRepresentationConverter employeeRepresentationConverter;

//    @Inject
//    EmployeeManagerBean employeeManagerBean;


    public com.EmployeeApp.rest.EmployeeRepresentation getEmployeeById(Long id) {
        Employee employee = employeeManagerBean.findById(id);
        com.EmployeeApp.rest.EmployeeRepresentation representation = employeeRepresentationConverter.getEmployeeRepresentationByToken(employee);
        return representation;
    }



}
