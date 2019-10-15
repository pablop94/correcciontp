package filtros;

import java.util.List;

import publicacion.Publicacion;

public abstract class Filtro {

	public abstract List<Publicacion> filtrarPublicaciones(List<Publicacion> publicaciones);
	
}
