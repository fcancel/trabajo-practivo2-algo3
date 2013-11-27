package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;



import fiuba.algo3.modelo.Efecto;
import fiuba.algo3.modelo.Facil;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.SorpresaDesfavorable;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;

public class TestSorpresaDesfavorable {

	@Test
	public void alAplicarSorpresaDesfavorableDeberianAumentarEnUn25PorCientoLosMovimientos() throws JuegoNoIniciado {
		
		
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
