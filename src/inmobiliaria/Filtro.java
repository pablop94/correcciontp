package inmobiliaria;

import java.util.List;

public abstract class Filtro {

	List<Publicacion> copiaPublicaciones = Sitio.getInstance().getPublicaciones();
	
	public abstract List<Publicacion> filtrarPublicaciones();
	
	
}
