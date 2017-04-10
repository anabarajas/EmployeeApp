package com.mycompany.entity;

import com.mycompany.entity.EBackgroundCheckStatus;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-09T22:29:22")
@StaticMetamodel(BackgroundCheck.class)
public class BackgroundCheck_ { 

    public static volatile SingularAttribute<BackgroundCheck, Long> documentId;
    public static volatile SingularAttribute<BackgroundCheck, Long> employeeId;
    public static volatile SingularAttribute<BackgroundCheck, Long> id;
    public static volatile SingularAttribute<BackgroundCheck, EBackgroundCheckStatus> status;

}