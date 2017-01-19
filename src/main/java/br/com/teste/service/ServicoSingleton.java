package br.com.teste.service;


public class ServicoSingleton {

	private static ServicoSingleton instancia;
	
	private ServicoSingleton() {
		super();
		System.out.println("ServicoSingleton criado");
	}

	public static ServicoSingleton getInstance() {
		if (instancia == null) {
			instancia = new ServicoSingleton();
		}
		return instancia;
	}
	
	public void processa(String string) {
		try {
			System.out.println("inicio " + string);
			Thread.sleep(20000); //20s
			System.out.println("- fim " + string);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}
