package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class PublicacionTest {
	
	private Publicacion publicacion;
	private Inmueble inmueble;
	private PosibleInquilino posibleInquilino;
	private Propietario propietario;
	
	@BeforeEach
	void setUp() {
		inmueble = mock(Inmueble.class);
		publicacion = new Publicacion(inmueble, 4, LocalDate.of(2019, Month.SEPTEMBER, 25), LocalDate.of(2019, Month.OCTOBER, 10), 10000d);
		posibleInquilino = new PosibleInquilino("maxi", "maxi@unq.com", "1123432332", LocalDate.of(2019, Month.APRIL, 12 ));
		propietario = new Propietario("Jorege", "Jorge@unq.com", "1145545444", LocalDate.of(2018, Month.AUGUST, 19 ));
	}
	
	@Test
	void testConstructorPublicacion() {
		assertEquals(publicacion.getInmueble(), inmueble);
		assertEquals(publicacion.getCapacidad(), 4);
		assertEquals(publicacion.getCheckIn(), LocalDate.of(2019, Month.SEPTEMBER, 25));
		assertEquals(publicacion.getCheckOut(), LocalDate.of(2019, Month.OCTOBER, 10));
		assertTrue(publicacion.getCheckIn().isBefore(publicacion.getCheckOut()));
		assertEquals(publicacion.getPrecio(), 10000d);
		
	}
	

}