package com.cts.student.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cts.student.model.Student;
import com.cts.student.service.StudentServiceImpl;
import com.cts.student.service.exception.StudentNotFoundException;

/**
 * 
 * @author harshit
 *
 */
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentServiceImpl studentService;

	//https://github.com/harshitsankhala/springStudentRepo.git
	@GetMapping("/demo")
	public String sayHello() {
		return "Hello";
	}

	/**
	 * addDetails method used to add details of student
	 * 
	 * @param student
	 */
	@PostMapping("/addDetails")
	public void addDetails(@Valid @RequestBody Student student) {
		studentService.addDetails(student);
	}

	/**
	 * studentByRollNo used to return student detail based on roll number
	 * 
	 * @param rollNumber
	 * @return
	 * @throws StudentNotFoundException
	 */
	@GetMapping("studentByRoll")
	public Student studentByRollNo(@RequestParam Long rollNumber) throws StudentNotFoundException {
		try {
			return studentService.studentByRollNo(rollNumber);
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			throw new StudentNotFoundException("No student found with roll number = " + rollNumber);
		}
	}

	
	
	/**
	 * updateDetails method used to update details of student 
	 * @param student
	 * @throws StudentNotFoundException
	 */
	@PutMapping("/update/{student}")
	public void updateDetails(@Valid @RequestBody Student student) throws StudentNotFoundException
	{
		try {
			studentService.updateDetail(student);
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			throw new StudentNotFoundException("Student not found.Please select exsisting student to update details.");
		}
	}
	
	/**
	 * deleteStudentByRollNo used to delete the record of student
	 * @param rollNumber
	 * @throws StudentNotFoundException
	 */
	@DeleteMapping("/delete")
	public void deleteStudentByRollNo(@RequestParam Long rollNumber) throws StudentNotFoundException
	{
		try {
		studentService.deleteStudentByRollNo(rollNumber);
		}
		catch(EmptyResultDataAccessException e)
		{
			throw new StudentNotFoundException("Student record does not found");
		}
	}

}
