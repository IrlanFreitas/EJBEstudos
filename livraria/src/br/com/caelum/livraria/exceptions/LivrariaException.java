package br.com.caelum.livraria.exceptions;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class LivrariaException extends RuntimeException {

	private static final long serialVersionUID = -1530517312232558852L;
	
	public LivrariaException(String mensagem) {
		super(mensagem);
	}
	
	public LivrariaException() {}

}
