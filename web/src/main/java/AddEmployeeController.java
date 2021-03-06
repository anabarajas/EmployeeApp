import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.ECountry;
import com.employeeApp.entity.EDepartment;
import com.employeeApp.entity.EEmployeePosition;
import com.employeeApp.entity.Employee;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by AnaCris on junio/18/17.
 */
@Named(value = "addEmployeeController")
@SessionScoped
public class AddEmployeeController extends AbstractEmployeeController implements Serializable {

    @Inject
    private EmployeeManagerBean employeeManagerBean;

    private Employee employee;
    private Long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private ECountry country;
    private EDepartment department;
    private EEmployeePosition position;
    private Date startDate;

    public void cleanUp() {
        employee = null;
        id = null;
        firstName = null;
        lastName = null;
        dateOfBirth = null;
        country = null;
        department = null;
        position = null;
        startDate = null;
    }

    public String addNewEmployee() {
        employee = employeeManagerBean.createEmployee(firstName, lastName, dateOfBirth, country, position, department, startDate);
        id = employee.getId();
        return "show?faces-redirect=true";
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

    public ECountry getCountry() {
        return country;
    }

    public void setCountry(ECountry country) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
