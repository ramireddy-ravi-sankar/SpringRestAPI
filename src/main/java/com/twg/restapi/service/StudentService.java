package com.twg.restapi.service;

import java.util.List;

import com.twg.restapi.entity.Student;

public interface StudentService {
	
	public Student saveStudent(Student student);
	public List<Student> findAll();
	public Student findById(int id);
	public Student updateStudent(int id, Student student);
	public void deleteStudent(int id);
}
