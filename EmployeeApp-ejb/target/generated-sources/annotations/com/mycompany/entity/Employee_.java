package com.mycompany.entity;

import com.mycompany.entity.BackgroundCheck;
import com.mycompany.entity.EDepartment;
import com.mycompany.entity.EEmployeePosition;
import com.mycompany.entity.EEmployeeStatus;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-15T23:55:02")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, String> firstName;
    public static volatile SingularAttribute<Employee, String> lastName;
    public static volatile SingularAttribute<Employee, String> country;
    public static volatile SingularAttribute<Employee, Date> dateOfBirth;
    public static volatile CollectionAttribute<Employee, BackgroundCheck> backgroundCheckCollection;
    public static volatile SingularAttribute<Employee, Long> id;
    public static volatile SingularAttribute<Employee, EEmployeePosition> position;
    public static volatile SingularAttribute<Employee, EDepartment> department;
    public static volatile SingularAttribute<Employee, Date> startDate;
    public static volatile SingularAttribute<Employee, EEmployeeStatus> status;

}