package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sitio.Sitio;
import usuario.AdministradorDeSitio;

class AdministradorDeSitioTest {

	private AdministradorDeSitio administradorDeSitio;
	private Sitio sitio;

	@BeforeEach
	void setUp() throws Exception {
		sitio = new Sitio();
		administradorDeSitio = new AdministradorDeSitio(sitio);
	}

	@Test
	void comoAdministradorDeSitioPuedoAgregarServiciosAlSitio() {
		assertEquals(sitio.getServicios().size(), 0);
		administradorDeSitio.crearServicio("Wi-fi");
		assertEquals(sitio.getServicios().get(0), "Wi-fi");
	}

	@Test
	void comoAdministradorDeSitioPuedoAgregarTiposDeInmuebleAlSitio() {
		assertEquals(sitio.getTiposInmueble().size(), 0);
		administradorDeSitio.crearTipoInmueble("Casa");
		assertEquals(sitio.getTiposInmueble().get(0), "Casa");
	}
}
