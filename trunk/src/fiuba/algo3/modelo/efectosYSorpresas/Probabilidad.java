package fiuba.algo3.modelo.efectosYSorpresas;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import fiuba.algo3.modelo.serializacion.AdaptadorDeInterfaces;

@XmlJavaTypeAdapter(AdaptadorDeInterfaces.class)

public interface Probabilidad {

	public double calcularProbabilidad();
	
}
