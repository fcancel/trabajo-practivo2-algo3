package vehiculo.estadoVehiculo.cuatroPorCuatro;

import vehiculo.estadoVehiculo.EstadoVehiculo;


public class CuatroPorCuatro implements EstadoVehiculo{
    
    public void CuatroPorCuatro(){
        
    }
    
    @Override
    public EstadoVehiculo getEstadoVehiculo(){
        EstadoVehiculo estadoCuatroPorCuatro = new CuatroPorCuatro();
        return estadoCuatroPorCuatro;      
    }
}