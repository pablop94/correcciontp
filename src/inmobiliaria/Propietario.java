package inmobiliaria;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Propietario extends Usuario{ //Clase nueva

	private Map propiedadesEnAlquiler;
	
	
	public Propietario(String nombre, String email, String telefono, LocalDate fechaCreacion) {
		Map<Publicacion,PosibleInquilino> propiedadesEnAlquiler = new HashMap<Publicacion, PosibleInquilino>();
		this.email = email;
		this.fechaCreacion = fechaCreacion;
		this.nombre = nombre;
		this.telefono = telefono;
	}
	
	public void agregarAlDic(PosibleInquilino pi, Publicacion publi) {
		this.propiedadesEnAlquiler.put(pi, publi);
	}
	
	

}
