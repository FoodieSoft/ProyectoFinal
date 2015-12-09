package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Dominio.GestorReceta;
import Dominio.Receta;

public class VentanaAdministrador extends JFrame {

	private static VentanaAdministrador frameAdministrador;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnAadirReceta;
	private JButton btnModificarReceta;
	private JButton btnEliminarReceta;
	private JScrollPane scrollPane;
	private static JList listaRecetas;
	private VentanaReceta ventanaReceta;
	private GestorReceta gestorReceta = new GestorReceta();

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
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(new ThisWindowListener());
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaAdministrador.class.getResource("/Presentacion/logo.png")));
		setTitle("Administrar recetas");
		setResizable(false);
		setBounds(100, 100, 400, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 202, 0, 0 };
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
					listaRecetas = new JList();
					DefaultListModel modeloLista = new DefaultListModel();
					listaRecetas.setModel(modeloLista);
					scrollPane.setViewportView(listaRecetas);

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
			ventanaReceta = new VentanaReceta();
			ventanaReceta.setVisible(true);
			ventanaReceta.aniadirReceta = true;
			VentanaReceta.nombreReceta = null;
		}
	}

	private class BtnModificarRecetaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				// Seleccionamos el la receta a modificar
				int indiceRecetaModificar = listaRecetas.getSelectedIndex();
				DefaultListModel modeloLista = (DefaultListModel) listaRecetas.getModel();

				// Lo eliminamos de la lista
				String recetaModificar = modeloLista.getElementAt(indiceRecetaModificar).toString();

				ventanaReceta = new VentanaReceta();
				ventanaReceta.setVisible(true);
				ventanaReceta.aniadirReceta = false;
				VentanaReceta.nombreReceta = recetaModificar;

			} catch (Exception e) {

			}

		}
	}

	private class BtnEliminarRecetaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				// Seleccionamos el nodo a eliminar
				int indiceRecetaEliminar = listaRecetas.getSelectedIndex();
				DefaultListModel modeloLista = (DefaultListModel) listaRecetas.getModel();

				try {

					// Lo eliminamos de la lista
					String recetaEliminar = modeloLista.getElementAt(indiceRecetaEliminar).toString();
					int eleccion = JOptionPane.showOptionDialog(frameAdministrador,
							"¿Seguro que quieres eliminar la receta?", "Eliminar receta", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
					if (eleccion == 0) {
						if (gestorReceta.eliminarReceta(recetaEliminar) == true) {
							JOptionPane.showMessageDialog(frameAdministrador, "Receta eliminada");
						} else {
							JOptionPane.showMessageDialog(frameAdministrador, "Receta no eliminada");
						}
					}

					actualizarRecetasLista();
				} catch (Exception e) {
				}

			} catch (Exception e) {

			}
		}
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowActivated(WindowEvent e) {
			try {
				actualizarRecetasLista();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private static void actualizarRecetasLista() throws SQLException, Exception {

		DefaultListModel modeloLista = (DefaultListModel) listaRecetas.getModel();
		modeloLista.clear();
		GestorReceta gestorReceta = new GestorReceta();

		Vector<Receta> recetas = gestorReceta.leerRecetas();

		for (int i = 0; i < recetas.size(); i++) {

			modeloLista.addElement(recetas.elementAt(i).getNombre());
		}

		listaRecetas.setModel(modeloLista);

	}
}