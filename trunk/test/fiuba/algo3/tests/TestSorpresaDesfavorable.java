package fiuba.algo3.tests;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBException;

import org.junit.Test;











import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import fiuba.algo3.modelo.efectosYSorpresas.SorpresaDesfavorable;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class TestSorpresaDesfavorable {

	@Test
	public void alAplicarSorpresaDesfavorableDeberianAumentarEnUn25PorCientoLosMovimientos() throws JuegoNoIniciado, JAXBException {
		
		
		GPS gps = new GPS();
		Jugador jugador = new Jugador("juan");
		gps.empezarJuego(new Moto(), new Facil(),jugador);
		Vehiculo vehiculo = gps.getVehiculo();
		Efecto sorpresaDesfavorable = new SorpresaDesfavorable();
		vehiculo.sumarMovimiento(10);
		
		assertEquals(gps.getMovimientos(),10);
		
		vehiculo.aceptarEfecto(sorpresaDesfavorable);
		
		assertEquals(gps.getMovimientos(),12);
		
	}
}
