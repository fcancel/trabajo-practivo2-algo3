package fiuba.algo3.modelo.efectosYSorpresas;

import javax.xml.bind.annotation.XmlElement;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Posicion;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Piquete implements Efecto {
	@XmlElement(name="posicion")
	private Posicion posicion;

	
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

	@Override
	public void setPosicion(Posicion posicion) {
		this.posicion= posicion;
	}

	@Override
	public int getX() {
		return ((this.posicion.getX())*500)/25;
	}

	@Override
	public int getY() {
		return ((this.posicion.getY())*500)/25;
	}
	
	
	
}
