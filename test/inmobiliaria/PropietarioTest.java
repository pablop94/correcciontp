package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropietarioTest {
    
	LocalDate fechaCreacion;
	Publicacion publicacion;
	Propietario propietario;
	Reserva reserva;
	Inquilino inquilino;
	
	@BeforeEach
	public void setUp() throws Exception {
		fechaCreacion = LocalDate.of(2019, Month.SEPTEMBER, 25);
		publicacion = mock(Publicacion.class);
		reserva = mock(Reserva.class);
		inquilino = mock(Inquilino.class);
		when(reserva.getInquilino()).thenReturn(inquilino);
		when(reserva.estaAceptada()).thenReturn(false);
		propietario = new Propietario("Ezequiel", "ese@hotmail.com", "+5411931294", fechaCreacion);
	}
	
	@Test
	void testConstructorPropietario() {
		assertEquals(propietario.getNombre(), "Ezequiel");
		assertEquals(propietario.getEmail(), "ese@hotmail.com");
		assertEquals(propietario.getTelefono(), "+5411931294");
		assertEquals(propietario.getFechaCreacion(), fechaCreacion);
	}
	

	
}
