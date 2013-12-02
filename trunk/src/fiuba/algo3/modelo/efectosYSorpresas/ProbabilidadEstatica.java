package fiuba.algo3.modelo.efectosYSorpresas;

import javax.xml.bind.annotation.XmlAttribute;



public class ProbabilidadEstatica implements Probabilidad {

	@XmlAttribute(name="probabilidad")
	private double probabilidad;
	
	public ProbabilidadEstatica(double probabilidad){
		this.probabilidad= probabilidad;
	}
	
	@Override
	public double calcularProbabilidad() {
		
		return probabilidad;
	}

}
