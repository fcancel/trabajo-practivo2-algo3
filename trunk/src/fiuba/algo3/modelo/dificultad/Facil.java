package fiuba.algo3.modelo.dificultad;

import java.util.Random;


public class Facil implements Dificultad{

	private static String MAPAFACIL = ".\\Mapas xml\\EscenarioDificil";
	private static int MOVIMIENTOS = 80;
	private static int FILAS = 25;
	private static int COLUMNAS = 25;
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

	@Override
	public String getMapa() {
		Random rnd = new Random();
		int numeroDeMapa = (int)(rnd.nextDouble() * 9 + 1);  
		String direccionDelMapa = this.MAPAFACIL+  Integer.toString(numeroDeMapa) +".XML"; 
		return direccionDelMapa;
	}

	@Override
	public String toString(){     
		return "Facil";
	}
}
