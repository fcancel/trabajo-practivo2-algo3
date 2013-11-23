package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Auto;
import fiuba.algo3.modelo.Calle;
import fiuba.algo3.modelo.Ciudad;
import fiuba.algo3.modelo.CuatroPorCuatro;
import fiuba.algo3.modelo.Efecto;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.Piquete;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;

public class TestPiquete {

	@Test
	public void alCaerUnaMotoEnUnPiqueteDebeSumarDosMovimientos() throws JuegoNoIniciado {
		
		GPS gps = new GPS();
		gps.empezarJuegoFacil(new Moto(),"juan");
		Vehiculo moto = gps.getVehiculo();
		Efecto piquete = new Piquete();
		
		assertEquals(gps.getMovimientos(),0);
		
		moto.aceptarEfecto(piquete);
		
		assertEquals(gps.getMovimientos(),2);
	}
	
	@Test
	public void alCaerUnAutoEnUnPiqueteDebeVolverALaPosicionAnterior() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
		
		GPS gps = new GPS();
		gps.empezarJuegoFacil(new Auto(),"juan");
		Vehiculo auto = gps.getVehiculo();
		Ciudad ciudad = gps.getCiudad();
		Efecto piquete = new Piquete();
		
		Posicion posicionDestino = new Posicion();
		posicionDestino.setX(2);
		posicionDestino.setY(7);
		
		Calle calleDestino = ciudad.calleEnUnaPosicion(posicionDestino);
		
		calleDestino.setObstaculo(piquete);
		calleDestino.setSorpresa(null);
		
		// El vehiculo se ubicara en la posicion  (1,7)
		Posicion posicion = auto.getPosicion();
		
		//verifico posicion inicial
		assertEquals(1,posicion.getX());
		assertEquals(7,posicion.getY());
				
		auto.moverDerecha();
				
		// la auto retrocede una posicion
		assertEquals(1,posicion.getX());
		assertEquals(7,posicion.getY());
		
		
	}
	
	@Test
	public void alCaerUnaCuatroPorCuatroEnUnPiqueteDebeVolverALaPosicionAnterior() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
		
		GPS gps = new GPS();
		gps.empezarJuegoFacil(new CuatroPorCuatro(),"diego");
		Vehiculo cuatroPorCuatro = gps.getVehiculo();
		Ciudad ciudad = gps.getCiudad();
		Efecto piquete = new Piquete();
		
		Posicion posicionDestino = new Posicion();
		posicionDestino.setX(2);
		posicionDestino.setY(7);
		
		Calle calleDestino = ciudad.calleEnUnaPosicion(posicionDestino);
		
		calleDestino.setObstaculo(piquete);
		calleDestino.setSorpresa(null);
		
		// El vehiculo se ubicara en la posicion  (1,7)
		Posicion posicion = cuatroPorCuatro.getPosicion();
		
		//verifico posicion inicial
		assertEquals(1,posicion.getX());
		assertEquals(7,posicion.getY());
		
		cuatroPorCuatro.moverDerecha();
		
		// la 4X4 retrocede una posicion
		assertEquals(1,posicion.getX());
		assertEquals(7,posicion.getY());
		
	}

}
