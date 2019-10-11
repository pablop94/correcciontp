package inmobiliaria;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdministradorDeReserva {
	
	private Sitio sitio;
	private Publicacion publicacion;
	private Inmueble inmueble;
	private List<Servicio> serviciosDelInmueble;
	private Direccion direccion;
	private LocalDate checkInPublicacion;
	private LocalDate checkOutPublicacion;
	private LocalDate checkInReserva;
	private LocalDate checkOutReserva;
	private AdministradorDeReservas administradorDeReservas;
	private Inquilino inquilino;
	private Period periodoPublicacion;
	private Period periodoReserva;

	
	@BeforeEach
	void setUp() {
		sitio = mock(Sitio.class);
		inquilino = mock(Inquilino.class);
		publicacion = mock(Publicacion.class);
		administradorDeReservas = new AdministradorDeReservas(sitio);
		LocalDate checkInReserva =  LocalDate.of(2019, Month.SEPTEMBER, 15);
		LocalDate checkOutReserva =  LocalDate.of(2019, Month.SEPTEMBER, 20);
	}
		
	@Test
	void testInquilinoRealizaUnaReserva() {
		
		assertEquals(administradorDeReservas.listarReservasPendientes().size(), 0);
		
		Reserva nuevaReserva = administradorDeReservas.realizarReserva(inquilino, publicacion, checkInReserva, checkOutReserva, 2);
		
		assertEquals(administradorDeReservas.listarReservasPendientes().size(), 1);
		assertEquals(nuevaReserva.getPublicacion(), publicacion);
		assertEquals(nuevaReserva.getInquilino(), inquilino);
		assertEquals(nuevaReserva.getCheckIn(), checkInReserva);
		assertEquals(nuevaReserva.getCheckOut(), checkOutReserva);
		assertEquals(nuevaReserva.getCantidadDeInquilinos(), 2);
		
		
	}
}
