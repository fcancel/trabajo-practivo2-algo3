package fiuba.algo3.modelo.efectosYSorpresas;


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
