package publicacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import usuario.Propietario;

public class Publicacion {

	private Inmueble inmueble;
	private int capacidad;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private double precio;
	private List<Reserva> reservas;
	
	public Publicacion(Inmueble inmueble, int capacidad, LocalDate checkIn, LocalDate checkOut, double precio) {
		this.inmueble = inmueble;
		this.capacidad = capacidad;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.precio = precio;
		this.reservas = new ArrayList<Reserva>();
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

	public Reserva agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
		return reserva;
	}
	
	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public Propietario getPropietario() {
		return this.getInmueble().getPropietario();
	}

	public Boolean puedeReservarseEn(LocalDate checkIn, LocalDate checkOut) {
		List<Boolean> collect = this.getReservas().stream().filter(reserva -> reserva.estaAceptada()).map(reserva -> this.tieneReservasPara(checkIn, checkOut, reserva)).collect(Collectors.toList());
		return (!collect.contains(true));
	}

	private Boolean tieneReservasPara(LocalDate checkIn, LocalDate checkOut, Reserva reserva) {
		return (checkIn.isBefore(reserva.getCheckOut()) && reserva.getCheckIn().isBefore(checkOut));
	}
	
//	public Boolean estaDentroDelCheckIn(LocalDate check) {
//		return (this.getCheckIn().isBefore(check) || this.getCheckIn().isEqual(check)) && check.isBefore(this.getCheckOut());
//	}
//	
//	public Boolean estaDentroDelCheckOut(LocalDate check) {
//		return (this.getCheckOut().isAfter(check) || this.getCheckOut().isEqual(check)) && check.isAfter(this.getCheckIn());
//	}
}
