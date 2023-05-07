package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminPestaniaCargarServicios extends JPanel {

	public static JPanel getPestania() {

		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new BorderLayout());

		/// ELEMENTOS
		JLabel pregunta = new JLabel("¿Desea cargar los servicios desde la base de datos?", SwingConstants.CENTER);

		ButtonGroup grupo = new ButtonGroup();
		JRadioButton botonSi = new JRadioButton("Sí");
		botonSi.setBackground(parametros.getColorCuerpo());
		grupo.add(botonSi);
		JRadioButton botonNo = new JRadioButton("No");
		botonNo.setBackground(parametros.getColorCuerpo());
		grupo.add(botonNo);

		/// ADD

		panel.add(pregunta, BorderLayout.NORTH);
		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new FlowLayout());
		auxiliar.setBackground(parametros.getColorCuerpo());
		auxiliar.add(botonSi);
		auxiliar.add(botonNo);
		panel.add(auxiliar, BorderLayout.CENTER);

		// FINAL

		JPanel panelFinal = new JPanel();

		panelFinal.setPreferredSize(parametros.getDimensionCuerpo());
		panelFinal.setBackground(parametros.getColorCuerpo());
		panelFinal.setLayout(new BorderLayout());

		JButton botonConfirmar = new JButton("Confirmar");
		botonConfirmar.setPreferredSize(parametros.getDimensionBotonArriba());
		JPanel confirmarPanel = new JPanel();
		confirmarPanel.setLayout(new BoxLayout(confirmarPanel, BoxLayout.X_AXIS));
		confirmarPanel.setPreferredSize(parametros.getDimensionBotonArriba());
		confirmarPanel.setBackground(parametros.getColorCuerpo());
		confirmarPanel.add(Box.createVerticalGlue());
		confirmarPanel.add(Box.createHorizontalGlue());
		confirmarPanel.add(botonConfirmar);
		confirmarPanel.add(Box.createVerticalGlue());
		confirmarPanel.add(Box.createHorizontalGlue());

		panelFinal.add(panel, BorderLayout.CENTER);
		panelFinal.add(confirmarPanel, BorderLayout.SOUTH);

		return panelFinal;
	}

	public adminPestaniaCargarServicios() {

		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
		setBackground(parametros.getColorCuerpo());
		setLayout(new BorderLayout());

		/// ELEMENTOS
		JLabel pregunta = new JLabel("¿Desea cargar los servicios desde la base de datos?", SwingConstants.CENTER);

		ButtonGroup grupo = new ButtonGroup();
		JRadioButton botonSi = new JRadioButton("Sí");
		botonSi.setBackground(parametros.getColorCuerpo());
		grupo.add(botonSi);
		JRadioButton botonNo = new JRadioButton("No");
		botonNo.setBackground(parametros.getColorCuerpo());
		grupo.add(botonNo);

		/// ADD

		add(pregunta, BorderLayout.NORTH);
		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new FlowLayout());
		auxiliar.setBackground(parametros.getColorCuerpo());
		auxiliar.add(botonSi);
		auxiliar.add(botonNo);
		add(auxiliar, BorderLayout.CENTER);

	}

}
