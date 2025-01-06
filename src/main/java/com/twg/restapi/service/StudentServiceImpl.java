package com.twg.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twg.restapi.entity.Address;
import com.twg.restapi.entity.Student;
import com.twg.restapi.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	@Transactional
	public Student saveStudent(Student student) {	
		if(student.getAddress()!=null) {
			for(Address address:student.getAddress()) {
				address.setStudent(student);
			}
		}
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public Student updateStudent(int id, Student student) {
		
		Student currentStudent=studentRepository.findById(id).get();
		
		currentStudent.setName(student.getName());
		currentStudent.setBranch(student.getBranch());
		currentStudent.setPercentage(student.getPercentage());
		
		if(student.getAddress()!=null) {
			currentStudent.getAddress().clear();
			for(Address address:student.getAddress()) {
				address.setStudent(currentStudent);
				currentStudent.getAddress().add(address);
			}
		}
		return studentRepository.save(currentStudent);
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
		
	}

}
