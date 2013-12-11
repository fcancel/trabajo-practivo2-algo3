
package fiuba.algo3.modelo.interfazGrafica;

import fiuba.algo3.modelo.excepciones.JugadorExistente;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Jugadores;

import java.util.logging.Level;
import java.util.logging.Logger;
        
public class PantallaCrearJugador extends javax.swing.JFrame {

    public PantallaCrearJugador() {
        initComponents();
        this.show();
    }

    
    @SuppressWarnings("unchecked")
    
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        nombreUsuario = new javax.swing.JTextField();
        guardarNombre = new javax.swing.JButton();
        mensajeJugadorYaExistente = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPS Challenge");
        setBounds(new java.awt.Rectangle(500, 200, 900, 550));
        setPreferredSize(new java.awt.Dimension(900, 558));
        setResizable(false);

        titulo.setFont(new java.awt.Font("Tahoma", 0, 31)); // NOI18N
        titulo.setText("Elija un nombre");

        nombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuarioActionPerformed(evt);
            }
        });

        guardarNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        guardarNombre.setText("Guardar nombre");
        guardarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarNombreActionPerformed(evt);
            }
        });

        mensajeJugadorYaExistente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(336, 336, 336))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mensajeJugadorYaExistente)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardarNombre))
                    .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(261, 261, 261))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {guardarNombre, mensajeJugadorYaExistente, nombreUsuario});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
                        .addComponent(mensajeJugadorYaExistente)
                        .addGap(18, 18, 18)
                        .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(guardarNombre)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {guardarNombre, mensajeJugadorYaExistente, nombreUsuario});

        pack();
        setLocationRelativeTo(null);
    }

    private void nombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuarioActionPerformed
    }

    private void guardarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarNombreActionPerformed
        
        Jugador jugadorNuevo = new Jugador(nombreUsuario.getText());
        Jugadores jugadorAAgregar = new Jugadores();
        try {
            jugadorAAgregar.agregarNuevoJugador(jugadorNuevo);
            PantallaJugadorIniciado pantallaJugadorIniciado = new PantallaJugadorIniciado(jugadorNuevo);
            this.show(false);
          
        } catch (JugadorExistente ex) {
            // Si el nombre ya existe le aviso por pantalla y espero a que ponga otro
            mensajeJugadorYaExistente.setText("Nombre de jugador ya existente");
        }
       
    }

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        PantallaDeInicio inicio = new PantallaDeInicio();
        this.show(false);
        inicio.show();
    }
    
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton guardarNombre;
    private javax.swing.JLabel mensajeJugadorYaExistente;
    private javax.swing.JTextField nombreUsuario;
    private javax.swing.JLabel titulo;

}
