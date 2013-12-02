package fiuba.algo3.tests;

import static org.junit.Assert.*;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import fiuba.algo3.modelo.mapa.Calle;
import fiuba.algo3.modelo.mapa.Ciudad;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Posicion;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

import org.junit.Test;


public class TestLasFuncionesDeLaCiudad {

	@Test
    public void validarPosicion() throws MovimientoInvalido{
		int filas = 10;
		int columnas = 10;
		Posicion posicion = new Posicion();
		posicion.setX(1);
		posicion.setY(1);
		GPS gps = new GPS();
        EstadoVehiculo estado = new Moto();
        Vehiculo vehiculo = new Vehiculo(estado);
        Ciudad ciudad = new Ciudad(filas,columnas,vehiculo,gps);
        Calle calle = ciudad.calleEnUnaPosicion(posicion);
        calle.inicializarCalle();
        assertTrue(ciudad.esValidaLaPosicion(posicion) == true);
    }

	@Test
    public void ubicaElVehiculoEnUnaPosicionValida() throws MovimientoInvalido, JuegoNoIniciado{
		
		GPS gps = new GPS();
		Jugador jugador = new Jugador("juan");
		gps.empezarJuego(new Moto(), new Facil(),jugador);
		Vehiculo auto = gps.getVehiculo();
		Ciudad ciudad = gps.getCiudad();
		Posicion posicion = auto.getPosicion();
		Calle calle = ciudad.calleEnUnaPosicion(posicion);
		
		assertTrue(calle.getVehiculo() == auto);
    }

	@Test
    public void alMovermeAUnLugarInvalidoReciboExcepcionMovimientoInvalido(){
        try{
    		int filas = 6;
    		int columnas = 10;
    		Posicion posicion = new Posicion();
    		posicion.setX(0);
    		posicion.setY(0);
    		GPS gps = new GPS();
    		EstadoVehiculo estado = new Moto();
    		Vehiculo vehiculo = new Vehiculo(estado);
    		Ciudad ciudad = new Ciudad(filas,columnas,vehiculo,gps);
    		ciudad.esValidaLaPosicion(posicion);
        	assertTrue( false );
        	
        }catch( MovimientoInvalido e ){
        	
        }
    }
	
	@Test
    public void alUbicaElVehiculoEnLaMetaElJuegoNoDebeEstarEnMarcha() throws MovimientoInvalido, JuegoNoIniciado, JuegoFinalizado{
		
		GPS gps = new GPS();
		Jugador jugador = new Jugador("juan");
		gps.empezarJuego(new Moto(), new Facil(),jugador);
		Ciudad ciudad = gps.getCiudad();
		Posicion posicionDeMeta = ciudad.getPosicionMeta();
		ciudad.colocarVehiculo(posicionDeMeta);
		
		assertFalse(gps.juegoEnMarcha());
    }

	@Test
    public void alUbicaElVehiculoEnLaMetaYQuererRealizarOtroMovimientoDeboRecibirExcepcionJuegoTerminado() throws MovimientoInvalido, JuegoNoIniciado{
		
		try{
			
			GPS gps = new GPS();
			Jugador jugador = new Jugador("juan");
			gps.empezarJuego(new Moto(), new Facil(),jugador);
			Vehiculo auto= gps.getVehiculo();
			Ciudad ciudad = gps.getCiudad();
			Posicion posicionDeMeta = ciudad.getPosicionMeta();
			
			ciudad.colocarVehiculo(posicionDeMeta);
			
			auto.moverDerecha();
			
			assertTrue(false);
			
		}catch(JuegoFinalizado e){
			
		}

    }
	
	@Test
	public void sePruebaLaSerializacionDeLaCiudad() throws JuegoNoIniciado{
		  try {
			  
				GPS gps = new GPS();
				Jugador jugador = new Jugador("juan");
				gps.empezarJuego(new Moto(), new Facil(),jugador);
 				Ciudad ciudad = gps.getCiudad();
			  	
				File file = new File("C:\\file.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(Ciudad.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 
				// output pretty printed
				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		 
				jaxbMarshaller.marshal(ciudad, file);
				jaxbMarshaller.marshal(ciudad, System.out);
		 
		  }catch (JAXBException e) {
			    	  e.printStackTrace();
		  		}
	}
	
//	@Test
//	public void sePruebaLaDesSerializacionDeLaCiudad(){
//		  try {
//				File file = new File("C:\\file.xml");
//				JAXBContext jaxbContext = JAXBContext.newInstance(Ciudad.class);
//		 
//				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//				Ciudad ciudad = (Ciudad) jaxbUnmarshaller.unmarshal(file);
//				System.out.println(ciudad);
//		 
//		  }catch (JAXBException e) {
//			  e.printStackTrace();
//		  } 
//	}
}

