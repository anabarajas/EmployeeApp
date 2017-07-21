import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.Employee;

import javax.inject.Inject;

/**
 * Created by abarajas on 6/22/17.
 */
public class EmployeeResourceService {

    private EmployeeRepresentationConverter employeeRepresentationConverter;

    @Inject
    EmployeeManagerBean employeeManagerBean;


    public EmployeeRepresentation getEmployeeById(Long id) {
        Employee employee = employeeManagerBean.findById(id);
        EmployeeRepresentation representation = employeeRepresentationConverter.getEmployeeRepresentationByToken(employee);
        return representation;
    }



}
