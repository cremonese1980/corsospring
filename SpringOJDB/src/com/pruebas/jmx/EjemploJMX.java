package com.pruebas.jmx;

import java.io.Serializable;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.jmx.export.annotation.ManagedOperationParameters;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName="Ventura24:name=ejemplojmx",
		description="Nuestro MB de ejemplo")
public class EjemploJMX implements Serializable {
	
	
	String usuario = System.getProperty("user.name");

	private static final long serialVersionUID = 8382169223187588868L;
	

	public EjemploJMX() {
		System.out.println("Ejemplo JMX construido");
	}


	@ManagedAttribute
	public String getUsuario() {
		return usuario;
	}

	@ManagedAttribute(description="Nombre del login del SO")
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@ManagedOperation(description="suma de cantidades")
	@ManagedOperationParameters({@ManagedOperationParameter(name="c1", description="Cantidad c1"),
		@ManagedOperationParameter(name="c2", description="Cantidad c2")})
	public int sumar(int c1, int c2){
		
		return c1+c2;
	}
	
	

}
