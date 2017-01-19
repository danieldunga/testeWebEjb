package br.com.teste.service;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.com.teste.interceptador.Tempo;

@Stateless
@Interceptors({Tempo.class})
public class ServicoEJB {

	@PostConstruct
	private void info() {
		System.out.println("ServicoEJB criado");
	}
	
	public void processa(String string) {
		try {
			System.out.println("criando " + string);
			Thread.sleep(20000); //20s
			System.out.println("criado " + string);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
