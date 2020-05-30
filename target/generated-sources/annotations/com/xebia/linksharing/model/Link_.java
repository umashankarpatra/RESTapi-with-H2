package com.xebia.linksharing.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Link.class)
public abstract class Link_ extends com.xebia.linksharing.model.AuditModel_ {

	public static volatile SingularAttribute<Link, Integer> favCount;
	public static volatile SingularAttribute<Link, Long> id;
	public static volatile SingularAttribute<Link, String> title;
	public static volatile SingularAttribute<Link, String> url;
	public static volatile SingularAttribute<Link, Boolean> status;

	public static final String FAV_COUNT = "favCount";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String URL = "url";
	public static final String STATUS = "status";

}

