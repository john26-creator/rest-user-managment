package com.user.management.usermanagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	@Size(min=2, max=30, message = "Wrong size for user name. It should be between 2 and 30") 
	private String name;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@NotNull
	private Date birthDate;
	@NotNull
	@Pattern (regexp = "^(FRANCE|france)$", message = "Wrong Nationality. You should be a FRENCH resident") 
	private String country;
	@NotNull
	@Pattern (regexp = "^\\+33[0-9]{9}$", message = "Wrong phone number format. +33XXXXXXXXX expected") 
	private String phoneNumber;
	private char gender;
	
}
