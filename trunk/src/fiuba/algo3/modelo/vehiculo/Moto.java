package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import res.ImageLoader;


public class Moto implements EstadoVehiculo{



	public Moto(){

	}
        
	@Override
	public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {

		efecto.realizarEfecto((Moto) vehiculo.getEstado(), vehiculo);

	}

	@Override
	public String toString(){

		return "Moto";
	}   
        
        @Override
        public String miEstadoActualEs(){
        return "Moto";
        }
        
}