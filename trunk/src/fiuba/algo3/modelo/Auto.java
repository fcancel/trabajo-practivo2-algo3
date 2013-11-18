package fiuba.algo3.modelo;


/**
 *
 * @author Cancel
 */
public class Auto implements EstadoVehiculo{
    
    /**
     *
     */
    public Auto (){
              
    }
    
    /**
     *
     * @return
     */
    @Override
    public EstadoVehiculo getEstadoVehiculo() {
        EstadoVehiculo estadoAuto = new Auto();
        return estadoAuto;
    }
    
	@Override
	public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {
		
		efecto.realizarEfecto(this, vehiculo);
		
	}
    
}