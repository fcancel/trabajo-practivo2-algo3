package fiuba.algo3.modelo.efectosYSorpresas;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Posicion;
import fiuba.algo3.modelo.vehiculo.Vehiculo;
import res.ImageLoader;

public class SorpresaDesfavorable implements Efecto {
	
	@XmlElement(name="posicion")
	private Posicion posicion;
	@XmlAttribute(name="direccionDeImagen")
	private String direccionDeImagen;
        


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
            ImageLoader setearImagen = new ImageLoader();
            this.direccionDeImagen = setearImagen.imagenSorpresa();
            
            return this.direccionDeImagen;
	}

}
