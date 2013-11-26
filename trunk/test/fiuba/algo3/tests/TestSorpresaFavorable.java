package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Efecto;
import fiuba.algo3.modelo.Facil;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.SorpresaFavorable;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;

public class TestSorpresaFavorable {

	@Test
	public void alAplicarSorpresaFavorableDeberianDisminuirEnUn20PorcientoLosMovimientos() throws JuegoNoIniciado {
		
		
		GPS gps = new GPS();
		gps.empezarJuego(new Moto(), new Facil(),"tomas");

		Vehiculo vehiculo = gps.getVehiculo();
		Efecto sorpresaFavorable = new SorpresaFavorable();
		vehiculo.sumarMovimiento(10);
		
		assertEquals(gps.getMovimientos(),10);
		
		vehiculo.aceptarEfecto(sorpresaFavorable);
		
		assertEquals(gps.getMovimientos(),8);
		
	}

}
