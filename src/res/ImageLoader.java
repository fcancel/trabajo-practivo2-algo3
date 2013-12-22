package res;

import fiuba.algo3.modelo.efectosYSorpresas.ControlPolicial;
import fiuba.algo3.modelo.efectosYSorpresas.Piquete;
import fiuba.algo3.modelo.efectosYSorpresas.Pozo;



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
    
    public String imagenEfecto(Class clase){
         if (clase.equals(Piquete.class))
        return "/res/piquete.png";
        else
            if (clase.equals(ControlPolicial.class) )
                    return "/res/policia.png";
                        if (clase.equals(Pozo.class))
                            return "/res/pozo.png";
                                else return "/res/sorpresa.png";
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
