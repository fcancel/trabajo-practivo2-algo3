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
    }
    public int getDimension() {
        return dimension;
    }
}
