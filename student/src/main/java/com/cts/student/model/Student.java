package com.cts.student.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Column
	@NotBlank(message = "Fist name should not be blank")
	private String firstName;
	@Column
	@NotBlank(message = "Last name should not be blank")
	private String lastName;
	@Column
	@NotBlank(message = "Student class should not be blank")
	private String studentClass;
	@Column
	@NotBlank(message = "Student section should not be blank")
	private String studentSection;
	@Column
//	@DateTimeFormat(iso = DateTimeFormatter.ofPattern("dd-MM-yyyy"))
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateOfBirth;
	@Column
	@NotBlank(message = "Created by should not be blank")
	private String createdBy;
	@Column
	@NotBlank(message = "Modified by should not be blank")
	private String modifiedBy;
	@Column
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate createdDate;
	@Column
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate modifiedDate;

	public Student() {
		super();
	}

	public Student(Long rollNumber, @NotBlank(message = "Fist name should not be blank") String firstName,
			@NotBlank(message = "Last name should not be blank") String lastName,
			@NotBlank(message = "Student class should not be blank") String studentClass,
			@NotBlank(message = "Student section should not be blank") String studentSection, LocalDate dateOfBirth,
			@NotBlank(message = "Created by should not be blank") String createdBy,
			@NotBlank(message = "Modified by should not be blank") String modifiedBy, LocalDate createdDate,
			LocalDate modifiedDate) {
		super();
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentClass = studentClass;
		this.studentSection = studentSection;
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

	public String getStudentSection() {
		return studentSection;
	}

	public void setStudentSection(String studentSection) {
		this.studentSection = studentSection;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
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

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", studentClass=" + studentClass + ", studentSection=" + studentSection + ", dateOfBirth="
				+ dateOfBirth + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
	

	
}
