package fiuba.algo3.modelo;

public class SorpresaDesfavorable implements Efecto {

	private void sumarMovimientos(Vehiculo vehiculo){
		
		double movimientosASumar = (vehiculo.movimientos()) * 0.25;
		
		vehiculo.sumarMovimiento((int)movimientosASumar );
		
	}
	
	@Override
	public void realizarEfecto(Moto moto, Vehiculo vehiculo) {
		
		this.sumarMovimientos(vehiculo);

	}

	@Override
	public void realizarEfecto(Auto auto, Vehiculo vehiculo) {

		this.sumarMovimientos(vehiculo);

	}

	@Override
	public void realizarEfecto(CuatroPorCuatro cuatroPorCuatro, Vehiculo vehiculo) {
		
		this.sumarMovimientos(vehiculo);

	}


}
