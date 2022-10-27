package com.thbs.StudentData.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.thbs.StudentData.entity.Student;

@Repository
public class StudentRepo implements StudentRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int save(Student info) {
		return jdbcTemplate.update("INSERT INTO Student(id,name,dept,grade) VALUES(?,?,?,?)",
				new Object[] { info.getId(), info.getName(), info.getDept(), info.getGrade() });
	}

	@Override
	public int update(Student details) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student findById(long id) {

		try {
			Student std = jdbcTemplate.queryForObject("Select * from Student where id=?",
					BeanPropertyRowMapper.newInstance(Student.class), id);
			return std;
		}

		catch (Exception e) {
			return null;
		}
	}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update("delete  from Student where id=?",id);
	}

	@Override
	public List<Student> findAll() {

		return jdbcTemplate.query("SELECT * from student", BeanPropertyRowMapper.newInstance(Student.class));
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

}
