package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class VentanaAdministrador extends JFrame {

	private static VentanaAdministrador frameAdministrador;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAadirReceta;
	private JButton btnModificarReceta;
	private JButton btnEliminarReceta;
	private JScrollPane scrollPane;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frameAdministrador = new VentanaAdministrador();
					frameAdministrador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAdministrador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAdministrador.class.getResource("/Presentacion/logo.png")));
		setTitle("Administrar recetas");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 268, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 100, 100, 100, 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridheight = 4;
				gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 1;
				panel.add(scrollPane, gbc_scrollPane);
				{
					list = new JList();
					scrollPane.setViewportView(list);
				}
			}
			{
				btnAadirReceta = new JButton("A\u00F1adir receta");
				btnAadirReceta.addActionListener(new BtnAadirRecetaActionListener());
				GridBagConstraints gbc_btnAadirReceta = new GridBagConstraints();
				gbc_btnAadirReceta.fill = GridBagConstraints.BOTH;
				gbc_btnAadirReceta.insets = new Insets(0, 0, 5, 0);
				gbc_btnAadirReceta.gridx = 1;
				gbc_btnAadirReceta.gridy = 1;
				panel.add(btnAadirReceta, gbc_btnAadirReceta);
			}
			{
				btnModificarReceta = new JButton("Modificar receta");
				btnModificarReceta.addActionListener(new BtnModificarRecetaActionListener());
				GridBagConstraints gbc_btnModificarReceta = new GridBagConstraints();
				gbc_btnModificarReceta.fill = GridBagConstraints.BOTH;
				gbc_btnModificarReceta.insets = new Insets(0, 0, 5, 0);
				gbc_btnModificarReceta.gridx = 1;
				gbc_btnModificarReceta.gridy = 2;
				panel.add(btnModificarReceta, gbc_btnModificarReceta);
			}
			{
				btnEliminarReceta = new JButton("Eliminar receta");
				btnEliminarReceta.addActionListener(new BtnEliminarRecetaActionListener());
				GridBagConstraints gbc_btnEliminarReceta = new GridBagConstraints();
				gbc_btnEliminarReceta.insets = new Insets(0, 0, 5, 0);
				gbc_btnEliminarReceta.fill = GridBagConstraints.BOTH;
				gbc_btnEliminarReceta.gridx = 1;
				gbc_btnEliminarReceta.gridy = 3;
				panel.add(btnEliminarReceta, gbc_btnEliminarReceta);
			}
		}
	}

	private class BtnAadirRecetaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	private class BtnModificarRecetaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		}
	}

	private class BtnEliminarRecetaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int eleccion = JOptionPane.showOptionDialog(frameAdministrador, "¿Seguro que quieres eliminar la receta?",
					"Eliminar receta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		}
	}
}
