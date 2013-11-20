package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Random;

import fiuba.algo3.modelo.excepciones.MovimientoInvalido;


public class Ciudad {
    private Calle[][] ciudad;
    private GPS gps;
    private Vehiculo vehiculo;
    private int dimension;

    public Ciudad(int dimension, Vehiculo vehiculo, GPS gps) {
        this.dimension = dimension * dimension;
        this.gps = gps;
        this.vehiculo = vehiculo;        
        this.cargarEscenario(dimension);	
    	this.establecerMetayVehiculo(vehiculo);
    }
    
    private void establecerMetayVehiculo(Vehiculo vehiculo) {
    	Posicion posicionMeta = this.posicionAleatoriaValida();
    	Calle calleMeta = this.calleEnUnaPosicion(posicionMeta);
    	calleMeta.inicializarCalle();
    	calleMeta.meta();
    	Posicion posicionVehiculo = this.posicionAleatoriaVehiculo(posicionMeta);
    	Calle calleVehiculo = this.calleEnUnaPosicion(posicionVehiculo);
    	calleVehiculo.inicializarCalle();
    	calleVehiculo.setVehiculo(vehiculo);
   	}

	private Posicion posicionAleatoriaVehiculo(Posicion posicionMeta) {
		Posicion posicionOpuestaALaMeta = new Posicion();
		posicionOpuestaALaMeta.setX((this.dimension - posicionMeta.getX()));
		posicionOpuestaALaMeta.setY((this.dimension - posicionMeta.getY()));
		return posicionOpuestaALaMeta;
	}

	private Posicion posicionAleatoriaValida() {
    	//Genera una posición aleatoria para ubicar la meta
    	Random rnd = new Random(); 

    	Posicion posicionAleatoriaValida = new Posicion();
    	int fila = (int)(rnd.nextDouble() * dimension + 0);
    	if ((fila%2) == 0)
    		fila = fila + 1;
    	posicionAleatoriaValida.setX(fila);
    	
    	int columna = (int)(rnd.nextDouble() * dimension + 0);
    	if ((columna%2) == 0)
    		columna = columna + 1;
    	posicionAleatoriaValida.setY(columna);
    	return posicionAleatoriaValida;
	}

	private void cargarEscenario(int dimension){
        
        this.ciudad = new Calle[dimension][dimension];
        for (int i = 0; i<(dimension-1); i++){
            
            if((i%2) == 0){ //fila pares
                for (int j = 0; j<(dimension-1); j++){
                    if ((j%2) == 0)
                        this.ciudad[i][j] = new Calle(false);
                    else
                        this.ciudad[i][j] = new Calle();
                }
            }
            else{
                for (int j = 0; j<(dimension-1); j++){
                    if ((j%2) == 0)
                        this.ciudad[i][j] = new Calle();
                    else
                        this.ciudad[i][j] = new Calle(true);
                }
            }
        }        
    }
    
    public boolean esValidaLaPosicion(Posicion posicion) throws MovimientoInvalido{ 
    	Calle calleDondeQuieroMoverme = this.calleEnUnaPosicion(posicion);
    	if (calleDondeQuieroMoverme.esTransitable()){
    		this.colocarVehiculo(calleDondeQuieroMoverme);
                return true;
        }        
        else
    		throw new MovimientoInvalido();                       
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
}
