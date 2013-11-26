package fiuba.algo3.tests;

import java.io.File;

public class eliminarArchivosDePruebas {

	public static void eliminar(String archivo){
		
    	File fichero = new File(archivo);
		fichero.delete();
		
	}
	
}
