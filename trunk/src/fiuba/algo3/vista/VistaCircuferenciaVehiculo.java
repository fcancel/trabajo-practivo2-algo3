package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Circulo;

public class VistaCircuferenciaVehiculo extends Circulo {

	public VistaCircuferenciaVehiculo() {
		super(100);
		// TODO Auto-generated constructor stub
	}

	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = (Graphics)superfice.getBuffer();
		grafico.setColor(Color.WHITE);
		grafico.fillOval(getPosicionable().getX()-200/2, getPosicionable().getY()-200/2, 200, 200);
	}
}
