package com.xebia.uma.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID")
	private Long id;
	@Column(name = "USER_NAME")
	private String userName;
	// @JsonIgnore
	@Column(name = "PASSWORD")
	private String password;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "CREATED_TIME")
	private Date creationTime;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_TIME")
	private Date updatedTime;
	@Temporal(value = TemporalType.DATE)
	@Column(name = "DOB")
	private Date dateofBirth;
	@Enumerated(value = EnumType.STRING)

	@Transient
	private String dateOfBirthString;
	
}
