import com.employeeApp.eao.EmployeeManagerBean;
import com.employeeApp.entity.*;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnaCris
 */
@Named(value="employeesController")
@SessionScoped
public class EmployeesController implements Serializable {
    
    @Inject
    private EmployeeManagerBean employeeManagerBean;
    
    private List<Employee> employees = new ArrayList<>();
    private ESearchField searchField;
    private String searchWord;
    private Boolean isSearchResult;

    EmployeesController(){
        searchWord = "";
        searchField = null;
        isSearchResult = false;
    }

    public void onPageLoad() {
        if (!isSearchResult) {
            employees = employeeManagerBean.findAllEmployees();
            searchField = null;
            searchWord = null;
        } else {
            isSearchResult = false;
        }
    }

    public String searchForEmployee() {
        if (searchWord != null && !searchWord.isEmpty()) {
            isSearchResult = true;
            switch (searchField) {
                case FIRST_NAME:
                    employees = employeeManagerBean.findByFirstName(searchWord);
                    break;
                case LAST_NAME:
                    employees = employeeManagerBean.findByLastName(searchWord);
                    break;
                case COUNTRY:
                    employees = employeeManagerBean.findByCountry(ECountry.getECountryFromString(searchWord));
                    break;
                case DEPARTMENT:
                    employees = employeeManagerBean.findByDepartment(EDepartment.getEDepartmentFromString(searchWord));
                    break;
                case STATUS:
                    employees = employeeManagerBean.findByStatus(EEmployeeStatus.getEEmployeeStatusFromString(searchWord));
                    break;
                case POSITION:
                    employees = employeeManagerBean.findByPosition(EEmployeePosition.getEEmployeePositionFromString(searchWord));
                    break;
                default:
                    break;

            }
        }
        return "list?faces-redirect=true";
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public EEmployeePosition[] getEmployeePositions() {
        return EEmployeePosition.values();
    }

    public EEmployeeStatus[] getEmployeeStatuses() {
        return EEmployeeStatus.values();
    }

    public EDepartment[] getDepartments() {
        return EDepartment.values();
    }

    public ECountry[] getCountries() {
        return ECountry.values();
    }

    public ESearchField[] getSearchFields() {
        return ESearchField.values();
    }

    public ESearchField getSearchField() {
        return searchField;
    }

    public void setSearchField(ESearchField searchField) {
        this.searchField = searchField;
    }

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }
}
