package inmobiliaria;

import java.time.LocalDate;

public abstract class Usuario { // Clase nueva

	public Usuario(String nombre, String email, String telefono, LocalDate fechaCreacion) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.fechaCreacion = fechaCreacion;
	}
	
	protected String nombre;
	protected String email;
	protected String telefono;
	protected LocalDate fechaCreacion;
	
	
	protected String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected String getTelefono() {
		return telefono;
	}
	protected void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	protected LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	protected void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
}
