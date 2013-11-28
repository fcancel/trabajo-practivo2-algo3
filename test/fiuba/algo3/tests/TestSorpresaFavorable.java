package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import fiuba.algo3.modelo.efectosYSorpresas.SorpresaFavorable;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class TestSorpresaFavorable {

	@Test
	public void alAplicarSorpresaFavorableDeberianDisminuirEnUn20PorcientoLosMovimientos() throws JuegoNoIniciado {
		
		
		GPS gps = new GPS();
		Jugador jugador = new Jugador("tomas");
		gps.empezarJuego(new Moto(), new Facil(),jugador);

		Vehiculo vehiculo = gps.getVehiculo();
		Efecto sorpresaFavorable = new SorpresaFavorable();
		vehiculo.sumarMovimiento(10);
		
		assertEquals(gps.getMovimientos(),10);
		
		vehiculo.aceptarEfecto(sorpresaFavorable);
		
		assertEquals(gps.getMovimientos(),8);
		
	}

}
