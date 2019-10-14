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
	private Inquilino inquilino;
	private LocalDate checkInPublicacion;
	private LocalDate checkOutPublicacion;
	private LocalDate checkInReserva1;
	private LocalDate checkOutReserva1;
	private LocalDate checkInReserva2;
	private LocalDate checkOutReserva2;
	private LocalDate checkInReserva3;
	private LocalDate checkOutReserva3;
	private Propietario propietario;
	private Reserva nuevaReserva;
	private Reserva nuevaReserva2;
	private Reserva nuevaReserva3;

	@BeforeEach
	void setUp() {
		inmueble = mock(Inmueble.class);
		nuevaReserva = mock(Reserva.class);
		nuevaReserva2 = mock(Reserva.class);
		nuevaReserva3 = mock(Reserva.class);
		propietario = mock(Propietario.class);
		inquilino = mock(Inquilino.class);
		checkInPublicacion = LocalDate.of(2019, Month.SEPTEMBER, 25);
		checkOutPublicacion = LocalDate.of(2019, Month.OCTOBER, 5);
		checkInReserva1 = LocalDate.of(2019, Month.SEPTEMBER, 25);
		checkOutReserva1 = LocalDate.of(2019, Month.SEPTEMBER, 29);
		checkInReserva2 = LocalDate.of(2019, Month.SEPTEMBER, 30);
		checkOutReserva2 = LocalDate.of(2019, Month.OCTOBER, 5);
		checkInReserva3 = LocalDate.of(2019, Month.SEPTEMBER, 29);
		checkOutReserva3 = LocalDate.of(2019, Month.OCTOBER, 2);
		when(nuevaReserva.getCheckIn()).thenReturn(checkInReserva1);
		when(nuevaReserva.getCheckOut()).thenReturn(checkOutReserva1);
		when(nuevaReserva.estaAceptada()).thenReturn(true);
		when(nuevaReserva2.getCheckIn()).thenReturn(checkInReserva2);
		when(nuevaReserva2.getCheckOut()).thenReturn(checkOutReserva2);
		when(nuevaReserva2.estaAceptada()).thenReturn(true);
		when(nuevaReserva3.getCheckIn()).thenReturn(checkInReserva3);
		when(nuevaReserva3.getCheckOut()).thenReturn(checkOutReserva3);
		when(nuevaReserva3.estaAceptada()).thenReturn(true);
		publicacion = new Publicacion(inmueble, 4, checkInPublicacion, checkOutPublicacion, 10000d);
	}
	
	@Test
	void testConstructorPublicacion() {
		assertEquals(publicacion.getInmueble(), inmueble);
		assertEquals(publicacion.getCapacidad(), 4);
		assertEquals(publicacion.getCheckIn(), checkInPublicacion);
		assertEquals(publicacion.getCheckOut(), checkOutPublicacion);
		assertTrue(publicacion.getCheckIn().isBefore(publicacion.getCheckOut()));
		assertEquals(publicacion.getPrecio(), 10000d);
	}
	
	@Test
	void cuandoAceptoUnaReservaNoQuieroPoderReservarNuevamenteParaEsasMismasFechas() {
		publicacion.agregarReserva(nuevaReserva);
		assertFalse(publicacion.puedeReservarseEn(checkInReserva1, checkOutReserva1));
		assertTrue(publicacion.puedeReservarseEn(checkInReserva2, checkOutReserva2));
		publicacion.agregarReserva(nuevaReserva2);
		assertFalse(publicacion.puedeReservarseEn(checkInReserva2, checkOutReserva2));
		assertFalse(publicacion.puedeReservarseEn(checkInReserva3, checkOutReserva3));
	}
	

}