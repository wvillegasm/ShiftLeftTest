package com.itsoft.slt.ejb.eis;

import java.util.List;

public interface EntityDAO<T> {

	List<T> findAll();

	T findById(T t);

	void save(T t);

	void update(T t);

	void delete(T t);

}
