/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.entity.BackgroundCheck;
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
public class BackgroundCheckManagerBean extends AbstractFacade<BackgroundCheck> {

    @PersistenceContext(unitName = "EmployeeAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BackgroundCheckManagerBean() {
        super(BackgroundCheck.class);
    }
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
