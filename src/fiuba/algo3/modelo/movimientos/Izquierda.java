package fiuba.algo3.modelo.movimientos;

import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class Izquierda implements Command{

	private Vehiculo vehiculo;
	
	public Izquierda(Vehiculo vehiculo){
		this.vehiculo = vehiculo;
	}
	
	@Override
	public void retroceder() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado {
		
		vehiculo.moverDerecha();
		
	}

}
