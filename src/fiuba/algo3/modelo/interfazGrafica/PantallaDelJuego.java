package fiuba.algo3.modelo.interfazGrafica;

import java.awt.GridBagLayout;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.xml.bind.JAXBException;

import fiuba.algo3.modelo.excepciones.JuegoNoIniciado;
import ar.uba.fi.algo3.titiritero.vista.Panel;


public class PantallaDelJuego extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	private Panel panel = null;
	private VistaJuego vista = null;


	private void comenzar() throws JuegoNoIniciado, JAXBException{
		this.vista = new VistaJuego(this.panel/*getSuperficieDeDibujo()*/);
		this.vista.agregarControladorDelTeclado(panel);
		this.vista.comenzar();
	}

	private Panel getSuperficieDeDibujo() {
		if (panel == null) {
			panel = new Panel(400,400);
			panel.setLayout(new GridBagLayout());
			panel.setBounds(new Rectangle(0, 0, 500, 500));
		}
		return panel;
	}

       
	public static void mainE() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				PantallaDelJuego thisClass = new PantallaDelJuego();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				thisClass.setVisible(true);
				try {
					thisClass.comenzar();
				} catch (JuegoNoIniciado e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JAXBException e) {
					// TODO Auto-generated catch block
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
		this.setSize(500,500);
		this.setContentPane(getJContentPane());
		this.setLocationRelativeTo(null);
		this.setTitle("GPS Challenge");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.out.println("windowClosing()"); // TODO Auto-generated Event stub windowClosing()
				System.exit(NORMAL);
			}
		});
	}
	
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getSuperficieDeDibujo(), null);
		}
		return jContentPane;
	}

} 