package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Inmueble;
import usuario.Propietario;

class PropietarioTest {
    
	private LocalDate fechaCreacion;
	private Propietario propietario;
	private Inmueble inmueble1;
	private Inmueble inmueble2;
	
	@BeforeEach
	public void setUp() throws Exception {
		fechaCreacion = LocalDate.of(2019, Month.SEPTEMBER, 25);
		propietario = new Propietario("Ezequiel", "ese@hotmail.com", "+5411931294", fechaCreacion);
		inmueble1 = mock(Inmueble.class);
		inmueble2 = mock(Inmueble.class);
	}
	
	@Test
	void testConstructorPropietario() {
		assertEquals(propietario.getNombre(), "Ezequiel");
		assertEquals(propietario.getEmail(), "ese@hotmail.com");
		assertEquals(propietario.getTelefono(), "+5411931294");
		assertEquals(propietario.getFechaRegistro(), fechaCreacion);
		assertEquals(propietario.getInmuebles().size(), 0);
	}
	
	@Test
	void testAgregoUnInmuebleAlPropietario() {
		this.propietario.agregarInmueble(inmueble1);
		assertTrue(propietario.getInmuebles().contains(inmueble1));
		assertFalse(propietario.getInmuebles().contains(inmueble2));
	}
	
	@Test
	void testNoSePuedenAgregarDosVecesUnMismoInmueble() {
		this.propietario.agregarInmueble(inmueble1);
		this.propietario.agregarInmueble(inmueble1);
		assertEquals(propietario.getInmuebles().size(), 1);
	}
	
}
