package com.pruebas;

import java.util.Enumeration;
import java.util.Properties;

public class PropiedadesImpl implements Ipropriedades {
	
	private String marca;	

	public PropiedadesImpl() {
		System.out.println("Implementation construida");
	}
	
	public void inicio(){
		System.out.println("Metodo inicio() invocado");
	}
	
	public void destruir(){
		System.out.println("Metodo destruir() invocado");
	}

	@Override
	public String getMarca() {
		// TODO Auto-generated method stub
		return marca;
	}

	@Override
	public String getPropiedades() {
		Properties properties = System.getProperties();
		Enumeration en = properties.propertyNames();
		String ps = "";
		while(en.hasMoreElements()){
			String key = (String)en.nextElement();
			ps+= "Propiedad " + key + ": " +
			properties.getProperty(key) + "\n";
			
		}
		return ps;
	}

	public void setMarca(String marca) {
		System.out.println("Inyectando marca");
		this.marca = marca;
	}

}
