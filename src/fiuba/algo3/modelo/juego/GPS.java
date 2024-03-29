package fiuba.algo3.modelo.juego;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fiuba.algo3.modelo.dificultad.Dificultad;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;
import fiuba.algo3.modelo.interfazGrafica.PantallaJuegoTerminado;
import fiuba.algo3.modelo.mapa.Ciudad;
import fiuba.algo3.modelo.serializacion.SerializacionCiudad;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement

public class GPS {    

	private static int MOVIMIENTO_INICIAL = 0;
	private Dificultad dificultad;
	@XmlAttribute (name="juegoEnCurso")
	private boolean juegoEnCurso;
	private PuntuacionesAltas puntuacionesAltas;
	@XmlAttribute (name="movimientos")
	private int movimientos;
	private Vehiculo vehiculo;
	private Ciudad ciudad;
	private Jugador jugador;
	@XmlElement(name="nick")
	private String nick;
	private Puntuacion puntuacion;

	private void verificarJuegoIniciado() throws JuegoNoIniciado{

		if(!this.juegoEnCurso)
			throw new JuegoNoIniciado();
	}

	private void cargarPuntuaciones(){

		this.puntuacionesAltas = new PuntuacionesAltas();

	}

	public GPS(){

		this.movimientos = MOVIMIENTO_INICIAL;
		this.cargarPuntuaciones();
		this.juegoEnCurso = false;

	}

	public int getMovimientos(){

		return this.movimientos;

	}

	public Puntuacion getPuntuacion(){
		return this.puntuacion;
	}
	
	public void sumarMovimiento( int movimientoASumar ){

		this.movimientos += movimientoASumar;

	}

	public boolean juegoEnMarcha() {

		return this.juegoEnCurso;

	}

	public void terminarJuego() {

		int limiteDeMovimientos = this.dificultad.getMaximoDeMovimientos();
		int multipilcador = this.dificultad.getMultiplicador();

		int puntuacionTotal = (limiteDeMovimientos - this.movimientos)* multipilcador;
		this.puntuacion = new Puntuacion(this.nick,puntuacionTotal);
		this.puntuacionesAltas.setPuntuacion(puntuacion);
		this.puntuacionesAltas.persistir();
		this.ciudad = null;
		this.vehiculo = null;
		this.juegoEnCurso = false;
		this.movimientos = MOVIMIENTO_INICIAL;
		                
		PantallaJuegoTerminado pantallaJuegoTerminado = new PantallaJuegoTerminado(this.jugador, puntuacion);                

	}

	public Vehiculo getVehiculo() throws JuegoNoIniciado {

		this.verificarJuegoIniciado();

		return this.vehiculo;

	}

	public Ciudad getCiudad() throws JuegoNoIniciado{

		this.verificarJuegoIniciado();

		return this.ciudad;

	}

	public Puntuacion puntuacion(int posicion) throws NoExisteEsaPosicion {

		return this.puntuacionesAltas.getPuntuacion(posicion);

	}

	public void empezarJuego(EstadoVehiculo estadoInicial, Dificultad dificultad,Jugador jugador) throws JAXBException{


		this.jugador=jugador;
		this.dificultad = dificultad;
		this.nick = this.jugador.getNombre();
		this.inicializarJuego(estadoInicial,dificultad.getFilas(),dificultad.getColumnas());

	}

	private void inicializarJuego(EstadoVehiculo estadoInicial, int filas, int columnas) throws JAXBException {

		this.juegoEnCurso = true;
		this.vehiculo = new Vehiculo(estadoInicial);
		this.vehiculo.setGPS(this);
		String mapa = this.dificultad.getMapa();
		this.ciudad = new Ciudad(filas,columnas,this.vehiculo,this,mapa);
		this.vehiculo.setCiudad(this.ciudad);
	}

	public int getLimiteDeMovimientos() {

		return this.dificultad.getMaximoDeMovimientos();
	}
	
	public void guardarPartida() throws JAXBException{
		String nombreJugador= this.jugador.getNombre();
		SerializacionCiudad serealizador = new SerializacionCiudad();
		serealizador.serializar(this.ciudad,".\\partidas\\"+nombreJugador+".xml");
	}
	
	public void cargarPartida(String partidaGuardada) throws JAXBException{
		this.juegoEnCurso = true;
		SerializacionCiudad serealizador = new SerializacionCiudad();
		Ciudad ciudadCargada = serealizador.desSerealizar(partidaGuardada);
		this.vehiculo = ciudadCargada.getVehiculo();
		this.puntuacionesAltas = ciudadCargada.getGps().getPuntuacionesAltas();
		this.dificultad = ciudadCargada.getGps().getDificultad();
		this.jugador= ciudadCargada.getGps().getJugador();
		this.nick = this.jugador.getNombre();
		this.movimientos = ciudadCargada.getGps().getMovimientos();
		this.vehiculo.setGPS(this);
		this.ciudad = ciudadCargada;
		this.vehiculo.setCiudad(this.ciudad);
}

	@XmlElement(name="puntuacionesAltas")
	private PuntuacionesAltas getPuntuacionesAltas() {
		return this.puntuacionesAltas;
	}

	@XmlElement(name="dificultad")
	public Dificultad getDificultad() {
		return this.dificultad;
	}

	@XmlElement(name="jugador")
	public Jugador getJugador(){
		return this.jugador;
	}

	public void setDificultad(Dificultad dificultad){
		this.dificultad = dificultad;
	}

	public void setJugador(Jugador jugador){
		this.jugador = jugador;
	}
}
