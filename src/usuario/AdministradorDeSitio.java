package usuario;

import sitio.Sitio;

public class AdministradorDeSitio extends Usuario{

	private Sitio sitio;

	public AdministradorDeSitio(Sitio sitio) {
		super();
		this.sitio = sitio;
	}

	public void crearServicio(String nombreServicio) {
		this.sitio.agregarServicio(nombreServicio);
	}

	public void crearTipoInmueble(String tipoInmueble) {
		this.sitio.agregarTipoInmueble(tipoInmueble);
	}
}
