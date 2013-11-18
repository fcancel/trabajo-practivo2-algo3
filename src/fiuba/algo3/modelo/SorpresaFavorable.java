package fiuba.algo3.modelo;

public class SorpresaFavorable implements Efecto {

	private void restarMovimientos(Vehiculo vehiculo){
		
		double movimientosARestar = (vehiculo.movimientos()) * - 0.20;
		
		vehiculo.sumarMovimiento((int)movimientosARestar );
		
	}
	
	@Override
	public void realizarEfecto(Moto moto, Vehiculo vehiculo) {
		
		this.restarMovimientos(vehiculo);

	}

	@Override
	public void realizarEfecto(Auto auto, Vehiculo vehiculo) {

		this.restarMovimientos(vehiculo);

	}

	@Override
	public void realizarEfecto(CuatroPorCuatro cuatroPorCuatro, Vehiculo vehiculo) {
		
		this.restarMovimientos(vehiculo);

	}

}
