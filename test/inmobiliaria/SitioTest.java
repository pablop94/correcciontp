package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Publicacion;
import sitio.Sitio;
import usuario.Usuario;

import static org.mockito.Mockito.*;

class SitioTest {

	private Sitio sitio;
	private Publicacion publicacion;
	private Usuario usuario;

	@BeforeEach
	void setUp() throws Exception {
		sitio = Sitio.getInstance();
		publicacion = mock(Publicacion.class);
		usuario = mock(Usuario.class);
	}
	
	@AfterEach
	void afterEach() {
		this.sitio.vaciarListaPublicaciones();
	}

	@Test
	void testCreoUnUsuarioYLoRegistroEnElSitio() {
		sitio.registrarUsuario(usuario);
		assertTrue(sitio.getUsuarios().contains(usuario));
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
