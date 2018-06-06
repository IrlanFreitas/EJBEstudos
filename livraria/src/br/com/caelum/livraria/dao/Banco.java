package br.com.caelum.livraria.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.modelo.Usuario;

//javax.ejb
//@Singleton 
// Eager Initialization -  Depois disso, após inicializar o servidor de aplicação já é exibida a 
// mensagem no console que está no callback @PostConstruct
//@Startup  
public class Banco {
	
	@PersistenceContext
	private EntityManager manager;
	
	@PostConstruct
	void aposCriacao() {
//		inicializaBanco();
		System.out.println("BancoDao foi instanciado pelo EJB container");
	}
	
	@SuppressWarnings("unused")
	private void inicializaBanco() {
		Autor silveira = new Autor("Paulo Silveira");
		Autor cordeiro = new Autor( "Gilliard Cordeiro");
		Autor coelho = new Autor( "Hébert Coelho");
		
		manager.persist(silveira);
		manager.persist(cordeiro);
		manager.persist(coelho);
		
		manager.persist(new Livro("Java 8 prático",silveira));
		manager.persist(new Livro("Lógica de Programação",silveira));

		manager.persist(new Livro("CDI: Integre as dependências",cordeiro));
		manager.persist(new Livro("JSF e JPA",cordeiro));

		manager.persist(new Livro("JPA Efficaz",coelho));
		manager.persist(new Livro("JSF Efficaz",coelho));
		
		manager.persist(new Usuario("admin", "pass"));
	}

}
