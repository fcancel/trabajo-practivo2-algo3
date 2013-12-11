package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;



public class Auto implements EstadoVehiculo{

	private String imagen="/res/auto.png";

	public Auto (){

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