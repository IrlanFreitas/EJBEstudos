package br.com.caelum.livraria.test;

import java.rmi.RemoteException;

import br.com.caelum.livraria.webservice.LivrariaWSProxy;
import br.com.caelum.livraria.webservice.Livro;

public class WSClientTest {

	public static void main(String[] args) throws RemoteException {
		
		LivrariaWSProxy proxy = new LivrariaWSProxy();
		
		Livro[] livros = proxy.getLivrosPeloTitulo("");
		
		for(Livro livro: livros) {
			System.out.println(livro);
		}

	}

}
