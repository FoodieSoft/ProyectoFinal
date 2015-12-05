package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaMenuUsuario extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JPanel panel;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JTextArea txt;
	private JTextArea textArea_1;
	private JTextArea textArea_2;
	private JTextArea textArea_3;
	private JTextArea textArea_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenuUsuario frame = new VentanaMenuUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMenuUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaMenuUsuario.class.getResource("/Presentacion/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 632);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnArchivo = new JMenu("Archivo");
				menuBar.add(mnArchivo);
				{
					mntmSalir = new JMenuItem("Salir");
					mnArchivo.add(mntmSalir);
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{248, 0, 0};
			gbl_panel.rowHeights = new int[]{100, 100, 100, 100, 100, 96, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			{
				txt = new JTextArea();
				GridBagConstraints gbc_txt = new GridBagConstraints();
				gbc_txt.insets = new Insets(0, 0, 5, 0);
				gbc_txt.fill = GridBagConstraints.BOTH;
				gbc_txt.gridx = 1;
				gbc_txt.gridy = 0;
				panel.add(txt, gbc_txt);
			}
			{
				textArea_1 = new JTextArea();
				GridBagConstraints gbc_textArea_1 = new GridBagConstraints();
				gbc_textArea_1.insets = new Insets(0, 0, 5, 0);
				gbc_textArea_1.fill = GridBagConstraints.BOTH;
				gbc_textArea_1.gridx = 1;
				gbc_textArea_1.gridy = 1;
				panel.add(textArea_1, gbc_textArea_1);
			}
			{
				textArea_2 = new JTextArea();
				GridBagConstraints gbc_textArea_2 = new GridBagConstraints();
				gbc_textArea_2.insets = new Insets(0, 0, 5, 0);
				gbc_textArea_2.fill = GridBagConstraints.BOTH;
				gbc_textArea_2.gridx = 1;
				gbc_textArea_2.gridy = 2;
				panel.add(textArea_2, gbc_textArea_2);
			}
			{
				textArea_3 = new JTextArea();
				GridBagConstraints gbc_textArea_3 = new GridBagConstraints();
				gbc_textArea_3.insets = new Insets(0, 0, 5, 0);
				gbc_textArea_3.fill = GridBagConstraints.BOTH;
				gbc_textArea_3.gridx = 1;
				gbc_textArea_3.gridy = 3;
				panel.add(textArea_3, gbc_textArea_3);
			}
			{
				textArea_4 = new JTextArea();
				GridBagConstraints gbc_textArea_4 = new GridBagConstraints();
				gbc_textArea_4.insets = new Insets(0, 0, 5, 0);
				gbc_textArea_4.fill = GridBagConstraints.BOTH;
				gbc_textArea_4.gridx = 1;
				gbc_textArea_4.gridy = 4;
				panel.add(textArea_4, gbc_textArea_4);
			}
		}
	}

}
