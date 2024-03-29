package fiuba.algo3.tests;

import javax.xml.bind.JAXBException;

import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import fiuba.algo3.modelo.efectosYSorpresas.Pozo;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;
import junit.framework.Assert;

import org.junit.Test;


public class TestPozo {
    
    @Test
    public void testAlCaerUnaMotoEnUnPozoSusMovimientosSonIncrementadosEnTres() throws JuegoNoIniciado, JAXBException {
        
        GPS gps = new GPS();
        Jugador jugador = new Jugador("ArmandoBarreda");
        gps.empezarJuego(new Moto(), new Facil(),jugador);
        Vehiculo moto = gps.getVehiculo();
        Efecto pozo = new Pozo();        
               
        moto.aceptarEfecto(pozo);
        
        Assert.assertEquals(3, gps.getMovimientos());
	
	      
   }
    
    @Test
    public void testAlCaerUnAutoEnUnPozoSusMovimientosSonIncrementadosEnTres() throws JuegoNoIniciado, JAXBException {
        
        GPS gps = new GPS();
        Jugador jugador = new Jugador("Schwarzenegger");
        gps.empezarJuego(new Auto(), new Facil(),jugador);
        Vehiculo auto = gps.getVehiculo();
        Efecto pozo = new Pozo();
        
        auto.aceptarEfecto(pozo);
        
        Assert.assertEquals(3, gps.getMovimientos());
               
        
    }
    
    @Test
    public void testAlCaerUnaCuatroPorCuatroEnUnPozoSusMovimientosNoSonAfectados() throws JuegoNoIniciado, JAXBException {
        
        GPS gps = new GPS();
        Jugador jugador = new Jugador("Rojo");
        gps.empezarJuego(new CuatroPorCuatro(), new Facil(),jugador);
        Vehiculo cuatroPorCuatro = gps.getVehiculo();
        Efecto pozo = new Pozo();
        
        cuatroPorCuatro.aceptarEfecto(pozo);
        
        Assert.assertEquals(0, gps.getMovimientos());
    }
}
