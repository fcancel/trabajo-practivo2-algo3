package fiuba.algo3.modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;

public class PuntuacionesAltas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 181082646L;
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
	
	public void persistir(String archivo) {
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo));
			oos.writeObject(this);
			oos.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static PuntuacionesAltas recuperar(String archivo) {
		
		try {

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
			PuntuacionesAltas putuacionesAltas = (PuntuacionesAltas) ois.readObject();
			ois.close();
			return putuacionesAltas;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	
	}
}
