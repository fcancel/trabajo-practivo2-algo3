package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Auto;
import fiuba.algo3.modelo.ControlPolicial;
import fiuba.algo3.modelo.CuatroPorCuatro;
import fiuba.algo3.modelo.Efecto;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.ProbabilidadEstatica;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;

public class TestControlPolicial{

	@Test
	public void alCaerUnAutoEnElControlPolicialConProbabilidad5DebeSumarTresMovimientos() throws JuegoNoIniciado {

		GPS gps = new GPS();
		gps.empezarJuegoFacil(new Auto(),"tomas");
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.5));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),3);
		
	}
	
	@Test
	public void alCaerUnAutoEnElControlPolicialConProbabilidad7NoDebeSumarTresMovimientos() throws JuegoNoIniciado {

		GPS gps = new GPS();
		gps.empezarJuegoFacil(new Auto(),"juan");
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.7));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),0);
		
	}
	
	@Test
	public void alCaerUnaCuatroPorCuatroEnElControlPolicialConProbabilidad3DebeSumarTresMovimientos() throws JuegoNoIniciado {

		GPS gps = new GPS();
		gps.empezarJuegoFacil(new CuatroPorCuatro(),"pedro");
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.3));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),3);
		
	}
	
	@Test
	public void alCaerUnaCuatroPorCuatroEnElControlPolicialConProbabilidad7NoDebeSumarTresMovimientos() throws JuegoNoIniciado {

		GPS gps = new GPS();
		gps.empezarJuegoFacil(new CuatroPorCuatro(),"lautaro");
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.7));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),0);
		
	}
	
	@Test
	public void alCaerUnaMotoEnElControlPolicialConProbabilidad8DebeSumarTresMovimientos() throws JuegoNoIniciado {

		GPS gps = new GPS();
		gps.empezarJuegoFacil(new Moto(),"tomas");
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.8));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),3);
		
	}
	@Test
	public void alCaerUnaMotoEnElControlPolicialConProbabilidad9NoDebeSumarTresMovimientos() throws JuegoNoIniciado {

		GPS gps = new GPS();
		gps.empezarJuegoFacil(new Moto(),"jose");
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.9));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),0);
		
	}

}
