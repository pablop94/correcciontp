package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;
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
	private Publicacion publicacion4;
	private Publicacion publicacion5;
	private Inmueble inmueble1;
	private Inmueble inmueble2;
	private Inmueble inmueble3;
	private Inmueble inmueble4;
	private Inmueble inmueble5;
	private List<Publicacion> publicacionesFiltradas;

	@BeforeEach
	void setUp() {
//		sitio = new Sitio();
		sitio = Sitio.getInstance();
		publicacionesFiltradas = sitio.getPublicaciones();
		
		filtroCiudad = new Ciudad("Quilmes");
		filtroCheckIn = new CheckIn(LocalDate.of(2019, Month.SEPTEMBER, 20));
		filtroCheckOut = new CheckOut(LocalDate.of(2019, Month.SEPTEMBER, 30));
		filtroCompuesto = new FiltroCompuesto();
		
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		publicacion3 = mock(Publicacion.class);
		publicacion4 = mock(Publicacion.class);
		publicacion5 = mock(Publicacion.class);
		
		inmueble1 = mock(Inmueble.class);
		inmueble2 = mock(Inmueble.class);
		inmueble3 = mock(Inmueble.class);
		inmueble4 = mock(Inmueble.class);
		inmueble5 = mock(Inmueble.class);
		
		LocalDate checkIn1 = LocalDate.of(2019, Month.AUGUST, 30);
		LocalDate checkOut1 = LocalDate.of(2019, Month.SEPTEMBER, 20);
		LocalDate checkIn2 = LocalDate.of(2019, Month.SEPTEMBER, 20);
		LocalDate checkOut2 = LocalDate.of(2019, Month.SEPTEMBER, 30);
		LocalDate checkIn3 = LocalDate.of(2019, Month.SEPTEMBER, 20);
		LocalDate checkOut3 = LocalDate.of(2019, Month.OCTOBER, 10);
		LocalDate checkIn4 = LocalDate.of(2019, Month.SEPTEMBER, 20);
		LocalDate checkOut4 = LocalDate.of(2019, Month.SEPTEMBER, 30);
		LocalDate checkIn5 = LocalDate.of(2019, Month.SEPTEMBER, 10);
		LocalDate checkOut5 = LocalDate.of(2019, Month.SEPTEMBER, 30);
				
		when(publicacion1.getInmueble()).thenReturn(inmueble1);
		when(inmueble1.getCiudad()).thenReturn("Quilmes");		// coincide
		when(publicacion1.getCheckIn()).thenReturn(checkIn1);
		when(publicacion1.getCheckOut()).thenReturn(checkOut1);
		
		when(publicacion2.getInmueble()).thenReturn(inmueble2);
		when(inmueble2.getCiudad()).thenReturn("Berazategui");
		when(publicacion2.getCheckIn()).thenReturn(checkIn2);	// coincide
		when(publicacion2.getCheckOut()).thenReturn(checkOut2); // coincide
		
		when(publicacion3.getInmueble()).thenReturn(inmueble3);
		when(inmueble3.getCiudad()).thenReturn("Quilmes");		// coincide
		when(publicacion3.getCheckIn()).thenReturn(checkIn3);	// coincide
		when(publicacion3.getCheckOut()).thenReturn(checkOut3);
		
		when(publicacion4.getInmueble()).thenReturn(inmueble4);
		when(inmueble4.getCiudad()).thenReturn("Quilmes");		// coincide
		when(publicacion4.getCheckIn()).thenReturn(checkIn4);	// coincide
		when(publicacion4.getCheckOut()).thenReturn(checkOut4); // coincide
		
		when(publicacion5.getInmueble()).thenReturn(inmueble5);
		when(inmueble5.getCiudad()).thenReturn("Bernal");		
		when(publicacion5.getCheckIn()).thenReturn(checkIn5);
		when(publicacion5.getCheckOut()).thenReturn(checkOut5); // coincide
		
		sitio.agregarPublicacion(this.publicacion1);
		sitio.agregarPublicacion(this.publicacion2);
		sitio.agregarPublicacion(this.publicacion3);
		sitio.agregarPublicacion(this.publicacion4);
		sitio.agregarPublicacion(this.publicacion5);
	}
	
	@Test
	void testFiltroPorCiudad() {
		assertEquals(this.sitio.getPublicaciones().size(), 5);
		this.filtroCompuesto.agregarFiltro(filtroCiudad);
		publicacionesFiltradas = this.filtroCompuesto.filtrarPublicaciones(publicacionesFiltradas);
		assertEquals(publicacionesFiltradas.size(), 3);
		assertTrue(publicacionesFiltradas.contains(publicacion1));
		assertFalse(publicacionesFiltradas.contains(publicacion2));
		assertTrue(publicacionesFiltradas.contains(publicacion3));
		assertTrue(publicacionesFiltradas.contains(publicacion4));
		assertFalse(publicacionesFiltradas.contains(publicacion5));
	}
	
