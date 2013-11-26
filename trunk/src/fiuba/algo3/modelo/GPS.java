/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiuba.algo3.modelo;

import java.io.File;

import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;

/**
 *
 * @author Cancel
 */

public class GPS {
    
    private static int MOVIMIENTO_INICIAL = 0;
    private static int MOVIMIENTOS_FACIL = 80;
    private static int MOVIMIENTOS_MODERADO = 60;
    private static int MOVIMIENTOS_DIFICIL = 40;
    private static int FILASYCOLUMNAS_FACIL = 15;
    private static int FILASYCOLUMNAS_MODERADO = 19;
    private static int FILASYCOLUMNAS_DIFICIL = 25;
    private static int MULTIPLICADOR_FACIL = 1;
    private static int MULTIPLICADOR_MODERADO = 2;
    private static int MULTIPLICADOR_DIFICIL = 3;
    
    private boolean juegoEnCurso;
    private PuntuacionesAltas puntuacionesAltas;
    private int movimientos;
    private Vehiculo vehiculo;
    private Ciudad ciudad;
    private String jugador;
    private int limiteDeMovimientos;
	private int multiplicador;
	private String archivo = "puntuaciones\\puntuacionesAltas.dat";

    private void verificarJuegoIniciado() throws JuegoNoIniciado{
		
		if(!this.juegoEnCurso)
			throw new JuegoNoIniciado();
	}
    
    private void cargarPuntuaciones(){
    	File fichero = new File(archivo);
		if(fichero.exists()){
			this.puntuacionesAltas = PuntuacionesAltas.recuperar(archivo);
		}else{
			this.puntuacionesAltas = new PuntuacionesAltas();
		}
    }
    
    public GPS(){
    	
        this.movimientos = MOVIMIENTO_INICIAL;
        this.cargarPuntuaciones();
        this.juegoEnCurso = false;
        
    }
    
    public int getMovimientos(){
        
    	return this.movimientos;
    	
    }
    
    public void sumarMovimiento( int movimientoASumar ){
    	
        this.movimientos += movimientoASumar;
        
    }
    
	public boolean juegoEnMarcha() {
		
		return this.juegoEnCurso;
		
	}

	public void terminarJuego() {
		
		int puntuacionTotal = (this.limiteDeMovimientos - this.movimientos)* this.multiplicador;
		Puntuacion puntuacion = new Puntuacion(this.jugador,puntuacionTotal);
		this.puntuacionesAltas.setPuntuacion(puntuacion);
		this.puntuacionesAltas.persistir(archivo);
		this.ciudad = null;
		this.vehiculo = null;
		this.juegoEnCurso = false;
		this.movimientos = MOVIMIENTO_INICIAL;
		
	}

	public Vehiculo getVehiculo() throws JuegoNoIniciado {
		
		this.verificarJuegoIniciado();
		
		return this.vehiculo;
		
	}

	public Ciudad getCiudad() throws JuegoNoIniciado{
		
		this.verificarJuegoIniciado();
		
		return this.ciudad;
				
	}

	public Puntuacion puntuacion(int posicion) throws NoExisteEsaPosicion {
		
		return this.puntuacionesAltas.getPuntuacion(posicion);
		
	}

	public void empezarJuegoFacil(EstadoVehiculo estadoInicial, String nick) {
		
		
        this.inicializarJuego(estadoInicial,FILASYCOLUMNAS_FACIL,nick);
		this.limiteDeMovimientos = MOVIMIENTOS_FACIL;
		this.multiplicador = MULTIPLICADOR_FACIL;
		
	}

	public void empezarJuegoModerado(EstadoVehiculo estadoInicial, String nick) {
		
		this.inicializarJuego(estadoInicial,FILASYCOLUMNAS_MODERADO,nick);
		this.limiteDeMovimientos = MOVIMIENTOS_MODERADO;
		this.multiplicador = MULTIPLICADOR_MODERADO;
	}

	public void empezarJuegoDificil(EstadoVehiculo estadoInicial, String nick) {

		this.inicializarJuego(estadoInicial,FILASYCOLUMNAS_DIFICIL,nick);
		this.limiteDeMovimientos = MOVIMIENTOS_DIFICIL;
		this.multiplicador = MULTIPLICADOR_DIFICIL;
	}
	
	private void inicializarJuego(EstadoVehiculo estadoInicial,int filasYColumnas,String nick) {
		
		this.juegoEnCurso = true;
        this.vehiculo = new Vehiculo(estadoInicial);
        this.vehiculo.setGPS(this);
		this.ciudad = new Ciudad(filasYColumnas,this.vehiculo,this);
        this.vehiculo.setCiudad(this.ciudad);
        this.jugador = nick;
		
	}

	public int getLimiteDeMovimientos() {
		
		return this.limiteDeMovimientos;
	}


	

}
