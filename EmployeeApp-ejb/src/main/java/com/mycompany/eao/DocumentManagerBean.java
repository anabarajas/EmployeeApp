/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eao;

import com.mycompany.entity.Document;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AnaCris
 */
@Stateless
public class DocumentManagerBean extends AbstractFacade<Document> implements Serializable, IDocumentManagerBeanLocal {

    @PersistenceContext(unitName = "EmployeeAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentManagerBean() {
        super(Document.class);
    }
    
    @Override
     public List<Document> findAllDocuments() {
        Query q = em.createNamedQuery("Document.findAll");
        return q.getResultList();
    }
    
    @Override
    public Document findById(Integer id) {
        Query q = em.createNamedQuery("Document.findById");
        q.setParameter("id", id);
        return (Document) q.getSingleResult();
    }
    
    @Override
    public Document findByDocumentType(String documentType) {
        Query q = em.createNamedQuery("Document.findByDocumentType");
        q.setParameter("documentType", documentType);
        return (Document) q.getSingleResult();
    }
    
    @Override
    public Document findByDocumentNumber(Integer documentNumber) {
        Query q = em.createNamedQuery("Document.findByDocumentNumber");
        q.setParameter("documentNumber", documentNumber);
        return (Document) q.getSingleResult();
    }
    
    @Override
    public Document findByEmployeeId(Integer employeeId) {
        Query q = em.createNamedQuery("Document.findByEmployeeId");
        q.setParameter("employeeId", employeeId);
        return (Document) q.getSingleResult();
    }
    
    @Override
    public Document findByDocumentReviewStatus(String documentReviewStatus) {
        Query q = em.createNamedQuery("Document.findByDocumentReviewStatus");
        q.setParameter("documentReviewStatus", documentReviewStatus);
        return (Document) q.getSingleResult();
    }
}
