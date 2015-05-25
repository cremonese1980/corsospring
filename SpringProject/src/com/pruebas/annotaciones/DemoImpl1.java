package com.pruebas.annotaciones;

import org.springframework.stereotype.Component;

@Component
public class DemoImpl1 implements IDemo {
	
	

	public DemoImpl1() {
		System.out.println("DemoImpl1 construido");
	}

	@Override
	public void mostrarVAlor(String valor) {

		System.out.println("DemoImpl1 valor: " + valor);
	}

}
