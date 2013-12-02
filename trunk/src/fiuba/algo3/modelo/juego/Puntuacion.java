package fiuba.algo3.modelo.juego;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Puntuacion implements Comparable, Serializable {

    @XmlAttribute (name="serializacion")
	private static final long serialVersionUID = 1644432881082646123L;
    @XmlAttribute (name="puntos")
	private int puntos;
    @XmlAttribute (name="nick")
    private String nick;

    public Puntuacion(){
    };
    
	public Puntuacion(String nick, int puntos){
		
		this.nick = nick;
		this.puntos = puntos;
		
	}

	public String getNick() {
		
		return this.nick;
	}
	
	public int getPuntos() {
		
		return this.puntos;
	}
	
	@Override
	public int compareTo(Object punt) {
		
		Puntuacion puntuacion = (Puntuacion) punt;
		
		if (this.puntos > puntuacion.getPuntos())
			return -1;
		else if(this.puntos < puntuacion.getPuntos())
			return 1;
		return 0;
	}



}
