/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.employeeApp.eao.IEmployeeManagerBeanLocal;
import com.employeeApp.entity.EDepartment;
import com.employeeApp.entity.EEmployeePosition;
import com.employeeApp.entity.Employee;

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
@Named(value="showEmployeeController")
@SessionScoped
public class ShowEmployeeController implements Serializable {

    private static final Logger LOG = Logger.getLogger(ShowEmployeeController.class.getName());

    @Inject
    IEmployeeManagerBeanLocal employeeManagerBean;

    @Inject
    AddEmployeeController addEmployeeController;

    private Employee employee;
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String country;
    private EDepartment department;
    private EEmployeePosition position;
    private Date startDate;

    @PostConstruct
    public void init() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try {
            id = addEmployeeController.getId();
//            req.getParameter("addEmployeeId");

//            if (req.getParameter("addEmployeeId") != null) {
//               // id = addEmployeeController.getId();
//                id = Long.valueOf(req.getParameter("addEmployeeId"));
//            } else {
//                id = Long.valueOf(req.getParameter("id"));
//            }
        } catch(Exception e) {
            LOG.log(Level.WARNING, "ShowEmployeeController:init() - no value for parameters");
        }

    }

    public ShowEmployeeController() {
    }

    public void pageFieldsCleanUp() {
        employee = new Employee();
        id = null;
    }

    public void cleanUp() {
        employee = new Employee();
    }

    public String fetchEmployee(Long employeeId) {
        try {
            if (id == null) {
                id = employeeId;
            }
            employee = employeeManagerBean.findById(id);
        } catch (Exception ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            JsfUtil.addErrorMessage("error fetching employee id" + id.toString());
        }
        return "show";

    }

    public void onPageLoad() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try {
            if (req.getParameter("addEmployeeId") != null) {
                id = Long.valueOf(req.getParameter("addEmployeeId"));
            } else if (req.getParameter("updatedEmployeeId") != null ) {
                id = Long.valueOf(req.getParameter("updatedEmployeeId"));
            } else {
                LOG.log(Level.INFO, "ShowEmployeeController :: onpageLoad() - page called from list controller");
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, e.getMessage());
            JsfUtil.addErrorMessage("error fetching employee id" + id.toString());
        }
    }

    public String returnToList() {
        pageFieldsCleanUp();
        return "list";
    }

    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        return dateFormat.format(date);
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


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCountry() {
        return country;
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
