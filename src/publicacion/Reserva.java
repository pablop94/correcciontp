package publicacion;

import java.time.LocalDate;

import usuario.Inquilino;

public class Reserva {
	private Publicacion publicacion;
	private Inquilino inquilino;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Boolean estaAceptada;
	
	public Reserva(Publicacion publicacion, Inquilino inquilino, LocalDate checkIn, LocalDate checkOut) {
		this.estaAceptada = false;
		this.publicacion = publicacion;
		this.inquilino = inquilino;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.getPublicacion().agregarReserva(this);
		this.getInquilino().agregarReserva(this);
		this.getPublicacion().getPropietario().notificarReservaPendiente(this);
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public Inquilino getInquilino() {
		return this.inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public Boolean estaAceptada() {
		return this.estaAceptada;
	}

	public void aceptar() {
		this.estaAceptada = true;
		this.getInquilino().notificarReservaConcretada(this);
	}
	
}
