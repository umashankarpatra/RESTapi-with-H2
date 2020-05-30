package com.xebia.linksharing.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Date> updatedTime;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Date> dateofBirth;
	public static volatile SingularAttribute<User, Date> creationTime;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> userName;

	public static final String UPDATED_TIME = "updatedTime";
	public static final String PASSWORD = "password";
	public static final String DATEOF_BIRTH = "dateofBirth";
	public static final String CREATION_TIME = "creationTime";
	public static final String ID = "id";
	public static final String USER_NAME = "userName";

}

