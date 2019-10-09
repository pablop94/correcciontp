package inmobiliaria;

import java.util.Date;

public class Publicacion {

	private Inmueble inmueble;
	private int capacidad;
	private Date checkIn;
	private Date checkOut;
	private double precio;
	
	public Publicacion(Inmueble inmueble, int capacidad, Date checkIn, Date checkOut, double precio) {
		this.inmueble = inmueble;
		this.capacidad = capacidad;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.precio = precio;
	}

	public Publicacion() {
		// TODO Auto-generated constructor stub
	}

}
