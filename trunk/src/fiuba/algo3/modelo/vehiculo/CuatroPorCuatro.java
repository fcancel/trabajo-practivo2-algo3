package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;


public class CuatroPorCuatro implements EstadoVehiculo{

	private String imagen="/res/CxC.png";
	
    public CuatroPorCuatro(){
        
    } 
	@Override
	public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {
		
		efecto.realizarEfecto((CuatroPorCuatro) vehiculo.getEstado(), vehiculo);
		
	}

	@Override
	public String getDirecionDeImagen() {
		// TODO Auto-generated method stub
		return imagen;
	}
    
}