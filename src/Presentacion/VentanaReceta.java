package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class VentanaReceta extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblCantidadIngrendiente;
	private JLabel lblCantidadIngrediente;
	private JLabel lblCantidadIngrediente_1;
	private JLabel lblCantidadIngrediente_2;
	private JLabel lblCantidadIngrediente_3;
	private JLabel lblCantidadIngrediente_4;
	private JFormattedTextField formattedTextField;
	private JFormattedTextField formattedTextField_1;
	private JFormattedTextField formattedTextField_2;
	private JFormattedTextField formattedTextField_3;
	private JFormattedTextField formattedTextField_4;
	private JFormattedTextField formattedTextField_5;
	private JLabel lblIngrediente;
	private JLabel lblIngrediente_1;
	private JLabel lblIngrediente_2;
	private JLabel lblIngrediente_3;
	private JLabel lblIngrediente_4;
	private JLabel lblIngrediente_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNombre;
	private JTextField textField_6;
	private JLabel lblTipoDeComida;
	private JComboBox comboBox;
	private JLabel lblPreparacion;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaReceta frame = new VentanaReceta();
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
	public VentanaReceta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaReceta.class.getResource("/Presentacion/logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
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
				textField_6 = new JTextField();
				GridBagConstraints gbc_textField_6 = new GridBagConstraints();
				gbc_textField_6.gridwidth = 2;
				gbc_textField_6.insets = new Insets(0, 0, 5, 5);
				gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_6.gridx = 1;
				gbc_textField_6.gridy = 0;
				panel.add(textField_6, gbc_textField_6);
				textField_6.setColumns(10);
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
				comboBox = new JComboBox();
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.gridwidth = 2;
				gbc_comboBox.insets = new Insets(0, 0, 5, 5);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 1;
				gbc_comboBox.gridy = 1;
				panel.add(comboBox, gbc_comboBox);
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
				formattedTextField = new JFormattedTextField();
				GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
				gbc_formattedTextField.insets = new Insets(0, 0, 5, 5);
				gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_formattedTextField.gridx = 1;
				gbc_formattedTextField.gridy = 2;
				panel.add(formattedTextField, gbc_formattedTextField);
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
				textField = new JTextField();
				GridBagConstraints gbc_textField = new GridBagConstraints();
				gbc_textField.gridwidth = 2;
				gbc_textField.insets = new Insets(0, 0, 5, 5);
				gbc_textField.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField.gridx = 3;
				gbc_textField.gridy = 2;
				panel.add(textField, gbc_textField);
				textField.setColumns(10);
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
				formattedTextField_1 = new JFormattedTextField();
				GridBagConstraints gbc_formattedTextField_1 = new GridBagConstraints();
				gbc_formattedTextField_1.insets = new Insets(0, 0, 5, 5);
				gbc_formattedTextField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_formattedTextField_1.gridx = 1;
				gbc_formattedTextField_1.gridy = 3;
				panel.add(formattedTextField_1, gbc_formattedTextField_1);
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
				textField_1 = new JTextField();
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.gridwidth = 2;
				gbc_textField_1.insets = new Insets(0, 0, 5, 5);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 3;
				gbc_textField_1.gridy = 3;
				panel.add(textField_1, gbc_textField_1);
				textField_1.setColumns(10);
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
				formattedTextField_2 = new JFormattedTextField();
				GridBagConstraints gbc_formattedTextField_2 = new GridBagConstraints();
				gbc_formattedTextField_2.insets = new Insets(0, 0, 5, 5);
				gbc_formattedTextField_2.fill = GridBagConstraints.HORIZONTAL;
				gbc_formattedTextField_2.gridx = 1;
				gbc_formattedTextField_2.gridy = 4;
				panel.add(formattedTextField_2, gbc_formattedTextField_2);
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
				textField_2 = new JTextField();
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.gridwidth = 2;
				gbc_textField_2.insets = new Insets(0, 0, 5, 5);
				gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_2.gridx = 3;
				gbc_textField_2.gridy = 4;
				panel.add(textField_2, gbc_textField_2);
				textField_2.setColumns(10);
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
				formattedTextField_3 = new JFormattedTextField();
				GridBagConstraints gbc_formattedTextField_3 = new GridBagConstraints();
				gbc_formattedTextField_3.insets = new Insets(0, 0, 5, 5);
				gbc_formattedTextField_3.fill = GridBagConstraints.HORIZONTAL;
				gbc_formattedTextField_3.gridx = 1;
				gbc_formattedTextField_3.gridy = 5;
				panel.add(formattedTextField_3, gbc_formattedTextField_3);
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
				textField_3 = new JTextField();
				GridBagConstraints gbc_textField_3 = new GridBagConstraints();
				gbc_textField_3.gridwidth = 2;
				gbc_textField_3.insets = new Insets(0, 0, 5, 5);
				gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_3.gridx = 3;
				gbc_textField_3.gridy = 5;
				panel.add(textField_3, gbc_textField_3);
				textField_3.setColumns(10);
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
				formattedTextField_4 = new JFormattedTextField();
				GridBagConstraints gbc_formattedTextField_4 = new GridBagConstraints();
				gbc_formattedTextField_4.insets = new Insets(0, 0, 5, 5);
				gbc_formattedTextField_4.fill = GridBagConstraints.HORIZONTAL;
				gbc_formattedTextField_4.gridx = 1;
				gbc_formattedTextField_4.gridy = 6;
				panel.add(formattedTextField_4, gbc_formattedTextField_4);
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
				textField_4 = new JTextField();
				GridBagConstraints gbc_textField_4 = new GridBagConstraints();
				gbc_textField_4.gridwidth = 2;
				gbc_textField_4.insets = new Insets(0, 0, 5, 5);
				gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_4.gridx = 3;
				gbc_textField_4.gridy = 6;
				panel.add(textField_4, gbc_textField_4);
				textField_4.setColumns(10);
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
				formattedTextField_5 = new JFormattedTextField();
				GridBagConstraints gbc_formattedTextField_5 = new GridBagConstraints();
				gbc_formattedTextField_5.insets = new Insets(0, 0, 5, 5);
				gbc_formattedTextField_5.fill = GridBagConstraints.HORIZONTAL;
				gbc_formattedTextField_5.gridx = 1;
				gbc_formattedTextField_5.gridy = 7;
				panel.add(formattedTextField_5, gbc_formattedTextField_5);
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
				textField_5 = new JTextField();
				GridBagConstraints gbc_textField_5 = new GridBagConstraints();
				gbc_textField_5.gridwidth = 2;
				gbc_textField_5.insets = new Insets(0, 0, 5, 5);
				gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_5.gridx = 3;
				gbc_textField_5.gridy = 7;
				panel.add(textField_5, gbc_textField_5);
				textField_5.setColumns(10);
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
					textArea = new JTextArea();
					scrollPane.setViewportView(textArea);
				}
			}
			{
				btnAceptar = new JButton("Aceptar");
				GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
				gbc_btnAceptar.gridx = 6;
				gbc_btnAceptar.gridy = 11;
				panel.add(btnAceptar, gbc_btnAceptar);
			}
		}
	}

}
