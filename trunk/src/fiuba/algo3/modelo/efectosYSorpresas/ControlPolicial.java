package fiuba.algo3.modelo.efectosYSorpresas;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Posicion;
import fiuba.algo3.modelo.vehiculo.Vehiculo;
import res.ImageLoader;

public class ControlPolicial implements Efecto {

	@XmlElement(name="probabilidad")
	private Probabilidad probabilidad;
	@XmlElement(name="posicion")
	private Posicion posicion;
	@XmlAttribute(name="direccionDeImagen")
	private String direccionDeImagen;
	
	public ControlPolicial(){
            ImageLoader setearImagen = new ImageLoader();
            this.direccionDeImagen = setearImagen.imagenPolicia();
	}
	
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
