package inmobiliaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDeReservas {

	private List<Reserva> reservasPendientes;
	private Sitio sitio;

	public AdministradorDeReservas(Sitio sitio) {
		this.reservasPendientes = new ArrayList<Reserva>();
		this.sitio = sitio;
	}

	public List<Reserva> listarReservasPendientes() {
		return this.reservasPendientes;
	}

	public Reserva realizarReserva(Inquilino inquilino, Publicacion publicacion, LocalDate checkIn, LocalDate checkOut,int cantidadDeInquilinos) {
		
		if(publicacion.puedeReservarse(checkIn, checkOut)) {
			Reserva nuevaReserva = new Reserva(inquilino, publicacion, checkIn, checkOut, cantidadDeInquilinos);
			this.reservasPendientes.add(nuevaReserva);
			
			return nuevaReserva;
		}
		
	}

}
