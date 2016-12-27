package br.com.teste.service;

public class ServicoNormal {

	public ServicoNormal() {
		System.out.println("ServicoNormal criado");
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
