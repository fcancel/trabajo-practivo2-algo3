package fiuba.algo3.tests;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.modelo.vehiculo.Posicion;

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
