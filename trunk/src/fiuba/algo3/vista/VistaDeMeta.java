package fiuba.algo3.vista;

import fiuba.algo3.modelo.vehiculo.Posicion;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaDeMeta extends Imagen implements Posicionable{
	
	private Posicion posicion;
	
	public VistaDeMeta(){
		this.setNombreArchivoImagen("/res/meta.png");
	}

	public void getPosicion(Posicion posicion){
		this.posicion=posicion;
	}
	
	@Override
	public int getX() {
		return this.posicion.getX()*20;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.posicion.getY()*20;
	}
}
