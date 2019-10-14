package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import publicacion.Inmueble;
import sitio.Reserva;
import sitio.Sitio;

public class Propietario extends Usuario{
	
	private List<Inmueble> inmuebles;
	
	public Propietario(String nombre, String email, String telefono, LocalDate fechaCreacion) {
		super(nombre, email, telefono, fechaCreacion);
		inmuebles = new ArrayList<Inmueble>();
	}

	public void agregarInmueble(Inmueble inmueble) {
		this.inmuebles.add(inmueble);
	}
	
	public void notificarReservaPendiente(Reserva nuevaReserva) {
		Sitio.getInstance().getServidorMail().enviarMail(this.getEmail(), 
				"Tenes una nueva reserva!", 
				"El usuario " + nuevaReserva.getInquilino().getNombre() + 
				" ha realizado una reserva en tu inmueble");
	}

}
