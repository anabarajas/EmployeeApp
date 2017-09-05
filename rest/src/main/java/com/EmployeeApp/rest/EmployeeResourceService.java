package com.EmployeeApp.rest;

import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.Employee;
import com.employeeApp.service.EmployeeServiceBean;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    public List<EmployeeRepresentation> getAllEmployees() {
         return employeeManagerBean.findAllEmployees()
                 .stream()
                 .map(EmployeeRepresentationConverter::getEmployeeRepresentationFromEmployee)
                 .collect(Collectors.toList());
    }

    public EmployeeRepresentation getEmployeeById(Long id) {
        EmployeeRepresentation representation;
        Employee employee = employeeManagerBean.findById(id);
        if (employee != null) {
            representation = EmployeeRepresentationConverter.getEmployeeRepresentationFromEmployee(employee);
        } else {
            throw new WebApplicationException(Response.Status.NOT_FOUND); // TODO: change rerror message returned!
        }
        return representation;
    }

    public EmployeeRepresentation createEmployeeWithNewId(EmployeeRepresentation e) {
        Employee employee = employeeManagerBean.createEmployee(e.getFirstName(), e.getLastName(), e.getDateOfBirth(),
                e.getCountry(), e.getPosition(), e.getDepartment(), e.getStartDate());
        return EmployeeRepresentationConverter.getEmployeeRepresentationFromEmployee(employee);
    }

    public EmployeeRepresentation updateEmployeeById(Long currentEmployeeId, EmployeeRepresentation updatedRepresentation) {
        Employee updatedFieldsEmployee = EmployeeRepresentationConverter.getEmployeeFromEmployeeRepresentation(updatedRepresentation);
        Employee currentUpdatedEmployee = null;
        try {
            currentUpdatedEmployee = employeeServiceBean.updateEmployeeById(currentEmployeeId, updatedFieldsEmployee);
        } catch (Exception e) {
            LOG.log(Level.SEVERE,"EmployeeResourceBean::updateEmployee - Error while updating employee: {0}", new Object[]{e.getCause().getCause()});
            if (e.getCause().getCause() instanceof ConstraintViolationException){
                ConstraintViolationException cvx = (ConstraintViolationException) e.getCause().getCause();
                cvx.getConstraintViolations().forEach(err -> LOG.log(Level.SEVERE, err.getPropertyPath().toString(), err.getMessage()));
            }
        }
        return EmployeeRepresentationConverter.getEmployeeRepresentationFromEmployee(currentUpdatedEmployee);

    }

    public void deleteEmployeeById(Long id) {
        employeeServiceBean.removeEmployeeById(id);
    }
}