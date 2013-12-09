package fiuba.algo3.tests;

import static org.junit.Assert.*;

import java.io.File;

import javax.xml.bind.JAXBException;

import fiuba.algo3.modelo.dificultad.Dificil;
import fiuba.algo3.modelo.dificultad.Dificultad;
import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.dificultad.Moderado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Moto;

import org.junit.Assert;
import org.junit.Test;


public class TestLasFuncionesDeGPS {
    

	
	@Test
    public void alCrearGPSElJuegoNoEstaEnMarcha(){
		
        GPS gps = new GPS();
        
        assertFalse(gps.juegoEnMarcha());
    }
	
	@Test
	public void alEmpezarJuegoElJuegoEstaEnMarcha() throws JAXBException{
		
		eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
		
        GPS gps = new GPS();
        Jugador jugador = new Jugador("jose");
        gps.empezarJuego(new Moto(), new Facil(),jugador);
        
        assertTrue(gps.juegoEnMarcha());
        
        eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
		
	}
	
	@Test
    public void alTerminarElJuegoEsteNoEstaEnMarcha() throws JAXBException{
		
		eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
		
		GPS gps = new GPS();
		Jugador jugador = new Jugador("tomas");
		gps.empezarJuego(new Moto(), new Facil(),jugador);
		
        gps.terminarJuego();
        
        assertFalse(gps.juegoEnMarcha());
        
        eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
	
	
	
	@Test
    public void alTerminarElJuegoYPedirVehiculoReciboExcepcionDeJuegoNoIniciado() throws JAXBException{
			
        try{
        	
        	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
        	
        	GPS gps = new GPS();
        	Jugador jugador = new Jugador("pedro");
        	gps.empezarJuego(new Moto(), new Facil(),jugador);
            gps.terminarJuego();
        	
            eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
            
            gps.getVehiculo();
        	
        	assertTrue( false );
        	
        }catch( JuegoNoIniciado e ){
        	
        }
		
    }
	
	@Test
    public void alTerminarElJuegoYPedirCiudadReciboExcepcionDeJuegoNoIniciado() throws JAXBException{
			
        try{
        	
        	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
        	
        	GPS gps = new GPS();
        	Jugador jugador = new Jugador("tomas");
        	gps.empezarJuego(new Moto(), new Facil(),jugador);
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
    
    
    @Test
    public void testAlEmpezarUnaPartidaEnFacilElLimiteDeMovimientosDebeSer80() throws JAXBException{
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	Jugador jugador = new Jugador("Rofwaldo");
    	gps.empezarJuego(new Moto(), new Facil(),jugador);
        
        assertEquals(80, gps.getLimiteDeMovimientos());
        
        eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void testAlEmpezarUnaPartidaEnModeradoElLimiteDeMovimientosDebeSer60() throws JAXBException{
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	Jugador jugador = new Jugador("Rofwaldo");
    	gps.empezarJuego(new Moto(), new Moderado(),jugador);
        
        assertEquals(60, gps.getLimiteDeMovimientos());
        
        eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void testAlEmpezarUnaPartidaEnDificilElLimiteDeMovimientosDebeSer40() throws JAXBException{
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	Jugador jugador = new Jugador("Rofwaldo");
    	gps.empezarJuego(new Moto(), new Dificil(),jugador);

        
        assertEquals(40, gps.getLimiteDeMovimientos());
        
        eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void testAlTerminarUnaPartidaEnFacilLaPuntuacionDebeSerCorrecta() throws NoExisteEsaPosicion, JAXBException{
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	Jugador jugador = new Jugador("Rofwaldo");
    	gps.empezarJuego(new Moto(), new Facil(),jugador);
    	gps.sumarMovimiento(4);
    	gps.terminarJuego();
    	
    	// (80-4)*1 = 76
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 76 );
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void testAlTerminarUnaPartidaEnModeradoLaPuntuacionDebeSerCorrecta() throws NoExisteEsaPosicion, JAXBException{
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	Jugador jugador = new Jugador("tomas");
    	gps.empezarJuego(new Moto(), new Moderado(),jugador);
    	gps.sumarMovimiento(10);
    	gps.terminarJuego();
    	
    	// (60-10)*3 = 100
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 100 );
        
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }

    @Test
    public void testAlTerminarUnaPartidaEnDificilLaPuntuacionDebeSerCorrecta() throws NoExisteEsaPosicion, JAXBException{

    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	Jugador jugador = new Jugador("tomas");
    	gps.empezarJuego(new Moto(), new Dificil(),jugador);
    	gps.sumarMovimiento(8);
    	gps.terminarJuego();

    	// (40-8)*3 = 96
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 96 );

    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void alTerminarElJuegoLaPuntuacionDebeSerAgregada() throws NoExisteEsaPosicion, JAXBException{


    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");

    	GPS gps = new GPS();
    	Jugador jugador = new Jugador("tomas");
    	gps.empezarJuego(new Moto(), new Facil(),jugador);
    	gps.sumarMovimiento(4);
    	gps.terminarJuego();

    	assertEquals( (gps.puntuacion(1)).getNick(), "tomas" );
    	assertEquals( (gps.puntuacion(1)).getPuntos(), 76 );

    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void alJugarDosPartidasDeboTenerDosPuntuaciones() throws NoExisteEsaPosicion, JAXBException{
    		
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gps = new GPS();
    	Jugador juan = new Jugador("juan");
    	gps.empezarJuego(new Moto(), new Facil(),juan);
       	gps.sumarMovimiento(4);
       	gps.terminarJuego();
       	
       	Jugador tomas = new Jugador("tomas");
    	gps.empezarJuego(new Auto(), new Dificil(),tomas);
       	gps.sumarMovimiento(10);
       	gps.terminarJuego();
        	
       	assertEquals( (gps.puntuacion(1)).getNick(), "tomas" );
       	assertEquals( (gps.puntuacion(1)).getPuntos(), 90 );
       	assertEquals( (gps.puntuacion(2)).getNick(), "juan" );
       	assertEquals( (gps.puntuacion(2)).getPuntos(), 76 );
        	
       	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    }
    
    @Test
    public void alIniciarUnGPSTerminarloYCrearUnoNuevoLasPuntuacionesDebenPersistir() throws NoExisteEsaPosicion, JAXBException{
		
    	eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
    	
    	GPS gpsInicial = new GPS();
    	
    	Jugador juan = new Jugador("juan");
    	gpsInicial.empezarJuego(new Moto(), new Facil(),juan);
    	gpsInicial.sumarMovimiento(4);
    	gpsInicial.terminarJuego();
    	
    	Jugador tomas = new Jugador("tomas");
    	gpsInicial.empezarJuego(new Auto(), new Dificil(),tomas);
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
