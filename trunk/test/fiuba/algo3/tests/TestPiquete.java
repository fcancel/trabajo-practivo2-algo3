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
		gps.empezarJuego(new Moto(), 5, "juan");
		Vehiculo moto = gps.getVehiculo();
		Efecto piquete = new Piquete();
		
		assertEquals(gps.getMovimientos(),0);
		
		moto.aceptarEfecto(piquete);
		
		assertEquals(gps.getMovimientos(),2);
	}
	
	@Test
	public void alCaerUnAutoEnUnPiqueteDebeVolverALaPosicionAnterior() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
		
		GPS gps = new GPS();
		gps.empezarJuego(new Auto(), 10, "juan");
		Vehiculo auto = gps.getVehiculo();
		Efecto piquete = new Piquete();
		
		// El vehiculo se ubicara en la posicion (1,3)
		Posicion posicion = auto.getPosicion();
		
		assertEquals(1,posicion.getX());
		assertEquals(3,posicion.getY());
		
		auto.moverDerecha();
		
		auto.aceptarEfecto(piquete);
		
		// el auto retrocede una posicion
		assertEquals(1,posicion.getX());
		assertEquals(3,posicion.getY());
		
	}
	
	@Test
	public void alCaerUnaCuatroPorCuatroEnUnPiqueteDebeVolverALaPosicionAnterior() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
		
		GPS gps = new GPS();
		gps.empezarJuego(new CuatroPorCuatro(), 10, "juan");
		Vehiculo cuatroPorCuatro = gps.getVehiculo();
		Efecto piquete = new Piquete();
		
		// El vehiculo se ubicara en la posicion (1,3)
		Posicion posicion = cuatroPorCuatro.getPosicion();
		
		assertEquals(1,posicion.getX());
		assertEquals(3,posicion.getY());
		
		cuatroPorCuatro.moverDerecha();
		
		cuatroPorCuatro.aceptarEfecto(piquete);
		
		// la 4X4 retrocede una posicion
		assertEquals(1,posicion.getX());
		assertEquals(3,posicion.getY());
		
	}

}
