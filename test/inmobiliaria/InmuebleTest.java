package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InmuebleTest {

	private Inmueble inmueble;
	private Direccion direccion;
	private Propietario propietario;
	private List<Servicio> servicios;

	@BeforeEach
	void setUp() throws Exception {
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
	}
	
}
