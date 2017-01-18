package br.com.teste.service;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.com.teste.interceptador.Tempo;

@Stateless
@Interceptors({Tempo.class})
public class ServicoAssincronoEJB {

	public void servicoSincrono() {
		try {
			Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	@Asynchronous
	public void servicoAssincrono() {
		try {
			Thread.sleep(1000 * 20);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
