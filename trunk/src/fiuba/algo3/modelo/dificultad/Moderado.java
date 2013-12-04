package fiuba.algo3.modelo.dificultad;

import java.util.Random;


public class Moderado  implements Dificultad {
	
	private static String MAPAMODERADO = ".\\Mapas xml\\EscenarioDificil";
	private static int MOVIMIENTOS = 60;
	private static int FILAS = 25;
	private static int COLUMNAS = 25;
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
	
	@Override
	public String getMapa() {

		Random rnd = new Random();
		int numeroDeMapa = (int)(rnd.nextDouble() * 9 + 1);  
		String direccionDelMapa = this.MAPAMODERADO+  Integer.toString(numeroDeMapa) +".XML"; 
		return direccionDelMapa;
	}
        
        @Override
        public String toString(){
            
            return "Moderado";
        }
}
