package com.pruebas.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterAOP implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args,
			Object cls) throws Throwable {

		System.out.println("-------------After-------------------");
		System.out.println("Valor retorno: " + returnValue.toString());
		System.out.println("-------------------------------------");
	}

}
