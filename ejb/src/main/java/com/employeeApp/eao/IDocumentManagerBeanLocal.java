/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.eao;

import com.employeeApp.entity.Document;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AnaCris
 */
@Local
public interface IDocumentManagerBeanLocal {
    
    void create(Document document);

    void edit(Document document);

    void remove(Document document);
    
    List<Document> findRange(int[] range);

    int count();
    
    List<Document> findAllDocuments();
    
    Document findById(Integer id);
    
    Document findByDocumentType(String documentType);
    
    Document findByDocumentNumber(Integer documentNumber);
    
    Document findByEmployeeId(Integer employeeId);
    
    Document findByDocumentReviewStatus(String documentReviewStatus);
    
    
    
    
    
}
