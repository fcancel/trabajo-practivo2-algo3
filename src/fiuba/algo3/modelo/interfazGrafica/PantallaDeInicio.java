package fiuba.algo3.modelo.interfazGrafica;

import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PantallaDeInicio extends javax.swing.JFrame {


    public PantallaDeInicio() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
   
    private void initComponents() {

        botonCrearNuevoJugador = new javax.swing.JButton();
        botonYaTengoUsuario = new javax.swing.JButton();
        tituloDelJuego = new javax.swing.JLabel();
        botonExit = new javax.swing.JButton();
        botonPuntuacionesAltas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPS Challenge");
        setBounds(new java.awt.Rectangle(500, 200, 900, 550));
        setForeground(java.awt.Color.lightGray);
        setResizable(false);

        botonCrearNuevoJugador.setFont(new java.awt.Font("Tahoma", 1, 29)); // NOI18N
        botonCrearNuevoJugador.setText("Crear nuevo jugador");
        botonCrearNuevoJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearNuevoJugadorActionPerformed(evt);
            }
        });

        botonYaTengoUsuario.setFont(new java.awt.Font("Tahoma", 1, 29)); // NOI18N
        botonYaTengoUsuario.setText("Jugador ya existente");
        botonYaTengoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonYaTengoUsuarioActionPerformed(evt);
            }
        });

        tituloDelJuego.setFont(new java.awt.Font("Ravie", 0, 31)); // NOI18N
        tituloDelJuego.setText("GPS Challenge");

        botonExit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botonExit.setText("Salir");
        botonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExitActionPerformed(evt);
            }
        });

        botonPuntuacionesAltas.setFont(new java.awt.Font("Tahoma", 1, 29)); // NOI18N
        botonPuntuacionesAltas.setText("Maximas puntuaciones");
        botonPuntuacionesAltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPuntuacionesAltasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloDelJuego)
                .addGap(321, 321, 321))
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonPuntuacionesAltas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                        .addComponent(botonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonCrearNuevoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonYaTengoUsuario))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {botonCrearNuevoJugador, botonPuntuacionesAltas, botonYaTengoUsuario});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloDelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonCrearNuevoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonYaTengoUsuario)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(botonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonPuntuacionesAltas)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {botonCrearNuevoJugador, botonPuntuacionesAltas, botonYaTengoUsuario});

        pack();
        setLocationRelativeTo(null);
    }

    private void botonCrearNuevoJugadorActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        PantallaCrearJugador creoJugador = new PantallaCrearJugador();
        this.show(false);
        
    }

    private void botonYaTengoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {                                                    

        PantallaJugadorYaExistente pantallaJugadorExistente = new PantallaJugadorYaExistente();
        this.show(false);
                
    }

    private void botonExitActionPerformed(java.awt.event.ActionEvent evt) {                                          
        System.exit(0);
    }

    private void botonPuntuacionesAltasActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        PantallaMaximasPuntuaciones pantallaMaximasPuntuaciones;
        try {
            pantallaMaximasPuntuaciones = new PantallaMaximasPuntuaciones();
            this.show(false);
          
        } catch (NoExisteEsaPosicion ex) {
            //Logger.getLogger(PantallaDeInicio.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

   
   
    public static void main(String args[]) {
       

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaDeInicio().setVisible(true);
            }
        });
    }

   
    private javax.swing.JButton botonCrearNuevoJugador;
    private javax.swing.JButton botonExit;
    private javax.swing.JButton botonPuntuacionesAltas;
    private javax.swing.JButton botonYaTengoUsuario;
    private javax.swing.JLabel tituloDelJuego;

}
