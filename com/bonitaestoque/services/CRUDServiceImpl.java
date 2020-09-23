package com.bonitaestoque.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.bonitaestoque.model.Connection;
import com.bonitaestoque.services.interfaces.CRUDService;

public class CRUDServiceImpl<E> implements CRUDService<E> {

	Connection conn = Connection.getInstance();
	EntityManager entityM;

	@Override
	public void create(E element) {
		System.out.println(element);
		entityM = conn.createConn();
		entityM.getTransaction().begin();
		entityM.persist(element);
		entityM.getTransaction().commit();
		entityM.close();

	}

	@Override
	public void delete(Class<E> type, Long id) {
		entityM = conn.createConn();
		entityM.getTransaction().begin();
		entityM.remove(entityM.getReference(type, id));
		entityM.getTransaction().commit();
		entityM.close();
	}

	
	@Override
	public List<E> getAll(Class<E> type) {
		entityM = conn.createConn();

		CriteriaBuilder crit = entityM.getCriteriaBuilder();
		CriteriaQuery<E> query = crit.createQuery(type);

		Root<E> variableRoot = query.from(type);
		query.select(variableRoot);
		List<E> list = entityM.createQuery(query).getResultList();
		entityM.close();
		return list;
	}

	@Override
	public E getById(Class<E> type, Long id) {
		entityM = conn.createConn();

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> getByName(Class<E> type, String name) {

		entityM = conn.createConn();

//		select u from users u where u.segundoNome =:sg
		Query query = entityM.createQuery("select pr from " + type.getName() + " pr where pr.nome like :name");
		query.setParameter("name", "%" + name + "%");

		entityM.close();
//		
		return query.getResultList();
	}

	public E update(E element) {
		entityM = conn.createConn();
		
		entityM.getTransaction().begin();
		E updatedElement = entityM.merge(element);
		entityM.getTransaction().commit();
		entityM.close();

		return updatedElement;
	}

	@Override
	public E update(Class<E> type, Long elementId) {
		// TODO Auto-generated method stub
		return null;
	}

}
