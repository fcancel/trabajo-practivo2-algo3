package fiuba.algo3.vista;

import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaDeCiudad  extends Imagen implements Posicionable{
	
	public VistaDeCiudad(){
		this.setNombreArchivoImagen("/res/Ciudad.png");
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
