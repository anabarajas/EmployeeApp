/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.eao;

import com.employeeApp.entity.BackgroundCheck;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author AnaCris
 */
@Stateless
@LocalBean
public class BackgroundCheckManagerBean implements Serializable {

    @PersistenceContext(unitName = "EmployeeAppPU")
    private EntityManager em;

    public List<BackgroundCheck> findAllBackgroundChecks() {
        Query q = em.createNamedQuery("BackgroundCheck.findAll");
        return q.getResultList();
    }
    
    public BackgroundCheck findById(Integer id) {
        Query q = em.createNamedQuery("BackgroundCheck.findById");
        q.setParameter("id", id);
        return (BackgroundCheck) q.getSingleResult();
    }
    
    public BackgroundCheck findByStatus(String status) {
        Query q = em.createNamedQuery("BackgroundCheck.findByStatus");
        q.setParameter("status", status);
        return (BackgroundCheck) q.getSingleResult();
    }   
}