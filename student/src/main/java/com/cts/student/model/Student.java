package com.cts.student.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * 
 * @author Harshit
 *
 */
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rollNumber;
	@NotBlank(message = "Fist name should not be blank")
	private String firstName;
	@NotBlank(message = "Last name should not be blank")
	private String lastName;
	@NotBlank(message = "Student class should not be blank")
	private String studentClass;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dateOfBirth;
	@NotBlank(message = "Created by should not be blank")
	private String createdBy;
	@NotBlank(message = "Modified by should not be blank")
	private String modifiedBy;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date createdDate;
	
	
	
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date modifiedDate;
	
	public Student() {
		super();
	}

	public Student(@NotNull Long rollNumber, @NotBlank String firstName, @NotBlank String lastName,
			@NotBlank String studentClass, Date dateOfBirth, @NotBlank String createdBy, @NotBlank String modifiedBy,
			Date createdDate, Date modifiedDate) {
		super();
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentClass = studentClass;
		this.dateOfBirth = dateOfBirth;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public Long getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(Long rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
