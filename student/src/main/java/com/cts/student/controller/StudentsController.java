package com.cts.student.controller;

import java.util.List;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.student.model.Student;
import com.cts.student.service.StudentServiceImpl;
import com.cts.student.service.exception.StudentNotFoundException;
/**
 * 
 * @author Harshit
 *  StudentsController used to perform CRUD operation for bulk data
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class StudentsController {

	//(CREATED_BY,CREATED_DATE,DATE_OF_BIRTH,FIRST_NAME,LAST_NAME,MODIFIED_BY,MODIFIED_DATE,STUDENT_CLASS)
	//CREATE TABLE IF NOT EXISTS STUDENT(ROLL_NUMBER INT PRIMARY KEY AUTO_INCREMENT,CREATED_BY VARCHAR(20),CREATED_DATE DATE,DATE_OF_BIRTH DATE,FIRST_NAME VARCHAR(50),LAST_NAME VARCHAR(50),MODIFIED_BY VARCHAR(50),MODIFIED_DATE DATE,STUDENT_CLASS VARCHAR(50));
	@Autowired
	StudentServiceImpl studentService;

	/**
	 * allStudents method used to return all student details
	 * 
	 * @return
	 * @throws StudentNotFoundException
	 */
	@GetMapping("showAllStudents")
	public List<Student> allStudents() throws StudentNotFoundException {
		try {
			return studentService.allStudent();
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			throw new StudentNotFoundException("No students");
		}
	}

	/**
	 * addMultipleStudents method used to add bulk student data
	 * 
	 * @param studentList
	 * @throws ConstraintViolationException
	 */
	@PostMapping("/addAllDetails")
	public void addMultipleStudents(@Valid @RequestBody List<Student> studentList) throws ConstraintViolationException {
		try {
			studentService.addMultipleStudent(studentList);
		} catch (TransactionSystemException e) {
			if (e.getRootCause() instanceof ConstraintViolationException) {
				ConstraintViolationException constraintViolationException = (ConstraintViolationException) e
						.getRootCause();
				throw new ConstraintViolationException(constraintViolationException.getConstraintViolations());
			}
		}

	}

	/**
	 * updateMultipleStudents method used to update  bulk student data
	 * 
	 * @param studentList
	 * @throws ConstraintViolationException
	 */
	@PutMapping("/updateAllDetails")
	public void updateMultipleStudents(@Valid @RequestBody List<Student> studentList)
			throws ConstraintViolationException {
		try {
			studentService.updateMultipleDetails(studentList);
		} catch (TransactionSystemException e) {
			if (e.getRootCause() instanceof ConstraintViolationException) {
				ConstraintViolationException constraintViolationException = (ConstraintViolationException) e
						.getRootCause();
				throw new ConstraintViolationException(constraintViolationException.getConstraintViolations());
			}
		}
	}
	
	/**
	 * deleteMultipleDetails method used to delete student data
	 * @param studentList
	 */
	@DeleteMapping("/deleteAllDetails")
	public void deleteMultipleDetails(@RequestBody List<Student> studentList)
	{
		studentService.deleteMultipleDetails(studentList);
	}
	
	/**
	 *  deleteAll method delete data of all students
	 */
	@DeleteMapping("/deleteAll")
	public void deleteAll()
	{
		studentService.deleteAll();
	}

}
