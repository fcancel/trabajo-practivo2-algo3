package fiuba.algo3.modelo;

public class Dificil implements Dificultad {
	
	private static int MOVIMIENTOS = 40;
	private static int FILAS = 25;
	private static int COLUMNAS = 25;
	private static int MULTIPLICADOR = 3;
	
	@Override
	public int getFilas() {
		return FILAS;
	}

	@Override
	public int getColumnas() {
		return COLUMNAS;
	}

	@Override
	public int getMultiplicador() {
		return MULTIPLICADOR;
	}

	@Override
	public int getMaximoDeMovimientos() {
		return MOVIMIENTOS;	
	}
	
}