/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiuba.algo3.tests;

import static org.junit.Assert.*;

import java.io.File;

import fiuba.algo3.modelo.Auto;
import fiuba.algo3.modelo.Dificil;
import fiuba.algo3.modelo.Dificultad;
import fiuba.algo3.modelo.EstadoVehiculo;
import fiuba.algo3.modelo.Facil;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moderado;
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
		
		eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
		
        GPS gps = new GPS();
        
        gps.empezarJuego(new Moto(), new Facil(),"jose");
        
        assertTrue(gps.juegoEnMarcha());
        
        eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
		
	}
	
	@Test
    public void alTerminarElJuegoEsteNoEstaEnMarcha(){
		
		eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
		
		GPS gps = new GPS();
        
		gps.empezarJuego(new Moto(), new Facil(),"tomas");
		
        gps.terminarJuego();
        
        assertFalse(gps.juegoEnMarcha());
        
        eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
	
	
	
	@Test
    public void alTerminarElJuegoYPedirVehiculoReciboExcepcionDeJuegoNoIniciado(){
			
        try{
        	
        	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
        	
        	GPS gps = new GPS();
        	
        	gps.empezarJuego(new Moto(), new Facil(),"pedro");
            gps.terminarJuego();
        	
            eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
            
            gps.getVehiculo();
        	
        	assertTrue( false );
        	
        }catch( JuegoNoIniciado e ){
        	
        }
		
    }
	
	@Test
    public void alTerminarElJuegoYPedirCiudadReciboExcepcionDeJuegoNoIniciado(){
			
        try{
        	
        	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
        	
        	GPS gps = new GPS();
        	
        	gps.empezarJuego(new Moto(), new Facil(),"tomas");
            gps.terminarJuego();
            
            eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
            
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
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	gps.empezarJuego(new Moto(), new Facil(),"Rofwaldo");
        
        assertEquals(80, gps.getLimiteDeMovimientos());
        
        eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void testAlEmpezarUnaPartidaEnModeradoElLimiteDeMovimientosDebeSer60(){
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	
    	gps.empezarJuego(new Moto(), new Moderado(),"Rofwaldo");
        
        assertEquals(60, gps.getLimiteDeMovimientos());
        
        eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void testAlEmpezarUnaPartidaEnDificilElLimiteDeMovimientosDebeSer40(){
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	gps.empezarJuego(new Moto(), new Dificil(),"Rofwaldo");

        
        assertEquals(40, gps.getLimiteDeMovimientos());
        
        eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void testAlTerminarUnaPartidaEnFacilLaPuntuacionDebeSerCorrecta() throws NoExisteEsaPosicion{
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	
    	gps.empezarJuego(new Moto(), new Facil(),"tomas");
    	gps.sumarMovimiento(4);
    	gps.terminarJuego();
    	
    	// (80-4)*1 = 76
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 76 );
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void testAlTerminarUnaPartidaEnModeradoLaPuntuacionDebeSerCorrecta() throws NoExisteEsaPosicion{
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	
    	gps.empezarJuego(new Moto(), new Moderado(),"tomas");
    	gps.sumarMovimiento(10);
    	gps.terminarJuego();
    	
    	// (60-10)*3 = 100
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 100 );
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }

    @Test
    public void testAlTerminarUnaPartidaEnDificilLaPuntuacionDebeSerCorrecta() throws NoExisteEsaPosicion{

    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();

    	gps.empezarJuego(new Moto(), new Dificil(),"tomas");
    	gps.sumarMovimiento(8);
    	gps.terminarJuego();

    	// (40-8)*3 = 96
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 96 );

    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void alTerminarElJuegoLaPuntuacionDebeSerAgregada() throws NoExisteEsaPosicion{


    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");

    	GPS gps = new GPS();

    	gps.empezarJuego(new Moto(), new Facil(),"tomas");
    	gps.sumarMovimiento(4);
    	gps.terminarJuego();

    	assertEquals( (gps.puntuacion(1)).getNick(), "tomas" );
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 76 );

    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void alJugarDosPartidasDeboTenerDosPuntuaciones() throws NoExisteEsaPosicion{
    		
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
        	
    	gps.empezarJuego(new Moto(), new Facil(),"juan");
       	gps.sumarMovimiento(4);
       	gps.terminarJuego();
       	
    	gps.empezarJuego(new Auto(), new Dificil(),"tomas");
       	gps.sumarMovimiento(10);
       	gps.terminarJuego();
        	
       	assertEquals( (gps.puntuacion(1)).getNick(), "tomas" );
       	assertEquals( (gps.puntuacion(1)).getPuntos(), 90 );
       	assertEquals( (gps.puntuacion(2)).getNick(), "juan" );
       	assertEquals( (gps.puntuacion(2)).getPuntos(), 76 );
        	
       	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void alIniciarUnGPSTerminarloYCrearUnoNuevoLasPuntuacionesDebenPersistir() throws NoExisteEsaPosicion{
		
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gpsInicial = new GPS();
    	
    	gpsInicial.empezarJuego(new Moto(), new Facil(),"juan");
    	gpsInicial.sumarMovimiento(4);
    	gpsInicial.terminarJuego();
    	
    	gpsInicial.empezarJuego(new Auto(), new Dificil(),"tomas");
    	gpsInicial.sumarMovimiento(10);
    	gpsInicial.terminarJuego();
    	
    	GPS gps = new GPS();
    	
    	assertEquals( (gps.puntuacion(1)).getNick(), "tomas" );
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 90 );
    	assertEquals( (gps.puntuacion(2)).getNick(), "juan" );
    	assertEquals( (gps.puntuacion(2)).getPuntos(), 76 );
    	
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
}
