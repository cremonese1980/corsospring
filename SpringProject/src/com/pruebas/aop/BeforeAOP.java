package com.pruebas.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAOP implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object cls)
			throws Throwable {
		System.out.println("-------------Before-------------------");
		System.out.println("Metodo: " + method);
		
		for (Object object : args) {
			System.out.println("Argumento: " + object.toString());
		}
		
		System.out.println("Clase: " + cls.toString());

	}

}
