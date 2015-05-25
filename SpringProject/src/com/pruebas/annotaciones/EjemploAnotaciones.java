package com.pruebas.annotaciones;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EjemploAnotaciones {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		
		ac.scan("com.pruebas.annotaciones");
		ac.refresh();
		
		ClaseconDependencia ccd = (ClaseconDependencia)ac.getBean("claseconDependencia");
		
		ccd.comprobar();

	}

}
