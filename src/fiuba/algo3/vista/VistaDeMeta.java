package fiuba.algo3.vista;

import fiuba.algo3.modelo.vehiculo.Posicion;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;
import res.ImageLoader;

public class VistaDeMeta extends Imagen implements Posicionable{
	
	private Posicion posicion;
	
	public VistaDeMeta(){
                ImageLoader setearImagen = new ImageLoader();
		this.setNombreArchivoImagen(setearImagen.imagenMeta());
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
		return this.posicion.getY()*20;
	}
}
