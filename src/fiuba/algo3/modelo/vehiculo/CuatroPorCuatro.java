package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import res.ImageLoader;


public class CuatroPorCuatro implements EstadoVehiculo{


	public CuatroPorCuatro(){
           
	} 
        
	@Override
	public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {

		efecto.realizarEfecto((CuatroPorCuatro) vehiculo.getEstado(), vehiculo);

	}


	@Override
	public String toString(){

		return "4x4";
	}

}