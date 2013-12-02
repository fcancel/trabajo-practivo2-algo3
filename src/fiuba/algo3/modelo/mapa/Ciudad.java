package fiuba.algo3.modelo.mapa;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.serializacion.SerializacionCiudad;
import fiuba.algo3.modelo.vehiculo.Posicion;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

@XmlRootElement
public class Ciudad {
	@XmlElement(name="calle")
	private Calle[][] ciudad;
	@XmlElement(name="GPS")
    private GPS gps;
	@XmlElement(name="vehiculo")
    private Vehiculo vehiculo;
    @XmlAttribute (name="filas")
    private int filas;
    @XmlAttribute (name="columnas")
    private int columnas;
    private Posicion posicionMeta;
    
    public Ciudad(){
    	
    }
    
    public Ciudad(int filas, int columnas , Vehiculo vehiculo, GPS gps) {
        this.columnas = columnas;
        this.filas = filas;
        this.gps = gps;
        this.vehiculo = vehiculo;        
        this.cargarEscenario(filas, columnas);	
    	this.establecerMetayVehiculo(vehiculo, filas, columnas);
    }
    
    public Ciudad cargarMapaDesdeXML(String archivoDeCarga) throws JAXBException{
    	SerializacionCiudad serializador = new SerializacionCiudad();
		String archivo = new String(archivoDeCarga);
		return serializador.desSerealizar(archivo);
    }
    
    private void establecerMetayVehiculo(Vehiculo vehiculo, int filas, int columnas) {
    	// el 1 para que este en la segunda columna
    	Posicion posicionVehiculo = this.posicionValida(1);
    	Calle calleVehiculo = this.calleEnUnaPosicion(posicionVehiculo);
    	// le asigno la posicion al vehiculo
    	vehiculo.setPosicion(posicionVehiculo);
    	calleVehiculo.setVehiculo(vehiculo);
    	// el dimension-1 para que este en la ultima columna
    	posicionMeta = this.posicionValida(this.filas-1);
    	Calle calleMeta = this.calleEnUnaPosicion(posicionMeta);
    	calleMeta.inicializarCalle();
    	calleMeta.meta();
    }

	private Posicion posicionValida(int coordenadaX) {
		
		// la primer posicion del vehiculo es (1, (this.dimension-1)/2(impar) )
		// la meta es (this.dimension-1 ,(this.dimension-1)/2(impar) )
		int x=coordenadaX;
		int y= (int)(this.columnas-1)/2;
		if(y%2 == 0){
			y--;
		}
		Posicion posicion = new Posicion();
		posicion.setX(x);
		posicion.setY(y);
		
		return posicion;
    	
	}

	private void cargarEscenario(int filas, int columnas){
        
        this.ciudad = new Calle[filas][columnas];
        for (int i = 0; i<(filas); i++){
            
            if((i%2) == 0){ //fila pares
                for (int j = 0; j<(columnas); j++){
                    if ((j%2) == 0)
                        this.ciudad[i][j] = new Calle(false);
                    else
                        this.ciudad[i][j] = new Calle(i);
                }
            }
            else{
            	for (int j = 0; j<(columnas); j++){
                    if ((j%2) == 0)
                        this.ciudad[i][j] = new Calle(i);
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
		return filas*columnas;
	}
	
	@XmlElement(name="posicionMeta")
	public Posicion getPosicionMeta() {
		return this.posicionMeta;	
	}

	public void colocarVehiculo(Posicion dondeQuieroIr) throws JuegoFinalizado {

		if(!gps.juegoEnMarcha())
			throw new JuegoFinalizado();
		
		Posicion posicionDondeEstaElVehiculo = this.vehiculo.getPosicion();
		Calle calleDondeEstaElVehiculo = this.calleEnUnaPosicion(posicionDondeEstaElVehiculo);
		calleDondeEstaElVehiculo.quitarVehiculo();
		
		Calle calleDondeQuieroMoverme = this.calleEnUnaPosicion(dondeQuieroIr);
		this.colocarVehiculo(calleDondeQuieroMoverme);
		
		if(calleDondeQuieroMoverme.sosMeta()){
			this.gps.terminarJuego();
		}
		
	}
	
	public void eliminarObstaculosYSorpresas(){
		 for (int i = 0; i<(filas); i++){
			 for (int j = 0; j<(columnas); j++){
				 this.ciudad[i][j].inicializarCalle();
			 }
		 }
	}

	public void setPosicionMeta(Posicion posicionMeta) {
		this.posicionMeta = posicionMeta;
	}

	public void setCiudad(Calle[][] ciudad) {
		this.ciudad = ciudad;
	}

	public void setGPS(GPS gps) {
		this.gps = gps;
	}

}