//	@Test
//	void testFiltroPorCheckIn() {
//		assertEquals(this.sitio.getPublicaciones().size(), 5);
//		this.filtroCompuesto.agregarFiltro(filtroCheckIn);
//		publicacionesFiltradas = this.filtroCompuesto.filtrarPublicaciones(publicacionesFiltradas);
//		assertEquals(publicacionesFiltradas.size(), 3);
//		assertFalse(publicacionesFiltradas.contains(publicacion1));
//		assertTrue(publicacionesFiltradas.contains(publicacion2));
//		assertTrue(publicacionesFiltradas.contains(publicacion3));
//		assertTrue(publicacionesFiltradas.contains(publicacion4));
//		assertFalse(publicacionesFiltradas.contains(publicacion5));
//	}
//
//	@Test
//	void testFiltroPorCheckOut() {
//		assertEquals(this.sitio.getPublicaciones().size(), 5);
//		this.filtroCompuesto.agregarFiltro(filtroCheckOut);
//		publicacionesFiltradas = this.filtroCompuesto.filtrarPublicaciones(publicacionesFiltradas);
//		assertEquals(publicacionesFiltradas.size(), 3);
//		assertFalse(publicacionesFiltradas.contains(publicacion1));
//		assertTrue(publicacionesFiltradas.contains(publicacion2));
//		assertFalse(publicacionesFiltradas.contains(publicacion3));
//		assertTrue(publicacionesFiltradas.contains(publicacion4));
//		assertTrue(publicacionesFiltradas.contains(publicacion5));
//	}
//	
//	@Test
//	void testFiltroPorCheckInYCheckOut() {
//		assertEquals(this.sitio.getPublicaciones().size(), 5);
//		this.filtroCompuesto.agregarFiltro(filtroCheckIn);
//		this.filtroCompuesto.agregarFiltro(filtroCheckOut);
//		publicacionesFiltradas = this.filtroCompuesto.filtrarPublicaciones(publicacionesFiltradas);
//		assertEquals(publicacionesFiltradas.size(), 2);
//		assertFalse(publicacionesFiltradas.contains(publicacion1));
//		assertTrue(publicacionesFiltradas.contains(publicacion2));
//		assertFalse(publicacionesFiltradas.contains(publicacion3));
//		assertTrue(publicacionesFiltradas.contains(publicacion4));
//		assertFalse(publicacionesFiltradas.contains(publicacion5));
//	}
//	
//	
//	@Test
//	void testFiltroPorCiudadYCheckIn() {
//		assertEquals(this.sitio.getPublicaciones().size(), 5);
//		this.filtroCompuesto.agregarFiltro(filtroCiudad);
//		this.filtroCompuesto.agregarFiltro(filtroCheckIn);
//		publicacionesFiltradas = this.filtroCompuesto.filtrarPublicaciones(publicacionesFiltradas);
//		assertEquals(publicacionesFiltradas.size(), 2);
//		assertFalse(publicacionesFiltradas.contains(publicacion1));
//		assertFalse(publicacionesFiltradas.contains(publicacion2));
//		assertTrue(publicacionesFiltradas.contains(publicacion3));
//		assertTrue(publicacionesFiltradas.contains(publicacion4));
//		assertFalse(publicacionesFiltradas.contains(publicacion5));
//	}
//	
//	@Test
//	void testFiltroPorCheckInCheckOutYCiudad() {
//		assertEquals(this.sitio.getPublicaciones().size(), 5);
//		this.filtroCompuesto.agregarFiltro(filtroCiudad);
//		this.filtroCompuesto.agregarFiltro(filtroCheckIn);
//		this.filtroCompuesto.agregarFiltro(filtroCheckOut);
//		publicacionesFiltradas = this.filtroCompuesto.filtrarPublicaciones(publicacionesFiltradas);
//		assertEquals(publicacionesFiltradas.size(), 1);
//		assertFalse(publicacionesFiltradas.contains(publicacion1));
//		assertFalse(publicacionesFiltradas.contains(publicacion2));
//		assertFalse(publicacionesFiltradas.contains(publicacion3));
//		assertTrue(publicacionesFiltradas.contains(publicacion4));
//		assertFalse(publicacionesFiltradas.contains(publicacion5));
//	}
	
}
