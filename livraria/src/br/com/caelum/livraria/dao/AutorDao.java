package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER) //Opcional - Configuração de transação pelo CMT
//@Interceptors({ LogInterceptor.class }) //Indicando que essa classe será interceptada
public class AutorDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostConstruct
	void aposCriacao() {
		
		System.out.println("AutorDao acaba de ser criado.");
		
	}
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY) // Configuração de Transação
	public void salva(Autor autor) {
		
		System.out.println("Salvando o autor "+ autor.getNome());
		
//		Utilizado para exibir que o Session Bean Stateless é thread safe
//		porque caso um esteja em uso, será criado outro, baseado no pool de objetos
//		try {
//			Thread.sleep(20000); //20s
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		manager.persist(autor);
		
		System.out.println("Salvou o autor "+ autor.getNome());
	}
	
	public List<Autor> todosAutores() {
		
		String jpql = "from Autor";
		
		TypedQuery<Autor> query = manager.createQuery(jpql, Autor.class);
		
		return query.getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		
		return manager.find(Autor.class, autorId);
	}
	
}
