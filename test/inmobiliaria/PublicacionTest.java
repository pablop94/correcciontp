package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmobiliaria.Sitio;

class PublicacionTest {
	
	private Publicacion publicacion;
	private Sitio sitio;
	private Inmueble inmueble;
	private List<Servicio> servicios;
	private List<Servicio> serviciosDelInmueble;
	private Direccion direccion;
	private LocalDate checkIn;
	private LocalDate checkOut;

	
	@BeforeEach
	void setUp() {
		sitio = new Sitio();
		serviciosDelInmueble = new ArrayList<Servicio>();
		servicios = new ArrayList<Servicio>();
		direccion = new Direccion("Oliveri", 1111);
		inmueble = new Inmueble("Argentina", "Quilmes", direccion, serviciosDelInmueble);
		LocalDate checkIn =  LocalDate.of(2019, Month.SEPTEMBER, 25);
		LocalDate checkOut =  LocalDate.of(2019, Month.OCTOBER, 10);
		publicacion = new Publicacion(inmueble, 4, LocalDate.of(2019, Month.SEPTEMBER, 25), LocalDate.of(2019, Month.OCTOBER, 10), 10000d);
	}
	
	
	@Test
	void cuandoCreoUnaPublicacionSeAgregaAlSitio() {
		assertEquals(sitio.getPublicaciones().size(), 0);
		sitio.agregarPublicacion(publicacion);
		assertEquals(sitio.getPublicaciones().size(), 1);
	}
	
	@Test
	void cuandoEliminoUnaPublicacionDesapareceDelSitio() {
		assertEquals(sitio.getPublicaciones().size(), 0);
		sitio.agregarPublicacion(publicacion);
		assertEquals(sitio.getPublicaciones().size(), 1);
		sitio.eliminarPublicacion(publicacion);
		assertEquals(sitio.getPublicaciones().size(), 0);
	}
	
	@Test
	void comoAdministradorDeSitioPuedoAgregarServiciosAlSitio() {
		assertEquals(sitio.getServicios().size(), 0);
		sitio.administradorDeSitio.crearServicio("Wi-fi");
		assertEquals(sitio.getServicios().stream().findFirst().get().getName(), "Wi-fi");
	}
	
	@Test
	void testConstructorInmueble() {
		sitio.administradorDeSitio.crearServicio("Wi-fi");
		assertEquals(inmueble.getPais(), "Argentina");
		assertEquals(inmueble.getCiudad(), "Quilmes"); 
		assertEquals(inmueble.getDireccion().getCalle(), direccion.getCalle()); //se podria preguntar a direccion getCalle() o getNumeracion() pero quizas es demasiado
		assertEquals(inmueble.getDireccion().getNumeracion(), direccion.getNumeracion()); //se podria preguntar a direccion getCalle() o getNumeracion() pero quizas es demasiado
		assertEquals(inmueble.getServicios(), serviciosDelInmueble); 
	}
	
	@Test
	void testConstructorPublicacion() {
		assertEquals(publicacion.getInmueble(), inmueble);
		assertEquals(publicacion.getCapacidad(), 4);
		assertEquals(publicacion.getCheckIn(), LocalDate.of(2019, Month.SEPTEMBER, 25));
		assertEquals(publicacion.getCheckOut(), LocalDate.of(2019, Month.OCTOBER, 10));
		assertTrue(publicacion.getCheckIn().isBefore(publicacion.getCheckOut()));
		assertEquals(publicacion.getPrecio(), 10000d);
		
	}
	

}
