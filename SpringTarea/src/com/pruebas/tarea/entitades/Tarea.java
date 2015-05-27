package com.pruebas.tarea.entitades;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component("Tarea")
public class Tarea implements Serializable {
	private static final long serialVersionUID = 8074982203043905372L;
	
	
	private long idtarea;
	private String contenido;

	public Tarea() {
		System.out.println("Tarea iniciada");
	}
	

	public Tarea(String contenido) {
		super();
		this.contenido = contenido;
	}
	
	public Tarea(long idtarea, String contenido) {
		super();
		this.idtarea = idtarea;
		this.contenido = contenido;
	}


	public long getIdtarea() {
		return idtarea;
	}


	public void setIdtarea(long idtarea) {
		this.idtarea = idtarea;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	@Override
	public String toString() {
		return "Tarea [idtarea=" + idtarea + ", contenido= " + contenido + "]";
	}
	
	

}