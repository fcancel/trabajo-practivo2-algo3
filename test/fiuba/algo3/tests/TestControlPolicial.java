package fiuba.algo3.tests;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.efectosYSorpresas.ControlPolicial;
import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import fiuba.algo3.modelo.efectosYSorpresas.ProbabilidadEstatica;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class TestControlPolicial{

	@Test
	public void alCaerUnAutoEnElControlPolicialConProbabilidad5DebeSumarTresMovimientos() throws JuegoNoIniciado, JAXBException {

		GPS gps = new GPS();
		Jugador jugador = new Jugador("tomas");
		gps.empezarJuego(new Auto(), new Facil(),jugador);
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.5));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),3);
		
	}
	
	@Test
	public void alCaerUnAutoEnElControlPolicialConProbabilidad7NoDebeSumarTresMovimientos() throws JuegoNoIniciado, JAXBException {

		GPS gps = new GPS();
		Jugador jugador = new Jugador("juan");
		gps.empezarJuego(new Auto(), new Facil(),jugador);
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.7));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),0);
		
	}
	
	@Test
	public void alCaerUnaCuatroPorCuatroEnElControlPolicialConProbabilidad3DebeSumarTresMovimientos() throws JuegoNoIniciado, JAXBException {

		GPS gps = new GPS();
		Jugador jugador = new Jugador("pedro");
		gps.empezarJuego(new CuatroPorCuatro(), new Facil(),jugador);
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.3));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),3);
		
	}
	
	@Test
	public void alCaerUnaCuatroPorCuatroEnElControlPolicialConProbabilidad7NoDebeSumarTresMovimientos() throws JuegoNoIniciado, JAXBException {

		GPS gps = new GPS();
		Jugador jugador = new Jugador("lautaro");
		gps.empezarJuego(new CuatroPorCuatro(), new Facil(),jugador);
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.7));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),0);
		
	}
	
	@Test
	public void alCaerUnaMotoEnElControlPolicialConProbabilidad8DebeSumarTresMovimientos() throws JuegoNoIniciado, JAXBException {

		GPS gps = new GPS();
		Jugador jugador = new Jugador("tomas");
		gps.empezarJuego(new Moto(), new Facil(),jugador);
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.8));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),3);
		
	}
	@Test
	public void alCaerUnaMotoEnElControlPolicialConProbabilidad9NoDebeSumarTresMovimientos() throws JuegoNoIniciado, JAXBException {

		GPS gps = new GPS();
		Jugador jugador = new Jugador("jose");
		gps.empezarJuego(new Moto(), new Facil(),jugador);
		Vehiculo auto = gps.getVehiculo();
		Efecto controlPolicial = new ControlPolicial(new ProbabilidadEstatica(0.9));
		
		assertEquals(gps.getMovimientos(),0);
		
		auto.aceptarEfecto(controlPolicial);
		
		assertEquals(gps.getMovimientos(),0);
		
	}

}
