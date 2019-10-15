package filtros;

import java.util.ArrayList;
import java.util.List;

import publicacion.Publicacion;

public class FiltroCompuesto extends Filtro {
	
	private List<Filtro> filtros;

	public FiltroCompuesto() {
		super();
		this.filtros = new ArrayList<Filtro>();
	}
	
	@Override
	public List<Publicacion> filtrarPublicaciones(List<Publicacion> publicaciones) {
		for (Filtro unFiltro: this.getFiltros()) {
			publicaciones = unFiltro.filtrarPublicaciones(publicaciones);
		}
		return publicaciones;
	}

	public List<Filtro> getFiltros() {
		return this.filtros;
	}
	
	public void agregarFiltro(Filtro filtro) {
		this.filtros.add(filtro);
	}

}
