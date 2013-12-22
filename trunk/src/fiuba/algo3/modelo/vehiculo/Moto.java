package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import res.ImageLoader;


public class Moto implements EstadoVehiculo{

	private String imagen;

	public Moto(){
            ImageLoader setearImagen = new ImageLoader();
            this.imagen = setearImagen.imagenMoto();
	}
        
	@Override
	public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {

		efecto.realizarEfecto((Moto) vehiculo.getEstado(), vehiculo);

	}

	@Override
	public String getDirecionDeImagen() {

		return imagen;
	}

	@Override
	public String toString(){

		return "Moto";
	}   
}