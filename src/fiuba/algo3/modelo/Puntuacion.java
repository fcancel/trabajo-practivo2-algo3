package fiuba.algo3.modelo;

public class Puntuacion implements Comparable {

	private int movimientos;
	private int dimension;
	private double promedio;

	public Puntuacion(int movimientos, int dimension){
		
		this.movimientos = movimientos;
		this.dimension = dimension;
		this.promedio = dimension / movimientos;
		
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
