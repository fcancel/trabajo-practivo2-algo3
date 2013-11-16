package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Puntuacion;

public class TestPuntuacion {

	@Test
	public void AlCrearUnaPuntuacionConSusAtributosEstosDebenSerCorrectos() {
		
		Puntuacion puntuacion = new Puntuacion(6,30);
		
		assertEquals( puntuacion.getMovimientos(),6 );
		assertEquals( puntuacion.getDimension(),30 );
		assertTrue( puntuacion.getPromedio() == 5 );
		
	}

}
