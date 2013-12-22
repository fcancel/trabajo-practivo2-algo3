package fiuba.algo3.vista;

import ar.uba.fi.algo3.titiritero.vista.Imagen;
import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import res.ImageLoader;

public class VistaDeEfecto extends Imagen{
	
	private Efecto efecto;
	
	public VistaDeEfecto(Efecto efecto){
		this.efecto = efecto;
        
		ImageLoader setearEfecto = new ImageLoader();
                
		this.setNombreArchivoImagen(setearEfecto.imagenEfecto(efecto));
	}
	
}
