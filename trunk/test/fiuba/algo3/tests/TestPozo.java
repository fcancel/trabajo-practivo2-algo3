package fiuba.algo3.tests;

import fiuba.algo3.modelo.Auto;
import fiuba.algo3.modelo.CuatroPorCuatro;
import fiuba.algo3.modelo.Efecto;
import fiuba.algo3.modelo.Facil;
import fiuba.algo3.modelo.GPS;
import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Pozo;
import fiuba.algo3.modelo.Moto;
import fiuba.algo3.modelo.Vehiculo;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import junit.framework.Assert;

import org.junit.Test;


public class TestPozo {
    
    @Test
    public void testAlCaerUnaMotoEnUnPozoSusMovimientosSonIncrementadosEnTres() throws JuegoNoIniciado {
        
        GPS gps = new GPS();
        Jugador jugador = new Jugador("ArmandoBarreda");
        gps.empezarJuego(new Moto(), new Facil(),jugador);
        Vehiculo moto = gps.getVehiculo();
        Efecto pozo = new Pozo();        
               
        moto.aceptarEfecto(pozo);
        
        Assert.assertEquals(3, gps.getMovimientos());
	
	      
   }
    
    @Test
    public void testAlCaerUnAutoEnUnPozoSusMovimientosSonIncrementadosEnTres() throws JuegoNoIniciado {
        
        GPS gps = new GPS();
        Jugador jugador = new Jugador("Schwarzenegger");
        gps.empezarJuego(new Auto(), new Facil(),jugador);
        Vehiculo auto = gps.getVehiculo();
        Efecto pozo = new Pozo();
        
        auto.aceptarEfecto(pozo);
        
        Assert.assertEquals(3, gps.getMovimientos());
               
        
    }
    
    @Test
    public void testAlCaerUnaCuatroPorCuatroEnUnPozoSusMovimientosNoSonAfectados() throws JuegoNoIniciado {
        
        GPS gps = new GPS();
        Jugador jugador = new Jugador("Rojo");
        gps.empezarJuego(new CuatroPorCuatro(), new Facil(),jugador);
        Vehiculo cuatroPorCuatro = gps.getVehiculo();
        Efecto pozo = new Pozo();
        
        cuatroPorCuatro.aceptarEfecto(pozo);
        
        Assert.assertEquals(0, gps.getMovimientos());
    }
}
