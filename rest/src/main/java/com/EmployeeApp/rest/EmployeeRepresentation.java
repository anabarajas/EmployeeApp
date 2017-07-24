package com.EmployeeApp.rest;

import com.employeeApp.entity.EDepartment;
import com.employeeApp.entity.EEmployeePosition;
import com.employeeApp.entity.EEmployeeStatus;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Created by abarajas on 6/23/17.
 */
@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeRepresentation {

    @XmlAttribute
    private Long id;
    @XmlElement(required=true)
    private String firstName;
    @XmlElement(required=true)
    private String lastName;
    @XmlElement(required=true)
    private String country;
    @XmlElement
    private Date dateOfBirth;
    @XmlElement
    private EEmployeeStatus status;
    @XmlElement
    private EEmployeePosition position;
    @XmlElement
    private EDepartment department;
    @XmlElement
    private Date startDate;

    public EmployeeRepresentation() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
}
