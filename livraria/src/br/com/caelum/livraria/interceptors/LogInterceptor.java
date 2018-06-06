package br.com.caelum.livraria.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptor {
	
	@AroundInvoke
	public Object interceptar(InvocationContext context) throws Exception {
		
		long millis = System.currentTimeMillis();
		
		//Método a ser chamado
		Object object = context.proceed();
		
		String nomeDoMetodo = context.getMethod().getName();
		
		String nomeClasse = context.getTarget().getClass().getSimpleName();
		
		System.out.println("Classe: "+ nomeClasse+ " - Método: "+ nomeDoMetodo + 
				"- Tempo de Execução: "+ (System.currentTimeMillis() - millis)+ " milisegundos" );
		
		return object;
	}

}
