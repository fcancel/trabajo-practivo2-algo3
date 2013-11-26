package fiuba.algo3.modelo;

import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;



public interface Command {

	void retroceder() throws JuegoNoIniciado, MovimientoInvalido, JuegoFinalizado;
	
}