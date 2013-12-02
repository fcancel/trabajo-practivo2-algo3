package fiuba.algo3.modelo.dificultad;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fiuba.algo3.modelo.serializacion.AdaptadorDeInterfaces;

@XmlJavaTypeAdapter(AdaptadorDeInterfaces.class)
public interface Dificultad {
	
	public int getFilas();
	public int getColumnas();
	public int getMultiplicador();
	public int getMaximoDeMovimientos();
	
}
