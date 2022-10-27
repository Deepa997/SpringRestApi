package com.thbs.StudentData.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.thbs.StudentData.entity.Student;

public class StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String Get_Student="select name,grade,dept from student where id=?";
	
	
		
	List<Student> users = jdbcTemplate.query("Get_Student", new BeanPropertyRowMapper(Student.class));
	
		

}
