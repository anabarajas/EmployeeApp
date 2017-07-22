/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.eao;

import com.employeeApp.entity.Document;

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
public class DocumentManagerBean implements Serializable {

    @PersistenceContext(unitName = "EmployeeAppPU")
    private EntityManager em;


    public List<Document> findAllDocuments() {
        Query q = em.createNamedQuery("Document.findAll");
        return q.getResultList();
    }

    public Document findById(Integer id) {
        Query q = em.createNamedQuery("Document.findById");
        q.setParameter("id", id);
        return (Document) q.getSingleResult();
    }

    public Document findByDocumentType(String documentType) {
        Query q = em.createNamedQuery("Document.findByDocumentType");
        q.setParameter("documentType", documentType);
        return (Document) q.getSingleResult();
    }
    
    public Document findByDocumentNumber(Integer documentNumber) {
        Query q = em.createNamedQuery("Document.findByDocumentNumber");
        q.setParameter("documentNumber", documentNumber);
        return (Document) q.getSingleResult();
    }
    
    public Document findByEmployeeId(Integer employeeId) {
        Query q = em.createNamedQuery("Document.findByEmployeeId");
        q.setParameter("employeeId", employeeId);
        return (Document) q.getSingleResult();
    }
    
    public Document findByDocumentReviewStatus(String documentReviewStatus) {
        Query q = em.createNamedQuery("Document.findByDocumentReviewStatus");
        q.setParameter("documentReviewStatus", documentReviewStatus);
        return (Document) q.getSingleResult();
    }
}
