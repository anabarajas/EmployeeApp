/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.eao;

import com.employeeApp.entity.Employee;
import com.employeeApp.entity.EDepartment;
import com.employeeApp.entity.EEmployeePosition;
import com.employeeApp.entity.EEmployeeStatus;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author AnaCris
 */
@Stateless
public class EmployeeManagerBean extends AbstractFacade<Employee> implements Serializable, IEmployeeManagerBeanLocal {

    private static final Logger LOG = Logger.getLogger(Employee.class.getName());

    @PersistenceContext(unitName = "EmployeeAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }



    public EmployeeManagerBean() {
        super(Employee.class);
    }


    public Employee createEmployee(String firstName, String lastName, Date dateOfBirth, String country, EEmployeePosition position, EDepartment department, Date startDate) {
        Employee e = new Employee();
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setDateOfBirth(dateOfBirth);
        e.setCountry(country);
        e.setPosition(position);
        e.setDepartment(department);
        e.setStartDate(startDate);
        e.setStatus(determineNewEmployeeStatus(country));
        super.create(e);
        return e;
    }

    private EEmployeeStatus determineNewEmployeeStatus(String country) {
        EEmployeeStatus employeeStatus;
        if (country.equals("United States")){
            employeeStatus = EEmployeeStatus.ACTIVE;
        } else {
            employeeStatus = EEmployeeStatus.PENDING;
        }
        return employeeStatus;
    }

    @Override
    public List<Employee> findAllEmployees() {
        Query q = em.createNamedQuery("Employee.findAll");
        return q.getResultList();
    }
    
    @Override
    public Employee findById(Long id) {
        Query q = em.createNamedQuery("Employee.findById");
        q.setParameter("id", id);
        return (Employee) q.getSingleResult();
        
    }
    
    @Override
    public Employee findByFirstName(String firstName) {
        Query q = em.createNamedQuery("Employee.findByFirstName");
        q.setParameter("firstName", firstName);
        return (Employee) q.getSingleResult();
        
    }
    
    @Override
    public Employee findByLastName(String lastName) {
        Query q = em.createNamedQuery("Employee.findByLastName");
        q.setParameter("lastName", lastName);
        return (Employee) q.getSingleResult();
        
    }
    
    @Override
     public Employee findByDateOfBirth(Date dateOfBirth) {
        Query q = em.createNamedQuery("Employee.findByDateOfBirth");
        q.setParameter("dateOfBirth", dateOfBirth);
        return (Employee) q.getSingleResult();
    }
     
    @Override
     public Employee findByCountry(String country) {
        Query q = em.createNamedQuery("Employee.findByCountry");
        q.setParameter("country", country);
        return (Employee) q.getSingleResult();
    }
     
    @Override
     public Employee findByStatus(String status) {
        Query q = em.createNamedQuery("Employee.findByStatus");
        q.setParameter("status", status);
        return (Employee) q.getSingleResult();
    }
     
    @Override
     public Employee findByPosition(String position) {
        Query q = em.createNamedQuery("Employee.findByPosition");
        q.setParameter("position", position);
        return (Employee) q.getSingleResult();
    }
     
    @Override
    public Employee findByDepartment(String department) {
        Query q = em.createNamedQuery("Employee.findByDepartment");
        q.setParameter("department", department);
        return (Employee) q.getSingleResult();
    }
    
    @Override
    public Employee findByStartDate(Date startDate) {
        Query q = em.createNamedQuery("Employee.findByStartDate");
        q.setParameter("startDate", startDate);
        return (Employee) q.getSingleResult();
    }
}