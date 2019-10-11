package inmobiliaria;

import java.util.ArrayList;
import java.util.List;

public class Sitio {

	private List<Publicacion> publicaciones;
	private List<Servicio> servicios;
	public AdministradorDeSitio administradorDeSitio;
	public AdministradorDeReservas administradorDeReservas;

	public Sitio() {
		super();
		this.publicaciones = new ArrayList<Publicacion>();
		this.administradorDeSitio = new AdministradorDeSitio(this);
		this.administradorDeReservas = new AdministradorDeReservas(this);
		this.servicios = new ArrayList<Servicio>();
	}

	
	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public void agregarPublicacion(Publicacion publicacion) {
		this.publicaciones.add(publicacion);
	}


	public void eliminarPublicacion(Publicacion publicacion) {
		this.publicaciones.remove(publicacion);
	}


	public List<Servicio> getServicios() {
		return this.servicios;
	}


	public void agregarServicio(Servicio servicioNuevo) {
		this.servicios.add(servicioNuevo);
	}



}
