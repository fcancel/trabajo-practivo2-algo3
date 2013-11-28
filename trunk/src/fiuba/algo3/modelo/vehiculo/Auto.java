package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;



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