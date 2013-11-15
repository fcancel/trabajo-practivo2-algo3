package vehiculo.estadoVehiculo.moto;

import vehiculo.estadoVehiculo.EstadoVehiculo;

/**
 *
 * @author Cancel
 */
public class Moto implements EstadoVehiculo{

    /**
     *
     */
    public void Moto(){
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public EstadoVehiculo getEstadoVehiculo() {
        EstadoVehiculo estadoMoto = new Moto();
        return estadoMoto;
    }
}