package fiuba.algo3.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import fiuba.algo3.modelo.excepciones.JugadorExistente;

public class Jugadores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 136608738905107904L;
	private ArrayList<Jugador> jugadores;
	private String archivo= "jugadores\\jugadores.dat";
	
	public Jugadores(){
		
		this.jugadores = new ArrayList<Jugador>();
		
	}
	
	public void agregarNuevoJugador(Jugador jugador) throws JugadorExistente {

		this.buscarJugador(jugador);
		this.jugadores.add(jugador);
		
	}

	private void buscarJugador(Jugador jugadorABuscar) throws JugadorExistente {

		for(Jugador jugador: this.jugadores ){
			if( jugador.nombre() == jugadorABuscar.nombre() ){
				throw new JugadorExistente();
			}
		}
		
	}

	public Jugador getJugador(String nombre) {
		
		for(Jugador jugador: this.jugadores ){
			if( jugador.esTuNombre(nombre) ){
				return jugador;
			}
		}
		
		return null;	
		
	}

	public ArrayList<Jugador> listaDeJugadores() {
		
		return this.jugadores;
		
	}
	
}
