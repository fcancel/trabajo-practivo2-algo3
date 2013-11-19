package fiuba.algo3.tests;

import fiuba.algo3.excepciones.JuegoNoIniciado;
import fiuba.algo3.excepciones.MovimientoInvalido;
import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.modelo.Auto;
import fiuba.algo3.modelo.CuatroPorCuatro;
import fiuba.algo3.modelo.EstadoVehiculo;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.Posicion;
import fiuba.algo3.modelo.Vehiculo;

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
    
    @Test
    public void testMuevoVehiculoHaciaArriba() throws JuegoNoIniciado, MovimientoInvalido{
        
        GPS gps = new GPS();
	gps.empezarJuego(new Auto(), 30, "Arriba");
        Vehiculo vehiculo = gps.getVehiculo();
        
        Posicion posicion = vehiculo.getPosicion();
        
        posicion.setY(11);
        posicion.setX(11);
        
        vehiculo.moverArriba();     
        
        Assert.assertEquals(9, vehiculo.getPosicion().getY());
    }
    
    @Test
    public void testMuevoVehiculoHaciaAbajo() throws JuegoNoIniciado, MovimientoInvalido{
       
        GPS gps = new GPS();
	gps.empezarJuego(new Auto(), 30, "Abajo");
        Vehiculo vehiculo = gps.getVehiculo();
        
        Posicion posicion = vehiculo.getPosicion();
        
        posicion.setY(11);
        posicion.setX(11);
        
        vehiculo.moverAbajo();     
        
        Assert.assertEquals(13, vehiculo.getPosicion().getY());
    }

   
    @Test
    public void testMuevoVehiculoHaciaLaDerecha() throws JuegoNoIniciado, MovimientoInvalido{
        
        GPS gps = new GPS();
	gps.empezarJuego(new Auto(), 30, "Derecha");
        Vehiculo vehiculo = gps.getVehiculo();
        
        Posicion posicion = vehiculo.getPosicion();
        
        posicion.setY(11);
        posicion.setX(10);
        
        vehiculo.moverDerecha();
        
        Assert.assertEquals(12, vehiculo.getPosicion().getX());
        
    }
    
    @Test
    public void testMuevoVehiculoHaciaLaIzquierda() throws JuegoNoIniciado, MovimientoInvalido{
        
        GPS gps = new GPS();
	gps.empezarJuego(new Auto(), 30, "Izquierda");
        Vehiculo vehiculo = gps.getVehiculo();
        
        Posicion posicion = vehiculo.getPosicion();
        
        posicion.setY(11);
        posicion.setX(10);
        
        vehiculo.moverIzquierda();
        
        Assert.assertEquals(8, vehiculo.getPosicion().getX());
       
    }
}
