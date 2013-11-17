package fiuba.algo3.modelo;

public class Calle {
    private boolean esMeta;
    private Vehiculo vehiculo;
    //private Efecto sorpresa;
    //private Efecto obstaculo;

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;        
    }
//    public void setSorpresa(Efecto sorpresa) {
//        this.vehiculo = vehiculo;        
//    }
//    public void setObstaculo(Efecto obstaculo) {
//    	this.vehiculo = vehiculo;        
//    }    
    public boolean sosMeta() {
    	return esMeta;
    }
    public void meta(){
    	esMeta = true;
    }
//    public boolean tengoSorpresa(){
//    	if (sopresa != null)
//    			return true;
//    	else
//    			return false;
//    }
//    public boolean tengoObstaculo(){
//    	if (sopresa != null)
//    			return true;
//    	else
//    			return false;
//    }
}
