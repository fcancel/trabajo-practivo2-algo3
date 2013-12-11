package fiuba.algo3.vista;

import java.awt.Color;
import java.awt.Graphics;

import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Figura;

public class VistaCircuferenciaMeta extends Figura {

	public void dibujar(SuperficieDeDibujo superfice) {
		Graphics grafico = (Graphics)superfice.getBuffer();
		grafico.setColor(Color.WHITE);
		grafico.fillOval(getPosicionable().getX()-40/2, getPosicionable().getY()-30/2, 50, 50);
	}
}
