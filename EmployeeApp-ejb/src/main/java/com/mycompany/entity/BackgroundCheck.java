/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AnaCris
 */
@Entity
@Table(name = "background_checks")
@NamedQueries({
    @NamedQuery(name = "BackgroundCheck.findAll", query = "SELECT b FROM BackgroundCheck b")
    , @NamedQuery(name = "BackgroundCheck.findById", query = "SELECT b FROM BackgroundCheck b WHERE b.id = :id")
    , @NamedQuery(name = "BackgroundCheck.findByStatus", query = "SELECT b FROM BackgroundCheck b WHERE b.status = :status")})
public class BackgroundCheck implements Serializable {

       private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EBackgroundCheckStatus status;
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Document> documentIdCollection;
    @JoinColumn(name = "employeeId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;

    public BackgroundCheck() {
    }

    public BackgroundCheck(Long id) {
        this.id = id;
    }

    public BackgroundCheck(Long id, EBackgroundCheckStatus status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EBackgroundCheckStatus getStatus() {
        return status;
    }

    public void setStatus(EBackgroundCheckStatus status) {
        this.status = status;
    }
    
    @XmlTransient
    public Collection<Document> getDocumentCollection() {
        return documentIdCollection;
    }

    public void setDocumentCollection(Collection<Document> documentIdCollection) {
        this.documentIdCollection = documentIdCollection;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof BackgroundCheck)) {
            return false;
        }
        BackgroundCheck other = (BackgroundCheck) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entity.BackgroundCheck[ id=" + id + " ]";
    }
    
}
