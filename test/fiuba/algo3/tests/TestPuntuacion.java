package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Puntuacion;

public class TestPuntuacion {

	@Test
	public void AlCrearUnaPuntuacionConElNickEsCorrecto() {
		
		Puntuacion puntuacion = new Puntuacion("juan",20);
		
		assertEquals( puntuacion.getNick(),"juan" );
		
	}
	
	@Test
	public void AlCrearUnaPuntuacionConLosPuntosSonCorrectos() {
		
		Puntuacion puntuacion = new Puntuacion("pedro",50);
		
		assertEquals( puntuacion.getPuntos(),50 );
		
	}

}
