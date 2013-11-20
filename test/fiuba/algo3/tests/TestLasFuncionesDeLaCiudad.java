package fiuba.algo3.tests;

import static org.junit.Assert.*;
import fiuba.algo3.modelo.Auto;
import fiuba.algo3.modelo.Calle;
import fiuba.algo3.modelo.Ciudad;
import fiuba.algo3.modelo.EstadoVehiculo;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;

import org.junit.Assert;
import org.junit.Test;

public class TestLasFuncionesDeLaCiudad {

	@Test
    public void validarPosicion() throws MovimientoInvalido{
		int dimension = 10;
		Posicion posicion = new Posicion();
		posicion.setX(1);
		posicion.setY(1);
		GPS gps = new GPS();
        EstadoVehiculo estado = new Moto();
        Vehiculo vehiculo = new Vehiculo(estado);
        Ciudad ciudad = new Ciudad(dimension,vehiculo,gps);
        Calle calle = ciudad.calleEnUnaPosicion(posicion);
        calle.inicializarCalle();
        assertTrue(ciudad.esValidaLaPosicion(posicion) == true);
    }

	@Test
    public void ubicaElVehiculoEnUnaPosicionValida() throws MovimientoInvalido, JuegoNoIniciado{
		
		GPS gps = new GPS();
		gps.empezarJuego(new Auto(), 5, "juan");
		Vehiculo auto = gps.getVehiculo();
		Ciudad ciudad = gps.getCiudad();
		Posicion posicion = auto.getPosicion();
		Calle calle = ciudad.calleEnUnaPosicion(posicion);
		
		assertTrue(calle.getVehiculo() == auto);
    }

	@Test
    public void alMovermeAUnLugarInvalidoReciboExcepcionMovimientoInvalido(){
        try{
    		int dimension = 4;
    		Posicion posicion = new Posicion();
    		posicion.setX(0);
    		posicion.setY(0);
    		GPS gps = new GPS();
    		EstadoVehiculo estado = new Moto();
    		Vehiculo vehiculo = new Vehiculo(estado);
    		Ciudad ciudad = new Ciudad(dimension,vehiculo,gps);
    		ciudad.esValidaLaPosicion(posicion);
        	assertTrue( false );
        	
        }catch( MovimientoInvalido e ){
        	
        }
    }
	
	@Test
    public void alUbicaElVehiculoEnLaMetaElJuegoNoDebeEstarEnMarcha() throws MovimientoInvalido, JuegoNoIniciado{
		
		GPS gps = new GPS();
		gps.empezarJuego(new Auto(), 10, "juan");
		Vehiculo auto = gps.getVehiculo();
		Ciudad ciudad = gps.getCiudad();
		Posicion posicionDeMeta = ciudad.posicionDeMeta();
		
		ciudad.esValidaLaPosicion(posicionDeMeta);
		
		assertFalse(gps.juegoEnMarcha());
    }

	
}
