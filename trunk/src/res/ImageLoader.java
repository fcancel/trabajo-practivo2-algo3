package res;

import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;


public class ImageLoader {
    
    public void ImageLoader(){
        
    }
    
    public String imagenMeta(){
        return "/res/meta.png";
    }
    
    public String imagenCiudad(){
        return "/res/Ciudad.png";
    }
    
    public String imagenVehiculo(String nombreVehiculo){
        if (nombreVehiculo == "CuatroPorCuatro")
        return "/res/CxC.png";
        else
            if (nombreVehiculo == "Auto")
                    return "/res/auto.png";
                            else return "/res/moto.png";
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
