package me.project.santander_dev_week_2024_v20.services;

import java.util.List;

public interface CrudService<ID, T> {

	List<T> findAll();
	T findById(ID id);
	T create(T entity);
	T update(ID id, T entity);
	void delete(ID id);
}
