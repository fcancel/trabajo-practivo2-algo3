package fiuba.algo3.modelo;

public class ProbabilidadEstatica implements Probabilidad {

	private double probabilidad;
	
	public ProbabilidadEstatica(double probabilidad){
		this.probabilidad= probabilidad;
	}
	
	@Override
	public double calcularProbabilidad() {
		
		return probabilidad;
	}

}
