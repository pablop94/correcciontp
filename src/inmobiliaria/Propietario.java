package inmobiliaria;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Propietario extends Usuario{ //Clase nueva

	private Map propiedadesEnAlquiler;
	
	
	public Propietario(String nombre, String email, String telefono, LocalDate fechaCreacion) {
		super(nombre, email, telefono, fechaCreacion);
		Map<Publicacion,Inquilino> propiedadesEnAlquiler = new HashMap<Publicacion, Inquilino>();
	}
	
	public void agregarAlDic(Inquilino pi, Publicacion publi) {
		this.propiedadesEnAlquiler.put(pi, publi);
	}

	public void notificarReservaPendiente(Reserva nuevaReserva) {
		Sitio.getInstance().getServidorMail().enviarMail(this.getEmail(), 
				"Tenes una nueva reserva!", 
				"El usuario " + nuevaReserva.getInquilino().getNombre() + 
				" ha realizado una reserva en tu inmueble");
	}

}
