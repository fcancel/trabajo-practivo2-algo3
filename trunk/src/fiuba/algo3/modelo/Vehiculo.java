package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;



public class Vehiculo {
    
    private Posicion posicion;
    private EstadoVehiculo estado;
    private GPS GPS;
    private String ultimoMovimiento;

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
    
    public void moverArriba() throws JuegoNoIniciado, MovimientoInvalido{
        
    	this.ultimoMovimiento = "AR";
        Ciudad ciudad;
        Posicion dondeQuieroIr;
        
        ciudad = this.GPS.getCiudad();
        dondeQuieroIr = this.posicion;
        dondeQuieroIr.setY(dondeQuieroIr.getY() - 1);
        
        if(ciudad.esValidaLaPosicion2(dondeQuieroIr))
            this.posicion.setY(this.posicion.getY() - 1);   
       
    }
        
    
    
    public void moverAbajo() throws JuegoNoIniciado, MovimientoInvalido{
        
    	this.ultimoMovimiento = "AB";
        Ciudad ciudad;
        Posicion dondeQuieroIr;
        
        ciudad = this.GPS.getCiudad();
        dondeQuieroIr = this.posicion;
        dondeQuieroIr.setY(dondeQuieroIr.getY() + 1);
        
        if(ciudad.esValidaLaPosicion2(dondeQuieroIr))
            this.posicion.setY(this.posicion.getY() + 1);
 
    }
    
    public void moverDerecha() throws JuegoNoIniciado, MovimientoInvalido{
        
    	this.ultimoMovimiento = "DE";
        Ciudad ciudad;
        Posicion dondeQuieroIr;
        
        ciudad = this.GPS.getCiudad();
        dondeQuieroIr = this.posicion;
        dondeQuieroIr.setX(dondeQuieroIr.getX() + 1);
        
        if(ciudad.esValidaLaPosicion2(dondeQuieroIr))
            this.posicion.setX(this.posicion.getX() + 1);
    
    }
    
    public void moverIzquierda() throws JuegoNoIniciado, MovimientoInvalido{
        
    	this.ultimoMovimiento = "IZ";
        Ciudad ciudad;
        Posicion dondeQuieroIr;
        
        ciudad = this.GPS.getCiudad();
        dondeQuieroIr = this.posicion;
        dondeQuieroIr.setX(dondeQuieroIr.getX() - 1);
        
        if(ciudad.esValidaLaPosicion2(dondeQuieroIr))
            this.posicion.setX(this.posicion.getX() - 1);
        
    }
    
    public EstadoVehiculo getEstado(){
    	return this.estado;
    }
    
    public void retroceder(){
    	
    	try{
    		
    	switch(this.ultimoMovimiento)
    	{ 
    		case "AR": 
    			{ 			
						this.moverAbajo();
					
    			}
    		break;
    		case "AB": 
			{ 			
					this.moverArriba();
				
			}
		break;
    		case "IZ": 
			{ 			
					this.moverDerecha();
				
			}
		break;
    		case "DE": 
			{ 			
					this.moverIzquierda();
				
			}
		break;
    	}
    	
    	}catch (JuegoNoIniciado | MovimientoInvalido e) {}
    	
    }
    
}
