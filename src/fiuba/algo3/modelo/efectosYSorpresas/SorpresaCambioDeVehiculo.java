package fiuba.algo3.modelo.efectosYSorpresas;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Posicion;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class SorpresaCambioDeVehiculo implements Efecto {

	//private boolean fueAbierto = false;


	private Posicion posicion;
	private String direccionDeImagen="/res/sorpresa.png";

	@Override
	public void realizarEfecto(Moto moto, Vehiculo vehiculo) {

		//if (fueAbierto = false){
			vehiculo.cambiarDeEstado(new Auto());
			//fueAbierto = true;
		//}
	}

	@Override
	public void realizarEfecto(Auto auto, Vehiculo vehiculo) {

		//if (fueAbierto = false){
			vehiculo.cambiarDeEstado(new CuatroPorCuatro());
			//fueAbierto = true;
		//}

	}

	@Override
	public void realizarEfecto(CuatroPorCuatro cuatroPorCuatro, Vehiculo vehiculo) {

		//if (fueAbierto = false){
			vehiculo.cambiarDeEstado(new Moto());
			//fueAbierto = true;
		//}
	}

	@Override
	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public int getX() {
		return ((this.posicion.getX())*500)/25;
	}

	@Override
	public int getY() {
		return ((this.posicion.getY())*500)/25;
	}
	
	@Override
	public String getDirecionDeImagen() {
		return this.direccionDeImagen;
	}

}