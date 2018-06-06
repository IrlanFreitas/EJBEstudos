package br.com.caelum.livraria.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//@Singleton
//@Startup
public class FactoryDao {
	
	 private EntityManagerFactory emf =  Persistence.createEntityManagerFactory("livraria-mysql");

//	 @Produces
	 public EntityManager getEntityManager() {
		 return emf.createEntityManager();
	 }
	 
}
