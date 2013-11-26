package fiuba.algo3.modelo;

public class Moderado  implements Dificultad {
	
	private static int MOVIMIENTOS = 60;
	private static int FILAS = 19;
	private static int COLUMNAS = 19;
	private static int MULTIPLICADOR = 2;
	

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
