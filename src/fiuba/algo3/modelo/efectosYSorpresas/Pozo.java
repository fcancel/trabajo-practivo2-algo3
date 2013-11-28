package fiuba.algo3.modelo.efectosYSorpresas;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;


public class Pozo implements Efecto {
    
    public Pozo(){
        
    }
    
    
    @Override
    public void realizarEfecto(Moto moto, Vehiculo vehiculo) {
		
        vehiculo.sumarMovimiento(3);
		
	}
    
    @Override
    public void realizarEfecto(Auto auto, Vehiculo vehiculo) {
        
        vehiculo.sumarMovimiento(3);
    }
    
    @Override
    public void realizarEfecto(CuatroPorCuatro cuatroPorCuatro, Vehiculo vehiculo){
        //Como no afecta a las cuatro por cuatro lo dejo vacio
    }
}
