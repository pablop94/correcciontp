package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filtros.CheckIn;
import filtros.CheckOut;
import filtros.Ciudad;
import filtros.FiltroCompuesto;
import publicacion.Inmueble;
import publicacion.Publicacion;
import sitio.Sitio;

class FiltrosTest {

	private Sitio sitio;
	private Ciudad filtroCiudad;
	private CheckIn filtroCheckIn;
	private CheckOut filtroCheckOut;
	private FiltroCompuesto filtroCompuesto;
	private Publicacion publicacion1;
	private Publicacion publicacion2;
	private Publicacion publicacion3;
	private Inmueble inmueble1;
	private Inmueble inmueble2;
	private Inmueble inmueble3;
	private List<Publicacion> publicacionesFiltradas;

	@BeforeEach
	void setUp() {
		sitio = Sitio.getInstance();
		publicacionesFiltradas = new ArrayList<Publicacion>();
		filtroCiudad = new Ciudad("Quilmes");
		filtroCheckIn = new CheckIn(LocalDate.of(2019, Month.SEPTEMBER, 20));
		filtroCheckOut = new CheckOut(LocalDate.of(2019, Month.SEPTEMBER, 30));
		filtroCompuesto = new FiltroCompuesto();
		
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		publicacion3 = mock(Publicacion.class);
		
		LocalDate checkIn1 = LocalDate.of(2019, Month.AUGUST, 10);
		LocalDate checkOut1 = LocalDate.of(2019, Month.AUGUST, 30);
		LocalDate checkIn2 = LocalDate.of(2019, Month.SEPTEMBER, 10);
		LocalDate checkOut2 = LocalDate.of(2019, Month.SEPTEMBER, 30);
		LocalDate checkIn3 = LocalDate.of(2019, Month.SEPTEMBER, 20);
		LocalDate checkOut3 = LocalDate.of(2019, Month.OCTOBER, 10);
		
		inmueble1 = mock(Inmueble.class);
		inmueble2 = mock(Inmueble.class);
		inmueble3 = mock(Inmueble.class);
		
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		when(publicacion1.getCheckIn()).thenReturn(checkIn1);
		when(publicacion1.getCheckOut()).thenReturn(checkOut1);
		
		when(publicacion2.getInmueble()).thenReturn(inmueble2);
		when(publicacion2.getCheckIn()).thenReturn(checkIn2);
		when(publicacion2.getCheckOut()).thenReturn(checkOut2);
		
		when(publicacion3.getInmueble()).thenReturn(inmueble3);
		when(publicacion3.getCheckIn()).thenReturn(checkIn3);
		when(publicacion3.getCheckOut()).thenReturn(checkOut3);
		
		when(inmueble1.getCiudad()).thenReturn("Quilmes");
		when(inmueble2.getCiudad()).thenReturn("Berazategui");
		when(inmueble3.getCiudad()).thenReturn("Quilmes");		
	}
	
	@Test
	void testFiltroPorCiudad() {
		sitio.agregarPublicacion(this.publicacion1);
		sitio.agregarPublicacion(this.publicacion2);
		sitio.agregarPublicacion(this.publicacion3);
		this.filtroCompuesto.agregarFiltro(filtroCiudad);
		publicacionesFiltradas = this.filtroCompuesto.filtrarPublicaciones();
		assertEquals(publicacionesFiltradas.size(), 2);
		assertTrue(publicacionesFiltradas.contains(publicacion1));
		assertFalse(publicacionesFiltradas.contains(publicacion2));
		assertTrue(publicacionesFiltradas.contains(publicacion3));
	}

	@Test
	void testFiltroPorCheckIn() {
		sitio.agregarPublicacion(this.publicacion1);
		sitio.agregarPublicacion(this.publicacion2);
		sitio.agregarPublicacion(this.publicacion3);
		this.filtroCompuesto.agregarFiltro(filtroCheckIn);
		this.filtroCompuesto.agregarFiltro(filtroCheckOut);
		publicacionesFiltradas = this.filtroCompuesto.filtrarPublicaciones();
		assertEquals(publicacionesFiltradas.size(), 1);
	}
	
	@Test
	void testFiltroPorCheckOut() {
		sitio.agregarPublicacion(this.publicacion1);
		sitio.agregarPublicacion(this.publicacion2);
		sitio.agregarPublicacion(this.publicacion3);
		this.filtroCompuesto.agregarFiltro(filtroCheckIn);
		this.filtroCompuesto.agregarFiltro(filtroCheckOut);
		publicacionesFiltradas = this.filtroCompuesto.filtrarPublicaciones();
		assertEquals(publicacionesFiltradas.size(), 1);
	}
	
	
}
