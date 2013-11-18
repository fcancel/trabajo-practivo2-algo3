package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.Auto;
import fiuba.algo3.modelo.Efecto;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.SorpresaFavorable;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.sorpresaDesfavorable;

public class TestSorpresaDesfavorable {

	@Test
	public void alAplicarSorpresaDesfavorableDeberianAumentarEnUn25PorCientoLosMovimientos() throws JuegoNoIniciado {
		
		
		GPS gps = new GPS();
		gps.empezarJuego(new Auto(), 5, "juan");
		Vehiculo vehiculo = gps.getVehiculo();
		Efecto sorpresaDesfavorable = new sorpresaDesfavorable();
		vehiculo.sumarMovimiento(10);
		
		assertEquals(gps.getMovimientos(),10);
		
		vehiculo.aceptarEfecto(sorpresaDesfavorable);
		
		assertEquals(gps.getMovimientos(),12);
		
	}
}
