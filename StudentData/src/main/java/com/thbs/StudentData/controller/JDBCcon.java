package com.thbs.StudentData.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thbs.StudentData.entity.Student;
import com.thbs.StudentData.repository.StudentRepo;


@RestController
@RequestMapping("api")
public class JDBCcon {
	
	 Logger logger= LoggerFactory.getLogger(JDBCcon.class);
	
	@Autowired
StudentRepo repo;
@GetMapping("/student/{id}")
public ResponseEntity<Student> getStudentById(@PathVariable("id") long id){
	logger.info("accesing id:"+id);
	try {
		Student s=repo.findById(id);
		if(s!=null) {
			return new ResponseEntity<>(s,HttpStatus.OK);
			
			}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}catch(Exception e) {
		return null;
	}
	
	
	
}

@DeleteMapping("/student/{id}")
public ResponseEntity<String> deleteById(@PathVariable("id") long id){
	try {
		int result=repo.deleteById(id);
		if(result==0) {
			//return new ResponseEntity<>(id,HttpStatus.OK);
			
		}
		return new ResponseEntity<>(HttpStatus.OK);
			
	}catch(Exception e) {
		return null;
	}
}
}


