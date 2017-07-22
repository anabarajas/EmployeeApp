/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AnaCris
 */
@Entity
@Table(name = "documents")
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
    , @NamedQuery(name = "Document.findById", query = "SELECT d FROM Document d WHERE d.id = :id")
    , @NamedQuery(name = "Document.findByDocumentType", query = "SELECT d FROM Document d WHERE d.documentType = :documentType")
    , @NamedQuery(name = "Document.findByDocumentNumber", query = "SELECT d FROM Document d WHERE d.documentNumber = :documentNumber")
    , @NamedQuery(name = "Document.findByEmployeeId", query = "SELECT d FROM Document d WHERE d.employeeId = :employeeId")
    , @NamedQuery(name = "Document.findByDocumentReviewStatus", query = "SELECT d FROM Document d WHERE d.documentReviewStatus = :documentReviewStatus")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "documentType")
    @Enumerated(EnumType.STRING)
    private EDocumentType documentType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentNumber")
    private int documentNumber;
    @Size(max = 45)
    @JoinColumn(name = "employeeId")
    private Employee employeeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "documentReviewStatus")
    @Enumerated(EnumType.STRING)
    private EDocumentReviewStatus documentReviewStatus;
            
    public Document() {
    }

    public Document(Long id) {
        this.id = id;
    }

    public Document(Long id, EDocumentType documentType, int documentNumber, EDocumentReviewStatus documentReviewStatus) {
        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.documentReviewStatus = documentReviewStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EDocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(EDocumentType documentType) {
        this.documentType = documentType;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public EDocumentReviewStatus getDocumentReviewStatus() {
        return documentReviewStatus;
    }

    public void setDocumentReviewStatus(EDocumentReviewStatus documentReviewStatus) {
        this.documentReviewStatus = documentReviewStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "com.mycompany.entity.Document[ id=" + id + " ]";
//    }
    
}
