package fiuba.algo3.modelo.efectosYSorpresas;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

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
