package com.universidadeuropea.dao;

public interface IDao<T, K> {
	
	T save(T objeto);
	
	T read(K id);
	
	void delete(T objeto);
	
	void deleteById(K id);
	
	T update(T objeto);
	
}
