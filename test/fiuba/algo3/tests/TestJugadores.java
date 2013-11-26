package fiuba.algo3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Jugadores;
import fiuba.algo3.modelo.excepciones.JugadorExistente;

public class TestJugadores {

	@Test
	public void alAgregarUnJugadorEsteDebeExistirEnLaListaDeJugadores() throws JugadorExistente {

		Jugador jugador= new Jugador("Pedro");
		Jugadores jugadores = new Jugadores();
		
		jugadores.agregarNuevoJugador(jugador);

		assertEquals(jugador,jugadores.getJugador("Pedro"));
	}

	@Test
	public void alAgregarUnJugadorYaExistenteDeboRecibirExcepcionDeJugadorExistente() {

		try{
			
			Jugadores jugadores = new Jugadores();
			
			jugadores.agregarNuevoJugador(new Jugador("Pedro"));
			
			jugadores.agregarNuevoJugador(new Jugador("Pedro"));
			
			assertTrue(false);
			
		}catch(JugadorExistente e){
			
		}
	}

	@Test
	public void alAgregarDosJugadoresYPedirListaDeNombresEstosDebenSerCorrectos() throws JugadorExistente {

		Jugadores jugadores = new Jugadores();
		Jugador pedro= new Jugador("Pedro");
		Jugador juan= new Jugador("Juan");

		jugadores.agregarNuevoJugador(pedro);

		jugadores.agregarNuevoJugador(juan);
		
		ArrayList<Jugador> jugadoresObtenidos = jugadores.listaDeJugadores();

		assertEquals(pedro,jugadoresObtenidos.get(0));
		assertEquals(juan,jugadoresObtenidos.get(1));

	}

}
