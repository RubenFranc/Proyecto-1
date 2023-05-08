package consola_grafica;

import javax.swing.*;

import Controlador.ControladorAdministrador;
import Model.Hotel;

import java.awt.*;
import java.awt.event.*;

public class adminPestaniaAsignarTarifaHabitacionFecha extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

        ControladorAdministrador controlador = new ControladorAdministrador();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(4, 2, 10, 10));

		/// ELEMENTOS
		JLabel tipo = new JLabel("Tipo", SwingConstants.CENTER);
		JLabel fechaInicio = new JLabel("Fecha de inicio (dd/MM)", SwingConstants.CENTER);
		JLabel fechaFin = new JLabel("Fecha de fin (dd/MM)", SwingConstants.CENTER);
		JLabel tarifa = new JLabel("Tarifa", SwingConstants.CENTER);

		// tipo
		ButtonGroup grupoTipo = new ButtonGroup();
		JRadioButton botonTipoEstandar = new JRadioButton("Estándar");
		botonTipoEstandar.setBackground(parametros.getColorCuerpo());
		botonTipoEstandar.setActionCommand("Estándar");
		grupoTipo.add(botonTipoEstandar);
		JRadioButton botonTipoSuite = new JRadioButton("Suite");
		botonTipoSuite.setBackground(parametros.getColorCuerpo());
		botonTipoSuite.setActionCommand("Suite");
		grupoTipo.add(botonTipoSuite);
		JRadioButton botonTipoSuiteDoble = new JRadioButton("Suite Doble");
		botonTipoSuiteDoble.setBackground(parametros.getColorCuerpo());
		botonTipoSuiteDoble.setActionCommand("Suite Doble");
		grupoTipo.add(botonTipoSuiteDoble);

		JPanel auxiliarTipo = new JPanel();
		auxiliarTipo.setLayout(new BoxLayout(auxiliarTipo, BoxLayout.X_AXIS));
		auxiliarTipo.setBackground(parametros.getColorCuerpo());
		auxiliarTipo.add(botonTipoEstandar);
		auxiliarTipo.add(botonTipoSuite);
		auxiliarTipo.add(botonTipoSuiteDoble);

		// Fecha Inicio
		JPanel auxiliarFechaInicio = new JPanel();
		auxiliarFechaInicio.setLayout(new FlowLayout());
		auxiliarFechaInicio.setBackground(parametros.getColorCuerpo());
		JTextField fechaInicioTextField = new JTextField();
		fechaInicioTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarFechaInicio.add(fechaInicioTextField);

		// Fecha Fin
		JPanel auxiliarFechaFin = new JPanel();
		auxiliarFechaFin.setLayout(new FlowLayout());
		auxiliarFechaFin.setBackground(parametros.getColorCuerpo());
		JTextField fechaFinTextField = new JTextField();
		fechaFinTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarFechaFin.add(fechaFinTextField);
		
		// Tarifa
		JPanel auxiliarTarifa = new JPanel();
		auxiliarTarifa.setLayout(new FlowLayout());
		auxiliarTarifa.setBackground(parametros.getColorCuerpo());
		JTextField tarifaTextField = new JTextField();
		tarifaTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarTarifa.add(tarifaTextField);

		/// ADD

		panel.add(tipo);
		panel.add(auxiliarTipo);
		panel.add(fechaInicio);
		panel.add(auxiliarFechaInicio);
		panel.add(fechaFin);
		panel.add(auxiliarFechaFin);
		panel.add(tarifa);
		panel.add(auxiliarTarifa);

		// FINAL

		JPanel panelFinal = new JPanel();

		panelFinal.setPreferredSize(parametros.getDimensionCuerpo());
		panelFinal.setBackground(parametros.getColorCuerpo());
		panelFinal.setLayout(new BorderLayout());

		JButton botonContinuar = new JButton("Continuar");
		botonContinuar.setPreferredSize(parametros.getDimensionBotonArriba());
		botonContinuar.addActionListener(event -> {
			ButtonModel opcionTipo = grupoTipo.getSelection();
			String opTipo = opcionTipo.getActionCommand();
			String tipi = "";
			if (opTipo.equals("Estándar")) {
				tipi = "e";
			}
			else if (opTipo.equals("Suite")) {
				tipi = "s";
			}
			else if (opTipo.equals("Suite Doble")) {
				tipi = "sd";
			}
			String nuevoPrecio = tarifaTextField.getText();
			double tari = Double.parseDouble(nuevoPrecio);
			String fechaIni = fechaInicioTextField.getText();
			String fechaFina = fechaFinTextField.getText();
			controlador.asignarTarifasHabitaciones(tipi, fechaIni, fechaFina, tari, hotel);
			JOptionPane.showMessageDialog(null, "Operación realizada con éxito.");
//			System.out.println(hotel.getModificacionesHabitaciones());
		});
		
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

