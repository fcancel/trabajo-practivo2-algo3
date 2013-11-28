package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.JugadorExistente;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Jugadores;
import fiuba.algo3.modelo.mapa.Ciudad;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class TestIntegral {

	@Test
	public void ganarJuegoSinObstaculos() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado, JugadorExistente {
		
		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");
		GPS gps = new GPS();
		Jugador jugador = new Jugador("tomas");
		Jugadores jugadores = new Jugadores();
		jugadores.agregarNuevoJugador(jugador);
		
		gps.empezarJuego(new Auto(), new Facil(),jugador);
		
		Vehiculo auto = gps.getVehiculo();
		Ciudad ciudad = gps.getCiudad();
		ciudad.eliminarObstaculosYSorpresas();

		//posicion inicial (1,7) y meta en (14,7)
		//14 movimientos a la derecha para ganar
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		
		assertFalse(gps.juegoEnMarcha());
		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");
	}

}
