package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Publicacion;
import sitio.Sitio;

import static org.mockito.Mockito.*;

class SitioTest {

	private Sitio sitio;
	private Publicacion publicacion;

	@BeforeEach
	void setUp() throws Exception {
		sitio = Sitio.getInstance();
		publicacion = mock(Publicacion.class);
	}
	
	@AfterEach
	void afterEach() {
		this.sitio.vaciarPublicaciones();
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

}
