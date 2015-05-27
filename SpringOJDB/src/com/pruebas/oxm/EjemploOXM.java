package com.pruebas.oxm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class EjemploOXM {

	public static void main(String[] args) {

		XmlBeanFactory bf = new XmlBeanFactory(new ClassPathResource(
				"com/pruebas/oxm/applicationContext.xml"));
		
		OxMapper oxMapper = (OxMapper)bf.getBean("oxMapper");
		
		Empleado ana = new Empleado("Ana", 22, 1200L);
		Empleado luis = new Empleado("Luis", 33, 995L);
		Empleado ana2 = new Empleado("Ana", 23, 1200L);
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(ana);
		empleados.add(ana2);
		empleados.add(luis);
		
		Empresa ventura24 = new Empresa("Ventura24", empleados);
		
		String archivo = "empresa.xml";
		try {
			oxMapper.writeObjectToXml(ventura24, archivo);
			System.out.println("Empresa serializada en XML");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Empresa empresaReconstruida = (Empresa) oxMapper.readObjectFromXml(archivo);
			System.out.println(empresaReconstruida);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
