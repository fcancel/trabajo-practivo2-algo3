/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiuba.algo3.tests;

import static org.junit.Assert.*;
import fiuba.algo3.modelo.Auto;
import fiuba.algo3.modelo.EstadoVehiculo;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;

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
        
        gps.empezarJuegoFacil(new Moto(),"jose");
        
        assertTrue(gps.juegoEnMarcha());
		
	}
	
	@Test
    public void alTerminarElJuegoEsteNoEstaEnMarcha(){
		
        GPS gps = new GPS();
        
        gps.empezarJuegoFacil(new Moto(),"tomas");
        gps.terminarJuego();
        
        assertFalse(gps.juegoEnMarcha());
    }
	
	
	
	@Test
    public void alTerminarElJuegoYPedirVehiculoReciboExcepcionDeJuegoNoIniciado(){
			
        try{
        	
        	GPS gps = new GPS();
        	
        	gps.empezarJuegoFacil(new Moto(),"pedro");
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
        	
        	gps.empezarJuegoFacil(new Moto(),"tomas");
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
    
    
    //Faltan definir los limite de movimientos
    @Test
    public void testAlEmpezarUnaPartidaEnFacilElLimiteDeMovimientosDebeSer80(){
        
    	GPS gps = new GPS();
        gps.empezarJuegoFacil(new Moto(),"Rofwaldo");
        
        assertEquals(80, gps.getLimiteDeMovimientos());
        
        
    }
    
    @Test
    public void testAlEmpezarUnaPartidaEnFacilElLimiteDeMovimientosDebeSer60(){
        
    	GPS gps = new GPS();
        gps.empezarJuegoModerado(new Moto(),"Rofwaldo");
        
        assertEquals(60, gps.getLimiteDeMovimientos());
        
        
    }
    
    @Test
    public void testAlEmpezarUnaPartidaEnFacilElLimiteDeMovimientosDebeSer40(){
        
    	GPS gps = new GPS();
        gps.empezarJuegoDificil(new Moto(),"Rofwaldo");
        
        assertEquals(40, gps.getLimiteDeMovimientos());
        
        
    }
    
    @Test
    public void testAlTerminarUnaPartidaEnFacilLaPuntuacionDebeSerCorrecta() throws NoExisteEsaPosicion{
        
    	GPS gps = new GPS();
    	
    	gps.empezarJuegoFacil(new Moto(),"tomas");
    	gps.sumarMovimiento(4);
    	gps.terminarJuego();
    	
    	// (80-4)*1 = 76
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 76 );
        
        
    }
    
    @Test
    public void testAlTerminarUnaPartidaEnModeradoLaPuntuacionDebeSerCorrecta() throws NoExisteEsaPosicion{
        
    	GPS gps = new GPS();
    	
    	gps.empezarJuegoModerado(new Moto(),"tomas");
    	gps.sumarMovimiento(10);
    	gps.terminarJuego();
    	
    	// (60-10)*3 = 100
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 100 );
        
        
    }
    
    @Test
    public void testAlTerminarUnaPartidaEnDificilLaPuntuacionDebeSerCorrecta() throws NoExisteEsaPosicion{
        
    	GPS gps = new GPS();
    	
    	gps.empezarJuegoDificil(new Moto(),"tomas");
    	gps.sumarMovimiento(8);
    	gps.terminarJuego();
    	
    	// (40-8)*3 = 96
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 96 );
        
        
    }
    
    @Test
    public void alTerminarElJuegoLaPuntuacionDebeSerAgregada() throws NoExisteEsaPosicion{

    		
        	GPS gps = new GPS();
        	
        	gps.empezarJuegoFacil(new Moto(),"tomas");
        	gps.sumarMovimiento(4);
        	gps.terminarJuego();
        	
        	assertEquals( (gps.puntuacion(1)).getNick(), "tomas" );
        	assertEquals( (gps.puntuacion(1)).getPuntos(), 76 );

    	
    }
    
    @Test
    public void alJugarDosPartidasDeboTenerDosPuntuaciones() throws NoExisteEsaPosicion{
    		
        	GPS gps = new GPS();
        	
        	gps.empezarJuegoFacil(new Moto(),"juan");
        	gps.sumarMovimiento(4);
        	gps.terminarJuego();
        	
        	gps.empezarJuegoDificil(new Auto(),"tomas");
        	gps.sumarMovimiento(10);
        	gps.terminarJuego();
        	
        	assertEquals( (gps.puntuacion(1)).getNick(), "tomas" );
        	assertEquals( (gps.puntuacion(1)).getPuntos(), 90 );
        	assertEquals( (gps.puntuacion(2)).getNick(), "juan" );
        	assertEquals( (gps.puntuacion(2)).getPuntos(), 76 );
        	
    	
    }
    
}
