import com.mycompany.eao.EmployeeManagerBean;
import com.mycompany.eao.IEmployeeManagerBeanLocal;
import com.mycompany.entity.EDepartment;
import com.mycompany.entity.EEmployeePosition;
import com.mycompany.entity.Employee;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

/**
 * Created by AnaCris on junio/18/17.
 */
@Named(value = "addEmployeeController")
@SessionScoped
public class AddEmployeeController {

    @Inject
    IEmployeeManagerBeanLocal employeeManagerBean;

    private Employee employee;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String country;
    private EDepartment department;
    private EEmployeePosition position;
    private Date startDate;

    public String addNewEmployee() {
        employee = new Employee(firstName, lastName, dateOfBirth, country, position, department);
        employeeManagerBean.create(employee);
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
