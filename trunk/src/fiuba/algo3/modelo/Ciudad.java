package fiuba.algo3.modelo;

import java.util.ArrayList;

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
        for (int i =0; i<dimension -1; i++){
			ArrayList<Calle> fila = new ArrayList<Calle>();
			for (int j = 0; j < dimension-1; j++){
				fila.add(new Calle());
			}
			this.ciudad.add(fila);
        }
    }
    public int getDimension() {
        return dimension;
    }
}
