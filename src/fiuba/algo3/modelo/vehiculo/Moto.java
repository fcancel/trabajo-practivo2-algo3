package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;


public class Moto implements EstadoVehiculo{

   
    public Moto(){
        
    }
    
   
    @Override
    public EstadoVehiculo getEstadoVehiculo() {
        EstadoVehiculo estadoMoto = new Moto();
        return estadoMoto;
    }
    
    
    @Override
    public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {
	
    efecto.realizarEfecto((Moto) vehiculo.getEstado(), vehiculo);
		
    }
    
}