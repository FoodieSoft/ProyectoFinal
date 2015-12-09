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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Dominio.GestorReceta;
import Dominio.Receta;

public class VentanaReceta extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblCantidadIngrendiente;
	private JLabel lblCantidadIngrediente;
	private JLabel lblCantidadIngrediente_1;
	private JLabel lblCantidadIngrediente_2;
	private JLabel lblCantidadIngrediente_3;
	private JLabel lblCantidadIngrediente_4;
	private JLabel lblIngrediente;
	private JLabel lblIngrediente_1;
	private JLabel lblIngrediente_2;
	private JLabel lblIngrediente_3;
	private JLabel lblIngrediente_4;
	private JLabel lblIngrediente_5;
	private JLabel lblNombre;
	private JLabel lblTipoDeComida;
	private JLabel lblPreparacion;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private static JTextField txtNombre;
	private static JComboBox cbTipoComida;
	private static JTextField txtCantidadIng1;
	private static JTextField txtCantidadIng2;
	private static JTextField txtCantidadIng3;
	private static JTextField txtCantidadIng4;
	private static JTextField txtCantidadIng5;
	private static JTextField txtCantidadIng6;
	private static JTextField txtIng2;
	private static JTextField txtIng1;
	private static JTextField txtIng3;
	private static JTextField txtIng4;
	private static JTextField txtIng5;
	private static JTextField txtIng6;
	private static JTextArea txtDescripcion;
	private static VentanaReceta frameVentanaReceta;

	// Variable que nos permitira saber si va a modificar la receta o aniadirla
	public boolean aniadirReceta = true;

	// Si queremos modificar una receta le pasamos el nombre
	public static String nombreReceta = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frameVentanaReceta = new VentanaReceta();
					frameVentanaReceta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaReceta() {
		setTitle("Recetas");
		addWindowListener(new ThisWindowListener());
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReceta.class.getResource("/Presentacion/logo.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 746, 710);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 153, 79, 104, 213, 70, 50, 0, 0 };
			gbl_panel.rowHeights = new int[] { 50, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0,
					Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				lblNombre = new JLabel("Nombre");
				GridBagConstraints gbc_lblNombre = new GridBagConstraints();
				gbc_lblNombre.anchor = GridBagConstraints.EAST;
				gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
				gbc_lblNombre.gridx = 0;
				gbc_lblNombre.gridy = 0;
				panel.add(lblNombre, gbc_lblNombre);
			}
			{
				txtNombre = new JTextField();
				GridBagConstraints gbc_txtNombre = new GridBagConstraints();
				gbc_txtNombre.gridwidth = 2;
				gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
				gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtNombre.gridx = 1;
				gbc_txtNombre.gridy = 0;
				panel.add(txtNombre, gbc_txtNombre);
				txtNombre.setColumns(10);
			}
			{
				lblTipoDeComida = new JLabel("Tipo de comida");
				GridBagConstraints gbc_lblTipoDeComida = new GridBagConstraints();
				gbc_lblTipoDeComida.anchor = GridBagConstraints.EAST;
				gbc_lblTipoDeComida.insets = new Insets(0, 0, 5, 5);
				gbc_lblTipoDeComida.gridx = 0;
				gbc_lblTipoDeComida.gridy = 1;
				panel.add(lblTipoDeComida, gbc_lblTipoDeComida);
			}
			{
				cbTipoComida = new JComboBox();
				cbTipoComida.setModel(new DefaultComboBoxModel(
						new String[] { "Desayuno", "Almuerzo", "Comida", "Merienda", "Cena" }));
				GridBagConstraints gbc_cbTipoComida = new GridBagConstraints();
				gbc_cbTipoComida.gridwidth = 2;
				gbc_cbTipoComida.insets = new Insets(0, 0, 5, 5);
				gbc_cbTipoComida.fill = GridBagConstraints.HORIZONTAL;
				gbc_cbTipoComida.gridx = 1;
				gbc_cbTipoComida.gridy = 1;
				panel.add(cbTipoComida, gbc_cbTipoComida);
			}
			{
				lblCantidadIngrendiente = new JLabel("Cantidad ingrediente");
				GridBagConstraints gbc_lblCantidadIngrendiente = new GridBagConstraints();
				gbc_lblCantidadIngrendiente.anchor = GridBagConstraints.EAST;
				gbc_lblCantidadIngrendiente.insets = new Insets(0, 0, 5, 5);
				gbc_lblCantidadIngrendiente.gridx = 0;
				gbc_lblCantidadIngrendiente.gridy = 2;
				panel.add(lblCantidadIngrendiente, gbc_lblCantidadIngrendiente);
			}
			{
				txtCantidadIng1 = new JTextField();
				GridBagConstraints gbc_txtCantidadIng1 = new GridBagConstraints();
				gbc_txtCantidadIng1.insets = new Insets(0, 0, 5, 5);
				gbc_txtCantidadIng1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCantidadIng1.gridx = 1;
				gbc_txtCantidadIng1.gridy = 2;
				panel.add(txtCantidadIng1, gbc_txtCantidadIng1);
				txtCantidadIng1.setColumns(10);
			}
			{
				lblIngrediente = new JLabel("Ingrediente");
				GridBagConstraints gbc_lblIngrediente = new GridBagConstraints();
				gbc_lblIngrediente.anchor = GridBagConstraints.EAST;
				gbc_lblIngrediente.insets = new Insets(0, 0, 5, 5);
				gbc_lblIngrediente.gridx = 2;
				gbc_lblIngrediente.gridy = 2;
				panel.add(lblIngrediente, gbc_lblIngrediente);
			}
			{
				txtIng1 = new JTextField();
				GridBagConstraints gbc_txtIng1 = new GridBagConstraints();
				gbc_txtIng1.gridwidth = 2;
				gbc_txtIng1.insets = new Insets(0, 0, 5, 5);
				gbc_txtIng1.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtIng1.gridx = 3;
				gbc_txtIng1.gridy = 2;
				panel.add(txtIng1, gbc_txtIng1);
				txtIng1.setColumns(10);
			}
			{
				lblCantidadIngrediente = new JLabel("Cantidad ingrediente");
				GridBagConstraints gbc_lblCantidadIngrediente = new GridBagConstraints();
				gbc_lblCantidadIngrediente.anchor = GridBagConstraints.EAST;
				gbc_lblCantidadIngrediente.insets = new Insets(0, 0, 5, 5);
				gbc_lblCantidadIngrediente.gridx = 0;
				gbc_lblCantidadIngrediente.gridy = 3;
				panel.add(lblCantidadIngrediente, gbc_lblCantidadIngrediente);
			}
			{
				txtCantidadIng2 = new JTextField();
				GridBagConstraints gbc_txtCantidadIng2 = new GridBagConstraints();
				gbc_txtCantidadIng2.insets = new Insets(0, 0, 5, 5);
				gbc_txtCantidadIng2.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCantidadIng2.gridx = 1;
				gbc_txtCantidadIng2.gridy = 3;
				panel.add(txtCantidadIng2, gbc_txtCantidadIng2);
				txtCantidadIng2.setColumns(10);
			}
			{
				lblIngrediente_1 = new JLabel("Ingrediente");
				GridBagConstraints gbc_lblIngrediente_1 = new GridBagConstraints();
				gbc_lblIngrediente_1.anchor = GridBagConstraints.EAST;
				gbc_lblIngrediente_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblIngrediente_1.gridx = 2;
				gbc_lblIngrediente_1.gridy = 3;
				panel.add(lblIngrediente_1, gbc_lblIngrediente_1);
			}
			{
				txtIng2 = new JTextField();
				GridBagConstraints gbc_txtIng2 = new GridBagConstraints();
				gbc_txtIng2.gridwidth = 2;
				gbc_txtIng2.insets = new Insets(0, 0, 5, 5);
				gbc_txtIng2.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtIng2.gridx = 3;
				gbc_txtIng2.gridy = 3;
				panel.add(txtIng2, gbc_txtIng2);
				txtIng2.setColumns(10);
			}
			{
				lblCantidadIngrediente_1 = new JLabel("Cantidad ingrediente");
				GridBagConstraints gbc_lblCantidadIngrediente_1 = new GridBagConstraints();
				gbc_lblCantidadIngrediente_1.anchor = GridBagConstraints.EAST;
				gbc_lblCantidadIngrediente_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblCantidadIngrediente_1.gridx = 0;
				gbc_lblCantidadIngrediente_1.gridy = 4;
				panel.add(lblCantidadIngrediente_1, gbc_lblCantidadIngrediente_1);
			}
			{
				txtCantidadIng3 = new JTextField();
				GridBagConstraints gbc_txtCantidadIng3 = new GridBagConstraints();
				gbc_txtCantidadIng3.insets = new Insets(0, 0, 5, 5);
				gbc_txtCantidadIng3.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCantidadIng3.gridx = 1;
				gbc_txtCantidadIng3.gridy = 4;
				panel.add(txtCantidadIng3, gbc_txtCantidadIng3);
				txtCantidadIng3.setColumns(10);
			}
			{
				lblIngrediente_2 = new JLabel("Ingrediente");
				GridBagConstraints gbc_lblIngrediente_2 = new GridBagConstraints();
				gbc_lblIngrediente_2.anchor = GridBagConstraints.EAST;
				gbc_lblIngrediente_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblIngrediente_2.gridx = 2;
				gbc_lblIngrediente_2.gridy = 4;
				panel.add(lblIngrediente_2, gbc_lblIngrediente_2);
			}
			{
				txtIng3 = new JTextField();
				GridBagConstraints gbc_txtIng3 = new GridBagConstraints();
				gbc_txtIng3.gridwidth = 2;
				gbc_txtIng3.insets = new Insets(0, 0, 5, 5);
				gbc_txtIng3.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtIng3.gridx = 3;
				gbc_txtIng3.gridy = 4;
				panel.add(txtIng3, gbc_txtIng3);
				txtIng3.setColumns(10);
			}
			{
				lblCantidadIngrediente_2 = new JLabel("Cantidad ingrediente");
				GridBagConstraints gbc_lblCantidadIngrediente_2 = new GridBagConstraints();
				gbc_lblCantidadIngrediente_2.anchor = GridBagConstraints.EAST;
				gbc_lblCantidadIngrediente_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblCantidadIngrediente_2.gridx = 0;
				gbc_lblCantidadIngrediente_2.gridy = 5;
				panel.add(lblCantidadIngrediente_2, gbc_lblCantidadIngrediente_2);
			}
			{
				txtCantidadIng4 = new JTextField();
				GridBagConstraints gbc_txtCantidadIng4 = new GridBagConstraints();
				gbc_txtCantidadIng4.insets = new Insets(0, 0, 5, 5);
				gbc_txtCantidadIng4.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCantidadIng4.gridx = 1;
				gbc_txtCantidadIng4.gridy = 5;
				panel.add(txtCantidadIng4, gbc_txtCantidadIng4);
				txtCantidadIng4.setColumns(10);
			}
			{
				lblIngrediente_3 = new JLabel("Ingrediente");
				GridBagConstraints gbc_lblIngrediente_3 = new GridBagConstraints();
				gbc_lblIngrediente_3.anchor = GridBagConstraints.EAST;
				gbc_lblIngrediente_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblIngrediente_3.gridx = 2;
				gbc_lblIngrediente_3.gridy = 5;
				panel.add(lblIngrediente_3, gbc_lblIngrediente_3);
			}
			{
				txtIng4 = new JTextField();
				GridBagConstraints gbc_txtIng4 = new GridBagConstraints();
				gbc_txtIng4.gridwidth = 2;
				gbc_txtIng4.insets = new Insets(0, 0, 5, 5);
				gbc_txtIng4.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtIng4.gridx = 3;
				gbc_txtIng4.gridy = 5;
				panel.add(txtIng4, gbc_txtIng4);
				txtIng4.setColumns(10);
			}
			{
				lblCantidadIngrediente_3 = new JLabel("Cantidad ingrediente");
				GridBagConstraints gbc_lblCantidadIngrediente_3 = new GridBagConstraints();
				gbc_lblCantidadIngrediente_3.anchor = GridBagConstraints.EAST;
				gbc_lblCantidadIngrediente_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblCantidadIngrediente_3.gridx = 0;
				gbc_lblCantidadIngrediente_3.gridy = 6;
				panel.add(lblCantidadIngrediente_3, gbc_lblCantidadIngrediente_3);
			}
			{
				txtCantidadIng5 = new JTextField();
				GridBagConstraints gbc_txtCantidadIng5 = new GridBagConstraints();
				gbc_txtCantidadIng5.insets = new Insets(0, 0, 5, 5);
				gbc_txtCantidadIng5.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCantidadIng5.gridx = 1;
				gbc_txtCantidadIng5.gridy = 6;
				panel.add(txtCantidadIng5, gbc_txtCantidadIng5);
				txtCantidadIng5.setColumns(10);
			}
			{
				lblIngrediente_4 = new JLabel("Ingrediente");
				GridBagConstraints gbc_lblIngrediente_4 = new GridBagConstraints();
				gbc_lblIngrediente_4.anchor = GridBagConstraints.EAST;
				gbc_lblIngrediente_4.insets = new Insets(0, 0, 5, 5);
				gbc_lblIngrediente_4.gridx = 2;
				gbc_lblIngrediente_4.gridy = 6;
				panel.add(lblIngrediente_4, gbc_lblIngrediente_4);
			}
			{
				txtIng5 = new JTextField();
				GridBagConstraints gbc_txtIng5 = new GridBagConstraints();
				gbc_txtIng5.gridwidth = 2;
				gbc_txtIng5.insets = new Insets(0, 0, 5, 5);
				gbc_txtIng5.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtIng5.gridx = 3;
				gbc_txtIng5.gridy = 6;
				panel.add(txtIng5, gbc_txtIng5);
				txtIng5.setColumns(10);
			}
			{
				lblCantidadIngrediente_4 = new JLabel("Cantidad ingrediente");
				GridBagConstraints gbc_lblCantidadIngrediente_4 = new GridBagConstraints();
				gbc_lblCantidadIngrediente_4.anchor = GridBagConstraints.EAST;
				gbc_lblCantidadIngrediente_4.insets = new Insets(0, 0, 5, 5);
				gbc_lblCantidadIngrediente_4.gridx = 0;
				gbc_lblCantidadIngrediente_4.gridy = 7;
				panel.add(lblCantidadIngrediente_4, gbc_lblCantidadIngrediente_4);
			}
			{
				txtCantidadIng6 = new JTextField();
				GridBagConstraints gbc_txtCantidadIng6 = new GridBagConstraints();
				gbc_txtCantidadIng6.insets = new Insets(0, 0, 5, 5);
				gbc_txtCantidadIng6.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtCantidadIng6.gridx = 1;
				gbc_txtCantidadIng6.gridy = 7;
				panel.add(txtCantidadIng6, gbc_txtCantidadIng6);
				txtCantidadIng6.setColumns(10);
			}
			{
				lblIngrediente_5 = new JLabel("Ingrediente");
				GridBagConstraints gbc_lblIngrediente_5 = new GridBagConstraints();
				gbc_lblIngrediente_5.anchor = GridBagConstraints.EAST;
				gbc_lblIngrediente_5.insets = new Insets(0, 0, 5, 5);
				gbc_lblIngrediente_5.gridx = 2;
				gbc_lblIngrediente_5.gridy = 7;
				panel.add(lblIngrediente_5, gbc_lblIngrediente_5);
			}
			{
				txtIng6 = new JTextField();
				GridBagConstraints gbc_txtIng6 = new GridBagConstraints();
				gbc_txtIng6.gridwidth = 2;
				gbc_txtIng6.insets = new Insets(0, 0, 5, 5);
				gbc_txtIng6.fill = GridBagConstraints.HORIZONTAL;
				gbc_txtIng6.gridx = 3;
				gbc_txtIng6.gridy = 7;
				panel.add(txtIng6, gbc_txtIng6);
				txtIng6.setColumns(10);
			}
			{
				lblPreparacion = new JLabel("Preparacion");
				lblPreparacion.setVerticalAlignment(SwingConstants.TOP);
				lblPreparacion.setHorizontalAlignment(SwingConstants.RIGHT);
				GridBagConstraints gbc_lblPreparacion = new GridBagConstraints();
				gbc_lblPreparacion.anchor = GridBagConstraints.EAST;
				gbc_lblPreparacion.fill = GridBagConstraints.VERTICAL;
				gbc_lblPreparacion.insets = new Insets(0, 0, 5, 5);
				gbc_lblPreparacion.gridx = 0;
				gbc_lblPreparacion.gridy = 8;
				panel.add(lblPreparacion, gbc_lblPreparacion);
			}
			{
				scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.gridheight = 3;
				gbc_scrollPane.gridwidth = 5;
				gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 8;
				panel.add(scrollPane, gbc_scrollPane);
				{
					txtDescripcion = new JTextArea();
					scrollPane.setViewportView(txtDescripcion);
				}
			}
			{
				btnAceptar = new JButton("Aceptar");
				btnAceptar.addActionListener(new BtnAceptarActionListener());
				GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
				gbc_btnAceptar.gridx = 6;
				gbc_btnAceptar.gridy = 11;
				panel.add(btnAceptar, gbc_btnAceptar);
			}
		}
	}

	private class BtnAceptarActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			GestorReceta gestorReceta = new GestorReceta();

			// Si queremos añadir la receta
			if (aniadirReceta == true) {
				try {

					Receta receta = null;
					Double ing1 = txtCantidadIng1.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng1.getText());
					Double ing2 = txtCantidadIng2.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng2.getText());
					Double ing3 = txtCantidadIng3.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng3.getText());
					Double ing4 = txtCantidadIng4.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng4.getText());
					Double ing5 = txtCantidadIng5.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng5.getText());
					Double ing6 = txtCantidadIng6.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng6.getText());
					if (!txtNombre.getText().isEmpty() && !txtIng1.getText().isEmpty()
							&& !txtDescripcion.getText().isEmpty()) {
						receta = new Receta(txtNombre.getText(), cbTipoComida.getSelectedIndex() + 1, ing1, ing2, ing3,
								ing4, ing5, ing6, txtIng1.getText(), txtIng2.getText(), txtIng3.getText(),
								txtIng4.getText(), txtIng5.getText(), txtIng6.getText(), txtDescripcion.getText());
						boolean insertado = gestorReceta.insertarReceta(receta);
						if (insertado == true) {
							JOptionPane.showMessageDialog(frameVentanaReceta, "Receta añadida");
						} else {
							JOptionPane.showMessageDialog(frameVentanaReceta, "Receta no añadida");
						}
					} else {
						JOptionPane.showMessageDialog(frameVentanaReceta,
								"Ponga una receta con nombre, al menos un ingrediente y con una descripcion");

					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frameVentanaReceta, "Error: " + e.getMessage());

				}
				// Si queremos modificar la receta

			} else {

				try {

					Receta receta = null;
					Double ing1 = txtCantidadIng1.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng1.getText());
					Double ing2 = txtCantidadIng2.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng2.getText());
					Double ing3 = txtCantidadIng3.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng3.getText());
					Double ing4 = txtCantidadIng4.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng4.getText());
					Double ing5 = txtCantidadIng5.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng5.getText());
					Double ing6 = txtCantidadIng6.getText().isEmpty() ? 0.0
							: Double.parseDouble(txtCantidadIng6.getText());
					if (!txtNombre.getText().isEmpty() && !txtIng1.getText().isEmpty()
							&& !txtDescripcion.getText().isEmpty()) {
						receta = new Receta(txtNombre.getText(), cbTipoComida.getSelectedIndex() + 1, ing1, ing2, ing3,
								ing4, ing5, ing6, txtIng1.getText(), txtIng2.getText(), txtIng3.getText(),
								txtIng4.getText(), txtIng5.getText(), txtIng6.getText(), txtDescripcion.getText());
						boolean insertado = gestorReceta.modificarReceta(receta);
						if (insertado == true) {
							JOptionPane.showMessageDialog(frameVentanaReceta, "Receta modificada");
						} else {
							JOptionPane.showMessageDialog(frameVentanaReceta, "Receta no modificada");
						}
					} else {
						JOptionPane.showMessageDialog(frameVentanaReceta,
								"Ponga una receta con nombre, al menos un ingrediente y con una descripcion");

					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(frameVentanaReceta, "Error: " + e.getMessage());
				}

			}
		}
	}

	private class ThisWindowListener extends WindowAdapter {
		@Override
		public void windowActivated(WindowEvent arg0) {
			// Si vamos a modificar una receta
			if (aniadirReceta == false) {
				try {
					mostrarRecetaVentana();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	private static void mostrarRecetaVentana() throws SQLException, Exception {

		GestorReceta gestorReceta = new GestorReceta();
		Receta receta = gestorReceta.leerReceta(nombreReceta);
		txtNombre.setText(receta.getNombre());
		cbTipoComida.setSelectedIndex(receta.getTipo() - 1);
		txtCantidadIng1.setText(String.valueOf(receta.getCantidad1()));
		txtCantidadIng2.setText(String.valueOf(receta.getCantidad2()));
		txtCantidadIng3.setText(String.valueOf(receta.getCantidad3()));
		txtCantidadIng4.setText(String.valueOf(receta.getCantidad4()));
		txtCantidadIng5.setText(String.valueOf(receta.getCantidad5()));
		txtCantidadIng6.setText(String.valueOf(receta.getCantidad6()));
		txtIng1.setText(receta.getIngrediente1());
		txtIng2.setText(receta.getIngrediente2());
		txtIng3.setText(receta.getIngrediente3());
		txtIng4.setText(receta.getIngrediente4());
		txtIng5.setText(receta.getIngrediente5());
		txtIng6.setText(receta.getIngrediente6());
		txtDescripcion.setText(receta.getDescripcion());
	}

}