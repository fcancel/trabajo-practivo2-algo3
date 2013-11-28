package fiuba.algo3.tests;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Posicion;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

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
    public void testMuevoVehiculoHaciaArriba() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
        
        GPS gps = new GPS();
        Jugador jugador = new Jugador("Arriba");
        gps.empezarJuego(new Moto(), new Facil(),jugador);
        Vehiculo vehiculo = gps.getVehiculo();
        
        Posicion posicion = vehiculo.getPosicion();
        
        posicion.setY(3);
        posicion.setX(3);
        
        vehiculo.moverArriba();     
        
        Assert.assertEquals(2, vehiculo.getPosicion().getY());
    }
    
    @Test
    public void testMuevoVehiculoHaciaAbajo() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
       
        GPS gps = new GPS();
        Jugador jugador = new Jugador("Abajo");
        gps.empezarJuego(new Moto(), new Facil(),jugador);
        Vehiculo vehiculo = gps.getVehiculo();
        
        Posicion posicion = vehiculo.getPosicion();
        
        posicion.setY(3);
        posicion.setX(3);
        
        vehiculo.moverAbajo();     
        
        Assert.assertEquals(4, vehiculo.getPosicion().getY());
    }

   
    @Test
    public void testMuevoVehiculoHaciaLaDerecha() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
        
        GPS gps = new GPS();
        Jugador jugador = new Jugador("Derecha");
        gps.empezarJuego(new Moto(), new Facil(),jugador);
        Vehiculo vehiculo = gps.getVehiculo();
        
        Posicion posicion = vehiculo.getPosicion();
        
        posicion.setY(3);
        posicion.setX(3);
        
        vehiculo.moverDerecha();
        
        Assert.assertEquals(4, vehiculo.getPosicion().getX());
        
    }
    
    @Test
    public void testMuevoVehiculoHaciaLaIzquierda() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
        
        GPS gps = new GPS();
        Jugador jugador = new Jugador("Izquierda");
        gps.empezarJuego(new Moto(), new Facil(),jugador);
        Vehiculo vehiculo = gps.getVehiculo();
        
        Posicion posicion = vehiculo.getPosicion();
        
        posicion.setY(3);
        posicion.setX(3);
        
        vehiculo.moverIzquierda();
        
        Assert.assertEquals(2, vehiculo.getPosicion().getX());
       
    }
}
