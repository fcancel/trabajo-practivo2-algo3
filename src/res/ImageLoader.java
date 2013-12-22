package res;

import fiuba.algo3.modelo.efectosYSorpresas.ControlPolicial;
import fiuba.algo3.modelo.efectosYSorpresas.Efecto;
import fiuba.algo3.modelo.efectosYSorpresas.Piquete;
import fiuba.algo3.modelo.efectosYSorpresas.Pozo;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Moto;



public class ImageLoader {
    
    public void ImageLoader(){
        
    }
    
    public String imagenMeta(){
        return "/res/meta.png";
    }
    
    public String imagenCiudad(){
        return "/res/Ciudad.png";
    }
    
    public String imagenVehiculo(EstadoVehiculo vehiculo){
    	
    	String imagen="";
		if(vehiculo.getClass().equals(Auto.class))
			imagen = "/res/auto.png";
		if(vehiculo.getClass().equals(Moto.class))
			imagen = "/res/moto.png";
		if(vehiculo.getClass().equals(CuatroPorCuatro.class))
			imagen = "/res/CxC.png";
		
		return imagen;
    }
    
    public String imagenEfecto(Efecto efecto){
    	
    	String imagen="";
		if(efecto.getClass().equals(ControlPolicial.class)){
			imagen = "/res/policia.png";
		}else if(efecto.getClass().equals(Piquete.class)){
			imagen = "/res/piquete.png";
		}else if(efecto.getClass().equals(Pozo.class)){
			imagen = "/res/pozo.png";
		}else{
			imagen = "/res/sorpresa.png";
		}
		
		return imagen;

    }
    public String imagenPiquete(){
        return "/res/piquete.png";
    }
    
    public String imagenPolicia(){
        return "/res/policia.png";
    }
    
    public String imagenPozo(){
        return "/res/pozo.png";
    }
    
    public String imagenSorpresa(){
        return "/res/sorpresa.png";
    }
}
