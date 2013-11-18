package fiuba.algo3.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.Probabilidad;
import fiuba.algo3.modelo.ProbabilidadEstatica;

public class TestProbabilidadEstatica {

	@Test
	public void alCrearProbabilidadEstaticaDebeDevolverElValorConQueSeLaCreo() {
		
		Probabilidad probabilidadEstatica = new ProbabilidadEstatica(0.3);
		
		assertTrue ( probabilidadEstatica.calcularProbabilidad() == 0.3);
		
	}

}
