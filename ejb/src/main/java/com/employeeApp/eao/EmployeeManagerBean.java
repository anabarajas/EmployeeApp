/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.eao;

import com.employeeApp.entity.*;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.validation.ConstraintViolationException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnaCris
 */
@LocalBean
@Stateless
public class EmployeeManagerBean implements Serializable {

    private static final Logger LOG = Logger.getLogger(EmployeeManagerBean.class.getName());

    @PersistenceContext(unitName = "EmployeeAppPU")
    private EntityManager em;

    public void removeEmployee(Employee e) throws RuntimeException {
       //Employee employeeToRemove = em.find(Employee.class, e.getId());
        Employee employeeToRemove = em.getReference(Employee.class, e.getId());
        em.remove(employeeToRemove);
        LOG.log(Level.INFO, "Removed employee {0} {1}, with id: {2}", new Object[]{e.getFirstName(), e.getLastName(), e.getId()});
    }

    public void updateEmployee(Employee employee , String firstName, String lastName, ECountry country, Date dateOfBirth, EDepartment department, EEmployeePosition position, Date startDate, EEmployeeStatus status) {
        try {
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setDateOfBirth(dateOfBirth);
            employee.setCountry(country);
            employee.setPosition(position);
            employee.setDepartment(department);
            employee.setStartDate(startDate);
            employee.setStatus(status);
            em.merge(employee);
            LOG.log(Level.INFO, "Employee {0} {1}, with id: {2} was updated!", new Object[]{employee.getFirstName(), employee.getLastName(), employee.getId()});
        } catch (Exception ex) {
            LOG.log(Level.WARNING, "EmployeeManagerBean::updateEmployee - Error while updating employee", ex.getMessage());
            if (ex instanceof ConstraintViolationException) {
                LOG.log(Level.SEVERE,"EmployeeManagerBean::updateEmployee - ConstraintViolationException: ");
                ConstraintViolationException cvx = (ConstraintViolationException) ex;
                cvx.getConstraintViolations().forEach(err->LOG.log(Level.SEVERE,err.toString()));
            }

        }
    }


    public Employee createEmployee(String firstName, String lastName, Date dateOfBirth, ECountry country, EEmployeePosition position, EDepartment department, Date startDate) {
        Employee e = new Employee();
        try {
            e.setFirstName(firstName);
            e.setLastName(lastName);
            e.setDateOfBirth(dateOfBirth);
            e.setCountry(country);
            e.setPosition(position);
            e.setDepartment(department);
            e.setStartDate(startDate);
            e.setStatus(determineNewEmployeeStatus(country));
            em.persist(e);
            em.flush();
            LOG.log(Level.INFO, "Created employee {0} {1}, with id: {2}", new Object[]{e.getFirstName(), e.getLastName(), e.getId()});
        } catch (Exception ex) {
            LOG.log(Level.WARNING, "EmployeeManagerBean::createEmployee - Error while creating Employee");
        }
        return e;
    }

    private EEmployeeStatus determineNewEmployeeStatus(ECountry country) {
        EEmployeeStatus employeeStatus;
        if (country == ECountry.US || country == ECountry.CA){
            employeeStatus = EEmployeeStatus.ACTIVE;
        } else {
            employeeStatus = EEmployeeStatus.PENDING;
        }
        return employeeStatus;
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
        Query q = em.createNamedQuery("Employee.findAll");
        return q.getResultList();
    }

    public Employee findById(Long id) {
        try {
            Query q = em.createNamedQuery("Employee.findById");
            q.setParameter("id", id);
            return (Employee) q.getSingleResult();
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, "EmployeeManagerBean::findById -" + "could not find an Employee with id: " + id.toString(), ex.getMessage());
            return null;
        }
    }

    public Employee findByFirstName(String firstName) {
        Query q = em.createNamedQuery("Employee.findByFirstName");
        q.setParameter("firstName", firstName);
        return (Employee) q.getSingleResult();

    }

    public Employee findByLastName(String lastName) {
        Query q = em.createNamedQuery("Employee.findByLastName");
        q.setParameter("lastName", lastName);
        return (Employee) q.getSingleResult();

    }

    public Employee findByDateOfBirth(Date dateOfBirth) {
        Query q = em.createNamedQuery("Employee.findByDateOfBirth");
        q.setParameter("dateOfBirth", dateOfBirth);
        return (Employee) q.getSingleResult();
    }

    public Employee findByCountry(String country) {
        Query q = em.createNamedQuery("Employee.findByCountry");
        q.setParameter("country", country);
        return (Employee) q.getSingleResult();
    }

    public Employee findByStatus(String status) {
        Query q = em.createNamedQuery("Employee.findByStatus");
        q.setParameter("status", status);
        return (Employee) q.getSingleResult();
    }

    public Employee findByPosition(String position) {
        Query q = em.createNamedQuery("Employee.findByPosition");
        q.setParameter("position", position);
        return (Employee) q.getSingleResult();
    }

    public Employee findByDepartment(String department) {
        Query q = em.createNamedQuery("Employee.findByDepartment");
        q.setParameter("department", department);
        return (Employee) q.getSingleResult();
    }

    public Employee findByStartDate(Date startDate) {
        Query q = em.createNamedQuery("Employee.findByStartDate");
        q.setParameter("startDate", startDate);
        return (Employee) q.getSingleResult();
    }
}
