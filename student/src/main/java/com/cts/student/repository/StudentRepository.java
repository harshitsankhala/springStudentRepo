package com.cts.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.student.model.Student;
/**
 * 
 * @author 882851
 * 
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
