package com.twg.restapi.service;

import java.util.List;

public interface BaseService<T, ID> {
	
	T getById(ID id);
	List<T> getAll();
	T save(T entity);
	void deleteById(ID id);
}
