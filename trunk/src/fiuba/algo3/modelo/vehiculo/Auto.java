package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import res.ImageLoader;



public class Auto implements EstadoVehiculo{

	private String imagen;

	public Auto (){
            ImageLoader setearImagen = new ImageLoader();
            this.imagen = setearImagen.imagenAuto();
	}

	@Override
	public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto) {

		efecto.realizarEfecto((Auto) vehiculo.getEstado(), vehiculo);

	}


	@Override
	public String getDirecionDeImagen() {
		return imagen;
	}

	@Override
	public String toString(){

		return "Auto";
	}
}