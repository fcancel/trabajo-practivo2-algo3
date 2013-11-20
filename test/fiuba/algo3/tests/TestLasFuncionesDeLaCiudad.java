package fiuba.algo3.tests;

import static org.junit.Assert.*;

import fiuba.algo3.modelo.Calle;
import fiuba.algo3.modelo.Ciudad;
import fiuba.algo3.modelo.EstadoVehiculo;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;
import org.junit.Assert;

import org.junit.Test;

public class TestLasFuncionesDeLaCiudad {

	@Test
    public void ubicaElVehiculoEnUnaPosicionValida() throws MovimientoInvalido{
		int dimension = 10;
		Posicion posicion = new Posicion();
		posicion.setX(1);
		posicion.setY(1);
		GPS gps = new GPS();
        EstadoVehiculo estado = new Moto();
        Vehiculo vehiculo = new Vehiculo(estado);
        Ciudad ciudad = new Ciudad(dimension,vehiculo,gps);		
        Assert.assertEquals(true, ciudad.esValidaLaPosicion(posicion));
        Calle calle = ciudad.calleEnUnaPosicion(posicion);
        assertTrue(calle.getVehiculo() == vehiculo);
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
	
}
