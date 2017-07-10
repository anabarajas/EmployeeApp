/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.employeeApp.eao.IEmployeeManagerBeanLocal;
import com.employeeApp.entity.Employee;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnaCris
 */
@Named(value="showEmployeeController")
@SessionScoped
public class ShowEmployeeController extends AbstractEmployeeController implements Serializable {

    private static final Logger LOG = Logger.getLogger(ShowEmployeeController.class.getName());

    @Inject
    private IEmployeeManagerBeanLocal employeeManagerBean;

    @Inject
    private AddEmployeeController addEmployeeController;

    private Employee employee;
    private Long id;

//    @PostConstruct
//    public void init() {
//        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        try {
//            if (req.getParameter("addEmployeeId") != null && !req.getParameter("addEmployeeId").isEmpty()) {
//                id = Long.valueOf(req.getParameter("addEmployeeId"));
//            } else if (req.getParameter("id") != null && !req.getParameter("id").isEmpty()) {
//                id = Long.valueOf(req.getParameter("id"));
//            } else {
//                id = addEmployeeController.getId();
//            }
//            employee = employeeManagerBean.findById(id);
//            LOG.log(Level.INFO, "ShowEmployeeController:init() - fetched employee {0} {1}, id: {2} for rendering of page", new Object[]{employee.getFirstName(), employee.getLastName(), employee.getId()} );
//        } catch(Exception e) {
//            LOG.log(Level.WARNING, "ShowEmployeeController:init() - no value for parameters");
//        }
//
//    }

    public ShowEmployeeController() {
    }

    public void cleanUp() {
        employee = new Employee();
        id = null;
    }

    public void onPageLoad() {
            HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            try {
                if (req.getParameter("id") != null) {
                    id = Long.valueOf(req.getParameter("id"));
                } else if (id == null) {
                    id = addEmployeeController.getId();
                }
                employee = employeeManagerBean.findById(id);
            } catch (Exception e) {
                LOG.log(Level.WARNING, e.getMessage());
                JsfUtil.addErrorMessage("error fetching employee");
            }
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
}
