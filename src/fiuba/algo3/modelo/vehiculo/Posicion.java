package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.movimientos.Direccion;


public class Posicion {

	private int posicionX;
	private int posicionY;

	public void Posicion(){
		this.posicionX = 0;
		this.posicionY = 0;
	}

	public void setX( int numero ){

		this.posicionX = numero;        
	}


	public int getX(){

		return posicionX;
	}

	public void setY( int numero ) {

		this.posicionY = numero;
	}


	public int getY() {

		return posicionY;
	}

	public Posicion obtenerCopia() {

		Posicion posicion = new Posicion();
		posicion.posicionX = this.posicionX;
		posicion.posicionY = this.posicionY;
		return posicion;

	}

	public void moverX(Direccion direccion) {

		if(direccion == Direccion.DERECHA)
			this.posicionX++;
		if(direccion == Direccion.IZQUIERDA)
			this.posicionX--;
	}

	public void moverY(Direccion direccion) {

		if(direccion == Direccion.ABAJO)
			this.posicionY++;
		if(direccion == Direccion.ARRIBA)
			this.posicionY--;

	}


}
