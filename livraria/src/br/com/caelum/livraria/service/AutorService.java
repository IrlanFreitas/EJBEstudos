package br.com.caelum.livraria.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorService {
	
	@Inject
	private AutorDao dao;
	
	public void adiciona(Autor autor) {
		
		//Mais regras aqui
		
		dao.salva(autor);
		
		//Regra de negócio deu erro
		//Entendendo a forma do EJB lidar com as exceções.
		//throw new LivrariaException("Erro ao adicionar um autor");
	}
	
	public List<Autor> todosAutores() {
		return this.dao.todosAutores();
	}
	
}
