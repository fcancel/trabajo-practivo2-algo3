package fiuba.algo3.modelo;

public class Puntuacion implements Comparable {

	private int movimientos;
	private int dimension;
	private double promedio;
	private String nick;

	public Puntuacion(int movimientos, int dimension, String nick){
		
		this.nick = nick;
		this.movimientos = movimientos;
		this.dimension = dimension;
		if( (dimension == 0) | (movimientos == 0) ){
			this.promedio = 0;
		}else{
			this.promedio = dimension / movimientos;
		}
		
		
	}

	public int getMovimientos() {
		return this.movimientos;
	}

	public int getDimension() {
		return this.dimension;
	}

	public double getPromedio() {
		return this.promedio;
	}

	public String getNick() {
		
		return this.nick;
	}
	
	@Override
	public int compareTo(Object punt) {
		
		Puntuacion puntuacion = (Puntuacion) punt;
		
		if (this.promedio > puntuacion.getPromedio())
			return -1;
		else if(this.promedio < puntuacion.getPromedio())
			return 1;
		return 0;
	}



}
