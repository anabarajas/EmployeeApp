import com.employeeApp.entity.Employee;

/**
 * Created by abarajas on 6/23/17.
 */
public class EmployeeRepresentationConverter {

    public EmployeeRepresentation getEmployeeRepresentationByToken(Employee e) {
        EmployeeRepresentation employeeRepresentation = new EmployeeRepresentation();
        employeeRepresentation.setId(e.getId());
        employeeRepresentation.setFirstName(e.getFirstName());
        employeeRepresentation.setLastName(e.getLastName());
        employeeRepresentation.setCountry(e.getCountry());
        employeeRepresentation.setDepartment(e.getDepartment());
        employeeRepresentation.setDateOfBirth(e.getDateOfBirth());
        employeeRepresentation.setPosition(e.getPosition());
        employeeRepresentation.setStartDate(e.getStartDate());
      //  employeeRepresentation.set

        return null;
    }

}
