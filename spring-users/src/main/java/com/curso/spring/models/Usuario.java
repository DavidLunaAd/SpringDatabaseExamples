package com.curso.spring.models;

//import javax.persistence.Column;

//@Entity
//@Table(name = "usuarios")
public class Usuario {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "id")
	private String id;
	
//	@Column(name = "nombre")
	private String nombre;
	
//	@Column(name = "apellido")
	private String apellido;
	
//	@Column(name = "email")
	private String email;
	
//	@Column(name = "telefono")
	private String telefono;
	
//	@Column(name = "password")
	private String password;
	
//	@Column(name = "ciudad")
	private String ciudad;
	
//	@Column(name = "descripcion")
	private String descripcion;
		
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