//	public adminPestaniaAsignarTarifaHabitacionFecha() {
//
//		/// CONFIGURACION
//		setPreferredSize(parametros.getDimensionCuerpo());
//		setBackground(parametros.getColorCuerpo());
//		setLayout(new GridLayout(4, 2, 10, 10));
//
//		/// ELEMENTOS
//		JLabel tipo = new JLabel("Tipo", SwingConstants.CENTER);
//		JLabel fechaInicio = new JLabel("Fecha de inicio (dd/MM)", SwingConstants.CENTER);
//		JLabel fechaFin = new JLabel("Fecha de fin (dd/MM)", SwingConstants.CENTER);
//		JLabel tarifa = new JLabel("Tarifa", SwingConstants.CENTER);
//
//		// tipo
//		ButtonGroup grupoTipo = new ButtonGroup();
//		JRadioButton botonTipoEstandar = new JRadioButton("Estándar");
//		botonTipoEstandar.setBackground(parametros.getColorCuerpo());
//		botonTipoEstandar.setActionCommand("Estándar");
//		grupoTipo.add(botonTipoEstandar);
//		JRadioButton botonTipoSuite = new JRadioButton("Suite");
//		botonTipoSuite.setBackground(parametros.getColorCuerpo());
//		botonTipoSuite.setActionCommand("Suite");
//		grupoTipo.add(botonTipoSuite);
//		JRadioButton botonTipoSuiteDoble = new JRadioButton("Suite Doble");
//		botonTipoSuiteDoble.setBackground(parametros.getColorCuerpo());
//		botonTipoSuiteDoble.setActionCommand("Suite Doble");
//		grupoTipo.add(botonTipoSuiteDoble);
//
//		JPanel auxiliarTipo = new JPanel();
//		auxiliarTipo.setLayout(new BoxLayout(auxiliarTipo, BoxLayout.X_AXIS));
//		auxiliarTipo.setBackground(parametros.getColorCuerpo());
//		auxiliarTipo.add(botonTipoEstandar);
//		auxiliarTipo.add(botonTipoSuite);
//		auxiliarTipo.add(botonTipoSuiteDoble);
//
//		// Fecha Inicio
//		JPanel auxiliarFechaInicio = new JPanel();
//		auxiliarFechaInicio.setLayout(new FlowLayout());
//		auxiliarFechaInicio.setBackground(parametros.getColorCuerpo());
//		JTextField fechaInicioTextField = new JTextField();
//		fechaInicioTextField.setPreferredSize(new Dimension(200, 75));
//		auxiliarFechaInicio.add(fechaInicioTextField);
//
//		// Fecha Fin
//		JPanel auxiliarFechaFin = new JPanel();
//		auxiliarFechaFin.setLayout(new FlowLayout());
//		auxiliarFechaFin.setBackground(parametros.getColorCuerpo());
//		JTextField fechaFinTextField = new JTextField();
//		fechaFinTextField.setPreferredSize(new Dimension(200, 75));
//		auxiliarFechaFin.add(fechaFinTextField);
//		
//		// Tarifa
//		JPanel auxiliarTarifa = new JPanel();
//		auxiliarTarifa.setLayout(new FlowLayout());
//		auxiliarTarifa.setBackground(parametros.getColorCuerpo());
//		JTextField tarifaTextField = new JTextField();
//		tarifaTextField.setPreferredSize(new Dimension(200, 58));
//		auxiliarTarifa.add(tarifaTextField);
//
//		/// ADD
//
//		add(tipo);
//		add(auxiliarTipo);
//		add(fechaInicio);
//		add(auxiliarFechaInicio);
//		add(fechaFin);
//		add(auxiliarFechaFin);
//		add(tarifa);
//		add(auxiliarTarifa);
//
//	}

}
