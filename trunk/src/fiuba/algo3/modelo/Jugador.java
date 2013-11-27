package fiuba.algo3.modelo;

import java.io.Serializable;

public class Jugador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2805430129443063211L;
	private String nombre;
	//direccion del XML de la ciudad guardada
	//¿Obstaculos? ¿GPS?
	
	public Jugador(String nombre) {

		this.nombre = nombre;
		
	}

	public String getNombre() {
		
		return this.nombre;
	}

	public boolean equals(String nombre) {
		
		return this.nombre.equals(nombre);
	}
	

	public boolean equals(Jugador jugador) {
		
		return this.nombre.equals(jugador.nombre);
	}
	
}
