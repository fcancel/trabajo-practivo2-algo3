package fiuba.algo3.modelo.juego;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Jugador implements Serializable{
    @XmlAttribute (name="serializacion")
	private static final long serialVersionUID = -2805430129443063211L;
    @XmlAttribute (name="nombre")
	private String nombre;
	//direccion del XML de la ciudad guardada
	//¿Obstaculos? ¿GPS?
	
    public Jugador(){
    }
    
	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		
		return this.nombre;
	}

	/*public boolean equals(String nombre) {
		
		return this.nombre.equals(nombre);
	}*/
	

	@Override
	public boolean equals(Object jugador) {
		
		if(!jugador.getClass().equals(Jugador.class))
			return false;
		if(!((Jugador)jugador).getNombre().equals(this.nombre))
			return false;
		return true;
	}
	
}
