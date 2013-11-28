package fiuba.algo3.modelo.efectosYSorpresas;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class ControlPolicial implements Efecto {

	private Probabilidad probabilidad;
	
	public ControlPolicial(Probabilidad probabilidad) {
		this.probabilidad = probabilidad;
	}

	@Override
	public void realizarEfecto(Moto moto, Vehiculo vehiculo) {
		
		this.sumarMovientos(vehiculo, 0.8);
		
	}

	@Override
	public void realizarEfecto(Auto auto, Vehiculo vehiculo) {
		
		this.sumarMovientos(vehiculo, 0.5);
		
	}

	@Override
	public void realizarEfecto(CuatroPorCuatro cuatroPorCuatro, Vehiculo vehiculo) {

		this.sumarMovientos(vehiculo, 0.3);
		
	}

	private void sumarMovientos(Vehiculo vehiculo, double maximo){
		
		if(probabilidad.calcularProbabilidad() <= maximo){
			vehiculo.sumarMovimiento(3);
		}
		
	}
	
}
