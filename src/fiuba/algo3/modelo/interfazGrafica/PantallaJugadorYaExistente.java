/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fiuba.algo3.modelo.interfazGrafica;

import fiuba.algo3.modelo.Jugador;
import fiuba.algo3.modelo.Jugadores;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Cancel
 */
public class PantallaJugadorYaExistente extends javax.swing.JFrame {

    /**
     * Creates new form PantallaJugadorYaExistente
     */
    public PantallaJugadorYaExistente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxJugadoresASeleccionar = new javax.swing.JComboBox();
        botonAtras = new javax.swing.JButton();
        botonElegirJugador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Jugadores jugadores = new Jugadores();
        jugadores.recuperar();
        Iterator<Jugador> listaDeJugadores = jugadores.listaDeJugadores();
        ArrayList<String> cadenaJugadores = new ArrayList<String>();
        while (listaDeJugadores.hasNext()){
            cadenaJugadores.add( (listaDeJugadores.next().getNombre()) );
        }
        comboBoxJugadoresASeleccionar = new javax.swing.JComboBox(cadenaJugadores.toArray());
        comboBoxJugadoresASeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxJugadoresASeleccionarActionPerformed(evt);
            }
        });

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        botonElegirJugador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonElegirJugador.setText("Seleccionar jugador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(303, 303, 303)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonElegirJugador)
                    .addComponent(comboBoxJugadoresASeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(382, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(comboBoxJugadoresASeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonElegirJugador))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxJugadoresASeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxJugadoresASeleccionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxJugadoresASeleccionarActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        PantallaDeInicio inicio = new PantallaDeInicio();
        this.show(false);
        inicio.show();
    }//GEN-LAST:event_botonAtrasActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonElegirJugador;
    private javax.swing.JComboBox comboBoxJugadoresASeleccionar;
    // End of variables declaration//GEN-END:variables
}