package fiuba.algo3.modelo.interfazGrafica;

import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;
import fiuba.algo3.modelo.juego.Puntuacion;
import fiuba.algo3.modelo.juego.PuntuacionesAltas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.plaf.LabelUI;


public class PantallaMaximasPuntuaciones extends javax.swing.JFrame {

 
    public PantallaMaximasPuntuaciones() throws NoExisteEsaPosicion {
        initComponents();
        this.show();
        PuntuacionesAltas puntuacionesAltas = new PuntuacionesAltas();
        JLabel[] labelsJugadores = new JLabel[] {null, this.jugadorMaximo1, this.jugadorMaximo2, this.jugadorMaximo3, this.jugadorMaximo4, this.jugadorMaximo5};
        JLabel[] labelsPuntajesDeJugadores = new JLabel[] {null, this.puntajeMaximo1, this.puntajeMaximo2, this.puntajeMaximo3, this.puntajeMaximo4, this.puntajeMaximo5};
        
        if ( puntuacionesAltas.estaVacia() )
            avisoPuntuacionesVacias.setText("No hay puntuaciones máximas.");
        else{
            for (int contador = 1 ; contador<5 ; contador++){
                
                Puntuacion puntuacion = puntuacionesAltas.getPuntuacion(contador);
                
                labelsJugadores[contador].setText(puntuacion.getNick());
                labelsPuntajesDeJugadores[contador].setText( String.valueOf(puntuacion.getPuntos()) );
                                
            }    
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloDeMaximasPuntuaciones = new javax.swing.JLabel();
        jugadorMaximo1 = new javax.swing.JLabel();
        puntajeMaximo1 = new javax.swing.JLabel();
        jugadorMaximo2 = new javax.swing.JLabel();
        puntajeMaximo2 = new javax.swing.JLabel();
        jugadorMaximo3 = new javax.swing.JLabel();
        puntajeMaximo3 = new javax.swing.JLabel();
        jugadorMaximo4 = new javax.swing.JLabel();
        puntajeMaximo4 = new javax.swing.JLabel();
        jugadorMaximo5 = new javax.swing.JLabel();
        puntajeMaximo5 = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();
        avisoPuntuacionesVacias = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPS Challenge");
        setPreferredSize(new java.awt.Dimension(900, 558));
        setResizable(false);

        tituloDeMaximasPuntuaciones.setFont(new java.awt.Font("Ravie", 0, 31)); // NOI18N
        tituloDeMaximasPuntuaciones.setText("Máximas Puntuaciones");

        jugadorMaximo1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jugadorMaximo1.setText("Jugador1");

        puntajeMaximo1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        puntajeMaximo1.setText("puntaje1");

        jugadorMaximo2.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        jugadorMaximo2.setText("Jugador2");

        puntajeMaximo2.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        puntajeMaximo2.setText("puntaje2");

        jugadorMaximo3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jugadorMaximo3.setText("Jugador3");

        puntajeMaximo3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        puntajeMaximo3.setText("puntaje3");

        jugadorMaximo4.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        jugadorMaximo4.setText("Jugador4");

        puntajeMaximo4.setFont(new java.awt.Font("Tahoma", 0, 19)); // NOI18N
        puntajeMaximo4.setText("puntaje4");

        jugadorMaximo5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jugadorMaximo5.setText("Jugador5");

        puntajeMaximo5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        puntajeMaximo5.setText("puntaje5");

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        avisoPuntuacionesVacias.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        avisoPuntuacionesVacias.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jugadorMaximo4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)
                                .addComponent(puntajeMaximo4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jugadorMaximo2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)
                                .addComponent(puntajeMaximo2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jugadorMaximo1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)
                                .addComponent(puntajeMaximo1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jugadorMaximo5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)
                                .addComponent(puntajeMaximo5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jugadorMaximo3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(213, 213, 213)
                                .addComponent(puntajeMaximo3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tituloDeMaximasPuntuaciones)
                                .addGap(187, 187, 187))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(avisoPuntuacionesVacias, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(200, 200, 200))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloDeMaximasPuntuaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jugadorMaximo1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntajeMaximo1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jugadorMaximo2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntajeMaximo2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jugadorMaximo3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntajeMaximo3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jugadorMaximo4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntajeMaximo4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jugadorMaximo5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntajeMaximo5))
                .addGap(18, 18, 18)
                .addComponent(avisoPuntuacionesVacias, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        
        
        PantallaDeInicio inicio = new PantallaDeInicio();
        this.show(false);
        inicio.show();
    }//GEN-LAST:event_botonAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avisoPuntuacionesVacias;
    private javax.swing.JButton botonAtras;
    private javax.swing.JLabel jugadorMaximo1;
    private javax.swing.JLabel jugadorMaximo2;
    private javax.swing.JLabel jugadorMaximo3;
    private javax.swing.JLabel jugadorMaximo4;
    private javax.swing.JLabel jugadorMaximo5;
    private javax.swing.JLabel puntajeMaximo1;
    private javax.swing.JLabel puntajeMaximo2;
    private javax.swing.JLabel puntajeMaximo3;
    private javax.swing.JLabel puntajeMaximo4;
    private javax.swing.JLabel puntajeMaximo5;
    private javax.swing.JLabel tituloDeMaximasPuntuaciones;
    // End of variables declaration//GEN-END:variables
}
