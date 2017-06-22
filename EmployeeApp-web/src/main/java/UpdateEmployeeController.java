import com.mycompany.eao.IEmployeeManagerBeanLocal;
import com.mycompany.entity.EDepartment;
import com.mycompany.entity.EEmployeePosition;
import com.mycompany.entity.EEmployeeStatus;
import com.mycompany.entity.Employee;
import com.mycompany.service.IEmployeeServiceBeanLocal;

import javax.annotation.PostConstruct;
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
public class UpdateEmployeeController implements Serializable {

    private static final Logger LOG = Logger.getLogger(ShowEmployeeController.class.getName());

    @Inject
    IEmployeeManagerBeanLocal employeeManagerBean;

    @Inject
    IEmployeeServiceBeanLocal employeeServiceBean;

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

    @PostConstruct
    public void init() {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        id = Long.valueOf(req.getParameter("updateEmployeeId"));
        try {
            if (id != null) {
                employee = employeeManagerBean.findById(id);
            }
        } catch (Exception e) {
            LOG.log(Level.WARNING, e.getMessage());
            JsfUtil.addErrorMessage("error fetching employee id" + id.toString());
        }
    }

    public UpdateEmployeeController() {
        firstName = employee.getFirstName();
        lastName = employee.getLastName();
        dateOfBirth = employee.getDateOfBirth();
        startDate = employee.getStartDate();
        country = employee.getCountry();
        department = employee.getDepartment();
        position = employee.getPosition();
        status = employee.getStatus();
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
        employeeServiceBean.updateEmployee(employee ,firstName, lastName, country, dateOfBirth, department, position, status);
        cleanUp();
        return "show";
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
