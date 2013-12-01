package fiuba.algo3.tests;

import java.io.File;
import junit.framework.Assert;
import org.junit.Test;


public class eliminarArchivosDePruebas {

	public static void eliminar(String archivo){
		
    	File fichero = new File(archivo);
		fichero.delete();
	
	}

        @Test
        public void testTrue() {
		
		Assert.assertTrue(true);
}
}