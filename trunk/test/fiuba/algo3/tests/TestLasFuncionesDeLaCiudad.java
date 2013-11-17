package fiuba.algo3.tests;

import static org.junit.Assert.*;
import fiuba.algo3.modelo.Ciudad;
import fiuba.algo3.modelo.EstadoVehiculo;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.Vehiculo;

import org.junit.Assert;
import org.junit.Test;

public class TestLasFuncionesDeLaCiudad {

	@Test
    public void alCrearLaCiudadSeCreaUnaListaDeCalles(){
		int dimension = 4;
		GPS gps = new GPS();
        EstadoVehiculo estado = new Moto();
        Vehiculo vehiculo = new Vehiculo(estado);
        Ciudad ciudad = new Ciudad(dimension,vehiculo,gps);		
        assertTrue(ciudad.getDimension()== dimension * dimension);
    }
	
}
