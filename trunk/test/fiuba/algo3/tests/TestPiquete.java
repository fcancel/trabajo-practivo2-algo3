package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Efecto;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.Piquete;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;

public class TestPiquete {

	@Test
	public void alCaerUnaMotoEnUnPiqueteDebeSumarDosMovimientos() throws JuegoNoIniciado {
		
		GPS gps = new GPS();
		gps.empezarJuego(new Moto(), 5, "juan");
		Vehiculo moto = gps.getVehiculo();
		Efecto piquete = new Piquete();
		
		assertEquals(gps.getMovimientos(),0);
		
		moto.aceptarEfecto(piquete);
		
		assertEquals(gps.getMovimientos(),2);
	}
	
	/*@Test
	public void alCaerUnAutoEnUnPiqueteDebeVolverALaPosicionAnterior(){
		
		
		
	}
	
	@Test
	public void alCaerUnaCuatroPorCuatroEnUnPiqueteDebeVolverALaPosicionAnterior(){
		
		
		
	}*/

}
