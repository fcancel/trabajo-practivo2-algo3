package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Puntuacion;
import fiuba.algo3.modelo.PuntuacionesAltas;
import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;

public class TestPuntuacionesAltas {

	@Test
	public void alAgregarUnaPuntuacionYPedirleDeberiaObtenerla() throws NoExisteEsaPosicion {
		
		Puntuacion puntuacion = new Puntuacion("juan",50);
		PuntuacionesAltas puntuacionesAltas = new PuntuacionesAltas();
		
		puntuacionesAltas.setPuntuacion(puntuacion);
		
		assertEquals( puntuacionesAltas.getPuntuacion(1).getPuntos(),50 );
		
	}
	
	@Test
	public void alAgregarUnaPuntuacionYLuegoUnaDeMayorPromedioEsaDebeSerLaPrimera() throws NoExisteEsaPosicion {
		
		Puntuacion puntuacionBaja = new Puntuacion("julieta",30);
		Puntuacion puntuacionAlta = new Puntuacion("tomas",50);
		PuntuacionesAltas puntuacionesAltas = new PuntuacionesAltas();
		
		puntuacionesAltas.setPuntuacion(puntuacionBaja);
		
		assertEquals( puntuacionesAltas.getPuntuacion(1).getNick(), "julieta" );
		
		puntuacionesAltas.setPuntuacion(puntuacionAlta);
		
		assertEquals( puntuacionesAltas.getPuntuacion(1).getNick(), "tomas" );
		assertEquals( puntuacionesAltas.getPuntuacion(2).getNick(), "julieta" );
		
	}
	
	@Test
	public void alPedirUnaPuntuacionMasDeLaQueTengoDeboRecibirUnaExcepcionNoExisteEsaPosicion(){
		try{
			
			PuntuacionesAltas puntuacionesAltas = new PuntuacionesAltas();
			puntuacionesAltas.getPuntuacion(1);
			
			assertTrue(false);
			
		}catch(NoExisteEsaPosicion e){
			
		}
	}

}
