package fiuba.algo3.modelo;

/**
 *
 * @author Cancel
 */
public interface EstadoVehiculo {
    
    /**
     *
     * @return
     */
    public EstadoVehiculo getEstadoVehiculo();
    
    public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto);
    
}
