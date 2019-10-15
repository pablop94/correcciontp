package filtros;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import publicacion.Publicacion;

public class CheckIn extends Filtro {

	private LocalDate checkIn;
	
	public CheckIn(LocalDate checkIn) {
		super();
		this.checkIn = checkIn;
	}

	@Override
	public List<Publicacion> filtrarPublicaciones(List<Publicacion> publicaciones) {
		publicaciones = publicaciones.stream().filter(publicacion -> publicacion.getCheckIn().isEqual(this.checkIn)).collect(Collectors.toList());
		return publicaciones;
	}

}
