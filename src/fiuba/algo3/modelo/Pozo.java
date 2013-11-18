package fiuba.algo3.modelo;


public class Pozo implements Efecto {
    
    public Pozo(){
        
    }
    
    
    @Override
    public void realizarEfecto(Moto moto, Vehiculo vehiculo) {
		
        vehiculo.sumarMovimiento(3);
		
	}
    
    @Override
    public void realizarEfecto(Auto auto, Vehiculo vehiculo) {
        
        vehiculo.sumarMovimiento(3);
    }
    
    @Override
    public void realizarEfecto(CuatroPorCuatro cuatroPorCuatro, Vehiculo vehiculo){
        //Como no afecta a las cuatro por cuatro lo dejo vacio
    }
}
