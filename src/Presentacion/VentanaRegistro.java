package Presentacion;

import java.awt.BorderLayout;
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
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private static VentanaRegistro registro;
	private JPanel contentPane;
	private JLabel lblIntroduzcaSuCorreo;
	private JTextField txtCorreo;
	private JLabel lblIntroduzcaUnaContrasea;
	private JLabel lblVuelvaAIntroducir;
	private JPasswordField pasword1;
	private JPasswordField pasword2;
	private JButton btnRegistrar;
	
	
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
			txtCorreo = new JTextField();
			txtCorreo.setBounds(46, 42, 334, 22);
			contentPane.add(txtCorreo);
			txtCorreo.setColumns(10);
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
			pasword1 = new JPasswordField();
			pasword1.setToolTipText("Introducir la contrase\u00F1a para acceder a la agenda");
			pasword1.setBounds(216, 90, 164, 22);
			contentPane.add(pasword1);
		}
		{
			pasword2 = new JPasswordField();
			pasword2.setToolTipText("Introducir la contrase\u00F1a para acceder a la agenda");
			pasword2.setBounds(216, 132, 164, 22);
			contentPane.add(pasword2);
		}
		{
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.setBounds(283, 172, 97, 30);
			contentPane.add(btnRegistrar);
		}
	}
	
}
