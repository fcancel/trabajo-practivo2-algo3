package fiuba.algo3.modelo;

import java.util.Random;

import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;


public class Ciudad {
    private Calle[][] ciudad;
    private GPS gps;
    private Vehiculo vehiculo;
    private int dimension;
    private Posicion posicionMeta;
    
    public Ciudad(int dimension, Vehiculo vehiculo, GPS gps) {
        this.dimension = dimension;
        this.gps = gps;
        this.vehiculo = vehiculo;        
        this.cargarEscenario(dimension);	
    	this.establecerMetayVehiculo(vehiculo, dimension);
    }
    
    private void establecerMetayVehiculo(Vehiculo vehiculo, int dimension) {
    	// el 1 para que este en la segunda columna
    	Posicion posicionVehiculo = this.posicionValida(1);
    	Calle calleVehiculo = this.calleEnUnaPosicion(posicionVehiculo);
    	// le asigno la posicion al vehiculo
    	vehiculo.setPosicion(posicionVehiculo);
    	calleVehiculo.setVehiculo(vehiculo);
    	// el dimension-1 para que este en la ultima columna
    	posicionMeta = this.posicionValida(this.dimension-1);
    	Calle calleMeta = this.calleEnUnaPosicion(posicionMeta);
    	calleMeta.inicializarCalle();
    	calleMeta.meta();
    }

	private Posicion posicionValida(int coordenadaX) {
		
		// la primer posicion del vehiculo es (1, (this.dimension-1)/2(impar) )
		// la meta es (this.dimension-1 ,(this.dimension-1)/2(impar) )
		int x=coordenadaX;
		int y= (int)(this.dimension-1)/2;
		if(y%2 == 0){
			y--;
		}
		Posicion posicion = new Posicion();
		posicion.setX(x);
		posicion.setY(y);
		
		return posicion;
    	
	}

	private void cargarEscenario(int dimension){
        
        this.ciudad = new Calle[dimension][dimension];
        for (int i = 0; i<(dimension); i++){
            
            if((i%2) == 0){ //fila pares
                for (int j = 0; j<(dimension); j++){
                    if ((j%2) == 0)
                        this.ciudad[i][j] = new Calle(false);
                    else
                        this.ciudad[i][j] = new Calle();
                }
            }
            else{
            	for (int j = 0; j<(dimension); j++){
                    if ((j%2) == 0)
                        this.ciudad[i][j] = new Calle();
                    else
                    	//Para que sea una esquina, sin obstaculos y sorpresas
                        this.ciudad[i][j] = new Calle(true);
                }
            }
        }        
    }
    
    public boolean esValidaLaPosicion(Posicion posicion) throws MovimientoInvalido{ 
    	Calle calleDondeQuieroMoverme = this.calleEnUnaPosicion(posicion);
    	
    	if (calleDondeQuieroMoverme.esTransitable()){
    		
    		return true;
    		
        }        
        else{
        	
        	throw new MovimientoInvalido();
        	
        }
                          
    }
    
	public Calle calleEnUnaPosicion(Posicion posicion) {
		return this.ciudad[posicion.getX()][posicion.getY()];
	}
	
	private void colocarVehiculo(Calle calle) {
		calle.setVehiculo(this.vehiculo);
	}
	
	public int getDimension(){
		return dimension;
	}
	
	public Calle[][] getCiudad(){
		return ciudad;
	}

	public Posicion posicionDeMeta() {
		
		return this.posicionMeta;
		
	}

	public void colocarVehiculo(Posicion dondeQuieroIr) throws JuegoFinalizado {

		if(!gps.juegoEnMarcha())
			throw new JuegoFinalizado();
		
		Calle calleDondeQuieroMoverme = this.calleEnUnaPosicion(dondeQuieroIr);
		this.colocarVehiculo(calleDondeQuieroMoverme);
		
		if(calleDondeQuieroMoverme.sosMeta()){
			this.gps.terminarJuego();
		}
		
	}
	
	public void eliminarObstaculosYSorpresas(){
		 for (int i = 0; i<(dimension); i++){
			 for (int j = 0; j<(dimension); j++){
				 this.ciudad[i][j].inicializarCalle();
			 }
		 }
	}

}
