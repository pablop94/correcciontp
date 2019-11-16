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
	public List<Publicacion> filtrarPublicaciones(List<Publicacion> publicaciones) {
		/*acá hay dos cosas mal: 
		modificar un parámetro no está bueno
		acceder a publicacion.getInmueble().getCiudad().equals(this.ciudad) es violar encapsulamiento. Lo correcto sería: 
			tener un método en publicacion que se llame esDeLaCiudad(ciudad) y internamente llame a su inmueble.esDeLaCiudad(ciudad)
			y este ahí le pregunte a su ciudad si es igual a la que le pasaron por parámetro
		*/
		publicaciones = publicaciones.stream().filter(publicacion -> publicacion.getInmueble().getCiudad().equals(this.ciudad)).collect(Collectors.toList());
		return publicaciones;
	}

}
