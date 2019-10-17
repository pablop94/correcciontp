package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sitio.AdministradorDeSitio;
import sitio.Sitio;

class AdministradorDeSitioTest {

	private AdministradorDeSitio administradorDeSitio;
	private Sitio sitio;

	@BeforeEach
	void setUp() throws Exception {
		sitio = Sitio.getInstance();
		administradorDeSitio = new AdministradorDeSitio(sitio);
	}

	@Test
	void comoAdministradorDeSitioPuedoAgregarServiciosAlSitio() {
		assertEquals(sitio.getServicios().size(), 0);
		administradorDeSitio.crearServicio("Wi-fi");
		assertEquals(sitio.getServicios().stream().findFirst().get().getName(), "Wi-fi");
	}

}
