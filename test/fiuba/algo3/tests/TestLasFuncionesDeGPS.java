/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiuba.algo3.tests;

import static org.junit.Assert.*;
import fiuba.algo3.excepciones.JuegoNoIniciado;
import fiuba.algo3.excepciones.NoExisteEsaPosicion;
import fiuba.algo3.modelo.Auto;
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
        
        gps.empezarJuego(new Moto(),7);
        
        assertTrue(gps.juegoEnMarcha());
		
	}
	
	@Test
    public void alTerminarElJuegoEsteNoEstaEnMarcha(){
		
        GPS gps = new GPS();
        
        gps.empezarJuego(new Moto(),6);
        gps.terminarJuego();
        
        assertFalse(gps.juegoEnMarcha());
    }
	
	
	
	@Test
    public void alTerminarElJuegoYPedirVehiculoReciboExcepcionDeJuegoNoIniciado(){
			
        try{
        	
        	GPS gps = new GPS();
        	
        	gps.empezarJuego(new Moto(),5);
            gps.terminarJuego();
        	gps.getVehiculo();
        	
        	assertTrue( false );
        	
        }catch( JuegoNoIniciado e ){
        	
        }
		
    }
	
	@Test
    public void alTerminarElJuegoYPedirCiudadReciboExcepcionDeJuegoNoIniciado(){
			
        try{
        	
        	GPS gps = new GPS();
        	
        	gps.empezarJuego(new Moto(),5);
            gps.terminarJuego();
        	gps.getCiudad();
        	
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
    public void alPedirCiudadCuandoElJuegoNoSeInicioReciboExcepcionDeJuegoNoIniciado(){
		
        try{
        	
        	GPS gps = new GPS();
        	
        	gps.getCiudad();
        	
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
    
    @Test
    public void alTerminarElJuegoLaPuntuacionDebeSerCorrecta(){
    	
    	try{
    		
        	GPS gps = new GPS();
        	
        	gps.empezarJuego(new Moto(),5);
        	gps.sumarMovimiento(4);
        	gps.terminarJuego();
        	
        	assertTrue( (gps.puntuacion(1)).getPromedio() == ((5*5)/4) );
        	
    	}catch (NoExisteEsaPosicion e){
    		
    	}
    	
    }
    
    @Test
    public void alJugarDosPartidasDeboTenerDosPuntuaciones(){
    	
    	try{
    		
        	GPS gps = new GPS();
        	
        	gps.empezarJuego(new Moto(),5);
        	gps.sumarMovimiento(4);
        	gps.terminarJuego();
        	
        	gps.empezarJuego(new Auto(),10);
        	gps.sumarMovimiento(2);
        	gps.terminarJuego();
        	
        	assertTrue( (gps.puntuacion(1)).getPromedio() == ((10*10)/2) );
        	assertTrue( (gps.puntuacion(2)).getPromedio() == ((5*5)/4) );
        	
    	}catch (NoExisteEsaPosicion e){
    		
    	}
    	
    }
    
}
