package com.twg.restapi.service;

import com.twg.restapi.entity.Student;

public interface StudentService extends BaseService<Student, Integer> {
	
	public Student updateStudent(int id, Student student);
}
