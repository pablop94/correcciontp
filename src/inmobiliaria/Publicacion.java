package inmobiliaria;

import java.time.LocalDate;

public class Publicacion { // Clase nueva

	private Inmueble inmueble;
	private int capacidad;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private double precio;
	private PosibleInquilino posibleInquilino; //se puede cambiar por un array para que en ves de que solo tenga un posible inquilino, tenga barios a la ves y el propietario decida a cual alquilarsela
	private Propietario DueñoPublicacion;
	
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
	
	public void setPosibleinquilino(PosibleInquilino pi) {
		this.posibleInquilino = pi;
	}
	
	public void notificacionDePosibleAlquiler(Propietario DueñoPublicacion) {
		DueñoPublicacion.agregarAlDic(posibleInquilino, this);
	}
	
}
