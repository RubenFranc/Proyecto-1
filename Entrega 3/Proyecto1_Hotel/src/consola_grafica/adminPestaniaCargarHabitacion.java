package consola_grafica;

import javax.swing.*;

import Controlador.ControladorAdministrador;
import Model.Hotel;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class adminPestaniaCargarHabitacion extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

        ControladorAdministrador controlador = new ControladorAdministrador();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		// setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(7, 2, 10, 5));

		/// ELEMENTOS
		JLabel balcon = new JLabel("Balcon", SwingConstants.CENTER);
		JLabel cocina = new JLabel("Cocina", SwingConstants.CENTER);
		JLabel ventana = new JLabel("Ventana", SwingConstants.CENTER);
		JLabel capacidad = new JLabel("Capacidad", SwingConstants.CENTER);
		JLabel tipo = new JLabel("Tipo de habitación", SwingConstants.CENTER);
		JLabel tarifa = new JLabel("Tarifa", SwingConstants.CENTER);
		JLabel id = new JLabel("ID", SwingConstants.CENTER);

		// balcon
		ButtonGroup grupoBalcon = new ButtonGroup();
		JRadioButton botonSiBalcon = new JRadioButton("Sí");
		botonSiBalcon.setBackground(parametros.getColorCuerpo());
		botonSiBalcon.setActionCommand("Sí");
		grupoBalcon.add(botonSiBalcon);
		JRadioButton botonNoBalcon = new JRadioButton("No");
		botonNoBalcon.setBackground(parametros.getColorCuerpo());
		botonNoBalcon.setActionCommand("No");
		grupoBalcon.add(botonNoBalcon);

		JPanel auxiliarBalcon = new JPanel();
		auxiliarBalcon.setLayout(new FlowLayout());
		auxiliarBalcon.setBackground(parametros.getColorCuerpo());
		auxiliarBalcon.add(botonSiBalcon);
		auxiliarBalcon.add(botonNoBalcon);

		// cocina
		ButtonGroup grupoCocina = new ButtonGroup();
		JRadioButton botonSiCocina = new JRadioButton("Sí");
		botonSiCocina.setBackground(parametros.getColorCuerpo());
		botonSiCocina.setActionCommand("Sí");
		grupoCocina.add(botonSiCocina);
		JRadioButton botonNoCocina = new JRadioButton("No");
		botonNoCocina.setBackground(parametros.getColorCuerpo());
		botonNoCocina.setActionCommand("No");
		grupoBalcon.add(botonNoCocina);

		JPanel auxiliarCocina = new JPanel();
		auxiliarCocina.setLayout(new FlowLayout());
		auxiliarCocina.setBackground(parametros.getColorCuerpo());
		auxiliarCocina.add(botonSiCocina);
		auxiliarCocina.add(botonNoCocina);

		// ventana
		ButtonGroup grupoVentana = new ButtonGroup();
		JRadioButton botonSiVentana = new JRadioButton("Sí");
		botonSiVentana.setBackground(parametros.getColorCuerpo());
		botonSiVentana.setActionCommand("Sí");
		grupoVentana.add(botonSiVentana);
		JRadioButton botonNoVentana = new JRadioButton("No");
		botonNoVentana.setBackground(parametros.getColorCuerpo());
		botonNoVentana.setActionCommand("No");
		grupoVentana.add(botonNoVentana);

		JPanel auxiliarVentana = new JPanel();
		auxiliarVentana.setLayout(new FlowLayout());
		auxiliarVentana.setBackground(parametros.getColorCuerpo());
		auxiliarVentana.add(botonSiVentana);
		auxiliarVentana.add(botonNoVentana);

		// Capacidad
		JPanel auxiliarCapacidad = new JPanel();
		auxiliarCapacidad.setLayout(new FlowLayout());
		auxiliarCapacidad.setBackground(parametros.getColorCuerpo());
		JTextField capacidadTextField = new JTextField();
		capacidadTextField.setPreferredSize(new Dimension(200, 58));
		auxiliarCapacidad.add(capacidadTextField);

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
		auxiliarTipo.setLayout(new FlowLayout());
		auxiliarTipo.setBackground(parametros.getColorCuerpo());
		auxiliarTipo.add(botonTipoEstandar);
		auxiliarTipo.add(botonTipoSuite);
		auxiliarTipo.add(botonTipoSuiteDoble);

		// Tarifa
		JPanel auxiliarTarifa = new JPanel();
		auxiliarTarifa.setLayout(new FlowLayout());
		auxiliarTarifa.setBackground(parametros.getColorCuerpo());
		JTextField tarifaTextField = new JTextField();
		tarifaTextField.setPreferredSize(new Dimension(200, 58));
		auxiliarTarifa.add(tarifaTextField);

		// ID
		JPanel auxiliarId = new JPanel();
		auxiliarId.setLayout(new FlowLayout());
		auxiliarId.setBackground(parametros.getColorCuerpo());
		JTextField idTextField = new JTextField();
		idTextField.setPreferredSize(new Dimension(200, 58));
		auxiliarId.add(idTextField);
		
		/// ADD

		panel.add(id);
		panel.add(auxiliarId);
		panel.add(balcon);
		panel.add(auxiliarBalcon);
		panel.add(cocina);
		panel.add(auxiliarCocina);
		panel.add(ventana);
		panel.add(auxiliarVentana);
		panel.add(capacidad);
		panel.add(auxiliarCapacidad);
		panel.add(tipo);
		panel.add(auxiliarTipo);
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
			ButtonModel opcionBalcon = grupoBalcon.getSelection();
			String opBalcon = opcionBalcon.getActionCommand();
			boolean balc = false;
			if (opBalcon.equals("Sí")) {
				balc = true;
			}
			ButtonModel opcionCocina = grupoCocina.getSelection();
			String opCocina = opcionCocina.getActionCommand();
			boolean coci = false;
			if (opCocina.equals("Sí")) {
				coci = true;
			}
			ButtonModel opcionVentana = grupoVentana.getSelection();
			String opVentana = opcionVentana.getActionCommand();
			boolean vent = false;
			if (opVentana.equals("Sí")) {
				vent = true;
			}
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
			String opCapacidad = capacidadTextField.getText();
			int capa = Integer.parseInt(opCapacidad);
			String opTarifa = tarifaTextField.getText();
			double tari = Double.parseDouble(opTarifa);
			String opId = idTextField.getText();
			controlador.crearHabitacion(opId, tipi, capa, balc, coci, vent, tari, true, hotel);
