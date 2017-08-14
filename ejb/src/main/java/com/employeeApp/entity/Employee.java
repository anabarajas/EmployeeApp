/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employeeApp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AnaCris
 */
@Entity
@Table(name = "employees")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id")
    , @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employee.findByDateOfBirth", query = "SELECT e FROM Employee e WHERE e.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Employee.findByCountry", query = "SELECT e FROM Employee e WHERE e.country = :country")
    , @NamedQuery(name = "Employee.findByStatus", query = "SELECT e FROM Employee e WHERE e.status = :status")
    , @NamedQuery(name = "Employee.findByPosition", query = "SELECT e FROM Employee e WHERE e.position = :position")
    , @NamedQuery(name = "Employee.findByDepartment", query = "SELECT e FROM Employee e WHERE e.department = :department")
    , @NamedQuery(name = "Employee.findByStartDate", query = "SELECT e FROM Employee e WHERE e.startDate = :startDate")})
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "firstName")
    private String firstName;
    @NotNull
    @Column(name = "lastName")
    private String lastName;
    @NotNull
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
    @NotNull
    @Column(name = "country")
    @Enumerated(EnumType.STRING)
    private ECountry country;
    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EEmployeeStatus status;
    @NotNull
    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private EEmployeePosition position;
    @NotNull
    @Column(name = "department")
    @Enumerated(EnumType.STRING)
    private EDepartment department;
    @NotNull
    @Column(name = "startDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Transient
    private BackgroundCheck backgroundCheck;


    public Employee() {
    }

    public Employee(Long id) {
        this.id = id;
    }

    public Employee(String firstName, String lastName, Date dateOfBirth, ECountry country, EEmployeeStatus status, EEmployeePosition position, EDepartment department, Date startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.status = status;
        this.position = position;
        this.department = department;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ECountry getCountry() {
        return country;
    }

    public void setCountry(ECountry country) {
        this.country = country;
    }

    public EEmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EEmployeeStatus status) {
        this.status = status;
    }

    public EEmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EEmployeePosition position) {
        this.position = position;
    }

    public EDepartment getDepartment() {
        return department;
    }

    public void setDepartment(EDepartment department) {
        this.department = department;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public BackgroundCheck getBackgroundCheck() {
        return backgroundCheck;
    }

    public void setBackgroundCheck(BackgroundCheck backgroundCheck) {
        this.backgroundCheck = backgroundCheck;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}