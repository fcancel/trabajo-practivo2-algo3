package fiuba.algo3.modelo.interfazGrafica;

import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Puntuacion;
import javax.swing.SwingConstants;

public class PantallaJuegoTerminado extends javax.swing.JFrame {


    public PantallaJuegoTerminado(Jugador jugador, Puntuacion puntuacion) {
        initComponents();
        this.show();
        labelPuntaje.setText(jugador.getNombre());
        labelPuntaje.setText(String.valueOf(puntuacion.getPuntos()));
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        labelSuPuntajeEs = new javax.swing.JLabel("SU PUNTAJE ES:", SwingConstants.CENTER);
        labelPuntaje = new javax.swing.JLabel("Jugador", SwingConstants.CENTER);
        labelFelicitaciones1 = new javax.swing.JLabel("FELICITACIONES", SwingConstants.CENTER);
        labelJugador1 = new javax.swing.JLabel("Jugador", SwingConstants.CENTER);
        botonVolverAlMenuDeInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPS Challenge");
        setPreferredSize(new java.awt.Dimension(900, 558));

        labelSuPuntajeEs.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelSuPuntajeEs.setText("SU PUNTAJE ES:");

        labelPuntaje.setFont(new java.awt.Font("Motorwerk", 0, 90)); // NOI18N
        labelPuntaje.setText("PUNTAJE");

        labelFelicitaciones1.setFont(new java.awt.Font("Segoe Keycaps", 0, 36)); // NOI18N
        labelFelicitaciones1.setText("...GAME OVER...");

        labelJugador1.setFont(new java.awt.Font("Motorwerk", 0, 90)); // NOI18N
        labelJugador1.setText("Jugador");

        botonVolverAlMenuDeInicio.setText("Volver a Inicio");
        botonVolverAlMenuDeInicio.setMaximumSize(new java.awt.Dimension(5000, 5000));
        botonVolverAlMenuDeInicio.setMinimumSize(new java.awt.Dimension(900, 558));
        botonVolverAlMenuDeInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverAlMenuDeInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonVolverAlMenuDeInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(labelSuPuntajeEs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(labelPuntaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(labelFelicitaciones1, javax.swing.GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(labelJugador1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(labelFelicitaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128)
                .addComponent(labelSuPuntajeEs, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelPuntaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(botonVolverAlMenuDeInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addComponent(labelJugador1)
                    .addContainerGap(325, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }
    
    private void botonVolverAlMenuDeInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverAlMenuDeInicioActionPerformed
        PantallaDeInicio inicio = new PantallaDeInicio();
        this.show(false);
        inicio.show();
    }

    private javax.swing.JButton botonVolverAlMenuDeInicio;
    private javax.swing.JLabel labelFelicitaciones1;
    private javax.swing.JLabel labelJugador1;
    private javax.swing.JLabel labelPuntaje;
    private javax.swing.JLabel labelSuPuntajeEs;
}
