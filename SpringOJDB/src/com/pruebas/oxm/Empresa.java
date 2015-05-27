package com.pruebas.oxm;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Empresa implements Serializable {

	private static final long serialVersionUID = -375076970414860823L;
	
	private int idempresa;
	private String nombre;
	private Collection<Empresa> empleados;
	
	
	
	public Empresa() {
		super();
	}



	public Empresa(String nombre) {
		super();
		this.nombre = nombre;
	}



	public Empresa(String nombre, Collection<Empresa> empleados) {
		super();
		this.nombre = nombre;
		this.empleados = empleados;
	}



	public int getIdempresa() {
		return idempresa;
	}


	@XmlAttribute
	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}



	public String getNombre() {
		return nombre;
	}


	@XmlElement
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Collection<Empresa> getEmpleados() {
		return empleados;
	}



	public void setEmpleados(Collection<Empresa> empleados) {
		this.empleados = empleados;
	}



	@Override
	public String toString() {
		return "Empresa [idempresa=" + idempresa + ", nombre=" + nombre
				+ ", empleados=" + empleados + "]";
	}
	
	

}
