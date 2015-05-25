package com.pruebas.annotaciones;

import org.springframework.stereotype.Service;

@Service
public class DemoImpl2 implements IDemo {

	public DemoImpl2() {
		System.out.println("DemoImpl2 construido");
	}

	@Override
	public void mostrarVAlor(String valor) {

		System.out.println("DemoImpl2 valor: " + valor);
	}

}
