package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Direccion;
import publicacion.Inmueble;
import publicacion.Servicio;
import usuario.Propietario;

class PropietarioTest {
    
	private LocalDate fechaCreacion;
	private Propietario propietario;
	private Inmueble inmueble;
	private Inmueble inmueble2;
	private List<Servicio> servicios;
	
	@BeforeEach
	public void setUp() throws Exception {
		fechaCreacion = LocalDate.of(2019, Month.SEPTEMBER, 25);
		propietario = new Propietario("Ezequiel", "ese@hotmail.com", "+5411931294", fechaCreacion);
		inmueble = mock(Inmueble.class);
		inmueble2 = new Inmueble("Quilmes", "Argentina", new Direccion("Calle", 1222), servicios, propietario);
	}
	
	@Test
	void testConstructorPropietario() {
		assertEquals(propietario.getNombre(), "Ezequiel");
		assertEquals(propietario.getEmail(), "ese@hotmail.com");
		assertEquals(propietario.getTelefono(), "+5411931294");
		assertEquals(propietario.getFechaCreacion(), fechaCreacion);
		assertEquals(propietario.getInmuebles().size(), 1);
		this.inmueble.setPropietario(propietario);
		verify(inmueble, times(1)).setPropietario(propietario);
		this.propietario.agregarInmueble(inmueble);
		assertTrue(propietario.getInmuebles().contains(inmueble));
		assertTrue(propietario.getInmuebles().contains(inmueble2)); // se pasa el propietario del inmueble en su constructor, y se agrega automaticamente a la lista de inmuebles del propietario
	}

}
