package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaRecetasUsuario extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JButton btnVisualizarReceta;
	private JButton btnEliminarReceta;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRecetasUsuario frame = new VentanaRecetasUsuario();
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
		setTitle("Recetas del usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRecetasUsuario.class.getResource("/Presentacion/logo.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{318, 0, 0};
			gbl_panel.rowHeights = new int[]{82, 66, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
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
					table = new JTable();
					table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Nombre", "Tipo de comida"
						}
					));
					scrollPane.setViewportView(table);
				}
			}
			{
				btnVisualizarReceta = new JButton("Visualizar receta");
				GridBagConstraints gbc_btnVisualizarReceta = new GridBagConstraints();
				gbc_btnVisualizarReceta.insets = new Insets(0, 0, 5, 0);
				gbc_btnVisualizarReceta.gridx = 1;
				gbc_btnVisualizarReceta.gridy = 0;
				panel.add(btnVisualizarReceta, gbc_btnVisualizarReceta);
			}
			{
				btnEliminarReceta = new JButton("Eliminar receta");
				GridBagConstraints gbc_btnEliminarReceta = new GridBagConstraints();
				gbc_btnEliminarReceta.insets = new Insets(0, 0, 5, 0);
				gbc_btnEliminarReceta.gridx = 1;
				gbc_btnEliminarReceta.gridy = 1;
				panel.add(btnEliminarReceta, gbc_btnEliminarReceta);
			}
		}
	}

}
