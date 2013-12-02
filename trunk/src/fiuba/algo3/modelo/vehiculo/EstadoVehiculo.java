package fiuba.algo3.modelo.vehiculo;

import fiuba.algo3.modelo.efectosYSorpresas.Efecto;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fiuba.algo3.modelo.serializacion.AdaptadorDeInterfaces;

@XmlJavaTypeAdapter(AdaptadorDeInterfaces.class)
public interface EstadoVehiculo {
    
 
    //public EstadoVehiculo getEstadoVehiculo();
    
	public String getDirecionDeImagen();
	
    public void aceptarEfecto(Vehiculo vehiculo, Efecto efecto);
    
}
