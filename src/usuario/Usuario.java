package usuario;

import java.time.LocalDate;

public abstract class Usuario {

	public Usuario(String nombre, String email, String telefono, LocalDate fechaCreacion) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.fechaCreacion = fechaCreacion;
	}
	
	public Usuario() {
		super();
	}
	
	protected String nombre;
	protected String email;
	protected String telefono;
	protected LocalDate fechaCreacion;
	
	
	public String getNombre() {
		return nombre;
	}
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	protected void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	protected void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
}
