package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import res.ImageLoader;


public class CuatroPorCuatro implements EstadoVehiculo{

	private String imagen;

	public CuatroPorCuatro(){
            ImageLoader setearImagen = new ImageLoader();
            this.imagen = setearImagen.imagenCuatroPorCuatro();
	} 
        
	@Override
	public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {

		efecto.realizarEfecto((CuatroPorCuatro) vehiculo.getEstado(), vehiculo);

	}

	@Override
	public String getDirecionDeImagen() {
		return imagen;
	}

	@Override
	public String toString(){

		return "4x4";
	}
}