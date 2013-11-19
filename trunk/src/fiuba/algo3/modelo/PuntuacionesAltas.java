package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;

public class PuntuacionesAltas {
	
	private List<Puntuacion> puntuaciones;
	

	public PuntuacionesAltas(){
		
		this.puntuaciones = new ArrayList<Puntuacion>();
		
	}

	public void setPuntuacion(Puntuacion puntuacionAlta) {
		
		this.puntuaciones.add(puntuacionAlta);
		Collections.sort(this.puntuaciones);
		
	}

	public Puntuacion getPuntuacion(int posicion) throws NoExisteEsaPosicion {
		
		if( this.puntuaciones.size()<posicion)
			throw new NoExisteEsaPosicion();
		
		return this.puntuaciones.get(posicion-1);
	}

}
