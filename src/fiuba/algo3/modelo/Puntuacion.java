package fiuba.algo3.modelo;

public class Puntuacion {

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

}
