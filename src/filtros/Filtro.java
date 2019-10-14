package filtros;

import java.util.List;

import publicacion.Publicacion;
import sitio.Sitio;

public abstract class Filtro {

	List<Publicacion> copiaPublicaciones = Sitio.getInstance().getPublicaciones();
	
	public abstract List<Publicacion> filtrarPublicaciones();
	
}
