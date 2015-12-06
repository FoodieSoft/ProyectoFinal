package Presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class VentanaRegistro extends JFrame {

	private static VentanaRegistro registro;
	private JPanel contentPane;
	private JLabel lblIntroduzcaSuCorreo;
	private JTextField txtCorreo;
	private JLabel lblIntroduzcaUnaContrasea;
	private JLabel lblVuelvaAIntroducir;
	private JPasswordField pwd1;
	private JPasswordField pwd2;
	private JButton btnRegistrar;
	private JLabel lblAvisos;
	private boolean puedeRegistrar=false;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registro = new VentanaRegistro();
					registro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistro() {
		setTitle("Registrar usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/Presentacion/logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblIntroduzcaSuCorreo = new JLabel("Introduzca su correo electronico:");
			lblIntroduzcaSuCorreo.setBounds(12, 13, 280, 16);
			contentPane.add(lblIntroduzcaSuCorreo);
		}
		{
			lblIntroduzcaUnaContrasea = new JLabel("Introduzca una contrase\u00F1a:");
			lblIntroduzcaUnaContrasea.setBounds(12, 93, 192, 16);
			contentPane.add(lblIntroduzcaUnaContrasea);
		}
		{
			lblVuelvaAIntroducir = new JLabel("Vuelva a introducir la contrase\u00F1a:");
			lblVuelvaAIntroducir.setBounds(12, 135, 204, 16);
			contentPane.add(lblVuelvaAIntroducir);
		}
		{
			txtCorreo = new JTextField();
			txtCorreo.addFocusListener(new MiFocusListener());
			txtCorreo.setBounds(46, 42, 334, 22);
			contentPane.add(txtCorreo);
			txtCorreo.setColumns(10);
		}
		{
			pwd1 = new JPasswordField();
			pwd1.addFocusListener(new MiFocusListener());
			pwd1.setToolTipText("Introducir la contrase\u00F1a para acceder a la agenda");
			pwd1.setBounds(216, 90, 164, 22);
			contentPane.add(pwd1);
		}
		{
			pwd2 = new JPasswordField();
			pwd2.addKeyListener(new Pwd2KeyListener());
			pwd2.addFocusListener(new MiFocusListener());
			pwd2.setToolTipText("Introducir la contrase\u00F1a para acceder a la agenda");
			pwd2.setBounds(216, 132, 164, 22);
			contentPane.add(pwd2);
		}
		{
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new BtnRegistrarActionListener());
			btnRegistrar.setBounds(283, 172, 97, 30);
			contentPane.add(btnRegistrar);
		}
		{
			lblAvisos = new JLabel("");
			lblAvisos.setHorizontalAlignment(SwingConstants.CENTER);
			lblAvisos.setOpaque(true);
			lblAvisos.setBounds(12, 173, 259, 29);
			contentPane.add(lblAvisos);
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
	
	private class Pwd2KeyListener extends KeyAdapter {
		
		
		@Override
		//Comprobamos que las contraseñas introducidas son iguales
		public void keyReleased(KeyEvent e) {
			if(!pwd2.getText().equals(pwd1.getText())){
				pwd2.setBackground(Color.RED);
				puedeRegistrar=false;
			}else{
				pwd2.setBackground(Color.GREEN);
				puedeRegistrar=true;
			}
		}
	}
	private class BtnRegistrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			try{
			//Comprobamos que los campos no esten vacios
			if(txtCorreo.getText().isEmpty() || pwd2.getText().isEmpty() || puedeRegistrar==false){
				lblAvisos.setText("Introduzca un correo y contraseñas validas");
				lblAvisos.setBackground(Color.RED);
			}else{
				
				//Registramos al usuario
				
				lblAvisos.setText("Correcto");
				lblAvisos.setBackground(Color.GREEN);
			}
			}catch(Exception arg0){
				System.out.println(arg0.getMessage());
			}
		}
	}
}
