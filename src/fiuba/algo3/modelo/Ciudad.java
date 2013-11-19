package fiuba.algo3.modelo;

import java.util.ArrayList;

import fiuba.algo3.excepciones.MovimientoInvalido;


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
        this.cargarEscenario(dimension);
    }
    private void cargarEscenario(int dimension) {
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
				for (int j = 0; j < dimension-1; j++){
					if ((j % 2 )== 0)
						fila.add(new Calle());
					else
						fila.add(new Calle(false));
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
    
    public void esValidaLaPosicion(Posicion posicion) throws MovimientoInvalido{    	
    	Calle calleDondeQuieroMoverme = this.calleDondeQuieroIr(posicion);
    	if (calleDondeQuieroMoverme.esTransitable())
    		this.colocarVehiculo(calleDondeQuieroMoverme);
    	else
    		throw new MovimientoInvalido();
    }
    
	public Calle calleDondeQuieroIr(Posicion posicion) {
		ArrayList<Calle> fila = this.ciudad.get(posicion.getX());
		return fila.get(posicion.getY());
	}
	
	private void colocarVehiculo(Calle calle) {
		calle.setVehiculo(this.vehiculo);
	}
	
	public int getDimension(){
		return dimension;
	}
	
	public ArrayList<ArrayList<Calle>> getCiudad(){
		return ciudad;
	}
}
