package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;


public class Moto implements EstadoVehiculo{

	private String imagen="/res/moto.png";

	public Moto(){

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