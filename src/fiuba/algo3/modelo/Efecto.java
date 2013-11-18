package fiuba.algo3.modelo;

public interface Efecto {

	void realizarEfecto(Moto moto, Vehiculo vehiculo);

	void realizarEfecto(Auto auto, Vehiculo vehiculo);

	void realizarEfecto(CuatroPorCuatro cuatroPorCuatro, Vehiculo vehiculo);

}
