package fiuba.algo3.modelo.interfazGrafica;

import java.awt.Panel;
import java.util.Iterator;

import javax.xml.bind.JAXBException;

import fiuba.algo3.controlador.ControladorTeclado;
import fiuba.algo3.modelo.dificultad.Dificil;
import fiuba.algo3.modelo.dificultad.Dificultad;
import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.mapa.Ciudad;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Vehiculo;
import fiuba.algo3.vista.VistaDeCiudad;
import fiuba.algo3.vista.VistaDeEfecto;
import fiuba.algo3.vista.VistaDeVehiculo;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.KeyPressedController;


public class VistaJuego{

	private ControladorJuego controladorJuego = null;
	private GPS gps;
	private VistaDeVehiculo vistaDeVehiculo;
	
	public VistaJuego(SuperficieDeDibujo superficieDeDibujo) throws JuegoNoIniciado, JAXBException{
		
		//Creo el Controlador del juego y le seteo la superficie donde se mostraran los dibujables
		
		//new PantallaDeInicio().setVisible(true);
		
		gps = new GPS();
		
		
		//Habira que crar un menu que retorne el estado seleccionado
		//Como por Ej
		//EstadoVehiculo estadoDelVehiculo = IGObtenerEstado.estado();
		EstadoVehiculo estadoDelVehiculo = new Auto();
		
		
		//Habira que crar un menu que retorne el estado seleccionado
		//Como por Ej
		//Dificultad dificultad = IGObtenerDificultad.dificultad();
		Dificultad dificultad = new Dificil();
		
		gps.empezarJuego(estadoDelVehiculo, dificultad,new Jugador("tomas"));
		Vehiculo auto = gps.getVehiculo();
		
		ControladorTeclado CT = new ControladorTeclado(auto);
		
		controladorJuego = new ControladorJuego(true);
		controladorJuego.setSuperficieDeDibujo(superficieDeDibujo);

		
		vistaDeVehiculo = new VistaDeVehiculo();
		vistaDeVehiculo.agregarVehiculo(auto);
		vistaDeVehiculo.setPosicionable(auto);
		
		VistaDeCiudad vistaDeCiudad = new VistaDeCiudad(); 
		vistaDeCiudad.setPosicionable(vistaDeCiudad);
		
		controladorJuego.agregarDibujable(vistaDeCiudad);
		//this.agregarVistaDeEfectos(gps.getCiudad());
		controladorJuego.setCiudad(gps.getCiudad());
		controladorJuego.agregarDibujable(vistaDeVehiculo);
		controladorJuego.agregarKeyPressObservador(CT);

		controladorJuego.setIntervaloSimulacion(15);
		
	}
	
	/*private void agregarVistaDeEfectos(Ciudad ciudad) {
		Iterator<Efecto> iEfecto = ciudad.listaDeEfectos();
		int i= 1;
		while(iEfecto.hasNext()){
			Efecto efecto = iEfecto.next();
			VistaDeEfecto vistaDeEfecto = new VistaDeEfecto(efecto);
			vistaDeEfecto.setPosicionable(efecto);
			this.controladorJuego.agregarDibujable(vistaDeEfecto);
		}
	}*/

	public void comenzar(){
		controladorJuego.comenzarJuegoAsyn();	
	}
	
	/*public void detener() {
		controladorJuego.detenerJuego();
	}
	
	
	public void pausar() {
		controladorJuego.detenerJuego();
		
	}

	public void continuarJuego() {
		controladorJuego.comenzarJuego();
		
	}*/

	
	public void agregarControladorDelTeclado(Panel unPanel){
		unPanel.addKeyListener(new KeyPressedController(this.controladorJuego));
	}
}
