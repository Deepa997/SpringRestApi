package com.thbs.StudentData.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private String name;
private String dept;
private int grade;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(long id, String name, String dept, int grade) {
	super();
	this.id = id;
	this.name = name;
	this.dept = dept;
	this.grade = grade;
}
public long getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public int getGrade() {
	return grade;
}
public void setGrade(int grade) {
	this.grade = grade;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", dept=" + dept + ", grade=" + grade + "]";
}

}
