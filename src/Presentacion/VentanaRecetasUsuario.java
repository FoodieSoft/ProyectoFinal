package Presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dominio.GestorReceta;
import Dominio.Receta;

public class VentanaRecetasUsuario extends JFrame {
	public static String emailUsuario2;
	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JButton btnVisualizarReceta;
	private JButton btnEliminarReceta;
	private static JTable tableRecetasUsuario;
	private Vector<Receta> recetas = new Vector<Receta>();
	private static VentanaRecetasUsuario frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frame = new VentanaRecetasUsuario();
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
	public VentanaRecetasUsuario() {

		addWindowListener(new ThisWindowListener());
		setTitle("Recetas del usuario");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(VentanaRecetasUsuario.class.getResource("/Presentacion/logo.png")));
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 464, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 318, 0, 0 };
			gbl_panel.rowHeights = new int[] { 82, 66, 0, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridheight = 3;
				gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 0;
				gbc_scrollPane.gridy = 0;
				panel.add(scrollPane, gbc_scrollPane);
				{
					String[] nombreColumnas = { "Nombre", "Tipo de Comida" };

					DefaultTableModel modeloTabla = new DefaultTableModel(nombreColumnas, 0) {
						@Override
						public boolean isCellEditable(int row, int column) {
							// celdas no editables
							return false;
						}
					};
					tableRecetasUsuario = new JTable();
					tableRecetasUsuario.setAlignmentY(Component.TOP_ALIGNMENT);
					tableRecetasUsuario.setAlignmentX(Component.LEFT_ALIGNMENT);
					tableRecetasUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tableRecetasUsuario.setFillsViewportHeight(true);
					tableRecetasUsuario.setModel(new DefaultTableModel(

					));
					scrollPane.setViewportView(tableRecetasUsuario);
				}
			}
			{
				btnVisualizarReceta = new JButton("Visualizar receta");
				btnVisualizarReceta.addActionListener(new BtnVisualizarRecetaActionListener());
				GridBagConstraints gbc_btnVisualizarReceta = new GridBagConstraints();
				gbc_btnVisualizarReceta.insets = new Insets(0, 0, 5, 0);
				gbc_btnVisualizarReceta.gridx = 1;
				gbc_btnVisualizarReceta.gridy = 0;
				panel.add(btnVisualizarReceta, gbc_btnVisualizarReceta);
			}
			{
				btnEliminarReceta = new JButton("Eliminar receta");
				btnEliminarReceta.addActionListener(new BtnEliminarRecetaActionListener());
				GridBagConstraints gbc_btnEliminarReceta = new GridBagConstraints();
				gbc_btnEliminarReceta.insets = new Insets(0, 0, 5, 0);
				gbc_btnEliminarReceta.gridx = 1;
				gbc_btnEliminarReceta.gridy = 1;
				panel.add(btnEliminarReceta, gbc_btnEliminarReceta);
			}
		}
	}

	private class BtnVisualizarRecetaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				int indiceRecetaVisualizar = tableRecetasUsuario.getSelectedRow();
				JOptionPane.showMessageDialog(frame, recetas.elementAt(indiceRecetaVisualizar).toString());
			} catch (Exception e) {

			}

		}
	}

	private class BtnEliminarRecetaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			GestorReceta gestorReceta = new GestorReceta();
			try {
				int indiceRecetaEliminar = tableRecetasUsuario.getSelectedRow();
				int eleccion = JOptionPane.showOptionDialog(frame, "Seguro que quieres eliminar la receta?",
						"Eliminar receta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (eleccion == 0) {
					if (gestorReceta.eliminarRecetaUsuario(emailUsuario2,
							recetas.remove(indiceRecetaEliminar).getNombre()) == true) {
						JOptionPane.showMessageDialog(frame, "Receta eliminada");

					} else {
						JOptionPane.showMessageDialog(frame, "No se ha podido eliminar");
					}
				}
				actualizarRecetasLista();
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
				System.out.println(e1.toString());
			}
		}
	}

	private void actualizarRecetasLista() throws SQLException, Exception {

		GestorReceta gestRec = new GestorReceta();
		String[] nombreColumnas = { "Nombre", "Tipo de Comida" };
		@SuppressWarnings("serial")
		DefaultTableModel modeloTabla = new DefaultTableModel(nombreColumnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// celdas no editables
				return false;
			}
		};
		try {
			Vector<String> nombreRecetas = gestRec.leerRecetasUsuario(emailUsuario2);

			for (int i = 0; i < nombreRecetas.size(); i++) {
				String nombreReceta = nombreRecetas.elementAt(i).toString();
				String tipo = null;
				Receta receta = gestRec.RecetaCompletaUsuario(nombreReceta);
				recetas.add(receta);
				switch (recetas.elementAt(i).getTipo()) {
				case 1:
					tipo = "Desayuno";
					break;
				case 2:
					tipo = "Almuerzo";
					break;
				case 3:
					tipo = "Comida";
					break;
				case 4:
					tipo = "Merienda";
					break;
				case 5:
					tipo = "Cena";
					break;
				}
				Object[] data = { nombreRecetas.elementAt(i).toString(), tipo };
				modeloTabla.addRow(data);
			}
			tableRecetasUsuario.setModel(modeloTabla);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

}