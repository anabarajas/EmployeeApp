/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.eao.IEmployeeManagerBeanLocal;
import com.mycompany.entity.EDepartment;
import com.mycompany.entity.EEmployeePosition;
import com.mycompany.entity.EEmployeeStatus;
import com.mycompany.entity.Employee;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnaCris
 */
@Named(value="employeeShowController")
@SessionScoped
public class EmployeeShowController implements Serializable{

    private static final Logger LOG = Logger.getLogger(EmployeeShowController.class.getName());

    @Inject
    IEmployeeManagerBeanLocal employeeManagerBean;


    private Employee employee;
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String country;
    private EEmployeeStatus status;
    private EDepartment department;
    private EEmployeePosition position;
    private Date startDate;

    @PostConstruct
    public void init() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Integer id = Integer.valueOf(req.getParameter("id"));
        try {
            if (id != null) {
                employee = employeeManagerBean.findById(id);
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, e.getMessage());
            JsfUtil.addErrorMessage("error fetching employee id" + id.toString());
        }
    }

    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        return dateFormat.format(date);
    }

    public void addEmployee() {
        Employee employee = new Employee(firstName, lastName, dateOfBirth, country, status, position, department, startDate);
        employeeManagerBean.create(employee);
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCountry() {
        return country;
    }

    public EEmployeeStatus getStatus() {
        return status;
    }

    public EDepartment getDepartment() {
        return department;
    }

    public EEmployeePosition getPosition() {
        return position;
    }

    public Date getStartDate() {
        return startDate;
    }
}
