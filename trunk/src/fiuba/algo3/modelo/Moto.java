package fiuba.algo3.modelo;


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
	
    efecto.realizarEfecto(this, vehiculo);
		
    }
    
}