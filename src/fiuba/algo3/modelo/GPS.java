/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiuba.algo3.modelo;

import fiuba.algo3.excepciones.JuegoNoIniciado;

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
    //falta ciudad
    
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
    
    public void empezarJuego(EstadoVehiculo estadoInicial){
    	
    	
    	//debe recibir la dimesion y crear ciudad
        this.juegoEnCurso = true;
        this.vehiculo = new Vehiculo(estadoInicial);
        this.vehiculo.setGPS(this);
        
    }

	public boolean juegoEnMarcha() {
		
		return this.juegoEnCurso;
		
	}

	public void terminarJuego() {
		
		//falta agregar puntuacion y poner a null ciudad
		this.vehiculo = null;
		this.juegoEnCurso = false;
		
	}

	public Vehiculo getVehiculo() throws JuegoNoIniciado {
		
		if(this.vehiculo == null)
			throw new JuegoNoIniciado();
		
		return this.vehiculo;
		
	}
	
	//metodo getCiudad
}
