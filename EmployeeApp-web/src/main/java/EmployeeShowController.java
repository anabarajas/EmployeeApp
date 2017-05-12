/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.eao.IEmployeeManagerBeanLocal;
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
        }
    }

    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        return dateFormat.format(date);
    }

    public Employee getEmployee() {
        return employee;
    }
}
