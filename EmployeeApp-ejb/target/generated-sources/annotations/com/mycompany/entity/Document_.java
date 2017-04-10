package com.mycompany.entity;

import com.mycompany.entity.BackgroundCheck;
import com.mycompany.entity.EDocumentReviewStatus;
import com.mycompany.entity.EDocumentType;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-04-09T22:29:22")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, EDocumentType> documentType;
    public static volatile SingularAttribute<Document, Integer> documentNumber;
    public static volatile SingularAttribute<Document, Long> employeeId;
    public static volatile CollectionAttribute<Document, BackgroundCheck> backgroundCheckCollection;
    public static volatile SingularAttribute<Document, Long> id;
    public static volatile SingularAttribute<Document, EDocumentReviewStatus> documentReviewStatus;

}