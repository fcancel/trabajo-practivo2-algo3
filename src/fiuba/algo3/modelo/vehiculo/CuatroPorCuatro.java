package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;


/**
 *
 * @author Cancel
 */
public class CuatroPorCuatro implements EstadoVehiculo{
    
    /**
     *
     */
    public CuatroPorCuatro(){
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public EstadoVehiculo getEstadoVehiculo(){
        EstadoVehiculo estadoCuatroPorCuatro = new CuatroPorCuatro();
        return estadoCuatroPorCuatro;      
    }
    
	@Override
	public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {
		
		efecto.realizarEfecto((CuatroPorCuatro) vehiculo.getEstado(), vehiculo);
		
	}
    
}