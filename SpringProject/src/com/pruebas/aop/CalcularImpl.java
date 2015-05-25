package com.pruebas.aop;

public class CalcularImpl implements ICalcular {

	@Override
	public int sumar(int c1, int c2) {
		return c1+c2;
	}

}
