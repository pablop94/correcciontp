package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		assertEquals(sitio.getServicios().stream().findFirst().get().getName(), "Wi-fi");
	}

}
