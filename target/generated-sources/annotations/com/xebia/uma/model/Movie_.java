package com.xebia.uma.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Movie.class)
public abstract class Movie_ {

	public static volatile SingularAttribute<Movie, String> artist;
	public static volatile SingularAttribute<Movie, String> releaseDate;
	public static volatile SingularAttribute<Movie, String> description;
	public static volatile SingularAttribute<Movie, Long> id;
	public static volatile SingularAttribute<Movie, String> title;

	public static final String ARTIST = "artist";
	public static final String RELEASE_DATE = "releaseDate";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String TITLE = "title";

}

