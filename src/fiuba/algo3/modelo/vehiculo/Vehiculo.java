package fiuba.algo3.modelo.vehiculo;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ar.uba.fi.algo3.titiritero.Posicionable;
import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.mapa.Ciudad;
import fiuba.algo3.modelo.movimientos.Abajo;
import fiuba.algo3.modelo.movimientos.Arriba;
import fiuba.algo3.modelo.movimientos.Derecha;
import fiuba.algo3.modelo.movimientos.Direccion;
import fiuba.algo3.modelo.movimientos.Izquierda;
import fiuba.algo3.modelo.movimientos.Retroceder;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Vehiculo implements Posicionable {

	@XmlElement(name="posicion")
	private Posicion posicion;
	@XmlElement(name="estadoVehiculo")
	private EstadoVehiculo estado;
	private GPS GPS;
	@XmlElement(name="retroceder")
	private Retroceder retroceder;
	private Ciudad ciudad;
	@XmlElement(name="direccion")
	private Direccion direccion;

	
	public Vehiculo() {
	}
	
	public Vehiculo(EstadoVehiculo estadoASetear) {
		this.estado = estadoASetear;
		this.posicion = new Posicion();
		this.retroceder = new Retroceder();
		this.direccion = Direccion.DERECHA;
	}


	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicionASetear) {
		this.posicion = posicionASetear;
	}

	public void cambiarDeEstado(EstadoVehiculo estadoASetear) {
		this.estado = estadoASetear;
	}

	public void setCiudad(Ciudad ciudad) {

		this.ciudad = ciudad;

	}

	public EstadoVehiculo estadoActual() {
		return this.estado;
	}

	public void sumarMovimiento( int numeroASumar ){
		GPS Gps = getGPS();

		Gps.sumarMovimiento(numeroASumar);
	}

	private GPS getGPS(){
		return this.GPS;
	}

	public void setGPS(GPS gps){        
		this.GPS = gps;
	}

	public void aceptarEfecto(Efecto efecto){

		this.estado.aceptarEfecto(this,efecto);

	}

	public int movimientos(){

		return this.GPS.getMovimientos();

	}

	//ACLARACION 
	//X EJE HORIZONTAL
	//Y EJE VERTICAL

	public void moverArriba() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{

		this.retroceder.getUltimaAccion(new Arriba(this));
		this.direccion = Direccion.ARRIBA;
		
		this.moverme();

	}



	public void moverAbajo() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{

		this.retroceder.getUltimaAccion(new Abajo(this));
		this.direccion = Direccion.ABAJO;
		
		this.moverme();

	}

	public void moverDerecha() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{

		this.retroceder.getUltimaAccion(new Derecha(this));
		this.direccion = Direccion.DERECHA;

		this.moverme();

	}

	public void moverIzquierda() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{

		this.retroceder.getUltimaAccion(new Izquierda(this));
		this.direccion = Direccion.IZQUIERDA;
		
		this.moverme();

	}

	private void moverme() throws MovimientoInvalido, JuegoFinalizado{

		Posicion dondeQuieroIr= this.posicion.obtenerCopia();
		dondeQuieroIr.moverX(direccion);
		dondeQuieroIr.moverY(direccion);

		if(ciudad.esValidaLaPosicion(dondeQuieroIr)){
			ciudad.colocarVehiculo(dondeQuieroIr);
			this.posicion = dondeQuieroIr;
		}

	}

	public EstadoVehiculo getEstado(){
		return this.estado;
	}

	public void retroceder(){

		try{

			this.retroceder.realizar();

		}catch (JuegoNoIniciado | MovimientoInvalido | JuegoFinalizado e) {}

	}


	@Override
	public int getX() {	
		//return ((this.posicion.getX()*500)/25);
		return (this.posicion.getX()*20+12);
	}


	@Override
	public int getY() {
		//return ((this.posicion.getY()*500)/25);
		return (this.posicion.getY()*20+12);
	}

	public Direccion getDireccion(){
		return this.direccion;
	}
	
}
