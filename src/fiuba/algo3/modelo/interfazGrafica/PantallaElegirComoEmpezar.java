package fiuba.algo3.modelo.interfazGrafica;

import fiuba.algo3.modelo.dificultad.Dificil;
import fiuba.algo3.modelo.dificultad.Dificultad;
import fiuba.algo3.modelo.dificultad.Facil;
import fiuba.algo3.modelo.dificultad.Moderado;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.vehiculo.Auto;
import fiuba.algo3.modelo.vehiculo.CuatroPorCuatro;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;
import java.util.ArrayList;
import java.util.List;


public class PantallaElegirComoEmpezar extends javax.swing.JFrame {
private final Jugador jugador;
private EstadoVehiculo[] estadoVehiculos;
private Dificultad[] dificultades;
    
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
        setTitle("GPS Challenge");
        setPreferredSize(new java.awt.Dimension(900, 558));
        setResizable(false);

        Dificultad[] dificultades = { new Facil(), new Moderado(), new Dificil()};
        comboBoxDificultad.setModel(new javax.swing.DefaultComboBoxModel(dificultades));

        EstadoVehiculo[] vehiculos = {new Auto(), new CuatroPorCuatro(), new Moto()};
        this.estadoVehiculos = vehiculos;
        comboBoxVehiculoParaEmpezar.setModel(new javax.swing.DefaultComboBoxModel(vehiculos));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(comboBoxDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 434, Short.MAX_VALUE)
                .addComponent(comboBoxVehiculoParaEmpezar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        PantallaJugadorIniciado pantallaJugadorIniciado = new PantallaJugadorIniciado(this.jugador);
        this.show(false);
        pantallaJugadorIniciado.show();
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void BotonComenzarAJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonComenzarAJugarActionPerformed

        PantallaDelJuego pantallaDelJuego = new PantallaDelJuego();
        pantallaDelJuego.comenzarMiJuego( (EstadoVehiculo) comboBoxVehiculoParaEmpezar.getSelectedItem(), (Dificultad) comboBoxDificultad.getSelectedItem(), this.jugador);
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
