package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.dificultad.Dificil;
import fiuba.algo3.modelo.dificultad.Dificultad;
import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.dificultad.Moderado;

public class TestsDificultades {

	@Test
	public void testAlCrearUnaDificultadEnFacilSusDatosDebenSerCorrectos() {
		
		Dificultad facil = new Facil();
		
		assertEquals(25,facil.getFilas());
		assertEquals(25,facil.getColumnas());
		assertEquals(1,facil.getMultiplicador());
		assertEquals(80,facil.getMaximoDeMovimientos());
		
	}
	
	@Test
	public void testAlCrearUnaDificultadEnModeradoSusDatosDebenSerCorrectos() {
		
		Dificultad moderado = new Moderado();
		
		assertEquals(25,moderado.getFilas());
		assertEquals(25,moderado.getColumnas());
		assertEquals(2,moderado.getMultiplicador());
		assertEquals(60,moderado.getMaximoDeMovimientos());
		
	}
	
	@Test
	public void testAlCrearUnaDificultadEnDificilSusDatosDebenSerCorrectos() {
		
		Dificultad dificil = new Dificil();
		
		assertEquals(25,dificil.getFilas());
		assertEquals(25,dificil.getColumnas());
		assertEquals(3,dificil.getMultiplicador());
		assertEquals(40,dificil.getMaximoDeMovimientos());
		
	}

}
