package sitio;

import publicacion.Servicio;
import usuario.Usuario;

public class AdministradorDeSitio extends Usuario{

	private Sitio sitio;

	public AdministradorDeSitio(Sitio sitio) {
		super();
		this.sitio = sitio;
	}

	public void crearServicio(String nombreServicio) {
		Servicio servicioNuevo = new Servicio(nombreServicio);
		this.sitio.agregarServicio(servicioNuevo);
	}

}
