package br.com.teste.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class Tempo {

	@AroundInvoke
	public Object contaTempoExecucao(InvocationContext context) throws Exception {
		long inicio = System.currentTimeMillis();
		
		Object retorno = context.proceed();
		
		String nomeClasse = context.getTarget().getClass().getSimpleName();
		String nomeMetodo = context.getMethod().getName();
		
		System.out.println("Tempo de execução da classe " + nomeClasse + " e metodo " + nomeMetodo + " foi de " + (System.currentTimeMillis() - inicio) + "ms");
		
		return retorno;
	}
}
