package fiuba.algo3.tests;
import static org.junit.Assert.*;

import java.util.Random;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import fiuba.algo3.modelo.efectosYSorpresas.Pozo;
import fiuba.algo3.modelo.efectosYSorpresas.SorpresaCambioDeVehiculo;
import fiuba.algo3.modelo.mapa.Calle;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

import java.util.ArrayList;

import org.junit.Test;


public class TestLasFuncionesDeLaCalle {

	@Test
    public void asignaCorrectamenteLaSopresaYElObstaculoALaCalle(){
		Calle calle1= new Calle();
		Calle calle2= new Calle();
		Efecto sorpresa= new SorpresaCambioDeVehiculo();
		Efecto obstaculo = new Pozo();
		calle1.setSorpresa(sorpresa);
		calle2.setObstaculo(obstaculo);
        assertTrue((calle1.tengoSorpresa()) && (calle2.tengoObstaculo()));
    }

	@Test
	public void cuandoCreaUnaCalleSeLeAsignanObstaculosYSorpresasAleatoriamente(){
		//Se ejecuto la función Radom con el Seed 100 y se comprobo que arroja
		// la siguiente secuencia en sus primeros 10 números 6, 2, 5, 6, 5, 5, 2, 4, 5, 4
    	ArrayList<Calle> listaDeCalles= new ArrayList<Calle>();
		Random rnd = new Random(); 
    	rnd.setSeed(100);
    	for (int i= 0; i < 3; i++){
    		listaDeCalles.add(new Calle(rnd));	
    	}
		Calle calle2= listaDeCalles.get(2);
		Calle calle1= listaDeCalles.get(1);    	
		assertTrue((calle2.tengoSorpresa()) && (calle1.tengoObstaculo()));
	}
	@Test
	public void cuandoVaAUbicarElVehiculoEnLaCalleYHayUnEfectoEsAplicadoCorrectamente(){
        EstadoVehiculo estado = new Moto();
		Vehiculo vehiculo = new Vehiculo(estado);
		Calle calle1= new Calle();    	
		Efecto sorpresa= new SorpresaCambioDeVehiculo();
		calle1.setSorpresa(sorpresa);
		calle1.setObstaculo(null);
		calle1.setVehiculo(vehiculo);
		assertTrue(vehiculo.getEstado() != estado );
	}
}
