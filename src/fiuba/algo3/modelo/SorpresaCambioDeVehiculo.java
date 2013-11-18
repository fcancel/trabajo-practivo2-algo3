package fiuba.algo3.modelo;

public class SorpresaCambioDeVehiculo implements Efecto {
	
	@Override
	public void realizarEfecto(Moto moto, Vehiculo vehiculo) {

		vehiculo.cambiarDeEstado(new Auto());
		
	}

	@Override
	public void realizarEfecto(Auto auto, Vehiculo vehiculo) {
		
		vehiculo.cambiarDeEstado(new CuatroPorCuatro());
		
	}

	@Override
	public void realizarEfecto(CuatroPorCuatro cuatroPorCuatro, Vehiculo vehiculo) {

		vehiculo.cambiarDeEstado(new Moto());
		
	}

}