package fiuba.algo3.modelo;

import java.util.Random;

public class Calle {
    private boolean esMeta;
    private Vehiculo vehiculo;
    //private Efecto sorpresa;
    //private Efecto obstaculo;

    public Calle() {
    	Random rnd = new Random();
    //genera un número aleatorio entre 1 y 7 para decidir que agregará en la calle 
    	int objeto = (int)(rnd.nextDouble() * 7 + 1);        
    	this.crearObjetoEnLaCalle(objeto);
    }
    
    private void crearObjetoEnLaCalle(int objeto) {
//    	switch(objeto)
//    	{ 
//    		case 2: 
//    			{
//    				Efecto obstaculo = new Efecto();
//    				this.setObstaculo (obstaculo);
//    			}
//    		break;
//    		case 3:
//				{
//					Efecto obstaculo = new Efecto();
//					this.setObstaculo (obstaculo);
//				}
//    		break;
//    		case 4:
//				{
//					Efecto obstaculo = new Efecto();
//					this.setObstaculo (obstaculo);
//				}
//    		break;
//    		case 5:
//				{
//					Efecto sorpresa = new Efecto();
//					this.setSorpresa(sorpresa;
//				}
//    		case 6:
//				{
//					Efecto sorpresa = new Efecto;
//					this.setSorpresa(sorpresa);
//				}
//    		case 7:
//				{
//					Efecto sorpresa = new Efecto;
//					this.setSorpresa(sorpresa);
//				}
//    	};
    }

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
	public boolean calleVacia(){
		return (this == null);
	}
}
