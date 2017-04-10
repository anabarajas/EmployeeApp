/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.entity.BackgroundCheck;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
