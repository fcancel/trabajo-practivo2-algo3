package fiuba.algo3.modelo;

public class Piquete implements Efecto {

	@Override
	public void realizarEfecto(Moto moto, Vehiculo vehiculo) {

		vehiculo.sumarMovimiento(2);

	}

	@Override
	public void realizarEfecto(Auto auto, Vehiculo vehiculo) {

		vehiculo.retroceder();

	}

	@Override
	public void realizarEfecto(CuatroPorCuatro cuatroPorCuatro,
			Vehiculo vehiculo) {

		vehiculo.retroceder();

	}

}
