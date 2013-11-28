package fiuba.algo3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import fiuba.algo3.modelo.excepciones.JugadorExistente;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Jugadores;

public class TestJugadores {

	@Test
	public void alAgregarUnJugadorEsteDebeExistirEnLaListaDeJugadores() throws JugadorExistente {

		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");

		
		Jugador jugador= new Jugador("Pedro");
		Jugadores jugadores = new Jugadores();
		
		jugadores.agregarNuevoJugador(jugador);
		
		Iterator<Jugador> jugadoresObtenidos = jugadores.listaDeJugadores();

		assertTrue(jugadoresObtenidos.next().equals(jugador));
	
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
		
		Iterator<Jugador> jugadoresObtenidos = jugadores.listaDeJugadores();

		assertEquals(pedro,jugadoresObtenidos.next());
		assertEquals(juan,jugadoresObtenidos.next());

		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");

	}
	
	@Test
	public void alPersistirUnJugadorYRecuperarloDebeSerCorrectoSusDatos() throws JugadorExistente {

		
		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");
		
		Jugadores jugadores = new Jugadores();
		
		Jugador jugador = new Jugador("Juan");
		
		jugadores.agregarNuevoJugador(jugador);

		Jugadores jugadoresRecuperados = new Jugadores();
		
		Iterator<Jugador> listaDeJugadores = jugadoresRecuperados.listaDeJugadores();
		
		assertTrue(listaDeJugadores.next().equals(jugador));
		
		eliminarArchivosDePruebas.eliminar("jugadores\\jugadores.dat");

		
	}

}