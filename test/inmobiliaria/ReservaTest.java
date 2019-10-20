package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Publicacion;
import publicacion.Reserva;
import usuario.Usuario;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;

class ReservaTest {
	
	private Usuario propietario;
	private Reserva reserva;
	private Publicacion publicacion;
	private Usuario inquilino;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	@BeforeEach
	public void setUp() throws Exception {
		propietario = mock(Usuario.class);
		publicacion = mock(Publicacion.class);
		inquilino = mock(Usuario.class);
		checkIn = LocalDate.of(2019, Month.SEPTEMBER, 25);
		checkOut = LocalDate.of(2019, Month.SEPTEMBER, 29);
		when(publicacion.getPropietario()).thenReturn(propietario);
		reserva = new Reserva(publicacion, inquilino, checkIn, checkOut);
	}
	
	@Test
	void testConstructorReserva() {
		assertEquals(reserva.getPublicacion(), publicacion);
		assertEquals(reserva.getInquilino(), inquilino); 
		assertEquals(reserva.getCheckIn(), checkIn);
		assertEquals(reserva.getCheckOut(), checkOut);
	}
	
	@Test
	void cuandoUnaReservaSeCreaNoSeEncuentraAceptada() {
		assertFalse(reserva.estaAceptada());
	}
	
	@Test
	void cuandoUnaReservaSeConfirmaPasaAEstarAceptada() {
		reserva.aceptar();
		assertTrue(reserva.estaAceptada());
	}
	
	@Test
	void cuandoUnaReservaSeCreaSeAgregaALaListaDeReservasDeLaPublicacionCorrespondiente() {
		Reserva nuevaReserva = new Reserva(publicacion, inquilino, checkIn, checkIn);
		verify(publicacion, times(1)).agregarReserva(nuevaReserva);
	}
	
	@Test
	void cuandoUnaReservaSeCreaSeAgregaALaListaDeReservasDelInquilinoCorrespondiente() {
		Reserva nuevaReserva = new Reserva(publicacion, inquilino, checkIn, checkIn);
		verify(inquilino, times(1)).agregarReserva(nuevaReserva);
	}
	
	@Test
	void cuandoUnaReservaSeCreaSeNotificaAlPropitarioAlRespecto() {
		Reserva nuevaReserva = new Reserva(publicacion, inquilino, checkIn, checkIn);
		verify(propietario, times(1)).notificarReservaPendiente(nuevaReserva);
	}
	
	@Test
	void cuandoUnaReservaSeAceptaSeNotificaAlInquilino() {
		reserva.aceptar();
		verify(inquilino, times(1)).notificarReservaConcretada(reserva);
	}
}
