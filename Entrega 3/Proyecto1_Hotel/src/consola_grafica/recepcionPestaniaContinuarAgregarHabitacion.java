package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class recepcionPestaniaContinuarAgregarHabitacion extends JPanel {

	public static JPanel getPestania() {

		JPanel panel = new JPanel();

		/// CONFIGURACION
		// setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(2, 2, 10, 10));

		/// ELEMENTOS
		JLabel numeroOcupantes = new JLabel("Número de acompañantes en esta habitación", SwingConstants.CENTER);
		JLabel tipo = new JLabel("Tipo de habitación", SwingConstants.CENTER);
		
		JLabel titulo = new JLabel("Habitación #");
		// TODO Poner lógica para que se identifique qué # de habitación es	dentro de la reserva
		JPanel auxiliarTitulo = new JPanel();
		auxiliarTitulo.setBackground(parametros.getColorCuerpo());
		auxiliarTitulo.add(titulo);


		// Capacidad
		JPanel auxiliarNumeroOcupantes = new JPanel();
		auxiliarNumeroOcupantes.setLayout(new FlowLayout());
		auxiliarNumeroOcupantes.setBackground(parametros.getColorCuerpo());
		JTextField capacidadTextField = new JTextField();
		capacidadTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarNumeroOcupantes.add(capacidadTextField);

		// tipo
		ButtonGroup grupoTipo = new ButtonGroup();
		JRadioButton botonTipoEstandar = new JRadioButton("Estándar");
		botonTipoEstandar.setBackground(parametros.getColorCuerpo());
		grupoTipo.add(botonTipoEstandar);
		JRadioButton botonTipoSuite = new JRadioButton("Suite");
		botonTipoSuite.setBackground(parametros.getColorCuerpo());
		grupoTipo.add(botonTipoSuite);
		JRadioButton botonTipoSuiteDoble = new JRadioButton("Suite Doble");
		botonTipoSuiteDoble.setBackground(parametros.getColorCuerpo());
		grupoTipo.add(botonTipoSuiteDoble);

		JPanel auxiliarTipo = new JPanel();
		auxiliarTipo.setLayout(new FlowLayout());
		auxiliarTipo.setBackground(parametros.getColorCuerpo());
		auxiliarTipo.add(botonTipoEstandar);
		auxiliarTipo.add(botonTipoSuite);
		auxiliarTipo.add(botonTipoSuiteDoble);

		/// ADD

		panel.add(numeroOcupantes);
		panel.add(auxiliarNumeroOcupantes);
		panel.add(tipo);
		panel.add(auxiliarTipo);

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
		panelFinal.add(auxiliarTitulo, BorderLayout.NORTH);

		return panelFinal;
	}
}
