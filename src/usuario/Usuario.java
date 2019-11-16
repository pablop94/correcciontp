package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import publicacion.Inmueble;
import publicacion.Reserva;
import sitio.Sitio;

public class Usuario {

	private String nombre;
	private String email;
	private String telefono;
	private LocalDate fechaRegistro;
	private List<Reserva> reservas;
	private List<Inmueble> inmuebles;
	private Sitio sitio;
	
	public Usuario(String nombre, String email, String telefono, LocalDate fechaRegistro, Sitio sitio) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.fechaRegistro = fechaRegistro;
		reservas = new ArrayList<Reserva>();
		inmuebles = new ArrayList<Inmueble>();
		this.sitio = sitio;
	}
	
	public Usuario() {	}

	public String getNombre() {
		return nombre;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public Reserva agregarReserva(Reserva reserva) {
		this.reservas.add(reserva);
		return reserva;
	}
	
	public List<Inmueble> getInmuebles() {
		return this.inmuebles;
	}
	
	public void agregarInmueble(Inmueble inmueble) {
		if (!this.getInmuebles().contains(inmueble)) {
			this.inmuebles.add(inmueble);
		} else {
			return;
		}
	}

	public Sitio getSitio() {
		return this.sitio;
	}
	
	public void notificarReservaPendiente(Reserva reserva) {
		//Acá puede hacerse this.sitio.enviarMail() entonces el sitio se encarga de saber cómo enviarlo y no accedes a su servidor de mails
		this.sitio.getServidorMail().enviarMail(this.getEmail(), 
				"Tenes una nueva reserva!", 
				"El usuario " + reserva.getInquilino().getNombre() + 
				" ha realizado una reserva en tu inmueble");
	}
	
	public void notificarReservaConcretada(Reserva reserva) {
		// idem anterior
		this.sitio.getServidorMail().enviarMail(this.getEmail(), 
				"Tu reserva se confirmo!", 
				"El usuario " + reserva.getPublicacion().getPropietario().getNombre() + " acepto tu reserva!");
	}
	
}
