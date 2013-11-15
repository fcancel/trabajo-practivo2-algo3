package vehiculo.estadoVehiculo.auto;

import vehiculo.estadoVehiculo.EstadoVehiculo;


public class Auto implements EstadoVehiculo{
    
    public void Auto (){
              
    }
    
    @Override
    public EstadoVehiculo getEstadoVehiculo() {
        EstadoVehiculo estadoAuto = new Auto();
        return estadoAuto;
    }
}