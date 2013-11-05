package fiuba.algo3.ejemplo1;

import junit.framework.Assert;
import org.junit.Test;

public class testdos {

	@Test
	public void devolverUnDos(){
        Devolver variable = new Devolver();
        int resultado = variable.magia();
        Assert.assertEquals(2, resultado);

	}

}
