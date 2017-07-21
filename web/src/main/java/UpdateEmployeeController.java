import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.EDepartment;
import com.employeeApp.entity.EEmployeePosition;
import com.employeeApp.entity.EEmployeeStatus;
import com.employeeApp.entity.Employee;
import com.employeeApp.service.EmployeeServiceBean;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by abarajas on 6/21/17.
 */

@Named(value="updateEmployeeController")
@SessionScoped
public class UpdateEmployeeController extends AbstractEmployeeController implements Serializable {

    private static final Logger LOG = Logger.getLogger(ShowEmployeeController.class.getName());

    @Inject
    private EmployeeManagerBean employeeManagerBean;

    @Inject
    private EmployeeServiceBean employeeServiceBean;

    private Long id;
    private Employee employee;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date startDate;
    private String country;
    private EDepartment department;
    private EEmployeePosition position;
    private EEmployeeStatus status;

    public void onPageLoad() {
        cleanUp();
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        id = Long.valueOf(req.getParameter("id"));
        try {
            if (id != null) {
                employee = employeeManagerBean.findById(id);
                firstName = employee.getFirstName();
                lastName = employee.getLastName();
                dateOfBirth = employee.getDateOfBirth();
                startDate = employee.getStartDate();
                country = employee.getCountry();
                department = employee.getDepartment();
                position = employee.getPosition();
                status = employee.getStatus();
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, e.getMessage());
            JsfUtil.addErrorMessage("error fetching employee id" + id.toString());
        }
    }

    public void cleanUp() {
        this.employee = null;
        this.firstName = null;
        this.lastName = null;
        this.dateOfBirth = null;
        this.startDate = null;
        this.country = null;
        this.position = null;
        this.department = null;
        this.status = null;
    }

    public String updateEmployee() {
        employeeManagerBean.updateEmployee(employee ,firstName, lastName, country, dateOfBirth, department, position, startDate, status);
        return "show?faces-redirect=true&id=" + employee.getId();
    }

    public String deleteEmployee() {
        String page = "";
        try {
            employeeServiceBean.removeEmployee(employee);
            page = "delete?faces-redirect=true";
        } catch (Exception e) {
            LOG.log(Level.WARNING, "EmployeeServiceBean::remove - Error while removing employee {0} {1} with id: {2}", new Object[]{employee.getFirstName(), employee.getLastName(), employee.getId()});
            page = "failure?faces-redirect=true";
        }
        return page;

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public EDepartment getDepartment() {
        return department;
    }

    public void setDepartment(EDepartment department) {
        this.department = department;
    }

    public EEmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EEmployeePosition position) {
        this.position = position;
    }

    public EEmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EEmployeeStatus status) {
        this.status = status;
    }
}
