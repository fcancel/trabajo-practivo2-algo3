package fiuba.algo3.modelo.efectosYSorpresas;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class SorpresaCambioDeVehiculo implements Efecto {
    
        private boolean fueAbierto = false;
    
	
	@Override
	public void realizarEfecto(Moto moto, Vehiculo vehiculo) {
            
            if (fueAbierto = false){
		vehiculo.cambiarDeEstado(new Auto());
		fueAbierto = true;
            }
	}

	@Override
	public void realizarEfecto(Auto auto, Vehiculo vehiculo) {
		
             if (fueAbierto = false){
		vehiculo.cambiarDeEstado(new CuatroPorCuatro());
                fueAbierto = true;
             }
		
	}

	@Override
	public void realizarEfecto(CuatroPorCuatro cuatroPorCuatro, Vehiculo vehiculo) {

             if (fueAbierto = false){
		vehiculo.cambiarDeEstado(new Moto());
		fueAbierto = true;
             }
	}

}