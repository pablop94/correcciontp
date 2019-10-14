package filtros;

import java.util.List;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public class Ciudad extends Filtro {
	
	private String ciudad;
	
	public Ciudad(String ciudad) {
		super();
		this.ciudad = ciudad;
	}

	@Override
	public List<Publicacion> filtrarPublicaciones() {
		return this.copiaPublicaciones.stream().filter(publicacion -> publicacion.getInmueble().getCiudad().equals(this.ciudad)).collect(Collectors.toList());
	}

}
