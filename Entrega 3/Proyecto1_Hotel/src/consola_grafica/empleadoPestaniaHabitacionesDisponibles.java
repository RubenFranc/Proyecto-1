package consola_grafica;

import javax.swing.*;

import Controlador.ControladorEmpleado;
import Model.Habitacion;
import Model.Hotel;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Set;

public class empleadoPestaniaHabitacionesDisponibles extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

		ControladorEmpleado controlador = new ControladorEmpleado();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(2, 1, 20, 20));

		/// ELEMENTOS
//		JLabel informacion = new JLabel("Información", SwingConstants.CENTER);
		// TODO Poner la información de las habitaciones

		// Botones
		JButton estandaresDisponibles = new JButton("Estandares Disponibles");
		JButton suitesDisponibles = new JButton("Suites Disponibles");
		JButton suitesDoblesDisponibles = new JButton("Suites Dobles Disponibles");

		estandaresDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
		suitesDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
		suitesDoblesDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
		
		estandaresDisponibles.addActionListener(event -> {
			Map<String, Map<String, Habitacion>> habitacionesDisponibles = controlador.consultarHabitacionesDisponibles(hotel);
			String mssg = "*Estándar:";
			Set<String> habitacionesTipo = habitacionesDisponibles.get("e").keySet();
			for (String id: habitacionesTipo) {
				Habitacion habitacion =  habitacionesDisponibles.get("e").get(id);
				mssg += "\n\n    -Habitación " + id + ":";
				mssg += "\n       Capacidad: " + habitacion.getCapacidad();
				mssg += "\n       Con balcón: " + habitacion.hasBalcon();
				mssg += "\n       Con ventana: " + habitacion.hasVentana();
				mssg += "\n       Con cocina: " + habitacion.hasCocina();
			}
			JOptionPane.showMessageDialog(null, mssg);
		});
		suitesDisponibles.addActionListener(event -> {
			Map<String, Map<String, Habitacion>> habitacionesDisponibles = controlador.consultarHabitacionesDisponibles(hotel);
			String mssg = "*Suites:";
			Set<String> habitacionesTipo = habitacionesDisponibles.get("s").keySet();
			for (String id: habitacionesTipo) {
				Habitacion habitacion =  habitacionesDisponibles.get("s").get(id);
				mssg += "\n    -Habitación " + id + ":";
				mssg += "\n       Capacidad: " + habitacion.getCapacidad();
				mssg += "\n       Con balcón: " + habitacion.hasBalcon();
				mssg += "\n       Con ventana: " + habitacion.hasVentana();
				mssg += "\n       Con cocina: " + habitacion.hasCocina();
			}
			JOptionPane.showMessageDialog(null, mssg);
		});
		suitesDoblesDisponibles.addActionListener(event -> {
			Map<String, Map<String, Habitacion>> habitacionesDisponibles = controlador.consultarHabitacionesDisponibles(hotel);
			String mssg = "*Suites dobles:";
			Set<String> habitacionesTipo = habitacionesDisponibles.get("sd").keySet();
			for (String id: habitacionesTipo) {
				Habitacion habitacion =  habitacionesDisponibles.get("sd").get(id);
				mssg += "\n    -Habitación " + id + ":";
				mssg += "\n       Capacidad: " + habitacion.getCapacidad();
				mssg += "\n       Con balcón: " + habitacion.hasBalcon();
				mssg += "\n       Con ventana: " + habitacion.hasVentana();
				mssg += "\n       Con cocina: " + habitacion.hasCocina();
			}
			JOptionPane.showMessageDialog(null, mssg);
		});

		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new BoxLayout(auxiliar, BoxLayout.Y_AXIS));
		auxiliar.setBackground(parametros.getColorCuerpo());

		auxiliar.add(Box.createVerticalGlue());
		auxiliar.add(estandaresDisponibles);
		auxiliar.add(suitesDisponibles);
		auxiliar.add(suitesDoblesDisponibles);
		auxiliar.add(Box.createVerticalGlue());

		/// ADD

		panel.add(auxiliar);
//		panel.add(informacion);

		// FINAL

		JPanel panelFinal = new JPanel();

		panelFinal.setPreferredSize(parametros.getDimensionCuerpo());
		panelFinal.setBackground(parametros.getColorCuerpo());
		panelFinal.setLayout(new BorderLayout());

//		JButton botonContinuar = new JButton("Continuar");
//		botonContinuar.setPreferredSize(parametros.getDimensionBotonArriba());
		JPanel continuarPanel = new JPanel();
		continuarPanel.setLayout(new BoxLayout(continuarPanel, BoxLayout.X_AXIS));
		continuarPanel.setPreferredSize(parametros.getDimensionBotonArriba());
		continuarPanel.setBackground(parametros.getColorCuerpo());
		continuarPanel.add(Box.createVerticalGlue());
		continuarPanel.add(Box.createHorizontalGlue());
//		continuarPanel.add(botonContinuar);
		continuarPanel.add(Box.createVerticalGlue());
		continuarPanel.add(Box.createHorizontalGlue());

		panelFinal.add(panel, BorderLayout.CENTER);
		panelFinal.add(continuarPanel, BorderLayout.SOUTH);

		return panelFinal;
	}

//	public empleadoPestaniaHabitacionesDisponibles() {
//
//		/// CONFIGURACION
//		setPreferredSize(parametros.getDimensionCuerpo());
//		setBackground(parametros.getColorCuerpo());
//		setLayout(new GridLayout(2, 1, 20, 20));
//
//		/// ELEMENTOS
//		JLabel informacion = new JLabel("Información", SwingConstants.CENTER);
//		// TODO Poner la información de las habitaciones
//
//		// Botones
//		JButton estandaresDisponibles = new JButton("Estandares Disponibles");
//		JButton suitesDisponibles = new JButton("Suites Disponibles");
//		JButton suitesDoblesDisponibles = new JButton("Suites Dobles Disponibles");
//
//		estandaresDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
//		suitesDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
//		suitesDoblesDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
//
//		JPanel auxiliar = new JPanel();
//		auxiliar.setLayout(new BoxLayout(auxiliar, BoxLayout.Y_AXIS));
//		auxiliar.setBackground(parametros.getColorCuerpo());
//
//		auxiliar.add(Box.createVerticalGlue());
//		auxiliar.add(estandaresDisponibles);
//		auxiliar.add(suitesDisponibles);
//		auxiliar.add(suitesDoblesDisponibles);
//		auxiliar.add(Box.createVerticalGlue());
//
//		/// ADD
//
//		add(auxiliar);
//		add(informacion);
//
//	}

}
