package fiuba.algo3.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import fiuba.algo3.modelo.mapa.Calle;
import fiuba.algo3.modelo.mapa.Ciudad;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.serializacion.SerializacionCiudad;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Posicion;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


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
    public void ubicaElVehiculoEnUnaPosicionValida() throws MovimientoInvalido, JuegoNoIniciado, JAXBException{
		
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
    public void alUbicaElVehiculoEnLaMetaElJuegoNoDebeEstarEnMarcha() throws MovimientoInvalido, JuegoNoIniciado, JuegoFinalizado, JAXBException{
		
		GPS gps = new GPS();
		Jugador jugador = new Jugador("juan");
		gps.empezarJuego(new Moto(), new Facil(),jugador);
		Ciudad ciudad = gps.getCiudad();
		Posicion posicionDeMeta = ciudad.getPosicionMeta();
		ciudad.colocarVehiculo(posicionDeMeta);
		
		assertFalse(gps.juegoEnMarcha());
    }

	@Test
    public void alUbicaElVehiculoEnLaMetaYQuererRealizarOtroMovimientoDeboRecibirExcepcionJuegoTerminado() throws MovimientoInvalido, JuegoNoIniciado, JAXBException{
		
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
	public void sePruebaLaSerializacionDeLaCiudadYLaDesSerealizacionComparandoLosXmlGenerados() throws JuegoNoIniciado, SAXException, IOException, ParserConfigurationException{
		  try {
				SerializacionCiudad serealizador = new SerializacionCiudad();
			  	GPS gps = new GPS();
				String ArchivoUno = new String("C:\\PruebaSerializarIn.xml");
				String ArchivoDos = new String("C:\\PruebaSerializarOut.xml");
				Jugador jugador = new Jugador("martin");
				gps.empezarJuego(new Moto(), new Facil(),jugador);
 				Ciudad ciudadASerealizar = gps.getCiudad();
 				serealizador.serializar(ciudadASerealizar,ArchivoUno);
 				Ciudad ciudadDesSerealizada = serealizador.desSerealizar(ArchivoUno);
 				serealizador.serializar(ciudadDesSerealizada,ArchivoDos);
 				
 				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
 				dbf.setNamespaceAware(true);
 				dbf.setCoalescing(true);
 				dbf.setIgnoringElementContentWhitespace(true);
 				dbf.setIgnoringComments(true);
 				DocumentBuilder db = dbf.newDocumentBuilder();

 				Document doc1 = db.parse(ArchivoUno);
 				doc1.normalizeDocument();

 				Document doc2 = db.parse(ArchivoDos);

 				doc2.normalizeDocument();
 				
 				assertTrue(doc1.isEqualNode(doc2));
 				
		  }catch (JAXBException e) {
			    	  e.printStackTrace();
		  		}
	}	

}

