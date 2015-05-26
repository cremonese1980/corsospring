package com.pruebas;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;



@Entity
@Component
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5336924626160403519L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private Double money;
	

	public Persona() {
		// TODO Auto-generated constructor stub
	}


	public Persona(Integer id, String firstName, String lastName, Double money) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.money = money;
	}


	public Persona(String firstName, String lastName, Double money) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.money = money;
	}

 
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Double getMoney() {
		return money;
	}


	public void setMoney(Double money) {
		this.money = money;
	}
	
	

}
