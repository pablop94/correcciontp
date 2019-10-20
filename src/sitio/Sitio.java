package sitio;

import java.util.ArrayList;
import java.util.List;

import publicacion.Publicacion;

public class Sitio {

	private List<Publicacion> publicaciones;
	private List<String> servicios;
	private List<String> tiposInmueble;
	private ServidorMail servidorMail;
    public AdministradorDeSitio administradorDeSitio;
	private ServidorMail servidor;
	private static Sitio sitio;
 	
	public Sitio() {
		super();
		this.publicaciones = new ArrayList<Publicacion>();
		this.administradorDeSitio = new AdministradorDeSitio(this);
		this.servicios = new ArrayList<String>();
		this.tiposInmueble = new ArrayList<String>();
		this.servidorMail = servidor;
	}
	
	public static Sitio getInstance() {
        if (sitio == null){
            sitio = new Sitio();
        }
        return Sitio.sitio;
	}
	
	public ServidorMail getServidorMail() {
		return this.servidorMail;
	}
	
	public List<Publicacion> getPublicaciones() {
		return this.publicaciones;
	}

	public void agregarPublicacion(Publicacion publicacion) {
			this.publicaciones.add(publicacion);
	}

	public void eliminarPublicacion(Publicacion publicacion) {
		this.publicaciones.remove(publicacion);
	}


	public List<String> getServicios() {
		return this.servicios;
	}

	public void agregarServicio(String servicioNuevo) {
		this.servicios.add(servicioNuevo);
	}
	public List<String> getTiposInmueble() {
		return this.tiposInmueble;
	}

	public void agregarTipoInmueble(String tipoInmueble) {
		this.tiposInmueble.add(tipoInmueble);
	}
	
	public void vaciarListaPublicaciones() {
			this.publicaciones.clear();
	}
}
