package com.cts.student.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.cts.student.model.Student;
import com.cts.student.service.exception.StudentNotFoundException;
/**
 * 
 * @author 882851
 *
 */
public interface StudentService {
	
	public void addDetails(Student student);
	public Student studentByRollNo(Long rollNumber) throws StudentNotFoundException;
	public List<Student> allStudent()  throws StudentNotFoundException;
	public void updateDetail(Student student) throws StudentNotFoundException;
	public void deleteStudentByRollNo(Long rollNumber) throws EmptyResultDataAccessException;

}
