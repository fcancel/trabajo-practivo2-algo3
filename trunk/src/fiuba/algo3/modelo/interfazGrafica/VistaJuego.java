package fiuba.algo3.modelo.interfazGrafica;

import java.awt.Panel;
import java.util.Iterator;

import javax.xml.bind.JAXBException;

import fiuba.algo3.controlador.ContadorDeCantidadDeMovimientos;
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
import fiuba.algo3.vista.VistaDeMeta;
import fiuba.algo3.vista.VistaDeVehiculo;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.KeyPressedController;
import fiuba.algo3.modelo.vehiculo.Moto;


public class VistaJuego implements ObjetoVivo{

	private ControladorJuego controladorJuego = null;
	private GPS gps;
	private VistaDeVehiculo vistaDeVehiculo;
        //private PantallaDelJuego pantallita;
	private ContadorDeCantidadDeMovimientos observador;
	private int cantidadDeMovientos=0;
	private int maximoDeMovimientos;
	private boolean marcadoElMaximo = false;
	
	public VistaJuego(SuperficieDeDibujo superficieDeDibujo, EstadoVehiculo vehiculoRecibido, Dificultad dificultadRecibida, Jugador jugadorRecibido) throws JuegoNoIniciado, JAXBException{
		
	
		gps = new GPS();
		
		gps.empezarJuego(vehiculoRecibido, dificultadRecibida, jugadorRecibido);
		//gps.empezarJuego(vehiculoRecibido, dificultadRecibida, jugadorRecibido, this);
		Vehiculo vehiculo = gps.getVehiculo();
		
		this.maximoDeMovimientos= dificultadRecibida.getMaximoDeMovimientos();
		ControladorTeclado CT = new ControladorTeclado(vehiculo);
		
		controladorJuego = new ControladorJuego(true);
		controladorJuego.setSuperficieDeDibujo(superficieDeDibujo);

		
		vistaDeVehiculo = new VistaDeVehiculo();
		vistaDeVehiculo.agregarVehiculo(vehiculo);
		vistaDeVehiculo.setPosicionable(vehiculo);
		
		VistaDeCiudad vistaDeCiudad = new VistaDeCiudad(); 
		vistaDeCiudad.setPosicionable(vistaDeCiudad);
		
		VistaDeMeta vistaDeMeta= new VistaDeMeta();
		vistaDeMeta.getPosicion(gps.getCiudad().getPosicionMeta());
		vistaDeMeta.setPosicionable(vistaDeMeta);
		
		controladorJuego.agregarDibujable(vistaDeCiudad);
		//this.agregarVistaDeEfectos(gps.getCiudad());
		controladorJuego.setCiudad(gps.getCiudad());
		controladorJuego.agregarDibujable(vistaDeMeta);
		controladorJuego.agregarDibujable(vistaDeVehiculo);
		controladorJuego.agregarKeyPressObservador(CT);
		this.controladorJuego.agregarObjetoVivo(this);
		
		controladorJuego.setIntervaloSimulacion(15);
		
	}

	public void comenzar(){
		controladorJuego.comenzarJuegoAsyn();	
	}
	
	/*public void detener() {
            
                this.dejarDeMostrar();
		controladorJuego.detenerJuego();                
	}*/
        
        /*private void dejarDeMostrar(){
            this.pantallita.setVisible(false);
        }*/
	
	/*
	public void pausar() {
		controladorJuego.detenerJuego();
		
	}

	public void continuarJuego() {
		controladorJuego.comenzarJuego();
		
	}*/

	
	public void agregarControladorDelTeclado(Panel unPanel){
		unPanel.addKeyListener(new KeyPressedController(this.controladorJuego));
	}

	public void agregarObservadorDeMovimientos(PantallaDelJuego pantallaDelJuego) {
		this.observador=pantallaDelJuego;
                //this.pantallita = pantallaDelJuego;
	}

	@Override
	public void vivir() {
		int movimientos = gps.getMovimientos();
		if(this.cantidadDeMovientos != movimientos){
			this.cantidadDeMovientos = movimientos;
			this.observador.seActualizaronLosMovimientos(movimientos);
		}
		if(!this.marcadoElMaximo){
			this.marcadoElMaximo= true;
			this.observador.maximoDeMovimientos(this.maximoDeMovimientos);
		}
	}
        
        
}
