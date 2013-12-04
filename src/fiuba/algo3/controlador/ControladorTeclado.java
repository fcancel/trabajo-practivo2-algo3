package fiuba.algo3.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import fiuba.algo3.modelo.excepciones.JuegoFinalizado;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.MovimientoInvalido;
import fiuba.algo3.modelo.vehiculo.Vehiculo;

public class ControladorTeclado implements KeyPressedObservador {
	 
		private Vehiculo vehiculo;
		
		public ControladorTeclado(Vehiculo vehiculo){
			this.vehiculo = vehiculo;
		}
		
		@Override
		public void keyPressed(KeyEvent e) {

			try {
				if( e.getKeyCode() == KeyEvent.VK_UP){
					this.vehiculo.moverArriba();

				}
				if( e.getKeyCode() == KeyEvent.VK_DOWN){
					this.vehiculo.moverAbajo();

				}
				if( e.getKeyCode() == KeyEvent.VK_LEFT){ 
					this.vehiculo.moverIzquierda();

				}
				if( e.getKeyCode() == KeyEvent.VK_RIGHT){
					this.vehiculo.moverDerecha();

				}
			} catch (JuegoNoIniciado e1) {
				
			} catch (MovimientoInvalido e1) {
				// TODO Auto-generated catch block
				
			} catch (JuegoFinalizado e1) {
				// TODO Auto-generated catch block
				
			};

		}
}
