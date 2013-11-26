package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Auto;
import fiuba.algo3.modelo.Ciudad;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;

public class TestIntegral {

	@Test
	public void ganarJuegoSinObstaculos() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado {
		
		GPS gps = new GPS();
		gps.empezarJuegoFacil(new Auto(),"juan");
		
		Vehiculo auto = gps.getVehiculo();
		Ciudad ciudad = gps.getCiudad();
		ciudad.eliminarObstaculosYSorpresas();

		//posicion inicial (1,7) y meta en (14,7)
		//14 movimientos a la derecha para ganar
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		auto.moverDerecha();
		
		assertFalse(gps.juegoEnMarcha());
		
	}

}