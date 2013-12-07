package fiuba.algo3.modelo.interfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.xml.bind.JAXBException;

import fiuba.algo3.controlador.ContadorDeCantidadDeMovimientos;
import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import ar.uba.fi.algo3.titiritero.vista.Panel;
import fiuba.algo3.modelo.dificultad.Dificultad;
import fiuba.algo3.modelo.juego.GPS;
//import fiuba.algo3.modelo.juego.GPS;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.mapa.Ciudad;
import fiuba.algo3.modelo.serializacion.SerializacionCiudad;
import fiuba.algo3.modelo.vehiculo.EstadoVehiculo;
import fiuba.algo3.modelo.vehiculo.Moto;
import fiuba.algo3.modelo.vehiculo.Vehiculo;


public class PantallaDelJuego extends JFrame implements ContadorDeCantidadDeMovimientos  {
	
	
	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	private Panel panel = null;
	private VistaJuego vista = null;
	private JPanel jPanelEstado = null;
	private JLabel jLabelMovimientos = null;
	private JLabel jLabelMovimientosActuales = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;  
	private JButton jBotonDeGuardarPartida = null; 
        

	private void comenzar(EstadoVehiculo vehiculoRecibido, Dificultad dificultadRecibida, Jugador jugadorRecibido) throws JuegoNoIniciado, JAXBException{
            
        this.vista = new VistaJuego(this.panel, vehiculoRecibido, dificultadRecibida, jugadorRecibido);		
                
		this.vista.agregarControladorDelTeclado(panel);
		this.vista.agregarObservadorDeMovimientos(this);
		this.vista.comenzar();                
	}
	
	private void comenzarJuegoGuardado(GPS gps) throws JuegoNoIniciado, JAXBException{
        
        this.vista = new VistaJuego(this.panel, gps);		
                
		this.vista.agregarControladorDelTeclado(panel);
		this.vista.agregarObservadorDeMovimientos(this);
		this.vista.comenzar();                
	}

	private Panel getSuperficieDeDibujo() {
		if (panel == null) {
			panel = new Panel(400,400);
			panel.setLayout(new GridBagLayout());
			panel.setBounds(new Rectangle(0, 0,500,500));
		}
		return panel;
	}

       
	public void comenzarMiJuego(final EstadoVehiculo vehiculoRecibido, final Dificultad dificultadRecibida, final Jugador jugadorRecibido) {
            
                
		SwingUtilities.invokeLater(new Runnable() {
                   
			public void run() {
				PantallaDelJuego thisClass = new PantallaDelJuego();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				thisClass.setVisible(true);
				try {
					thisClass.comenzar(vehiculoRecibido, dificultadRecibida, jugadorRecibido);
				} catch (JuegoNoIniciado e) {
					e.printStackTrace();
				} catch (JAXBException e) {
					e.printStackTrace();
				}
                               
                              
			}
		});
	}
	
	public void comenzarMiJuegoGuardado(final EstadoVehiculo vehiculoRecibido, final Dificultad dificultadRecibida, final Jugador jugadorRecibido, final GPS gps) {
        
        
		SwingUtilities.invokeLater(new Runnable() {
                   
			public void run() {
				PantallaDelJuego thisClass = new PantallaDelJuego();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				thisClass.setVisible(true);
				try {
					thisClass.comenzarJuegoGuardado(gps);
				} catch (JuegoNoIniciado e) {
					e.printStackTrace();
				} catch (JAXBException e) {
					e.printStackTrace();
				}
                               
                              
			}
		});
	}

	public PantallaDelJuego() {
            
               	super();                
		initialize();
	}

        
	private void initialize() {
		this.setResizable(false);
		//this.setSize(700,529);
		//this.setSize(800,550);
		this.setSize(509,631);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setTitle("GPS Challenge");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(NORMAL);
			}
		});
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getSuperficieDeDibujo(), null);
			jContentPane.add(getJPanelEstado(), null);
		}
		return jContentPane;
	}

	private JPanel getJPanelEstado() {
		if (jPanelEstado == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 1;
			gridBagConstraints1.gridy = -3;
			jLabelMovimientos = new JLabel();
			jLabelMovimientos.setText("0");
			
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = -3;
			jLabel = new JLabel();
			jLabel.setText("Limite de movimientos: ");
			jLabel.setForeground(Color.red);
			jLabel.setFont(new Font("Serif", Font.BOLD, 18)); 
			
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 1;
			gridBagConstraints2.gridy = 0;
			jLabelMovimientosActuales = new JLabel();
			jLabelMovimientosActuales.setText("0");
			
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 0;
			jLabel1 = new JLabel();
			jLabel1.setText("Cantidad de movimientos: ");
			jLabel1.setForeground(Color.blue);
			jLabel1.setFont(new Font("", 0, 16)); 

			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 0;
			jBotonDeGuardarPartida = new JButton();
			jBotonDeGuardarPartida.setText("Guardar Partida");
			jBotonDeGuardarPartida.setForeground(Color.blue);
			jLabel1.setFont(new Font("", 0, 16)); 

			
			jPanelEstado = new JPanel();
			jPanelEstado.setLayout(new GridBagLayout());
			
			
			jPanelEstado.setBounds(new Rectangle(0, 500, 509, 100));
			jPanelEstado.add(jLabel, gridBagConstraints);
			jPanelEstado.add(jLabelMovimientos, gridBagConstraints1);
			jPanelEstado.add(jLabel1, gridBagConstraints3);
			jPanelEstado.add(jLabelMovimientosActuales, gridBagConstraints2);
			jPanelEstado.add(jBotonDeGuardarPartida, gridBagConstraints4);
			

			jBotonDeGuardarPartida.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	            	jBotonDeGuardarPartidaActionPerformed(evt);
	            }
	        });

		}
		return jPanelEstado;
	}
	
	@Override
	public void seActualizaronLosMovimientos(int movimientosTotales) {
		this.jLabelMovimientosActuales.setText(String.valueOf(movimientosTotales));
                
	}

	@Override
	public void maximoDeMovimientos(int movimientosMaximo) {
		this.jLabelMovimientos.setText(String.valueOf(movimientosMaximo));
	}
	
	
	private void jBotonDeGuardarPartidaActionPerformed(
			ActionEvent evt) {
		this.vista.salvarPartida();
		System.exit(NORMAL);
	}

    //private void getGPS() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

} 