/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.eao.IEmployeeManagerBeanLocal;
import com.mycompany.entity.Employee;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author AnaCris
 */
@Named(value="showEmployeeController")
@SessionScoped
public class ShowEmployeeController implements Serializable{

    private static final Logger LOG = Logger.getLogger(ShowEmployeeController.class.getName());

    @Inject
    IEmployeeManagerBeanLocal employeeManagerBean;


    private Employee employee;
    private boolean updated;
    private String firstName;
//    private String lastName;
//    private Date dateOfBirth;
//    private String country;
//    private EDepartment department;
//    private EEmployeePosition position;
//    private Date startDate;

//    @PostConstruct
//    public void init() {
//        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        Long id = Long.valueOf(req.getParameter("id"));
//        try {
//            if (id != null) {
//                employee = employeeManagerBean.findById(id);
//            }
//        } catch (Exception e) {
//            LOG.log(Level.WARNING, e.getMessage());
//            JsfUtil.addErrorMessage("error fetching employee id" + id.toString());
//        }
//    }

    public ShowEmployeeController() {
        updated = false;
    }

    public String fetchEmployee() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Long id = Long.valueOf(req.getParameter("id"));
        employee = employeeManagerBean.findById(id);
        return "show";
    }

    public String returnToList() {
        cleanUp();
        return "list";
    }

    public void cleanUp() {
        employee = new Employee();
        updated = false;
    }

    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        return dateFormat.format(date);
    }

    public String updateEmployee() {
        employeeManagerBean.edit(employee);
        updated = true;
        return "show";
    }

    public void deleteEmployee(Employee employee) {
        employeeManagerBean.remove(employee);
    }

//    public void resetEmployeeFormFields() {
//        this.firstName = null;
//        this.lastName = null;
//        this.dateOfBirth = null;
//        this.country = null;
//        this.position = null;
//        this.department = null;
//    }
//
    public Employee getEmployee() {
        return employee;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //    public String getLastName() {
//        return lastName;
//    }
//
//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public EDepartment getDepartment() {
//        return department;
//    }
//
//    public EEmployeePosition getPosition() {
//        return position;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
}
