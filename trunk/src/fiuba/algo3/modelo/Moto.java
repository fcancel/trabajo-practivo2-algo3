package fiuba.algo3.modelo;


/**
 *
 * @author Cancel
 */
public class Moto implements EstadoVehiculo{

    /**
     *
     */
    public Moto(){
        
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
    
	@Override
	public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {
		
		efecto.realizarEfecto(this, vehiculo);
		
	}
    
}