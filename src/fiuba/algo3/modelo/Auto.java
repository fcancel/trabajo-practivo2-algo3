package fiuba.algo3.modelo;


/**
 *
 * @author Cancel
 */
public class Auto implements EstadoVehiculo{
    
    /**
     *
     */
    public void Auto (){
              
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
}