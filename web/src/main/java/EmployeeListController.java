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
@Named(value="employeeListController")
@SessionScoped
public class EmployeeListController implements Serializable {
    
    @Inject
    private EmployeeManagerBean employeeManagerBean;
    
    private List<Employee> employees = new ArrayList<Employee>();;
    private List<String> departments;
    private List<String> positions;
    private List<String> statuses;
    private List<String> countries;

    EmployeeListController(){
        departments = Stream.of(EDepartment.values())
                .map(d->d.getName())
                .collect(Collectors.toList());
        positions = Stream.of(EEmployeePosition.values())
                .map(p->p.getName())
                .collect(Collectors.toList());
        statuses = Stream.of(EEmployeeStatus.values())
                .map(s->s.getName())
                .collect(Collectors.toList());
        countries = Stream.of(ECountry.values())
                .map(c->c.getName())
                .sorted()
                .collect(Collectors.toList());
    }

    public void onPageLoad() {
        employees = employeeManagerBean.findAllEmployees();
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

    public List<String> getCountries() {
        return countries;
    }
}
