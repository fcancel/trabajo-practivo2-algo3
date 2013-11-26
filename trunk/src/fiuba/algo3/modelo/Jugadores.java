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
		
		File fichero = new File(archivo);
		if(fichero.exists()){
			this.recuperar();
		}else{
			this.jugadores = new ArrayList<Jugador>();
		}
		
	}
	
	public void agregarNuevoJugador(Jugador jugador) throws JugadorExistente {

		this.buscarJugador(jugador);
		this.jugadores.add(jugador);
		this.persistir();
		
	}

	private void buscarJugador(Jugador jugadorABuscar) throws JugadorExistente {

		for(Jugador jugador: this.jugadores ){
			if( jugador.nombre() == jugadorABuscar.nombre() ){
				throw new JugadorExistente();
			}
		}
		
	}

	public ArrayList<Jugador> listaDeJugadores() {
		
		return this.jugadores;
		
	}
	
	public void persistir() {
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.archivo));
			oos.writeObject(this);
			oos.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void recuperar() {
		
		try {

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
			Jugadores jugadoresRecuperados = (Jugadores) ois.readObject();
			ois.close();	

			this.jugadores = jugadoresRecuperados.jugadores;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	
	}
	
}
