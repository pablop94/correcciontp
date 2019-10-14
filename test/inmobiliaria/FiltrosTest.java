package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FiltrosTest {

	private Sitio sitio;
	private Ciudad ciudad;
	private CheckIn checkIn;
	private CheckOut checkOut;
	private FiltroCompuesto filtroCompuesto;
	private Publicacion publicacion1;
	private Publicacion publicacion2;
	private Publicacion publicacion3;
	private Inmueble inmueble1;
	private Inmueble inmueble2;

	@BeforeEach
	void setUp() {
		sitio = Sitio.getInstance();
		ciudad = new Ciudad("Quilmes");
		checkIn = new CheckIn(LocalDate.of(2019, Month.SEPTEMBER, 25));
		checkOut = new CheckOut(LocalDate.of(2019, Month.SEPTEMBER, 30));
		filtroCompuesto = new FiltroCompuesto();
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		publicacion3 = mock(Publicacion.class);
		inmueble1 = mock(Inmueble.class);
		inmueble2 = mock(Inmueble.class);
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		when(publicacion2.getInmueble()).thenReturn(inmueble2);
		when(inmueble1.getCiudad()).thenReturn("Quilmes");
		when(inmueble2.getCiudad()).thenReturn("Berazategui");
//		when(publicacion3.getInmueble().getCiudad()).thenReturn("Bernal");		
		
	}
	
	@Test
	void test() {
		sitio.agregarPublicacion(this.publicacion1);
		sitio.agregarPublicacion(this.publicacion2);
//		sitio.agregarPublicacion(this.publicacion3);
		this.filtroCompuesto.agregarFiltro(ciudad);
		List<Publicacion> publicacionesFiltradas = this.filtroCompuesto.filtrarPublicaciones();
		assertTrue(publicacionesFiltradas.contains(publicacion1));
		assertFalse(publicacionesFiltradas.contains(publicacion2));
	}

}
