package com.pruebas;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ExemploInjection {

	public static void main(String[] args) {

		XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource(
				"com/pruebas/applicationContext.xml"));
		
		Ipropriedades prp = (Ipropriedades) bf.getBean("propiedades");
		
		System.out.println("Valore marca: " + prp.getMarca());
		
		System.out.println("Propiedades: " + prp.getPropiedades());
		
		bf.destroyBean("propiedades", prp);
	}

}
