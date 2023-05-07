package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminPestaniaCambiarTarifaServicio extends JPanel {

	public static JPanel getPestania() {

		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(2, 2, 10, 10));

		/// ELEMENTOS
		JLabel servicioLabel = new JLabel("Servicio", SwingConstants.CENTER);
		JLabel nuevaTarifaLabel = new JLabel("Nueva Tarifa", SwingConstants.CENTER);

		// Servicios
		String[] servicios = { "a", "b", "c", "d", "e" };
		// TODO agregar los servicios correctos!!!
		JComboBox comboServicios = new JComboBox(servicios);

		JPanel auxiliarServicios = new JPanel();
		auxiliarServicios.setLayout(new BoxLayout(auxiliarServicios, BoxLayout.X_AXIS));
		auxiliarServicios.setBackground(parametros.getColorCuerpo());
		auxiliarServicios.add(comboServicios, SwingConstants.CENTER);

		// Fecha Inicio
		JPanel auxiliarNuevaTarifa = new JPanel();
		auxiliarNuevaTarifa.setLayout(new BoxLayout(auxiliarNuevaTarifa, BoxLayout.X_AXIS));
		auxiliarNuevaTarifa.setBackground(parametros.getColorCuerpo());
		JTextField nuevaTarifaTextField = new JTextField();
		nuevaTarifaTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarNuevaTarifa.add(nuevaTarifaTextField);

		/// ADD

		panel.add(servicioLabel);
		panel.add(auxiliarServicios);
		panel.add(nuevaTarifaLabel);
		panel.add(auxiliarNuevaTarifa);

		// FINAL

		JPanel panelFinal = new JPanel();

		panelFinal.setPreferredSize(parametros.getDimensionCuerpo());
		panelFinal.setBackground(parametros.getColorCuerpo());
		panelFinal.setLayout(new BorderLayout());

		JButton botonContinuar = new JButton("Continuar");
		botonContinuar.setPreferredSize(parametros.getDimensionBotonArriba());
		JPanel continuarPanel = new JPanel();
		continuarPanel.setLayout(new BoxLayout(continuarPanel, BoxLayout.X_AXIS));
		continuarPanel.setPreferredSize(parametros.getDimensionBotonArriba());
		continuarPanel.setBackground(parametros.getColorCuerpo());
		continuarPanel.add(Box.createVerticalGlue());
		continuarPanel.add(Box.createHorizontalGlue());
		continuarPanel.add(botonContinuar);
		continuarPanel.add(Box.createVerticalGlue());
		continuarPanel.add(Box.createHorizontalGlue());

		panelFinal.add(panel, BorderLayout.CENTER);
		panelFinal.add(continuarPanel, BorderLayout.SOUTH);

		return panelFinal;
	}

	public adminPestaniaCambiarTarifaServicio() {

		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
		setBackground(parametros.getColorCuerpo());
		setLayout(new GridLayout(2, 2, 10, 10));

		/// ELEMENTOS
		JLabel servicioLabel = new JLabel("Servicio", SwingConstants.CENTER);
		JLabel nuevaTarifaLabel = new JLabel("Nueva Tarifa", SwingConstants.CENTER);

		// Servicios
		String[] servicios = { "a", "b", "c", "d", "e" };
		// TODO agregar los servicios correctos!!!
		JComboBox comboServicios = new JComboBox(servicios);

		JPanel auxiliarServicios = new JPanel();
		auxiliarServicios.setLayout(new BoxLayout(auxiliarServicios, BoxLayout.X_AXIS));
		auxiliarServicios.setBackground(parametros.getColorCuerpo());
		auxiliarServicios.add(comboServicios, SwingConstants.CENTER);

		// Fecha Inicio
		JPanel auxiliarNuevaTarifa = new JPanel();
		auxiliarNuevaTarifa.setLayout(new BoxLayout(auxiliarNuevaTarifa, BoxLayout.X_AXIS));
		auxiliarNuevaTarifa.setBackground(parametros.getColorCuerpo());
		JTextField nuevaTarifaTextField = new JTextField();
		nuevaTarifaTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarNuevaTarifa.add(nuevaTarifaTextField);

		/// ADD

		add(servicioLabel);
		add(auxiliarServicios);
		add(nuevaTarifaLabel);
		add(auxiliarNuevaTarifa);

	}

}
