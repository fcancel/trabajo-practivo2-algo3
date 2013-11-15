package vehiculo;

import junit.framework.Assert;
import org.junit.Test;
import posicion.Posicion;
import vehiculo.estadoVehiculo.EstadoVehiculo;
import vehiculo.estadoVehiculo.auto.Auto;
import vehiculo.estadoVehiculo.cuatroPorCuatro.CuatroPorCuatro;
import vehiculo.estadoVehiculo.moto.Moto;

public class TestLasFuncionesDelVehiculo {
    
    @Test
    public void testLaClaseVehiculoSeCreaConUnEstadoValido(){
        EstadoVehiculo estado = new CuatroPorCuatro();
        Vehiculo vehiculo = new Vehiculo(estado);
        
        Assert.assertEquals(estado, vehiculo.estadoActual());
    }
    
    @Test
    public void testLasFuncionesSetYGetPosicionDeVehiculoFuncionanCorrectamente(){
        EstadoVehiculo estado = new Moto();
        Vehiculo vehiculo = new Vehiculo(estado);
        Posicion posicionAProbar = new Posicion ();
        Posicion posicion = new Posicion();
        posicion.setX(10);
        posicion.setY(3);
        
        
        vehiculo.setPosicion(posicion);
        posicionAProbar = vehiculo.getPosicion();
        
        Assert.assertEquals(posicion, posicionAProbar);
        
    }
    
    
    @Test
    public void testCambioUnVehiculoDeEstadoAOtroEstado(){
        EstadoVehiculo estadoAuto = new Auto();
        Vehiculo vehiculo = new Vehiculo(estadoAuto);
        EstadoVehiculo estadoMoto = new Moto();
        
        vehiculo.cambiarDeEstado(estadoMoto);
        
        Assert.assertEquals(estadoMoto, vehiculo.estadoActual());
    }
}
