package fiuba.algo3.modelo;


public class Posicion {
    
    private int posicionX;
    private int posicionY;
    
   public void Posicion(){
       this.posicionX = 0;
       this.posicionY = 0;
   }
   
    public void setX( int numero ){
        
        this.posicionX = numero;        
    }
    
    /**
     *
     * @return
     */
    public int getX(){
        
        return posicionX;
    }

    /**
     *
     * @param numero
     */
    public void setY( int numero ) {
        
        this.posicionY = numero;
    }

    /**
     *
     * @return
     */
    public int getY() {
        
        return posicionY;
    }

   
}
