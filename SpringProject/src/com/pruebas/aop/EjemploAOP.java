package com.pruebas.aop;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class EjemploAOP{

	public static void main(String[] args) {

		XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource(
				"com/pruebas/aop/applicationContext.xml"));
		
		ICalcular calc = (ICalcular)bf.getBean("proxy");
		
		System.out.println("Sumar(500 + 200): " + calc.sumar(500, 200));
		
	
	}

}
