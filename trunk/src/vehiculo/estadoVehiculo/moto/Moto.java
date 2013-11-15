
package vehiculo.estadoVehiculo.moto;

import vehiculo.estadoVehiculo.EstadoVehiculo;


public class Moto implements EstadoVehiculo{

    public void Moto(){
        
    }
    
    @Override
    public EstadoVehiculo getEstadoVehiculo() {
        EstadoVehiculo estadoMoto = new Moto();
        return estadoMoto;
    }
    
}
