package inmobiliaria;

import java.util.List;

public class Inmueble {

	private String pais;
	private String ciudad;
	private Direccion direccion;
	private List<Servicio> servicios;
	
	public Inmueble(String pais, String ciudad, Direccion direccion, List<Servicio> servicios) {
		this.pais = pais;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.servicios = servicios;
	}

	public String getPais() {
		return this.pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}
}
