/*package com.thbs.StudentData.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thbs.StudentData.entity.Student;
import com.thbs.StudentData.repository.StudentRepository;

@Service
public class StudentService {
@Autowired
private StudentRepository repo;

public List<Student>getAllStudent(){
	List<Student>allStudent=new ArrayList<Student>();
	
	repo.findAll().forEach(s ->allStudent.add(s));
	return allStudent;
}

public Student addStudent(Student std) {
	return repo.save(std);
}

public Optional<Student> getStudentById(int id) {
	return repo.findById(id);
}


}*/
