package inmobiliaria;

import java.util.ArrayList;
import java.util.List;

public class FiltroCompuesto extends Filtro {
	
	private List<Filtro> filtros;

	public FiltroCompuesto() {
		super();
		this.filtros = new ArrayList<Filtro>();
	}
	@Override
	public List<Publicacion> filtrarPublicaciones() {
		for (Filtro unFiltro: this.getFiltros()) {
			this.copiaPublicaciones = unFiltro.filtrarPublicaciones();
		}
		return copiaPublicaciones;
	}

	private List<Filtro> getFiltros() {
		return this.filtros;
	}
	
	public void agregarFiltro(Filtro filtro) {
		this.filtros.add(filtro);
	}

}
