package fiuba.algo3.modelo.interfazGrafica;

import fiuba.algo3.modelo.juego.Jugador;


public class PantallaElegirComoEmpezar extends javax.swing.JFrame {
private final Jugador jugador;
    
    public PantallaElegirComoEmpezar(Jugador jugadorRecibido) {
        this.jugador = jugadorRecibido;
        initComponents();
        labelNombreJugador.setText("Jugador: " +jugador.getNombre());
        this.show();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxDificultad = new javax.swing.JComboBox();
        comboBoxVehiculoParaEmpezar = new javax.swing.JComboBox();
        labelNombreJugador = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();
        BotonComenzarAJugar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboBoxDificultad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fácil", "Moderado", "Difícil" }));

        comboBoxVehiculoParaEmpezar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Moto", "4x4", "Auto" }));

        labelNombreJugador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNombreJugador.setText("Jugador:");

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        BotonComenzarAJugar.setText("Jugar");
        BotonComenzarAJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonComenzarAJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(comboBoxDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 357, Short.MAX_VALUE)
                .addComponent(comboBoxVehiculoParaEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonComenzarAJugar)
                .addGap(387, 387, 387))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelNombreJugador)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxVehiculoParaEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                .addComponent(BotonComenzarAJugar)
                .addGap(36, 36, 36)
                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        PantallaJugadorIniciado pantallaJugadorIniciado = new PantallaJugadorIniciado(this.jugador);
        this.show(false);
        pantallaJugadorIniciado.show();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void BotonComenzarAJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonComenzarAJugarActionPerformed

        PantallaDelJuego pantallaDelJuego = new PantallaDelJuego();
        pantallaDelJuego.mainE();
        this.show(false);
    }//GEN-LAST:event_BotonComenzarAJugarActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonComenzarAJugar;
    private javax.swing.JButton botonAtras;
    private javax.swing.JComboBox comboBoxDificultad;
    private javax.swing.JComboBox comboBoxVehiculoParaEmpezar;
    private javax.swing.JLabel labelNombreJugador;
    // End of variables declaration//GEN-END:variables
}
