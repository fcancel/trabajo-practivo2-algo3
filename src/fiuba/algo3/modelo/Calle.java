package fiuba.algo3.modelo;

import java.util.Random;

public class Calle {
    private boolean esMeta;
    private boolean transitable;
    private Vehiculo vehiculo;
    private Efecto sorpresa;
    private Efecto obstaculo;

    public Calle() {
    	Random rnd = new Random();
    //genera un número aleatorio entre 1 y 7 para decidir que agregará en la calle 
    	int objeto = (int)(rnd.nextDouble() * 7 + 1);        
    	this.crearObjetoEnLaCalle(objeto);
    	transitable = true;
    	sorpresa = null;
    	obstaculo = null;
    }
    
    public Calle(boolean transitable){
    	this.transitable = transitable;
    }
    
    public boolean esTransitable(){
    	return transitable;
    }
    
    private void crearObjetoEnLaCalle(int objeto) {
    	switch(objeto)
    	{ 
    		case 2: 
    			{
    				Efecto obstaculo = new Pozo();
    				this.setObstaculo (obstaculo);
    			}
    		break;
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
    		case 5:
				{
					Efecto sorpresa = new SorpresaDesfavorable();
					this.setSorpresa(sorpresa);
				}
    		case 6:
				{
					Efecto sorpresa = new SorpresaCambioDeVehiculo();
					this.setSorpresa(sorpresa);
				}
    		case 7:
				{
					Efecto sorpresa = new SorpresaFavorable();
					this.setSorpresa(sorpresa);
				}
    	};
    }

	public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
		if (this.tengoSorpresa() || this.tengoObstaculo() )
			vehiculo.aceptarEfecto(this.sorpresa);
    }
	
    public void setSorpresa(Efecto sorpresa) {
        this.sorpresa = sorpresa;        
    }
    public void setObstaculo(Efecto obstaculo) {
    	this.obstaculo = obstaculo;        
    }    
    public boolean sosMeta() {
    	return esMeta;
    }
    public void meta(){
    	esMeta = true;
    }
    public boolean tengoSorpresa(){
    	if (sorpresa != null)
    			return true;
    	else
    			return false;
    }
    public boolean tengoObstaculo(){
    	if (obstaculo != null)
    			return true;
    	else
    			return false;
    }
	public boolean calleVacia(){
		return (this == null);
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
}
