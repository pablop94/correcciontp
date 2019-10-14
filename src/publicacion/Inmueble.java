package publicacion;

import java.util.List;

import usuario.Propietario;

public class Inmueble {

	private String pais;
	private String ciudad;
	private Direccion direccion;
	private List<Servicio> servicios;
	private Propietario propietario;
	
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

	public Propietario getPropietario() {
		return this.propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
		propietario.agregarInmueble(this);
	}
	
}
