/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;

/**
 *
 * @author Cancel
 */

public class GPS {
    
    private static int MOVIMIENTO_INICIAL = 0;
    private boolean juegoEnCurso;
    private PuntuacionesAltas puntuacionesAltas;
    private int movimientos;
    private Vehiculo vehiculo;
    private Ciudad ciudad;
    private String jugador;

    private void verificarJuegoIniciado() throws JuegoNoIniciado{
		
		if(!this.juegoEnCurso)
			throw new JuegoNoIniciado();
	}
    
    public GPS(){
    	
        this.movimientos = MOVIMIENTO_INICIAL;
        this.puntuacionesAltas = new PuntuacionesAltas();
        this.juegoEnCurso = false;
        
    }
    
    public int getMovimientos(){
        
    	return this.movimientos;
    	
    }
    
    public void sumarMovimiento( int movimientoASumar ){
    	
        this.movimientos += movimientoASumar;
        
    }
    
    public void empezarJuego(EstadoVehiculo estadoInicial,int dimension,String nick){
    	
        this.juegoEnCurso = true;
        this.vehiculo = new Vehiculo(estadoInicial);
        this.vehiculo.setGPS(this);
        this.ciudad = new Ciudad(dimension,this.vehiculo,this);
        this.vehiculo.setCiudad(this.ciudad);
        this.jugador = nick;
        
    }

	public boolean juegoEnMarcha() {
		
		return this.juegoEnCurso;
		
	}

	public void terminarJuego() {
		
		int dimension = this.ciudad.getDimension();
		//Puntuacion puntuacion = new Puntuacion(this.jugador,50/*va la puntuacion calculada*/);
		//this.puntuacionesAltas.setPuntuacion(puntuacion);
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
	

}
