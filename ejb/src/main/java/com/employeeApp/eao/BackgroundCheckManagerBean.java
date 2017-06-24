/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.eao;

import com.employeeApp.entity.BackgroundCheck;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AnaCris
 */
@Stateless
public class BackgroundCheckManagerBean extends AbstractFacade<BackgroundCheck> implements Serializable, IBackgroundCheckManagerLocal{

    @PersistenceContext(unitName = "EmployeeAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BackgroundCheckManagerBean() {
        super(BackgroundCheck.class);
    }
    @Override
    public List<BackgroundCheck> findAllBackgroundChecks() {
        Query q = em.createNamedQuery("BackgroundCheck.findAll");
        return q.getResultList();
    }
    
    @Override
    public BackgroundCheck findById(Integer id) {
        Query q = em.createNamedQuery("BackgroundCheck.findById");
        q.setParameter("id", id);
        return (BackgroundCheck) q.getSingleResult();
    }
    
    @Override
    public BackgroundCheck findByStatus(String status) {
        Query q = em.createNamedQuery("BackgroundCheck.findByStatus");
        q.setParameter("status", status);
        return (BackgroundCheck) q.getSingleResult();
    }   
}