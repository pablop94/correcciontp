package inmobiliaria;

import java.time.LocalDate;

public class Publicacion {

	private Inmueble inmueble;
	private int capacidad;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private double precio;
	
	public Publicacion(Inmueble inmueble, int capacidad, LocalDate checkIn, LocalDate checkOut, double precio) {
		this.inmueble = inmueble;
		this.capacidad = capacidad;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.precio = precio;
	}

	public Inmueble getInmueble() {
		return this.inmueble;
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public double getPrecio() {
		return this.precio;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}
	
	public LocalDate getCheckOut() {
		return checkOut;
	}
	
}
