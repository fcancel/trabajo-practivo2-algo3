package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Jugador;

public class TestJugador {

	@Test
	public void alCrearUnJugadorSuNombreDeUsuarioDebeSerCorrecto() {

		Jugador jugador = new Jugador("Juan");
		
		assertTrue(jugador.esTuNombre("Juan"));
		
	}

}

