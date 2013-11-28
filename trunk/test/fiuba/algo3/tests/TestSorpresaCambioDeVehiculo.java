package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.efectosYSorpresas.ControlPolicial;
import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import fiuba.algo3.modelo.efectosYSorpresas.ProbabilidadEstatica;
import fiuba.algo3.modelo.efectosYSorpresas.SorpresaCambioDeVehiculo;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class TestSorpresaCambioDeVehiculo {
	
	@Test
	public void alCaerUnaMotoEnCambioDeVehiculoDebeCambiarAAuto() throws JuegoNoIniciado {
		
		GPS gps = new GPS();
		Jugador jugador = new Jugador("juan");
		gps.empezarJuego(new Moto(), new Facil(),jugador);
		Vehiculo vehiculo = gps.getVehiculo();
		Efecto cambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.8));
		
		vehiculo.aceptarEfecto(controlPolicial);

		//Al ser moto aumenta en 3 movimientos
		assertEquals(gps.getMovimientos(),3);
		
		vehiculo.aceptarEfecto(cambioDeVehiculo);
		vehiculo.aceptarEfecto(controlPolicial);
		
		//Al cambiar a auto no aumentan los movimientos
		assertEquals(gps.getMovimientos(),3);
		
	}
	
	@Test
	public void alCaerUnAutoEnCambioDeVehiculoDebeCambiarACuatroPorCuatro() throws JuegoNoIniciado {
		
		
		GPS gps = new GPS();
		Jugador jugador = new Jugador("juan");
		gps.empezarJuego(new Auto(), new Facil(),jugador);
		Vehiculo vehiculo = gps.getVehiculo();
		Efecto cambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.5));
		
		vehiculo.aceptarEfecto(controlPolicial);

		//Al ser auto aumenta en 3 movimientos
		assertEquals(gps.getMovimientos(),3);
		
		vehiculo.aceptarEfecto(cambioDeVehiculo);
		vehiculo.aceptarEfecto(controlPolicial);
		
		//Al cambiar a CuatroPorCuatro no aumentan los movimientos
		assertEquals(gps.getMovimientos(),3);
		
	}
	
	@Test
	public void alCaerUnaCuatroPorCuatroEnCambioDeVehiculoDebeCambiarACuatroPorCuatro() throws JuegoNoIniciado {
		
		GPS gps = new GPS();
		Jugador jugador = new Jugador("tomas");
		gps.empezarJuego(new CuatroPorCuatro(), new Facil(),jugador);
		Vehiculo vehiculo = gps.getVehiculo();
		Efecto cambioDeVehiculo = new SorpresaCambioDeVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.5));
		
		vehiculo.aceptarEfecto(controlPolicial);

		//Al ser CuatroPorCuatro no aumenta los movimientos
		assertEquals(gps.getMovimientos(),0);
		
		vehiculo.aceptarEfecto(cambioDeVehiculo);
		vehiculo.aceptarEfecto(controlPolicial);
		
		//Al cambiar a Moto aumentan los movimientos en 3
		assertEquals(gps.getMovimientos(),3);
		
	}

}
