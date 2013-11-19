package fiuba.algo3.modelo;

import java.util.ArrayList;

import fiuba.algo3.modelo.excepciones.MovimientoInvalido;


public class Ciudad {
    private Calle[][] ciudadnueva;
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
        this.cargarEscenario2(dimension);
    }
    
    private void cargarEscenario2(int dimension){
        
        this.ciudadnueva = new Calle[dimension][dimension];
        for (int i = 0; i<(dimension-1); i++){
            
            if((i%2) == 0){ //fila pares
                for (int j = 0; j<(dimension-1); j++){
                    if ((j%2) == 0)
                        this.ciudadnueva[i][j] = new Calle(false);
                    else
                        this.ciudadnueva[i][j] = new Calle();
                }
            }
            else{
                for (int j = 0; j<(dimension-1); j++){
                    if ((j%2) == 0)
                        this.ciudadnueva[i][j] = new Calle();
                    else
                        this.ciudadnueva[i][j] = new Calle(true);
                }
            }
        }
        
        
    }
    
    private void cargarEscenario(int dimension) {
        for (int i =0; i<dimension -1; i ++){
			ArrayList<Calle> fila = new ArrayList<Calle>();
			// Como la matriz de calles debe representar un mapa, hay partes donde no habr� calles que
			// representar� las manzanas, el esquema ser�a algo de la manera. (m = manzana, | � - = calle por donde se puede circular
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
    
    public boolean esValidaLaPosicion2(Posicion posicion){
        return this.ciudadnueva[posicion.getX()][posicion.getY()].esTransitable();
    }
    
    public boolean esValidaLaPosicion(Posicion posicion) throws MovimientoInvalido{ 
    	Calle calleDondeQuieroMoverme = this.calleDondeQuieroIr(posicion);
    	if (calleDondeQuieroMoverme.esTransitable()){
    		this.colocarVehiculo(calleDondeQuieroMoverme);
                return true;
        }        
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
