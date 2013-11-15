package posicion;

import junit.framework.Assert;
import org.junit.Test;

public class TestLaPosicionesFuncionanComoCorresponden {
    
    @Test
    public void TestLaPosicionXFuncionaComoCorresponde(){
    
        Posicion posicion = new Posicion();
    
        posicion.setX(10);
        int resultado = posicion.getX();
    
        Assert.assertEquals(10, resultado);
    }
    
    @Test
    public void TestLaPosicionYFuncionaComoCorresponde(){
        
        Posicion posicion = new Posicion();
        
        posicion.setY(7);
        int resultado = posicion.getY();
        
        Assert.assertEquals(7, resultado);
    }
}
