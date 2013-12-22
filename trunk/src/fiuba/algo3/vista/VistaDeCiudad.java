package fiuba.algo3.vista;

import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;
import res.ImageLoader;

public class VistaDeCiudad  extends Imagen implements Posicionable{
	
	public VistaDeCiudad(){
            ImageLoader setearImagen = new ImageLoader();
		this.setNombreArchivoImagen(setearImagen.imagenCiudad());
	}

	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}

}
