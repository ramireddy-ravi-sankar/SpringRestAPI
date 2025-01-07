package com.twg.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twg.restapi.entity.Address;
import com.twg.restapi.entity.Student;
import com.twg.restapi.repository.StudentRepository;

@Service
public class StudentServiceImpl extends BaseServiceImpl<Student, Integer> implements StudentService {
	
	@Override
	@Transactional
	public Student save(Student student) {	
		if(student.getAddress()!=null) {
			for(Address address:student.getAddress()) {
				address.setStudent(student);
			}
		}
		return super.save(student);
	}

	@Override
	@Transactional
	public Student updateStudent(int id, Student student) {
		
		Student currentStudent=getById(id);
		
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
		return super.save(currentStudent);
	}

}
