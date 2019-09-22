package com.love2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="alumno")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message="el nombre es requerido")
	@Size(min=2, max=30, message="debe tener entre 2 y 30 caracteres máximo")
	@Column(name="nombre")
	private String nombre;
	
	@NotBlank(message="el primer apellido es requerido")
	@Size(min=2, max=30, message="debe tener entre 2 y 30 caracteres máximo")
	@Column(name="primer_apellido")
	private String primerApellido;
	
	@Column(name="segundo_apellido")
	private String segundoApellido;
	
	@NotBlank(message="el email es requerido")
	@Email(message="Introduzca un email válido")
	@Column(name="email")
	private String email;
	
	public Alumno() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido="
				+ segundoApellido + ", email=" + email + "]";
	}

	
	
	

}
