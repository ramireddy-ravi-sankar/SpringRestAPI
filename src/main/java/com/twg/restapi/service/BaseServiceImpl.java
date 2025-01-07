package com.twg.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseServiceImpl<T, ID> implements BaseService<T, ID> {

	@Autowired
	protected JpaRepository<T, ID> repository;
	
	@Override
	public T getById(ID id) {
		T entity=repository.findById(id).get();
		return entity;
	}

	@Override
	public List<T> getAll() {
		
		return repository.findAll();
	}

	@Override
	public T save(T entity) {
		
		return repository.save(entity);
	}

	@Override
	public void deleteById(ID id) {
		repository.deleteById(id);
	}

}
