package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import publicacion.Reserva;
import sitio.Sitio;

public class Inquilino extends Usuario {
    
	private List<Reserva> reservas;
	
	public Inquilino(String nombre, String email, String telefono, LocalDate fechaCreacion) {
		super(nombre, email, telefono, fechaCreacion);
		reservas = new ArrayList<Reserva>();
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public Reserva agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
		return reserva;
	}

	public void notificarReservaConcretada(Reserva reserva) {
		Sitio.getInstance().getServidorMail().enviarMail(this.getEmail(), 
				"Tu reserva se confirmo!", 
				"El propietario acepto tu reserva!");
	}
	
}
