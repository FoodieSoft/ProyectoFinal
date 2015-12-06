package Presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Dominio.Cliente;
import Dominio.GestorCliente;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class Login extends JFrame {
	
	private VentanaRegistro registro= new VentanaRegistro();
	private static Login frame;
	private JPanel contentPane;
	private JTextField tftUsuario;
	private JButton btnAceptar;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JPasswordField tftContrasena;
	private JLabel lblInfo;
	private JLabel lblLogo;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Presentacion/logo.png")));
		setTitle("TodayEAT - Acceso");
		setResizable(false);
		setBounds(100, 100, 500, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			tftUsuario = new JTextField();
			tftUsuario.addFocusListener(new MiFocusListener());
			tftUsuario.addActionListener(new TftUsuarioActionListener());
			tftUsuario.setToolTipText("Introducir el usuario para acceder a la agenda");
			tftUsuario.setBounds(311, 48, 164, 22);
			contentPane.add(tftUsuario);
			tftUsuario.setColumns(10);
		}
		{
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setToolTipText("Acceder a la aplicaci\u00F3n");
			btnAceptar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {

					// Comprobamos que los campos id y contraseña no esten
					// vacios
					if (String.valueOf(tftContrasena.getPassword()).isEmpty() || tftUsuario.getText().isEmpty()) {
						lblInfo.setText("Introduzca su usuario y contraseña");
						lblInfo.setBackground(Color.RED);

					} else {

						// Creamos un usuario con un nombre y una contraseña
						//Cliente cliente= new Cliente(tftUsuario.getText(), tftContrasena.getText());
						GestorCliente gestorCliente=new GestorCliente();
						
						try {

							// Buscamos ese usuario en la base de datos
							switch(gestorCliente.autenticar(tftUsuario.getText(),tftContrasena.getText())) {
								
							case "usuario":
								VentanaMenuUsuario usur=new VentanaMenuUsuario();
								usur.setVisible(true);
								usur.setLocationRelativeTo(null);
								
								
							case "administrador":
								
//								InterfazGestor gestor = new InterfazGestor();
//								gestor.setVisible(true);
//								gestor.setLocationRelativeTo(null);
//								gestor.usuario=usuario;

								// Cerramos el login
								frame.dispose();

							default:

								lblInfo.setText("Usuario o contraseña incorrecta");
								lblInfo.setBackground(Color.RED);
								//lblInfo.setText("Registrese para poder utilizar la aplicación");
							}

						} catch (Exception e) {
							lblInfo.setText("Usuario o contraseña incorrectA");
							lblInfo.setBackground(Color.RED);
							System.out.println(e.getMessage());
						}

					}
				}
			});
			btnAceptar.setBounds(355, 189, 120, 40);
			contentPane.add(btnAceptar);
		}
		{
			JButton btnCancelar = new JButton("Cerrar");
			btnCancelar.setToolTipText("Cerrar acceso");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnCancelar.setBounds(223, 189, 120, 40);
			contentPane.add(btnCancelar);
		}
		{
			JButton btnRegistrar = new JButton("Registrar");
			btnRegistrar.setForeground(new Color(255, 0, 0));
			btnRegistrar.addActionListener(new ButtonActionListener());
			btnRegistrar.setToolTipText("Registrarse en la aplicaci\u00F3n");
			btnRegistrar.setBounds(46, 192, 120, 40);
			contentPane.add(btnRegistrar);
		}
		{
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblUsuario.setBounds(243, 50, 56, 16);
			contentPane.add(lblUsuario);
		}
		{
			lblContrasena = new JLabel("Contrase\u00F1a");
			lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblContrasena.setBounds(217, 107, 82, 16);
			contentPane.add(lblContrasena);
		}
		{
			lblInfo = new JLabel("");
			lblInfo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
			lblInfo.setOpaque(true);
			lblInfo.setBounds(217, 136, 258, 40);
			contentPane.add(lblInfo);
		}
		{
			lblLogo = new JLabel("");
			lblLogo.setToolTipText("Aplicacion creada por FoodieSoft");
			lblLogo.setIcon(new ImageIcon(Login.class.getResource("/presentacion/logo.png")));
			lblLogo.setBounds(30, 18, 150, 158);
			contentPane.add(lblLogo);
		}
		{
			tftContrasena = new JPasswordField();
			tftContrasena.addActionListener(new TftContrasenaActionListener());
			tftContrasena.addFocusListener(new MiFocusListener());
			tftContrasena.setToolTipText("Introducir la contrase\u00F1a para acceder a la agenda");
			tftContrasena.setBounds(311, 101, 164, 22);
			contentPane.add(tftContrasena);
		}
	}

	private class TftUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			tftContrasena.requestFocus();
		}
	}

	private class TftContrasenaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnAceptar.requestFocus();
		}
	}

	private class MiFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			e.getComponent().setBackground(new Color(250, 250, 210));
		}

		@Override
		public void focusLost(FocusEvent e) {
			e.getComponent().setBackground(new Color(250, 250, 250));
		}
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
			registro.setVisible(true);
			registro.setLocationRelativeTo(null);
			
		}
	}
}
