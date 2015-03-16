package com.itsoft.slt.ejb.service;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IServiceLocal<T> {

	List<T> findAll();
	
	T findById(T t);

	void insert(T t);

	void update(T t);

	void delete(T t);

}
