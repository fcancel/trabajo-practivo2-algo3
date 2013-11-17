package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.excepciones.NoExisteEsaPosicion;
import fiuba.algo3.modelo.Puntuacion;
import fiuba.algo3.modelo.PuntuacionesAltas;

public class TestPuntuacionesAltas {

	@Test
	public void alAgregarUnaPuntuacionYPedirleDeberiaObtenerla() throws NoExisteEsaPosicion {
		
		Puntuacion puntuacion = new Puntuacion(5,30,"juan");
		PuntuacionesAltas puntuacionesAltas = new PuntuacionesAltas();
		
		puntuacionesAltas.setPuntuacion(puntuacion);
		
		assertTrue( puntuacionesAltas.getPuntuacion(1).getPromedio() == 6 );
		
	}
	
	@Test
	public void alAgregarUnaPuntuacionYLuegoUnaDeMayorPromedioEsaDebeSerLaPrimera() throws NoExisteEsaPosicion {
		
		Puntuacion puntuacionBaja = new Puntuacion(5,30,"julieta");
		Puntuacion puntuacionAlta = new Puntuacion(2,30,"tomas");
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
