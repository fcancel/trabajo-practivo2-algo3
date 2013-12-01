package fiuba.algo3.modelo.juego;

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
import java.io.File;

public class PuntuacionesAltas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 181082646L;
	private ArrayList<Puntuacion> puntuaciones;
        private String archivo = "puntuaciones\\puntuacionesAltas.dat";
	

	public PuntuacionesAltas(){
		
            File fichero = new File(this.archivo);
		if(fichero.exists()){
			this.recuperar();
		}else{
			this.puntuaciones = new ArrayList<Puntuacion>();
		}
		
		
	}
        
        public boolean estaVacia(){
            
            return this.puntuaciones.isEmpty();
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

			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.archivo));
			PuntuacionesAltas puntuacionesAltas = (PuntuacionesAltas) ois.readObject();
			ois.close();

                        this.puntuaciones = puntuacionesAltas.puntuaciones;
                        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
			
	}
}
