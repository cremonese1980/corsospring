package com.pruebas;

import java.io.Serializable;

public class Usuario implements Serializable {
	private static final long serialVersionUID = 8074982203043905372L;
	
	
	private long idusuario;
	private String nombre;
	private String appellido;
	private String telefono;
	private String ciudad;

	public Usuario() {
	}

	public Usuario(long idusuario, String nombre, String appellido,
			String telefono, String ciudad) {
		super();
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.appellido = appellido;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}

	public Usuario(String nombre, String appellido, String telefono,
			String ciudad) {
		super();
		this.nombre = nombre;
		this.appellido = appellido;
		this.telefono = telefono;
		this.ciudad = ciudad;
	}

	public long getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(long idusuario) {
		this.idusuario = idusuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAppellido() {
		return appellido;
	}

	public void setAppellido(String appellido) {
		this.appellido = appellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	

}
