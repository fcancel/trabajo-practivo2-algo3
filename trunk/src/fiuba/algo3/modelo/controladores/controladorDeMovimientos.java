package fiuba.algo3.modelo.controladores;

import java.util.Observable;
import java.util.Observer;

import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Vehiculo;

public class controladorDeMovimientos implements Observer {

	private Vehiculo vehiculo;
	private Posicion ultimaPosicion;
	
	public controladorDeMovimientos(Vehiculo vehiculo){
		this.vehiculo = vehiculo;
		this.vehiculo.addObserver(this);
		this.ultimaPosicion = vehiculo.getPosicion().obtenerCopia();
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		
		Posicion posicionActual = this.vehiculo.getPosicion();
		
		if(posicionActual.getX() < this.ultimaPosicion.getX()){
			//Avisar a vista que el vehiculo se movio a la izquierda
		}
		if(posicionActual.getX() > this.ultimaPosicion.getX()){
			//Avisar a vista que el vehiculo se movio a la derecha
		}
		if(posicionActual.getY() < this.ultimaPosicion.getY()){
			//Avisar a vista que el vehiculo se movio a abajo
		}
		if(posicionActual.getY() > this.ultimaPosicion.getY()){
			//Avisar a vista que el vehiculo se movio a arriba
		}
		
		this.ultimaPosicion = posicionActual.obtenerCopia();
	}
	
}