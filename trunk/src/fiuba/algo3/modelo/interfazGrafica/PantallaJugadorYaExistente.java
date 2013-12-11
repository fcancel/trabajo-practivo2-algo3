package fiuba.algo3.modelo.interfazGrafica;

import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Jugadores;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ComboBoxModel;

public class PantallaJugadorYaExistente extends javax.swing.JFrame {

    private Jugadores jugadores;
    
    public PantallaJugadorYaExistente() {
        initComponents();
        this.show();
    }

    
    @SuppressWarnings("unchecked")
    private void initComponents() {

        comboBoxJugadoresASeleccionar = new javax.swing.JComboBox();
        botonAtras = new javax.swing.JButton();
        botonElegirJugador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPS Challenge");
        setPreferredSize(new java.awt.Dimension(900, 558));
        setResizable(false);

        this.jugadores = new Jugadores();

        Iterator<Jugador> listaDeJugadores = this.jugadores.listaDeJugadores();
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
        botonAtras.setMaximumSize(new java.awt.Dimension(5000, 5000));
        botonAtras.setMinimumSize(new java.awt.Dimension(900, 558));
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        botonElegirJugador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonElegirJugador.setText("Seleccionar jugador");
        botonElegirJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonElegirJugadorActionPerformed(evt);
            }
        });

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(comboBoxJugadoresASeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonElegirJugador))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void comboBoxJugadoresASeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxJugadoresASeleccionarActionPerformed
       
        
    }

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        PantallaDeInicio inicio = new PantallaDeInicio();
        this.show(false);
        inicio.show();
    }

    private void botonElegirJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonElegirJugadorActionPerformed
       
        int opcionElegida = comboBoxJugadoresASeleccionar.getSelectedIndex();
        
        if (opcionElegida >= 0 ){
            
            
                       
            PantallaJugadorIniciado pantallaJugadorIniciado = new PantallaJugadorIniciado(this.jugadores.getJugadorEnPosicion(opcionElegida));
            this.show(false);
            
        }
    }

    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonElegirJugador;
    private javax.swing.JComboBox comboBoxJugadoresASeleccionar;

}
