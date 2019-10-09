package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inmobiliaria.Sitio;

class PublicacionTest {
	
	private Publicacion publicacion;
	private Sitio sitio;
	private Inmueble inmueble;
	private List<Servicio> servicios;

	@BeforeEach
	void setUp() {
		sitio = new Sitio();
		inmueble = new Inmueble("Argentina", "Buenos Aires", new Direccion("Oliveri", 1111), sitio.getServicios());
		publicacion = new Publicacion(inmueble, 4, new Date(), new Date(), 10000d);
		servicios = new ArrayList<Servicio>();
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
		inmueble = new Inmueble("Argentina", "Buenos Aires", new Direccion("Oliveri", 1111), sitio.getServicios());
	}
	
	@Test
	void testConstructorPublicacion() {
		publicacion = new Publicacion(inmueble, 4, new Date(), new Date(), 10000d);
	}
	
	@Test
	void testReservarPublicacion() {
		
	}
}
