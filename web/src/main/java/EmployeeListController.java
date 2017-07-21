import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.EDepartment;
import com.employeeApp.entity.EEmployeePosition;
import com.employeeApp.entity.EEmployeeStatus;
import com.employeeApp.entity.Employee;

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
@Named(value="employeeListController")
@SessionScoped
public class EmployeeListController implements Serializable {
    
    @Inject
    private EmployeeManagerBean employeeManagerBean;
    
    private List<Employee> employees = new ArrayList<Employee>();;
    private List<String> departments;
    private List<String> positions;
    private List<String> statuses;

    public void onPageLoad() {
        employees = employeeManagerBean.findAllEmployees();
        departments = Stream.of(EDepartment.values())
                .map(EDepartment::toString)
                .collect(Collectors.toList());
        positions = Stream.of(EEmployeePosition.values())
                .map(EEmployeePosition::toString)
                .collect(Collectors.toList());
        statuses = Stream.of(EEmployeeStatus.values())
                .map(EEmployeeStatus::toString)
                .collect(Collectors.toList());
    }
    
    public List<Employee> getEmployees() {
        return employees;
    }

    public List<String> getDeparments(){
        return departments;
    }

    public List<String> getPositions() {
        return positions;
    }

    public List<String> getStatuses() {
        return statuses;
    }
}
