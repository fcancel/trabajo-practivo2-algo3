package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import res.ImageLoader;



public class Auto implements EstadoVehiculo{



	public Auto (){

	}

	@Override
	public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {

		efecto.realizarEfecto((Auto) vehiculo.getEstado(), vehiculo);

	}


	@Override
	public String toString(){

		return "Auto";
	}
        
        
        public String miEstadoActualEs(){
        return "Auto";
        }
}