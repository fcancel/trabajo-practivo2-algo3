package fiuba.algo3.modelo;


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