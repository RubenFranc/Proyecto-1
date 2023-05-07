package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class empleadoPestaniaHabitacionesOcupadas extends JPanel {

	public static JPanel getPestania() {

		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(2, 1, 20, 20));

		/// ELEMENTOS
		JLabel informacion = new JLabel("Información", SwingConstants.CENTER);
		// TODO Poner la información de las habitaciones

		// Botones
		JButton estandaresOcupadas = new JButton("Estandares Ocupadas");
		JButton suitesOcupadas = new JButton("Suites Ocupadas");
		JButton suitesDoblesOcupadas = new JButton("Suites Dobles Ocupadas");

		estandaresOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
		suitesOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
		suitesDoblesOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());

		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new BoxLayout(auxiliar, BoxLayout.Y_AXIS));
		auxiliar.setBackground(parametros.getColorCuerpo());

		auxiliar.add(Box.createVerticalGlue());
		auxiliar.add(estandaresOcupadas);
		auxiliar.add(suitesOcupadas);
		auxiliar.add(suitesDoblesOcupadas);
		auxiliar.add(Box.createVerticalGlue());

		/// ADD

		panel.add(auxiliar);
		panel.add(informacion);

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

	public empleadoPestaniaHabitacionesOcupadas() {

		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
		setBackground(parametros.getColorCuerpo());
		setLayout(new GridLayout(2, 1, 20, 20));

		/// ELEMENTOS
		JLabel informacion = new JLabel("Información", SwingConstants.CENTER);
		// TODO Poner la información de las habitaciones

		// Botones
		JButton estandaresOcupadas = new JButton("Estandares Ocupadas");
		JButton suitesOcupadas = new JButton("Suites Ocupadas");
		JButton suitesDoblesOcupadas = new JButton("Suites Dobles Ocupadas");

		estandaresOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
		suitesOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
		suitesDoblesOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());

		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new BoxLayout(auxiliar, BoxLayout.Y_AXIS));
		auxiliar.setBackground(parametros.getColorCuerpo());

		auxiliar.add(Box.createVerticalGlue());
		auxiliar.add(estandaresOcupadas);
		auxiliar.add(suitesOcupadas);
		auxiliar.add(suitesDoblesOcupadas);
		auxiliar.add(Box.createVerticalGlue());

		/// ADD

		add(auxiliar);
		add(informacion);

	}

}
