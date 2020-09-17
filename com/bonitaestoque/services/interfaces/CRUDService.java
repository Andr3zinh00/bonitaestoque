package com.bonitaestoque.services.interfaces;

import java.util.List;

public interface CRUDService<E> {
	/**
	 * pega elemento por ID
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	E getById(Class<E> type, Long id);

	/**
	 * Atualiza um elemento no banco de dados
	 * @param element
	 * @return
	 */
	E update(Class<E>type, Long elementId);
	
	/**
	 * Cria um elemento no banco de dados
	 * 
	 * @param element
	 */
	void create(E element);

	/**
	 * Deleta a ocorrencia no bd por ID
	 * 
	 * @param id
	 */
	void delete(Class<E> type, Long id);

	/**
	 * Pega todos elementos
	 * 
	 * @param type
	 * @return
	 */
	List<E> getAll(Class<E> type);

	/**
	 * Pega por uma Query especifica
	 * 
	 * @param name
	 * @return
	 */
	List<E> getByName(Class<E> type, String name);
}
