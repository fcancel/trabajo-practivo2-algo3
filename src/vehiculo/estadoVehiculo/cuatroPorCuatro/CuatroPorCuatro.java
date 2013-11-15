package vehiculo.estadoVehiculo.cuatroPorCuatro;

import vehiculo.estadoVehiculo.EstadoVehiculo;

/**
 *
 * @author Cancel
 */
public class CuatroPorCuatro implements EstadoVehiculo{
    
    /**
     *
     */
    public void CuatroPorCuatro(){
        
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
}