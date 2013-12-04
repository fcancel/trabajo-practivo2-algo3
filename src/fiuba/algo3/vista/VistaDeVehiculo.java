package fiuba.algo3.vista;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import fiuba.algo3.modelo.vehiculo.Vehiculo;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaDeVehiculo extends Imagen{
	
	private Vehiculo vehiculo;
	
	public VistaDeVehiculo(){
		//this.setNombreArchivoImagen("/res/auto.png");
	}
	
	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		this.setNombreArchivoImagen(this.vehiculo.getEstado().getDirecionDeImagen());
		Graphics grafico = (Graphics)superficeDeDibujo.getBuffer();
		grafico.drawImage(rotarImagen(this.getImagen()),posicionXCentral() , posicionYCentral(), null);
	}

	protected int posicionXCentral(){
		int posX =this.vehiculo.getX();
		return posX-(this.getImagen().getWidth()/2);
	}

	protected int posicionYCentral(){
		int posY= this.vehiculo.getY();
		return posY-(this.getImagen().getHeight()/2);
	}
	
	public BufferedImage rotarImagen(BufferedImage bufferedImage){
		 int angulo=this.getAnguloDeMovimiento();

		 AffineTransform tx = AffineTransform.getRotateInstance(Math.toRadians(angulo), bufferedImage.getWidth() / 2, bufferedImage.getHeight() / 2);
		 AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		 bufferedImage = op.filter(bufferedImage, null);
		 return bufferedImage;
	    }
	
    //Pos: se devuelve el angulo de movimiento
	private int getAnguloDeMovimiento(){

		int angulo=0;

		switch(this.vehiculo.getDireccion()){
		case ARRIBA: 
			angulo= 270;
			break;
		case ABAJO: 
			angulo= 90;
			break;
		case DERECHA: 
			angulo= 00;
			break;
		case IZQUIERDA: 
			angulo= 180;
			break;
		}

		return angulo;
	}

	public void agregarVehiculo(Vehiculo vehiculo) {
		
		this.vehiculo = vehiculo;
		
	}
	
}