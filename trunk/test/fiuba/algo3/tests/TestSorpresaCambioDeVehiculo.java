package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Auto;
import fiuba.algo3.modelo.ControlPolicial;
import fiuba.algo3.modelo.CuatroPorCuatro;
import fiuba.algo3.modelo.Efecto;
import fiuba.algo3.modelo.Facil;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.ProbabilidadEstatica;
import fiuba.algo3.modelo.SorpresaCambioDeVehiculo;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;

public class TestSorpresaCambioDeVehiculo {
	
	@Test
	public void alCaerUnaMotoEnCambioDeVehiculoDebeCambiarAAuto() throws JuegoNoIniciado {
		
		GPS gps = new GPS();
		gps.empezarJuego(new Moto(), new Facil(),"juan");
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
		gps.empezarJuego(new Auto(), new Facil(),"juan");
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
		gps.empezarJuego(new CuatroPorCuatro(), new Facil(),"tomas");
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
