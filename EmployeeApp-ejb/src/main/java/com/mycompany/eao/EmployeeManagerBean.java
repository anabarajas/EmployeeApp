/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eao;

import com.mycompany.entity.Employee;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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
