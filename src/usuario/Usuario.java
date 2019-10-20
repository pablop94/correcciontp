package usuario;

import java.time.LocalDate;

public abstract class Usuario {

	protected String nombre;
	protected String email;
	protected String telefono;
	protected LocalDate fechaRegistro;
	
	public Usuario(String nombre, String email, String telefono, LocalDate fechaRegistro) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.fechaRegistro = fechaRegistro;
	}
	
	public Usuario() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}
	
}
