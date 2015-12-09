package Presentacion;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import Dominio.GestorReceta;
import Dominio.Receta;

public class VentanaMenuUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static VentanaMenuUsuario frameMenuUsuario;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnGenerarDesayuno;
	private JButton btnGenerarAlmuerzo;
	private JButton btnGenerarComida;
	private JButton btnGenerarMerienda;
	private JButton btnGenerarCena;
	private JButton btnGuardarRecetas;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JTextArea txtDesayuno;
	private JTextArea txtAlmuerzo;
	private JTextArea txtComida;
	private JTextArea txtMerienda;
	private JTextArea txtCena;
	private JButton btnGenerarMenu;
	protected Object frame;
	private GestorReceta gest = new GestorReceta();
	private JButton btnVerMisRecetas;
	public String emailUsuario;
	private Receta[] ArrayReceta = new Receta[6];

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frameMenuUsuario = new VentanaMenuUsuario();
					frameMenuUsuario.setVisible(true);
					frameMenuUsuario.setLocationRelativeTo(null);
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
		setTitle("Generar recetas");
		setMinimumSize(new Dimension(500, 500));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(VentanaMenuUsuario.class.getResource("/Presentacion/logo.png")));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		{
			panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 248, 0, 0 };
			gbl_panel.rowHeights = new int[] { 100, 100, 100, 100, 100, 31, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			{
				btnGenerarDesayuno = new JButton("Generar desayuno");
				btnGenerarDesayuno.addActionListener(new BtnGenerarDesayunoActionListener());
				GridBagConstraints gbc_btnGenerarDesayuno = new GridBagConstraints();
				gbc_btnGenerarDesayuno.fill = GridBagConstraints.BOTH;
				gbc_btnGenerarDesayuno.insets = new Insets(0, 0, 5, 5);
				gbc_btnGenerarDesayuno.gridx = 0;
				gbc_btnGenerarDesayuno.gridy = 0;
				panel.add(btnGenerarDesayuno, gbc_btnGenerarDesayuno);
			}
			{
				scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 0;
				panel.add(scrollPane, gbc_scrollPane);
				{
					txtDesayuno = new JTextArea();
					txtDesayuno.setEditable(false);
					scrollPane.setViewportView(txtDesayuno);
				}
			}
			{
				btnGenerarAlmuerzo = new JButton("Generar almuerzo");
				btnGenerarAlmuerzo.addActionListener(new BtnGenerarAlmuerzoActionListener());
				GridBagConstraints gbc_btnGenerarAlmuerzo = new GridBagConstraints();
				gbc_btnGenerarAlmuerzo.fill = GridBagConstraints.BOTH;
				gbc_btnGenerarAlmuerzo.insets = new Insets(0, 0, 5, 5);
				gbc_btnGenerarAlmuerzo.gridx = 0;
				gbc_btnGenerarAlmuerzo.gridy = 1;
				panel.add(btnGenerarAlmuerzo, gbc_btnGenerarAlmuerzo);
			}
			{
				scrollPane_1 = new JScrollPane();
				GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
				gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_1.gridx = 1;
				gbc_scrollPane_1.gridy = 1;
				panel.add(scrollPane_1, gbc_scrollPane_1);
				{
					txtAlmuerzo = new JTextArea();
					txtAlmuerzo.setEditable(false);
					scrollPane_1.setViewportView(txtAlmuerzo);
				}
			}
			{
				btnGenerarComida = new JButton("Generar comida");
				btnGenerarComida.addActionListener(new BtnGenerarComidaActionListener());
				GridBagConstraints gbc_btnGenerarComida = new GridBagConstraints();
				gbc_btnGenerarComida.fill = GridBagConstraints.BOTH;
				gbc_btnGenerarComida.insets = new Insets(0, 0, 5, 5);
				gbc_btnGenerarComida.gridx = 0;
				gbc_btnGenerarComida.gridy = 2;
				panel.add(btnGenerarComida, gbc_btnGenerarComida);
			}
			{
				scrollPane_2 = new JScrollPane();
				GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
				gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_2.gridx = 1;
				gbc_scrollPane_2.gridy = 2;
				panel.add(scrollPane_2, gbc_scrollPane_2);
				{
					txtComida = new JTextArea();
					txtComida.setEditable(false);
					scrollPane_2.setViewportView(txtComida);
				}
			}
			{
				btnGenerarMerienda = new JButton("Generar merienda");
				btnGenerarMerienda.addActionListener(new BtnGenerarMeriendaActionListener());
				GridBagConstraints gbc_btnGenerarMerienda = new GridBagConstraints();
				gbc_btnGenerarMerienda.fill = GridBagConstraints.BOTH;
				gbc_btnGenerarMerienda.insets = new Insets(0, 0, 5, 5);
				gbc_btnGenerarMerienda.gridx = 0;
				gbc_btnGenerarMerienda.gridy = 3;
				panel.add(btnGenerarMerienda, gbc_btnGenerarMerienda);
			}
			{
				scrollPane_3 = new JScrollPane();
				GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
				gbc_scrollPane_3.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_3.gridx = 1;
				gbc_scrollPane_3.gridy = 3;
				panel.add(scrollPane_3, gbc_scrollPane_3);
				{
					txtMerienda = new JTextArea();
					txtMerienda.setEditable(false);
					scrollPane_3.setViewportView(txtMerienda);
				}
			}
			{
				btnGenerarCena = new JButton("Generar cena");
				btnGenerarCena.addActionListener(new BtnGenerarCenaActionListener());
				GridBagConstraints gbc_btnGenerarCena = new GridBagConstraints();
				gbc_btnGenerarCena.fill = GridBagConstraints.BOTH;
				gbc_btnGenerarCena.insets = new Insets(0, 0, 5, 5);
				gbc_btnGenerarCena.gridx = 0;
				gbc_btnGenerarCena.gridy = 4;
				panel.add(btnGenerarCena, gbc_btnGenerarCena);
			}
			{
				scrollPane_4 = new JScrollPane();
				GridBagConstraints gbc_scrollPane_4 = new GridBagConstraints();
				gbc_scrollPane_4.insets = new Insets(0, 0, 5, 0);
				gbc_scrollPane_4.fill = GridBagConstraints.BOTH;
				gbc_scrollPane_4.gridx = 1;
				gbc_scrollPane_4.gridy = 4;
				panel.add(scrollPane_4, gbc_scrollPane_4);
				{
					txtCena = new JTextArea();
					txtCena.setEditable(false);
					scrollPane_4.setViewportView(txtCena);
				}
			}
			{
			}
			btnGuardarRecetas = new JButton("Guardar recetas");
			btnGuardarRecetas.addActionListener(new BtnGuardarRecetasActionListener());
			{
				btnGenerarMenu = new JButton("Generar men\u00FA completo");
				btnGenerarMenu.addActionListener(new BtnGenerarMenuActionListener());
				btnGenerarMenu.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				GridBagConstraints gbc_btnGenerarMenu = new GridBagConstraints();
				gbc_btnGenerarMenu.fill = GridBagConstraints.BOTH;
				gbc_btnGenerarMenu.insets = new Insets(0, 0, 5, 0);
				gbc_btnGenerarMenu.gridx = 1;
				gbc_btnGenerarMenu.gridy = 5;
				panel.add(btnGenerarMenu, gbc_btnGenerarMenu);
			}
			{
				btnVerMisRecetas = new JButton("Ver mis recetas");
				btnVerMisRecetas.addActionListener(new BtnVerMisRecetasActionListener());
				GridBagConstraints gbc_btnVerMisRecetas = new GridBagConstraints();
				gbc_btnVerMisRecetas.fill = GridBagConstraints.BOTH;
				gbc_btnVerMisRecetas.insets = new Insets(0, 0, 5, 0);
				gbc_btnVerMisRecetas.gridx = 1;
				gbc_btnVerMisRecetas.gridy = 6;
				panel.add(btnVerMisRecetas, gbc_btnVerMisRecetas);
			}
			GridBagConstraints gbc_btnGuardarRecetas = new GridBagConstraints();
			gbc_btnGuardarRecetas.fill = GridBagConstraints.BOTH;
			gbc_btnGuardarRecetas.gridx = 1;
			gbc_btnGuardarRecetas.gridy = 7;
			panel.add(btnGuardarRecetas, gbc_btnGuardarRecetas);
		}
	}

	private class BtnGenerarDesayunoActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] numComensales = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			int comensales = 0;
			try {
				comensales = (int) JOptionPane.showInputDialog(frameMenuUsuario,
						"�Para cuantos comensales quiere la receta?", "Numero de comensales",
						JOptionPane.INFORMATION_MESSAGE, null, numComensales, null);
			} catch (Exception arg) {
			}

			try {

				if (comensales != 0) {

					txtDesayuno.setText(gest.generarReceta(1, comensales).toString());
					ArrayReceta[1] = gest.generarReceta(1, comensales);
				}
			} catch (Exception arg0) {

			}
		}
	}

	private class BtnGenerarAlmuerzoActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] numComensales = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			int comensales = 0;
			try {
				comensales = (int) JOptionPane.showInputDialog(frameMenuUsuario,
						"�Para cuantos comensales quiere la receta?", "Numero de comensales",
						JOptionPane.INFORMATION_MESSAGE, null, numComensales, null);
			} catch (Exception arg) {
			}

			try {

				if (comensales != 0) {

					txtAlmuerzo.setText(gest.generarReceta(2, comensales).toString());
					ArrayReceta[2] = gest.generarReceta(2, comensales);
				}
			} catch (Exception arg0) {

			}

		}
	}

	private class BtnGenerarComidaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] numComensales = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			int comensales = 0;
			try {
				comensales = (int) JOptionPane.showInputDialog(frameMenuUsuario,
						"�Para cuantos comensales quiere la receta?", "Numero de comensales",
						JOptionPane.INFORMATION_MESSAGE, null, numComensales, null);
			} catch (Exception arg) {
			}

			try {

				if (comensales != 0) {
					txtComida.setText(gest.generarReceta(3, comensales).toString());
					ArrayReceta[3] = gest.generarReceta(3, comensales);
				}
			} catch (Exception arg0) {

			}

		}
	}

	private class BtnGenerarMeriendaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] numComensales = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			int comensales = 0;
			try {
				comensales = (int) JOptionPane.showInputDialog(frameMenuUsuario,
						"�Para cuantos comensales quiere la receta?", "Numero de comensales",
						JOptionPane.INFORMATION_MESSAGE, null, numComensales, null);
			} catch (Exception arg) {
			}

			try {

				if (comensales != 0) {
					txtMerienda.setText(gest.generarReceta(4, comensales).toString());
					ArrayReceta[4] = gest.generarReceta(4, comensales);
				}
			} catch (Exception arg0) {

			}

		}
	}

	private class BtnGenerarCenaActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] numComensales = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			int comensales = 0;
			try {
				comensales = (int) JOptionPane.showInputDialog(frameMenuUsuario,
						"�Para cuantos comensales quiere la receta?", "Numero de comensales",
						JOptionPane.INFORMATION_MESSAGE, null, numComensales, null);
			} catch (Exception arg) {
			}

			try {

				if (comensales != 0) {
					txtCena.setText(gest.generarReceta(5, comensales).toString());
					ArrayReceta[5] = gest.generarReceta(5, comensales);
				}
			} catch (Exception arg0) {

			}

		}
	}

	private class BtnGenerarMenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object[] numComensales = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			int comensales = 0;
			try {
				comensales = (int) JOptionPane.showInputDialog(frameMenuUsuario,
						"�Para cuantos comensales quiere la receta?", "Numero de comensales",
						JOptionPane.INFORMATION_MESSAGE, null, numComensales, null);
			} catch (Exception arg) {
			}
			try {

				if (comensales != 0) {
					txtDesayuno.setText(gest.generarReceta(1, comensales).toString());
					ArrayReceta[1] = gest.generarReceta(1, comensales);
					txtAlmuerzo.setText(gest.generarReceta(2, comensales).toString());
					ArrayReceta[2] = gest.generarReceta(2, comensales);
					txtComida.setText(gest.generarReceta(3, comensales).toString());
					ArrayReceta[3] = gest.generarReceta(3, comensales);
					txtMerienda.setText(gest.generarReceta(4, comensales).toString());
					ArrayReceta[4] = gest.generarReceta(4, comensales);
					txtCena.setText(gest.generarReceta(5, comensales).toString());
					ArrayReceta[5] = gest.generarReceta(5, comensales);
				}
			} catch (Exception arg0) {

			}

		}
	}

	private class BtnGuardarRecetasActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			GestorReceta gest = new GestorReceta();
			boolean a�adido = false;
			for (int i = 1; i < ArrayReceta.length; i++) {
				try {
					a�adido = gest.GuardarReceta(ArrayReceta[i].getNombre(), emailUsuario);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frameMenuUsuario,
							"Usted ya tiene guardada la receta de: " + ArrayReceta[i].getNombre());
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}

			}
		}
	}

	private class BtnVerMisRecetasActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			VentanaRecetasUsuario VenRec = new VentanaRecetasUsuario();
			VenRec.setVisible(true);
			VenRec.setLocationRelativeTo(null);
			// frameMenuUsuario.dispose();
		}
	}

}// Fin de la clase