package inmobiliaria;

import java.time.LocalDate;

public class PosibleInquilino extends Usuario { //Clase nueva

	public PosibleInquilino(String nombre, String email, String telefono, LocalDate fechaCreacion) {
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public void reservarPublicacion(Publicacion publicacion) {
		publicacion.setPosibleinquilino(this);
	}
	
}
