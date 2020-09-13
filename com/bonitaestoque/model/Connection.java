package com.bonitaestoque.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	private EntityManagerFactory emf = null;
	private EntityManager et = null;

	private static Connection conn;

	public Connection() {
	}

	public static Connection getInstance() {
		if (conn == null)
			conn = new Connection();
		return conn;
	}

	/**
	 * Retorna a conexão com bd se já estiver aberta, retorna o a instancia
	 * previamente aberta, caso contrario abre uma nova
	 * 
	 * @return
	 */
	public EntityManager createConn() {
		emf = emf == null ? Persistence.createEntityManagerFactory("bonitaestoque") : emf;
		return et != null && et.isOpen() ? et : emf.createEntityManager();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	public EntityManager getEntityManagaer() {
		return et;
	}

}
