package fiuba.algo3.modelo.juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;









import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fiuba.algo3.modelo.excepciones.JugadorExistente;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Jugadores implements Serializable {

    @XmlAttribute (name="serializacion")
	private static final long serialVersionUID = 136608738905107904L;
    @XmlElement(name="jugadores")
    private ArrayList<Jugador> jugadores;
    @XmlAttribute (name="archivo")
    private String archivo = "jugadores\\jugadores.dat";
	
	public Jugadores(){
		
		File fichero = new File(this.archivo);
		if(fichero.exists()){
			this.recuperar();
		}else{
			this.jugadores = new ArrayList<Jugador>();
		}
		
	}
	
	public void agregarNuevoJugador(Jugador jugador) throws JugadorExistente {

		this.verificarQueElJugadorNoEste(jugador);
		this.jugadores.add(jugador);
		this.persistir();
		
	}

	private void verificarQueElJugadorNoEste(Jugador jugadorABuscar) throws JugadorExistente {

		for(Jugador jugador: this.jugadores ){
			if( jugador.equals(jugadorABuscar) ){
				throw new JugadorExistente();
			}
		}
		
	}

	public Iterator<Jugador> listaDeJugadores() {
		
		Iterator<Jugador> iterable = this.jugadores.iterator();
		
		return iterable;
		
	}
        
        public Jugador getJugadorEnPosicion(int posicion){
            
            return this.jugadores.get(posicion);
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
