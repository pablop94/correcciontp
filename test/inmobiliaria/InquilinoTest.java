package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import publicacion.Reserva;
import usuario.Inquilino;

class InquilinoTest {

	private Inquilino inquilino;
	private LocalDate fechaCreacion;
	private Reserva reserva;
	
	@BeforeEach
	void setUp() throws Exception {
		fechaCreacion = LocalDate.of(2018, Month.DECEMBER, 21);
		inquilino = new Inquilino("Kevin", "kevindlp@gmail.com", "+54011223424", fechaCreacion);
		reserva = mock(Reserva.class);
	}

	@Test
	void testConstructorInquilino() {
		assertEquals(inquilino.getNombre(), "Kevin");
		assertEquals(inquilino.getEmail(), "kevindlp@gmail.com");
		assertEquals(inquilino.getTelefono(), "+54011223424");
		assertEquals(inquilino.getFechaRegistro(), fechaCreacion);
		assertEquals(inquilino.getReservas().size(), 0);
	}

	@Test
	void testInquilinoAgregaUnaReservaYLoContieneSuListaDeReservas() {
		this.inquilino.agregarReserva(reserva);
		assertTrue(inquilino.getReservas().contains(reserva));
	}
	
	
}
