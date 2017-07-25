package com.EmployeeApp.rest;

import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.Employee;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by abarajas on 6/22/17.
 */
public class EmployeeResourceService {

    private static Logger LOG = Logger.getLogger(EmployeeResourceService.class.getName());
    private static String LOOK_UP_NAME = "java:global/employeeApp/ejb/EmployeeManagerBean";
    private EmployeeManagerBean employeeManagerBean;


    public EmployeeResourceService() {
        try {
            employeeManagerBean = InitialContext.doLookup(LOOK_UP_NAME);
        } catch (NamingException e) {
            LOG.log(Level.WARNING, "EmployeeResourceService:: failed to lookup bean", e.getExplanation());
        }
    }

    public EmployeeRepresentation getEmployeeById(Long id) {
        Employee employee = employeeManagerBean.findById(id);
        EmployeeRepresentation representation = EmployeeRepresentationConverter.getEmployeeRepresentationByToken(employee);
        return representation;
    }



}
