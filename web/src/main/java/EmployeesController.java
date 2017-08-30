import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.*;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnaCris
 */
@Named(value="employeesController")
@SessionScoped
public class EmployeesController implements Serializable {
    
    @Inject
    private EmployeeManagerBean employeeManagerBean;
    
    private List<Employee> employees = new ArrayList<Employee>();;

    EmployeesController(){}

    public void onPageLoad() {
        employees = employeeManagerBean.findAllEmployees();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public EEmployeePosition[] getEmployeePositions() {
        return EEmployeePosition.values();
    }

    public EEmployeeStatus[] getEmployeeStatuses() {
        return EEmployeeStatus.values();
    }

    public EDepartment[] getDepartments() {
        return EDepartment.values();
    }

    public ECountry[] getCountries() {
        return ECountry.values();
    }

}
