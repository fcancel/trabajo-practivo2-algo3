/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiuba.algo3.tests;

import static org.junit.Assert.*;
import fiuba.algo3.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;

import org.junit.Assert;
import org.junit.Test;


public class TestLasFuncionesDeGPS {
    
    
	@Test
    public void alCrearGPSElJuegoNoEstaEnMarcha(){
		
        GPS gps = new GPS();
        
        assertFalse(gps.juegoEnMarcha());
    }
	
	@Test
	public void alEmpezarJuegoElJuegoEstaEnMarcha(){
		
        GPS gps = new GPS();
        
        gps.empezarJuego(new Moto());
        
        assertTrue(gps.juegoEnMarcha());
		
	}
	
	@Test
    public void alTerminarElJuegoEsteNoEstaEnMarcha(){
		
        GPS gps = new GPS();
        
        gps.empezarJuego(new Moto());
        gps.terminarJuego();
        
        assertFalse(gps.juegoEnMarcha());
    }
	
	@Test
    public void alTerminarElJuegoYPedirVehiculoReciboExcepcionDeJuegoNoIniciado(){
			
        try{
        	
        	GPS gps = new GPS();
        	
        	gps.empezarJuego(new Moto());
            gps.terminarJuego();
        	gps.getVehiculo();
        	
        	assertTrue( false );
        	
        }catch( JuegoNoIniciado e ){
        	
        }
		
    }
	
	@Test
    public void alPedirVehiculoCuandoElJuegoNoSeInicioReciboExcepcionDeJuegoNoIniciado(){
		
        try{
        	
        	GPS gps = new GPS();
        	
        	gps.getVehiculo();
        	
        	assertTrue( false );
        	
        }catch( JuegoNoIniciado e ){
        	
        }
		
    }
	
	
	@Test
    public void testElGpsSeIniciaConNumeroDeMovimientosIgualACero(){
        GPS gps = new GPS();
        int resultado;
        
        resultado = gps.getMovimientos();
        
        Assert.assertEquals(0, resultado);
    }
    
    @Test
    public void testLeSumoMovimientosAlGpsYMeDevuelveLaSumaDeMovimientos(){
        GPS gps = new GPS();
        
        gps.sumarMovimiento(4);
        
        Assert.assertEquals(4, gps.getMovimientos());
    }
    
}
