package fiuba.algo3.modelo;



public class Auto implements EstadoVehiculo{
    
    
    public Auto (){
              
    }
    

    @Override
    public EstadoVehiculo getEstadoVehiculo() {
        EstadoVehiculo estadoAuto = new Auto();
        return estadoAuto;
    }
    
	@Override
	public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {
		
		efecto.realizarEfecto((Auto) vehiculo.getEstado(), vehiculo);
		
	}
    
}