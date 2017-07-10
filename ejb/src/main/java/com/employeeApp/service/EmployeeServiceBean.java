/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.service;

import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.Employee;
import com.employeeApp.eao.IEmployeeManagerBeanLocal;
import com.employeeApp.entity.EDepartment;
import com.employeeApp.entity.EEmployeePosition;
import com.employeeApp.entity.EEmployeeStatus;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnaCris
 */

@Stateless
public class EmployeeServiceBean implements IEmployeeServiceBeanLocal {

    private static final Logger LOG = Logger.getLogger(EmployeeServiceBean.class.getName());

    @PersistenceContext(unitName = "EmployeeAppPU")
    private EntityManager em;

    @EJB
    private IEmployeeManagerBeanLocal employeeManagerBean;

    public String removeEmployee(Employee e) {
        try{
            employeeManagerBean.remove(e);
            return "delete?faces-redirect=true";
        } catch (Exception ex) {
            LOG.log(Level.WARNING, "EmployeeServiceBean::remove - Error while removing employee {0} {1} with id: {2}", new Object[]{e.getFirstName(), e.getLastName(), e.getId()});
            return "failure?faces-redirect=true";
        }
    }
}
