/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiuba.algo3.modelo.juego;

import java.io.File;

import fiuba.algo3.modelo.dificultad.Dificultad;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;
import fiuba.algo3.modelo.mapa.Ciudad;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class GPS {
    
    private static int MOVIMIENTO_INICIAL = 0;
    
    private Dificultad dificultad;
    private boolean juegoEnCurso;
    private PuntuacionesAltas puntuacionesAltas;
    private int movimientos;
    private Vehiculo vehiculo;
    private Ciudad ciudad;
    private Jugador jugador;
    private String nick;
	

    private void verificarJuegoIniciado() throws JuegoNoIniciado{
		
		if(!this.juegoEnCurso)
			throw new JuegoNoIniciado();
	}
    
    private void cargarPuntuaciones(){
    	
	this.puntuacionesAltas = new PuntuacionesAltas();
		
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
		
		int limiteDeMovimientos = this.dificultad.getMaximoDeMovimientos();
		int multipilcador = this.dificultad.getMultiplicador();
		
		int puntuacionTotal = (limiteDeMovimientos - this.movimientos)* multipilcador;
		Puntuacion puntuacion = new Puntuacion(this.nick,puntuacionTotal);
                this.puntuacionesAltas.setPuntuacion(puntuacion);
		this.puntuacionesAltas.persistir();
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

	public void empezarJuego(EstadoVehiculo estadoInicial, Dificultad dificultad,Jugador jugador){
		
		this.jugador=jugador;
		this.dificultad = dificultad;
		this.nick = this.jugador.getNombre();
		this.inicializarJuego(estadoInicial,dificultad.getFilas(),dificultad.getColumnas());

	}
	
	private void inicializarJuego(EstadoVehiculo estadoInicial, int filas, int columnas) {
		
		this.juegoEnCurso = true;
        this.vehiculo = new Vehiculo(estadoInicial);
        this.vehiculo.setGPS(this);
		this.ciudad = new Ciudad(filas,columnas,this.vehiculo,this);
        this.vehiculo.setCiudad(this.ciudad);
		
	}

	public int getLimiteDeMovimientos() {
		
		return this.dificultad.getMaximoDeMovimientos();
	}


	

}
