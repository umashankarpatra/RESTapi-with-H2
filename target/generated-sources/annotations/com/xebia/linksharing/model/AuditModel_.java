package com.xebia.linksharing.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AuditModel.class)
public abstract class AuditModel_ {

	public static volatile SingularAttribute<AuditModel, Date> createdAt;
	public static volatile SingularAttribute<AuditModel, Date> updatedAt;

	public static final String CREATED_AT = "createdAt";
	public static final String UPDATED_AT = "updatedAt";

}

