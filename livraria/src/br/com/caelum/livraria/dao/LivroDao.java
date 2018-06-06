package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager manager;

	public void salva(Livro livro) {
		manager.persist(livro);
	}

	public List<Livro> todosLivros() {

		String jpql = "from Livro"; // Forma resumida de Select all do hql

		TypedQuery<Livro> query = manager.createQuery(jpql, Livro.class);

		return query.getResultList();
	}

	public List<Livro> getLivrosPeloTitulo(String titulo) {
		StringBuilder jpql = new StringBuilder("SELECT l FROM Livro l");

		if (titulo != null && !titulo.trim().isEmpty()) {
			jpql.append(" WHERE l.titulo LIKE :pTitulo ");
		}

		TypedQuery<Livro> query = manager.createQuery(jpql.toString(), Livro.class);
		if (titulo != null && !titulo.trim().isEmpty()) {
			query.setParameter("pTitulo","%"+ titulo+ "%");
		}

		return query.getResultList();
	}

}
