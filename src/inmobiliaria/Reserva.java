package inmobiliaria;

import java.time.LocalDate;

public class Reserva {
	
	private Inquilino inquilino;
	private Publicacion publicacion;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private int cantidadDeInquilinos;
	

	public Reserva(Inquilino inquilino, Publicacion publicacion, LocalDate checkIn, LocalDate checkOut, int cantidadDeInquilinos) {
		super();
		this.inquilino = inquilino;
		this.publicacion = publicacion;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.cantidadDeInquilinos = cantidadDeInquilinos;
	}


	public Inquilino getInquilino() {
		return inquilino;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public int getCantidadDeInquilinos() {
		return cantidadDeInquilinos;
	}

}
