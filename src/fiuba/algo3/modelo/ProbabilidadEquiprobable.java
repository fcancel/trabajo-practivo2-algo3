package fiuba.algo3.modelo;

import java.util.Random;

 public class ProbabilidadEquiprobable implements Probabilidad{

	@Override
	public double calcularProbabilidad() {
		
		Random rnd = new Random();
		
		return rnd.nextDouble();
	}

}
