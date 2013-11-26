package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;



public class Vehiculo {
    
    private Posicion posicion;
    private EstadoVehiculo estado;
    private GPS GPS;
    private Retroceder retroceder;
	private Ciudad ciudad;

    public Vehiculo(EstadoVehiculo estadoASetear) {
        this.estado = estadoASetear;
        this.posicion = new Posicion();
        this.retroceder = new Retroceder();
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
    //ACLARACION ACA NO TENDRIA QUE LLEGAR NINGUN MOVIMIENTO INVALIDO
    //SE DEBERIA CHECKEAR EN CIUDAD CON ES VALIDA LA POSICION
    //SEGUNDA ACLARACION SE TOMA AL MAPA CON LAS CALLES POR ESO SUMO DOS, PARA TERMINAR EN LA ESQUINA
    //X EJE HORIZONTAL
    //Y EJE VERTICAL
    
    public void moverArriba() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
        
    	this.retroceder.getUltimaAccion(new Arriba(this));
    	
        Posicion dondeQuieroIr;
        
        dondeQuieroIr = this.posicion;
        dondeQuieroIr.setY(dondeQuieroIr.getY() - 1);
        
        if(ciudad.esValidaLaPosicion(dondeQuieroIr)){
        	ciudad.colocarVehiculo(dondeQuieroIr);
        }  
       
    }
        
    
    
    public void moverAbajo() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
        
    	this.retroceder.getUltimaAccion(new Abajo(this));

        Posicion dondeQuieroIr;
        

        dondeQuieroIr = this.posicion;
        dondeQuieroIr.setY(dondeQuieroIr.getY() + 1);
        
        
        if(ciudad.esValidaLaPosicion(dondeQuieroIr)){
        	ciudad.colocarVehiculo(dondeQuieroIr);
        }

 
    }
    
    public void moverDerecha() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
        
    	this.retroceder.getUltimaAccion(new Derecha(this));

        Posicion dondeQuieroIr;
        

        dondeQuieroIr = this.posicion;
        dondeQuieroIr.setX(dondeQuieroIr.getX() + 1);
        
        if(ciudad.esValidaLaPosicion(dondeQuieroIr)){
        	ciudad.colocarVehiculo(dondeQuieroIr);
        }
        

    
    }
    
    public void moverIzquierda() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
        
    	this.retroceder.getUltimaAccion(new Izquierda(this));

        Posicion dondeQuieroIr;
        

        dondeQuieroIr = this.posicion;
        dondeQuieroIr.setX(dondeQuieroIr.getX() - 1);
        
        if(ciudad.esValidaLaPosicion(dondeQuieroIr)){
        	ciudad.colocarVehiculo(dondeQuieroIr);
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
    
}
