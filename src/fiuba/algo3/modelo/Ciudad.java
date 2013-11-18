package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;


public class Ciudad {

	private ArrayList<ArrayList<Calle>> ciudad;
    private GPS gps;
    private Vehiculo vehiculo;
    private int dimension;

    public Ciudad(int dimension, Vehiculo vehiculo, GPS gps) {
        this.dimension = dimension * dimension;
        this.gps = gps;
        this.vehiculo = vehiculo;
        this.ciudad = new ArrayList<ArrayList<Calle>>();
        this.cargarEscenario();
    }
    private void cargarEscenario() {
        for (int i =0; i<dimension -1; i ++){
			ArrayList<Calle> fila = new ArrayList<Calle>();
			// Como la matriz de calles debe representar un mapa, hay partes donde no habrá calles que
			// representará las manzanas, el esquema sería algo de la manera. (m = manzana, | ó - = calle por donde se puede circular
			// |m|m|m|
			// |-|-|-| 	
			// |m|m|m|	
			// |-|-|-|
			if ((i % 2 )== 0)
			{
				for (int j = 0; j < dimension-1; j= j + 2){
					fila.add(new Calle());
				}
			}
			else
			{
				for (int j = 0; j < dimension-1; j++){
					fila.add(new Calle());
				}				
			}
			this.ciudad.add(fila);
        }
	}
    
    public boolean esValidaLaPosicionPosicion(Posicion posicion){    	
    	Calle calleDondeQuieroMoverme = this.calleDondeQuieroIr(posicion);
    	if (calleDondeQuieroMoverme.calleVacia())
    		//Debería devolver una excepción
    		return false;
    	else
    	{
    		this.colocarVehiculo(calleDondeQuieroMoverme);
    		return true;
    	}
    }
    
	private Calle calleDondeQuieroIr(Posicion posicion) {
		ArrayList<Calle> fila = new ArrayList<Calle>();
		fila = this.ciudad.get(posicion.getX());
		return fila.get(posicion.getX());
	}
	
	private void colocarVehiculo(Calle calle) {
		calle.setVehiculo(this.vehiculo);
//		if ((calle.tengoSorpresa) || (calle.tengoObstaculo)){
//			
//		}
	}
	
	public int getDimension() {
        return dimension;
    }
}
