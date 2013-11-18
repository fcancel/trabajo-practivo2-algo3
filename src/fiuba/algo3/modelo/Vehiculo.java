package fiuba.algo3.modelo;



public class Vehiculo {
    
    private Posicion posicion;
    private EstadoVehiculo estado;
    private GPS GPS;

    public Vehiculo(EstadoVehiculo estadoASetear) {
        this.estado = estadoASetear;
        this.posicion = new Posicion();        
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
    
    public void moverArriba(){
        
        this.posicion.setY((this.posicion.getY()) - 2);
    }
    
    public void moverAbajo(){
        
        this.posicion.setY((this.posicion.getY()) + 2);
    }
    
    public void moverDerecha(){
        
        this.posicion.setX((this.posicion.getX()) + 2);     
    }
    
    public void moverIzquierda(){
        
        this.posicion.setX((this.posicion.getX()) - 2);
    }
}
