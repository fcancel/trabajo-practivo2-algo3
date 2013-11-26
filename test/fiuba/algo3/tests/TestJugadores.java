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

		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");

		
		Jugador jugador= new Jugador("Pedro");
		Jugadores jugadores = new Jugadores();
		
		jugadores.agregarNuevoJugador(jugador);
		
		ArrayList<Jugador> jugadoresObtenidos = jugadores.listaDeJugadores();

		assertTrue(jugadoresObtenidos.get(0).equals("Pedro"));
	
		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");
	
	}

	@Test
	public void alAgregarUnJugadorYaExistenteDeboRecibirExcepcionDeJugadorExistente() {

		try{
			
			eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");

			Jugadores jugadores = new Jugadores();
			
			jugadores.agregarNuevoJugador(new Jugador("Pedro"));

			eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");
			
			jugadores.agregarNuevoJugador(new Jugador("Pedro"));
			
			assertTrue(false);
			
		}catch(JugadorExistente e){
			
		}
	}

	@Test
	public void alAgregarDosJugadoresYPedirListaDeNombresEstosDebenSerCorrectos() throws JugadorExistente {

		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");

		Jugadores jugadores = new Jugadores();
		Jugador pedro= new Jugador("Pedro");
		Jugador juan= new Jugador("Juan");

		jugadores.agregarNuevoJugador(pedro);

		jugadores.agregarNuevoJugador(juan);
		
		ArrayList<Jugador> jugadoresObtenidos = jugadores.listaDeJugadores();

		assertEquals(pedro,jugadoresObtenidos.get(0));
		assertEquals(juan,jugadoresObtenidos.get(1));

		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");

	}
	
	@Test
	public void alPersistirUnJugadorYRecuperarloDebeSerCorrectoSusDatos() throws JugadorExistente {

		
		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");
		
		Jugadores jugadores = new Jugadores();
		
		jugadores.agregarNuevoJugador(new Jugador("Juan"));

		Jugadores jugadoresRecuperados = new Jugadores();
		
		ArrayList<Jugador> listaDeJugadores = jugadoresRecuperados.listaDeJugadores();
		
		assertTrue(listaDeJugadores.get(0).equals("Juan"));
		
		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");

		
	}

}
