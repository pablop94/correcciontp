package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Direccion;
import publicacion.Inmueble;
import publicacion.Servicio;
import usuario.Propietario;

class InmuebleTest {

	private Inmueble inmueble;
	private Direccion direccion;
	private Propietario propietario;
	private List<Servicio> servicios;

	@BeforeEach
	void setUp() throws Exception {
		propietario = mock(Propietario.class);
		direccion = new Direccion("Calle", 1212);
		servicios = new ArrayList<Servicio>();
		inmueble = new Inmueble("Argentina", "Quilmes", direccion, servicios);
	}
	
	@Test
	void testConstructorInmueble() {
		assertEquals(inmueble.getPais(), "Argentina");
		assertEquals(inmueble.getCiudad(), "Quilmes"); 
		assertEquals(inmueble.getDireccion(), direccion);
		assertEquals(inmueble.getServicios().size(), 0);
		inmueble.setPropietario(propietario);
		assertEquals(inmueble.getPropietario(), propietario);
	}
	
}
