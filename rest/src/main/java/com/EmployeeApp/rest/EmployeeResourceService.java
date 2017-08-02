package com.EmployeeApp.rest;

import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.Employee;
import com.employeeApp.service.EmployeeServiceBean;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.ConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by abarajas on 6/22/17.
 */
public class EmployeeResourceService {

    private static final Logger LOG = Logger.getLogger(EmployeeResourceService.class.getName());
    private static String EMPLOYEE_MANAGER_BEAN_LOOK_UP_NAME = "java:global/employeeApp/ejb-1.0-SNAPSHOT/EmployeeManagerBean";
    private EmployeeManagerBean employeeManagerBean;
    private static String EMPLOYEE_SERVICE_BEAN_LOOK_UP_NAME = "java:global/employeeApp/ejb-1.0-SNAPSHOT/EmployeeServiceBean";
    private EmployeeServiceBean employeeServiceBean;


    public EmployeeResourceService() {
        try {
            employeeManagerBean = InitialContext.doLookup(EMPLOYEE_MANAGER_BEAN_LOOK_UP_NAME);
            employeeServiceBean = InitialContext.doLookup(EMPLOYEE_SERVICE_BEAN_LOOK_UP_NAME);
        } catch (NamingException e) {
            LOG.log(Level.WARNING, "EmployeeResourceService:: failed to lookup ejb's", e.getExplanation());
        }
    }

    public EmployeeRepresentation getEmployeeById(Long id) {
        Employee employee = employeeManagerBean.findById(id);
        EmployeeRepresentation representation = EmployeeRepresentationConverter.getEmployeeRepresentationFromEmployee(employee);
        return representation;
    }

    public EmployeeRepresentation createEmployeeWithNewId(EmployeeRepresentation e) {
        Employee employee = employeeManagerBean.createEmployee(e.getFirstName(), e.getLastName(), e.getDateOfBirth(),
                    e.getCountry(), e.getPosition(), e.getDepartment(), e.getStartDate());
        return EmployeeRepresentationConverter.getEmployeeRepresentationFromEmployee(employee);
    }

    public EmployeeRepresentation updateEmployeeById(Long currentEmployeeId, EmployeeRepresentation updatedRepresentation) {
        try{
            Employee updatedEmployee = EmployeeRepresentationConverter.getEmployeeFromEmployeeRepresentation(updatedRepresentation);
            employeeServiceBean.updateEmployeeById(currentEmployeeId, updatedEmployee);
        } catch (ConstraintViolationException e) {
            LOG.log(Level.SEVERE,"Exception: ");
            e.getConstraintViolations().forEach(err->LOG.log(Level.SEVERE,err.toString()));
        }

        return getEmployeeById(currentEmployeeId);
    }

}
