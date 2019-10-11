package inmobiliaria;

import java.time.LocalDate;

public abstract class Usuario { // Clase nueva

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
