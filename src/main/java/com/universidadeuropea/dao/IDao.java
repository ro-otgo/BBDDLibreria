package com.universidadeuropea.dao;

import java.util.List;

/**
 * Interfaz para interactuar con la base de datos.
 * 
 * Se realizan las operaciones tipicas CRUD.
 * 
 * @author Rodrigo
 *
 * @param <T> Objeto base.
 * @param <K> Tipo de la clave primaria del objeto base. 
 */
public interface IDao<T, K> {
	
	T save(T objeto);
	
	List<T> getAll();
	
	T getById(K id) throws Exception;
	
	void delete(T objeto) throws Exception;;
	
	boolean deleteById(K id) throws Exception;
	
	T update(T objeto);
	
}
