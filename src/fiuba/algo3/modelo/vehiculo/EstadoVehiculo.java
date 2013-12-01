package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;


public interface EstadoVehiculo {
    
 
    //public EstadoVehiculo getEstadoVehiculo();
    
	public String getDirecionDeImagen();
	
    public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto);
    
}
