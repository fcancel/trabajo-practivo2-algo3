package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;

public class Retroceder {
	
	private Command ultimaAccion;
	
	public void getUltimaAccion(Command ultimaAccion){
		this.ultimaAccion = ultimaAccion;
	}
	
	public void realizar() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado{
		this.ultimaAccion.retroceder();
	}

}