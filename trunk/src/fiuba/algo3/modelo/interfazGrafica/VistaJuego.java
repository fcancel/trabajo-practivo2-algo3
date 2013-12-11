package fiuba.algo3.modelo.interfazGrafica;

import java.awt.Panel;

import javax.xml.bind.JAXBException;

import fiuba.algo3.controlador.ContadorDeCantidadDeMovimientos;
import fiuba.algo3.controlador.ControladorTeclado;
import fiuba.algo3.modelo.dificultad.Dificultad;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Vehiculo;
import fiuba.algo3.vista.VistaCircuferenciaMeta;
import fiuba.algo3.vista.VistaCircuferenciaVehiculo;
import fiuba.algo3.vista.VistaDeCiudad;
import fiuba.algo3.vista.VistaDeMeta;
import fiuba.algo3.vista.VistaDeVehiculo;
import fiuba.algo3.vista.VistaFondo;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.KeyPressedController;


public class VistaJuego implements ObjetoVivo{

	private ControladorJuego controladorJuego = null;
	private GPS gps;
	private VistaDeVehiculo vistaDeVehiculo;
	private ContadorDeCantidadDeMovimientos observador;
	private int cantidadDeMovientos=0;
	private int maximoDeMovimientos;
	private boolean marcadoElMaximo = false;
	//private boolean yaEntre = false;
	
	public VistaJuego(SuperficieDeDibujo superficieDeDibujo, EstadoVehiculo vehiculoRecibido, Dificultad dificultadRecibida, Jugador jugadorRecibido) throws JuegoNoIniciado, JAXBException{
		
		
		gps = new GPS();
		
		gps.empezarJuego(vehiculoRecibido, dificultadRecibida, jugadorRecibido);
		Vehiculo vehiculo = gps.getVehiculo();
		
		this.maximoDeMovimientos= dificultadRecibida.getMaximoDeMovimientos();
		
		this.inicializar(vehiculo, superficieDeDibujo);
		
	}
	
	public VistaJuego(SuperficieDeDibujo superficieDeDibujo, GPS gps) throws JuegoNoIniciado, JAXBException{
		
		this.gps = gps;
		Vehiculo vehiculo = gps.getVehiculo();
		
		this.maximoDeMovimientos= gps.getDificultad().getMaximoDeMovimientos();
		
		this.inicializar(vehiculo, superficieDeDibujo);
		
	}

	private void inicializar(Vehiculo vehiculo,SuperficieDeDibujo superficieDeDibujo) throws JuegoNoIniciado{
		
		ControladorTeclado controladorTeclado = new ControladorTeclado(vehiculo);
		
		controladorJuego = new ControladorJuego(true);
		controladorJuego.setSuperficieDeDibujo(superficieDeDibujo);

		VistaFondo vistaFondo = new VistaFondo();
		vistaFondo.setPosicionable(vistaFondo);
		VistaCircuferenciaVehiculo vistaCircuferenciaVehiculo= new VistaCircuferenciaVehiculo();
		vistaCircuferenciaVehiculo.setPosicionable(vehiculo);
		
		vistaDeVehiculo = new VistaDeVehiculo();
		vistaDeVehiculo.agregarVehiculo(vehiculo);
		vistaDeVehiculo.setPosicionable(vehiculo);
		
		VistaDeCiudad vistaDeCiudad = new VistaDeCiudad(); 
		vistaDeCiudad.setPosicionable(vistaDeCiudad);
		
		VistaDeMeta vistaDeMeta= new VistaDeMeta();
		vistaDeMeta.getPosicion(gps.getCiudad().getPosicionMeta());
		vistaDeMeta.setPosicionable(vistaDeMeta);
		VistaCircuferenciaMeta vistaCircuferenciaMeta=new VistaCircuferenciaMeta();
		vistaCircuferenciaMeta.setPosicionable(vistaDeMeta);
		
		controladorJuego.agregarDibujable(vistaFondo);
		controladorJuego.agregarDibujable(vistaCircuferenciaVehiculo);
		controladorJuego.agregarDibujable(vistaCircuferenciaMeta);
		controladorJuego.agregarDibujable(vistaDeCiudad);
		controladorJuego.setCiudad(gps.getCiudad());
		controladorJuego.agregarDibujable(vistaDeMeta);
		controladorJuego.agregarDibujable(vistaDeVehiculo);
		controladorJuego.agregarKeyPressObservador(controladorTeclado);
		this.controladorJuego.agregarObjetoVivo(this);
		
		controladorJuego.setIntervaloSimulacion(15);
	}

	public void comenzar(){
		controladorJuego.comenzarJuegoAsyn();	
	}
	
	public void salvarPartida(){
		try {
			gps.guardarPartida();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarControladorDelTeclado(Panel unPanel){
		unPanel.addKeyListener(new KeyPressedController(this.controladorJuego));
	}

	public void agregarObservadorDeMovimientos(PantallaDelJuego pantallaDelJuego) {
		this.observador=pantallaDelJuego;
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
		/*if(!this.gps.juegoEnMarcha()&&!yaEntre){
			PantallaJuegoTerminado pantallaJuegoTerminado = new PantallaJuegoTerminado(this.gps.getJugador(), this.gps.getPuntuacion());
			this.yaEntre=true;
		}*/
	}
        
        
}
