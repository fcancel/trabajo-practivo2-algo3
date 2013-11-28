package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;


public interface EstadoVehiculo {
    
 
    public EstadoVehiculo getEstadoVehiculo();
    
    public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto);
    
}
