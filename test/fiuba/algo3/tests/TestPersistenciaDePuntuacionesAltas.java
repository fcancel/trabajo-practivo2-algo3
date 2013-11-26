package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Puntuacion;
import fiuba.algo3.modelo.PuntuacionesAltas;
import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;

public class TestPersistenciaDePuntuacionesAltas {

	@Test
	public void alPersistirUnaPuntuacionYRecuperarlaDebeSerCorrecta() throws NoExisteEsaPosicion {

		eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
		
		Puntuacion puntuacion = new Puntuacion("juan",20);
		PuntuacionesAltas puntuacionesAPersistir = new PuntuacionesAltas();
		
		puntuacionesAPersistir.setPuntuacion(puntuacion);

		
		String archivo = "puntuaciones\\puntuacionesAltas.dat";
		puntuacionesAPersistir.persistir(archivo);
		
		PuntuacionesAltas puntuacionesARecuperar = PuntuacionesAltas.recuperar(archivo);
		
		Puntuacion puntuacionAltaRecuperada = puntuacionesARecuperar.getPuntuacion(1);
		
		assertEquals(puntuacionAltaRecuperada.getNick(),"juan");
		assertEquals(puntuacionAltaRecuperada.getPuntos(),20);
		
		eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
		
	}
	
	@Test
	public void alPersistirDosPuntuacionesYRecuperarlasDebenSerCorrectas() throws NoExisteEsaPosicion {

		eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
		
		Puntuacion puntuacionBaja = new Puntuacion("juan",10);
		Puntuacion puntuacionAlta = new Puntuacion("Pedro",50);
		PuntuacionesAltas puntuacionesAPersistir = new PuntuacionesAltas();
		
		puntuacionesAPersistir.setPuntuacion(puntuacionBaja);
		puntuacionesAPersistir.setPuntuacion(puntuacionAlta);
		
		String archivo = "puntuaciones\\puntuacionesAltas.dat";
		puntuacionesAPersistir.persistir(archivo);
		
		PuntuacionesAltas puntuacionesARecuperar = PuntuacionesAltas.recuperar(archivo);
		
		Puntuacion puntuacionAltaRecuperada = puntuacionesARecuperar.getPuntuacion(1);
		Puntuacion puntuacionBajaRecuperada = puntuacionesARecuperar.getPuntuacion(2);
		
		assertEquals(puntuacionAltaRecuperada.getNick(),"Pedro");
		assertEquals(puntuacionAltaRecuperada.getPuntos(),50);
		assertEquals(puntuacionBajaRecuperada.getNick(),"juan");
		assertEquals(puntuacionBajaRecuperada.getPuntos(),10);
		
		eliminarArchivosDePruebas.eliminar("puntuaciones\\puntuacionesAltas.dat");
		
	}


}
