package com.pruebas.oxm;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class Empleado implements Serializable {
	private static final long serialVersionUID = -8362145031142335092L;
	
	
	private String nombre;
	private int edad;
	@XmlTransient
	private long sueldo;
	
	
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Empleado(String nombre, int edad, long sueldo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public long getSueldo() {
		return sueldo;
	}



	public void setSueldo(long sueldo) {
		this.sueldo = sueldo;
	}
	
	
	
	
}
