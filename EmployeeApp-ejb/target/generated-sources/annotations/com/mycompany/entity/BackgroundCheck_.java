package com.mycompany.entity;

import com.mycompany.entity.Document;
import com.mycompany.entity.EBackgroundCheckStatus;
import com.mycompany.entity.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-05-01T12:35:05")
@StaticMetamodel(BackgroundCheck.class)
public class BackgroundCheck_ { 

    public static volatile CollectionAttribute<BackgroundCheck, Document> documentIdCollection;
    public static volatile SingularAttribute<BackgroundCheck, Employee> employeeId;
    public static volatile SingularAttribute<BackgroundCheck, Long> id;
    public static volatile SingularAttribute<BackgroundCheck, EBackgroundCheckStatus> status;

}