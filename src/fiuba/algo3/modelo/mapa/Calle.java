package fiuba.algo3.modelo.mapa;

import java.util.Random;

import fiuba.algo3.modelo.efectosYSorpresas.ControlPolicial;
import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import fiuba.algo3.modelo.efectosYSorpresas.Piquete;
import fiuba.algo3.modelo.efectosYSorpresas.Pozo;
import fiuba.algo3.modelo.efectosYSorpresas.Probabilidad;
import fiuba.algo3.modelo.efectosYSorpresas.ProbabilidadEquiprobable;
import fiuba.algo3.modelo.efectosYSorpresas.SorpresaCambioDeVehiculo;
import fiuba.algo3.modelo.efectosYSorpresas.SorpresaDesfavorable;
import fiuba.algo3.modelo.efectosYSorpresas.SorpresaFavorable;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Calle {
    private boolean esMeta;
    private boolean transitable;
    private Vehiculo vehiculo;
    private Efecto sorpresa;
    private Efecto obstaculo;

    public Calle() {
    	transitable = true;
    	sorpresa = null;
    	obstaculo = null;
    	Random rnd = new Random();
    //genera un numero aleatorio entre 1 y 7 para decidir que agregar� en la calle 
    	int objeto = (int)(rnd.nextDouble() * 7 + 1);        
    	this.crearObjetoEnLaCalle(objeto);
    }
    
    public Calle(boolean transitable){
    	this.transitable = transitable;
    }
    
    //Este constructor solo es utilizado para llevar a cabo las pruebas
    public Calle(Random rnd){
    	transitable = true;
    	sorpresa = null;
    	obstaculo = null;
    	int objeto = (int)(rnd.nextDouble() * 7 + 1);  
    	this.crearObjetoEnLaCalle(objeto);
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
    		case 3:
				{
					Probabilidad probabilidad = new ProbabilidadEquiprobable();
					Efecto obstaculo = new ControlPolicial(probabilidad);
					this.setObstaculo (obstaculo);
				}
    		break;
    		case 4:
				{
					Efecto obstaculo = new Piquete();
					this.setObstaculo (obstaculo);
				}
    		break;
    		case 5:
				{
					Efecto sorpresa = new SorpresaDesfavorable();
					this.setSorpresa(sorpresa);
				}
                break;
    		case 6:
				{
					Efecto sorpresa = new SorpresaCambioDeVehiculo();
					this.setSorpresa(sorpresa);
				}
                break;
    		case 7:
				{
					Efecto sorpresa = new SorpresaFavorable();
					this.setSorpresa(sorpresa);
				}
                break;

    	};
    }

	public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
		if (this.tengoSorpresa())
			vehiculo.aceptarEfecto(this.sorpresa);
                if(this.tengoObstaculo())
                        vehiculo.aceptarEfecto(this.obstaculo);
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
    	return (sorpresa != null);
    }
    public boolean tengoObstaculo(){
    	return (obstaculo != null);
    }
	public boolean calleVacia(){
		return (this == null);
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void inicializarCalle(){
    	sorpresa = null;
    	obstaculo = null;
	}
}
