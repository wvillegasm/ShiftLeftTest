package com.itsoft.slt.ejb.service;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface UserServiceRemote<T> {
	
	List<T> findAll();
	
	T findById();
	
	void insert(T t);
	
	void update(T t);
	
	void delete(T t);
}
