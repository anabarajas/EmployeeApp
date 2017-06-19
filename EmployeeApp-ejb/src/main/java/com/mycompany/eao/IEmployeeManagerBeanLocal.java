/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.eao;

import com.mycompany.entity.Employee;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AnaCris
 */
@Local
public interface IEmployeeManagerBeanLocal {
    
    void create(Employee employee);

    void edit(Employee employee);

    void remove(Employee employee);

    List<Employee> findRange(int[] range);

    int count();
    
    List<Employee> findAllEmployees();
    
    Employee findById(Long id);
    
    Employee findByFirstName(String firstName);
    
    Employee findByLastName(String lastName);
    
    Employee findByDateOfBirth(Date dateOfBirth);
    
    Employee findByCountry(String country);
    
    Employee findByStatus(String status);
    
    Employee findByPosition(String position);
    
    Employee findByDepartment(String department);
    
    Employee findByStartDate(Date startDate);
    
    
    
    
    
    
    
    
    
    
    
    
}
