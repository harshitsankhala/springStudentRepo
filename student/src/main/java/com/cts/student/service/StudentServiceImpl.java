package com.cts.student.service;

import java.util.List;
import java.util.Optional;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import com.cts.student.model.Student;
import com.cts.student.repository.StudentRepository;
import com.cts.student.service.exception.StudentNotFoundException;

/**
 * 
 * @author Harshit StudentServiceImpl class used to provide business logic
 */
@Service
public class StudentServiceImpl {

	@Autowired
	StudentRepository repository;

	/**
	 * addDetails method used to add details of student
	 * 
	 * @param student
	 */
	public void addDetails(Student student) {
		// TODO Auto-generated method stub
		repository.save(student);

	}

	/**
	 * addMultipleStudents method used to add bulk student data
	 * 
	 * @param studentList
	 * @throws ConstraintViolationException
	 */
	public void addMultipleStudent(List<Student> studentList) throws TransactionSystemException {

		repository.saveAll(studentList);

	}

	/**
	 * studentByRollNo used to return student detail based on roll number
	 * 
	 * @param rollNumber
	 * @return
	 * @throws StudentNotFoundException
	 */
	public Student studentByRollNo(Long rollNumber) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Student> optional = repository.findById(rollNumber);
		if (!optional.isPresent())
			throw new StudentNotFoundException();

		return optional.get();

	}

	/**
	 * allStudents method used to return all student details
	 * 
	 * @return
	 * @throws StudentNotFoundException
	 */
	public List<Student> allStudent() throws StudentNotFoundException {
		// TODO Auto-generated method stub
		List<Student> studentList = repository.findAll();
		if (studentList.isEmpty())
			throw new StudentNotFoundException();

		return studentList;
	}

	/**
	 * updateDetails method used to update details of student
	 * 
	 * @param student
	 * @throws StudentNotFoundException
	 */
	public void updateDetail(Student student) throws StudentNotFoundException {
		// TODO Auto-generated method stub

		Student tempStudent = this.studentByRollNo(student.getRollNumber());
		tempStudent.setFirstName(student.getFirstName());
		tempStudent.setLastName(student.getLastName());
		tempStudent.setDateOfBirth(student.getDateOfBirth());
		tempStudent.setRollNumber(student.getRollNumber());
		tempStudent.setStudentClass(student.getStudentClass());
		tempStudent.setCreatedBy(student.getCreatedBy());
		tempStudent.setCreatedDate(student.getCreatedDate());
		tempStudent.setModifiedBy(student.getModifiedBy());
		tempStudent.setModifiedDate(student.getModifiedDate());

		repository.save(tempStudent);

	}

	/**
	 * updateMultipleStudents method used to update bulk student data
	 * 
	 * @param studentList
	 * @throws ConstraintViolationException
	 */
	public void updateMultipleDetails(List<Student> studentList) throws TransactionSystemException {
		repository.saveAll(studentList);
	}

	/**
	 * deleteStudentByRollNo used to delete the record of student
	 * 
	 * @param rollNumber
	 * @throws EmptyResultDataAccessException
	 */
	public void deleteStudentByRollNo(Long rollNumber) throws EmptyResultDataAccessException {
		repository.deleteById(rollNumber);
	}

	/**
	 * deleteMultipleDetails method used to delete student data
	 * 
	 * @param studentList
	 */
	public void deleteMultipleDetails(List<Student> studentList) {
		repository.deleteAll(studentList);
	}

	/**
	 * deleteAll method delete data of all students
	 */
	public void deleteAll() {
		repository.deleteAll();
	}
}
