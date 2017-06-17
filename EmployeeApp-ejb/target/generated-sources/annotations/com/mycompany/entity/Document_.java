package com.mycompany.entity;

import com.mycompany.entity.EDocumentReviewStatus;
import com.mycompany.entity.EDocumentType;
import com.mycompany.entity.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-06-16T16:05:06")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, EDocumentType> documentType;
    public static volatile SingularAttribute<Document, Integer> documentNumber;
    public static volatile SingularAttribute<Document, Employee> employeeId;
    public static volatile SingularAttribute<Document, Long> id;
    public static volatile SingularAttribute<Document, EDocumentReviewStatus> documentReviewStatus;

}