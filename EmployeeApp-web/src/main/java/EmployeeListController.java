
import com.mycompany.entity.Employee;
import com.mycompany.eao.IEmployeeManagerBeanLocal;
import java.io.Serializable;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.inject.Named;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnaCris
 */
@Named(value="employeeListController")
@SessionScoped
public class EmployeeListController implements Serializable {
    
    @Inject
    IEmployeeManagerBeanLocal employeeManagerBean;
    
    private List<Employee> employees = new ArrayList<Employee>();;
    
    
    
    @PostConstruct
    public void init() {
        employees = employeeManagerBean.findAllEmployees();
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }
    
//    public void addEmployee() {
//        employeeManagerBean.create
//    }
}
