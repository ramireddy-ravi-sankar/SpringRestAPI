package com.twg.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twg.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
