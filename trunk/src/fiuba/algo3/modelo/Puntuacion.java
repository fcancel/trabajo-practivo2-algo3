package fiuba.algo3.modelo;

public class Puntuacion implements Comparable {

	private int puntos;
	private String nick;

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
