package filtros;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public class CheckOut extends Filtro {

	private LocalDate checkOut;
	
	public CheckOut(LocalDate checkOut) {
		super();
		this.checkOut = checkOut;
	}

	@Override
	public List<Publicacion> filtrarPublicaciones(List<Publicacion> publicaciones) {
		publicaciones = publicaciones.stream().filter(publicacion -> publicacion.getCheckOut().isEqual(this.checkOut)).collect(Collectors.toList());
		return publicaciones;
	}

}
