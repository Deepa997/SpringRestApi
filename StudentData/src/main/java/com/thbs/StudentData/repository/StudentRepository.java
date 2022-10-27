package com.thbs.StudentData.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thbs.StudentData.entity.Student;

@Repository
public interface StudentRepository  {
	int save(Student info);
	int update(Student details);
	Student findById(long id);
	int deleteById(Long id);
	List<Student> findAll();
	int deleteAll();
	

}
 