package com.twg.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.twg.restapi.entity.Student;
import com.twg.restapi.service.StudentService;



@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	

	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List<Student> students = studentService.getAll();
		return students;
	}
	
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		
		Student student=studentService.getById(id);
		return student;
	}
	
	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		
		studentService.save(student);
	}
	
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id,@RequestBody Student student) {
		
		Student updateStudent=studentService.updateStudent(id, student);
		return updateStudent;
	}
	
	@DeleteMapping("/student/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteStudent(@PathVariable int id) {
		
		studentService.deleteById(id);
	}
}
