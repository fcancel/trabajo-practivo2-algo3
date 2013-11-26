package fiuba.algo3.modelo;

public class Facil implements Dificultad{

	private static int MOVIMIENTOS = 80;
	private static int FILAS = 15;
	private static int COLUMNAS = 15;
	private static int MULTIPLICADOR = 1;
	
	
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
