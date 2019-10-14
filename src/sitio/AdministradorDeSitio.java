package sitio;

import publicacion.Servicio;

public class AdministradorDeSitio {

	private Sitio sitio;

	public AdministradorDeSitio(Sitio sitio) {
		this.sitio = sitio;
	}

	public void crearServicio(String nombreServicio) {
		Servicio servicioNuevo = new Servicio(nombreServicio);
		this.sitio.agregarServicio(servicioNuevo);
	}

}