//			System.out.println(hotel.getHabitacionesDisponiblesHotel().get(tipi));
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

	public adminPestaniaCargarHabitacion() {

		/// CONFIGURACION
		// setPreferredSize(parametros.getDimensionCuerpo());
		setBackground(parametros.getColorCuerpo());
		setLayout(new GridLayout(7, 2, 10, 5));

		/// ELEMENTOS
		JLabel balcon = new JLabel("Balcon", SwingConstants.CENTER);
		JLabel cocina = new JLabel("Cocina", SwingConstants.CENTER);
		JLabel ventana = new JLabel("Ventana", SwingConstants.CENTER);
		JLabel capacidad = new JLabel("Capacidad", SwingConstants.CENTER);
		JLabel tipo = new JLabel("Tipo", SwingConstants.CENTER);
		JLabel tarifa = new JLabel("Tarifa", SwingConstants.CENTER);
		JLabel id = new JLabel("ID", SwingConstants.CENTER);

		// balcon
		ButtonGroup grupoBalcon = new ButtonGroup();
		JRadioButton botonSiBalcon = new JRadioButton("Sí");
		botonSiBalcon.setBackground(parametros.getColorCuerpo());
		grupoBalcon.add(botonSiBalcon);
		JRadioButton botonNoBalcon = new JRadioButton("No");
		botonNoBalcon.setBackground(parametros.getColorCuerpo());
		grupoBalcon.add(botonNoBalcon);

		JPanel auxiliarBalcon = new JPanel();
		auxiliarBalcon.setLayout(new FlowLayout());
		auxiliarBalcon.setBackground(parametros.getColorCuerpo());
		auxiliarBalcon.add(botonSiBalcon);
		auxiliarBalcon.add(botonNoBalcon);

		// cocina
		ButtonGroup grupoCocina = new ButtonGroup();
		JRadioButton botonSiCocina = new JRadioButton("Sí");
		botonSiCocina.setBackground(parametros.getColorCuerpo());
		grupoCocina.add(botonSiCocina);
		JRadioButton botonNoCocina = new JRadioButton("No");
		botonNoCocina.setBackground(parametros.getColorCuerpo());
		grupoBalcon.add(botonNoCocina);

		JPanel auxiliarCocina = new JPanel();
		auxiliarCocina.setLayout(new FlowLayout());
		auxiliarCocina.setBackground(parametros.getColorCuerpo());
		auxiliarCocina.add(botonSiCocina);
		auxiliarCocina.add(botonNoCocina);

		// ventana
		ButtonGroup grupoVentana = new ButtonGroup();
		JRadioButton botonSiVentana = new JRadioButton("Sí");
		botonSiVentana.setBackground(parametros.getColorCuerpo());
		grupoVentana.add(botonSiVentana);
		JRadioButton botonNoVentana = new JRadioButton("No");
		botonNoVentana.setBackground(parametros.getColorCuerpo());
		grupoVentana.add(botonNoVentana);

		JPanel auxiliarVentana = new JPanel();
		auxiliarVentana.setLayout(new FlowLayout());
		auxiliarVentana.setBackground(parametros.getColorCuerpo());
		auxiliarVentana.add(botonSiVentana);
		auxiliarVentana.add(botonNoVentana);

		// Capacidad
		JPanel auxiliarCapacidad = new JPanel();
		auxiliarCapacidad.setLayout(new FlowLayout());
		auxiliarCapacidad.setBackground(parametros.getColorCuerpo());
		JTextField capacidadTextField = new JTextField();
		capacidadTextField.setPreferredSize(new Dimension(200, 58));
		auxiliarCapacidad.add(capacidadTextField);

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

		// Tarifa
		JPanel auxiliarTarifa = new JPanel();
		auxiliarTarifa.setLayout(new FlowLayout());
		auxiliarTarifa.setBackground(parametros.getColorCuerpo());
		JTextField tarifaTextField = new JTextField();
		tarifaTextField.setPreferredSize(new Dimension(200, 58));
		auxiliarTarifa.add(tarifaTextField);
		
		// ID
		JPanel auxiliarId = new JPanel();
		auxiliarId.setLayout(new FlowLayout());
		auxiliarId.setBackground(parametros.getColorCuerpo());
		JTextField idTextField = new JTextField();
		idTextField.setPreferredSize(new Dimension(200, 58));
		auxiliarId.add(idTextField);

		/// ADD

		add(id);
		add(auxiliarId);
		add(balcon);
		add(auxiliarBalcon);
		add(cocina);
		add(auxiliarCocina);
		add(ventana);
		add(auxiliarVentana);
		add(capacidad);
		add(auxiliarCapacidad);
		add(tipo);
		add(auxiliarTipo);
		add(tarifa);
		add(auxiliarTarifa);

	}
}
