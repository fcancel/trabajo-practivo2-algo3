/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiuba.algo3.modelo;

/**
 *
 * @author Cancel
 */
public class GPS {
    
    private static int MOVIMIENTO_INICIAL = 0;
    private boolean juegoEnCurso;
    //private PuntuacionesAltas puntuacionesAltas;
    private int movimientos;
    
    public void GPS(){
        this.movimientos = MOVIMIENTO_INICIAL;
        this.empezarJuego();
    }
    
    public int getMovimientos(){
        return this.movimientos;
    }
    
    public void sumarMovimiento( int movimientoASumar ){
        this.movimientos += movimientoASumar;
    }
    
    public void empezarJuego(){
        this.juegoEnCurso = true;
    }
}
