package br.com.caelum.livraria.dao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Usuario;

@Stateful
public class UsuarioDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	public Usuario buscaPeloLogin(String login) {
		
		String jpql = "Select us from Usuario us "
				+ " where us.login = :pLogin ";
		
		TypedQuery<Usuario> query = manager.createQuery( jpql, Usuario.class);
		if (login != null && !login.trim().isEmpty()) {
			query.setParameter("pLogin", login);			
		}
		
		return query.getSingleResult();
	}
	
}
