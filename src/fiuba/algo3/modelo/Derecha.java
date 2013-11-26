package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;

public class Derecha implements Command{

	
	private Vehiculo vehiculo;
	
	public Derecha(Vehiculo vehiculo){
		this.vehiculo = vehiculo;
	}
	
	@Override
	public void retroceder() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{

		this.vehiculo.moverIzquierda();
		
	}

}