package com.ias.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ias.service.exception.GenericServiceException;

/**
 * Servicio generico que expone los servicios comunes y solicita la implementación
 * de otros métodos en especifico 
 * 
 * @author Paul Arenas
 *
 */
public interface GenericService<T, ID extends Serializable> {
	
	public default Iterable<T> findAll() {
		return getRepository().findAll();
	}
	
	public default Optional<T> get(ID id) {
		return getRepository().findById(id);
	}
	
	public default T save(T entity) {
		return getRepository().save(entity);
	}
	
	public default void delete(ID id) {
		if (getRepository().existsById(id)) {
			getRepository().deleteById(id);
		}
		else {
			throw new GenericServiceException("id doesn't exists: " + id);
		}
	}
	
	public default void update(T entity) {
		if (getRepository().existsById(getId(entity))) {
			getRepository().save(entity);
		}
		else {
			throw new GenericServiceException("Can't update because it doesn't exist in DB: " + entity);
		}
	}
	
	public ID getId(T entity);
	
	public CrudRepository<T, ID> getRepository();
}