package br.com.teste.service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ServicoSingletonEJB {
	
	@PostConstruct
	private void info() {
		System.out.println("ServicoSingletonEJB criado");
	}
	
	public void processa() {
		try {
			System.out.println("inicio ServicoSingletonEJB");
			Thread.sleep(20000); //20s
			System.out.println("- fim ServicoSingletonEJB");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
	
}
