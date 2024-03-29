package fiuba.algo3.modelo.interfazGrafica;

import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import fiuba.algo3.modelo.excepciones.NoExisteEsaPosicion;
import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;


public class PantallaJugadorIniciado extends javax.swing.JFrame {
private final Jugador jugador;
    
    public PantallaJugadorIniciado(Jugador jugadorIniciado) {
        this.jugador = jugadorIniciado;
        initComponents();
        setNombreDelJugador(this.jugador.getNombre());
        this.show();
    }

 
    @SuppressWarnings("unchecked")
    private void initComponents() {

        labelNombreJugador = new javax.swing.JLabel();
        tituloDelJuego = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();
        botonNuevaPartida = new javax.swing.JButton();
        botonContinuarPartida = new javax.swing.JButton();
        botonPuntuacionesAltas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GPS Challenge");
        setPreferredSize(new java.awt.Dimension(900, 558));
        setResizable(false);

        labelNombreJugador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNombreJugador.setText("Jugador:");

        tituloDelJuego.setFont(new java.awt.Font("Ravie", 0, 31)); // NOI18N
        tituloDelJuego.setText("GPS Challenge");

        botonAtras.setText("Atras");
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed(evt);
            }
        });

        botonNuevaPartida.setText("Nueva partida");
        botonNuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaPartidaActionPerformed(evt);
            }
        });

        botonContinuarPartida.setText("Continuar partida");
        botonContinuarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonContinuarPartidaActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(tituloDelJuego)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonContinuarPartida)
                            .addComponent(botonNuevaPartida)
                            .addComponent(botonPuntuacionesAltas))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNombreJugador)
                    .addComponent(tituloDelJuego))
                .addGap(80, 80, 80)
                .addComponent(botonNuevaPartida)
                .addGap(18, 18, 18)
                .addComponent(botonContinuarPartida)
                .addGap(18, 18, 18)
                .addComponent(botonPuntuacionesAltas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {                                           
        PantallaDeInicio inicio = new PantallaDeInicio();
        this.show(false);
        inicio.show();
    }

    private void botonNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        
        PantallaElegirComoEmpezar pantallaElegirComoEmpezar = new PantallaElegirComoEmpezar(this.jugador);
        this.show(false);       
        
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

    private void botonContinuarPartidaActionPerformed(java.awt.event.ActionEvent evt) {                                                      

        PantallaDelJuego pantallaDelJuego = new PantallaDelJuego();
    	GPS gps = new GPS();
    try {
        gps.cargarPartida(".\\partidas\\"+this.jugador.getNombre()+".xml");
        pantallaDelJuego.comenzarMiJuegoGuardado(gps.getVehiculo().getEstado(), gps.getDificultad() , this.jugador, gps);
        this.show(false);
    } catch (JAXBException | JuegoNoIniciado ex) {
        //Logger.getLogger(PantallaJugadorIniciado.class.getName()).log(Level.SEVERE, null, ex);
    }
    	
    }
    
    private void setNombreDelJugador(String nombreJugadorAIntroducir){
        labelNombreJugador.setText("Jugador: " +nombreJugadorAIntroducir);
    }

    private javax.swing.JButton botonAtras;
    private javax.swing.JButton botonContinuarPartida;
    private javax.swing.JButton botonNuevaPartida;
    private javax.swing.JButton botonPuntuacionesAltas;
    private javax.swing.JLabel labelNombreJugador;
    private javax.swing.JLabel tituloDelJuego;
  
}
