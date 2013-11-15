package vehiculo;

import posicion.Posicion;
import vehiculo.estadoVehiculo.EstadoVehiculo;


public class Vehiculo {
    
    private Posicion posicion;
    private EstadoVehiculo estado;

    Vehiculo(EstadoVehiculo estadoASetear) {
        this.estado = estadoASetear;
        this.posicion = new Posicion();
    }

   
    public void Vehiculo(EstadoVehiculo estadoASetear) {
        
        this.estado = estadoASetear;
        this.posicion = new Posicion();
    }
    
    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicionASetear) {
        this.posicion = posicionASetear;
    }

    public void cambiarDeEstado(EstadoVehiculo estadoASetear) {
        this.estado = estadoASetear;
    }

    public EstadoVehiculo estadoActual() {
        return this.estado;
    }
    
}
