package vehiculo;

import gps.GPS;
import posicion.Posicion;
import vehiculo.estadoVehiculo.EstadoVehiculo;


public class Vehiculo {
    
    private Posicion posicion;
    private EstadoVehiculo estado;
    private GPS GPS;

    public Vehiculo(EstadoVehiculo estadoASetear) {
        this.estado = estadoASetear;
        this.posicion = new Posicion();
        this.GPS = new GPS();
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
    
    public void sumarMovimiento( int numeroASumar){
        GPS Gps = getGPS();
        
        Gps.sumarMovimiento(numeroASumar);
    }
    
    private GPS getGPS(){
        return this.GPS;
    }
    
}
