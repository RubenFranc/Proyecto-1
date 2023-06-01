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
		panel.setLayout(new GridLayout(19, 2, 1, 1));

		/// ELEMENTOS
		JLabel balcon = new JLabel("Balcon", SwingConstants.CENTER);
		JLabel cocina = new JLabel("Cocina", SwingConstants.CENTER);
		JLabel ventana = new JLabel("Ventana", SwingConstants.CENTER);
		JLabel capacidad = new JLabel("Capacidad", SwingConstants.CENTER);
		JLabel tipo = new JLabel("Tipo de habitación", SwingConstants.CENTER);
		JLabel tarifa = new JLabel("Tarifa", SwingConstants.CENTER);
		JLabel id = new JLabel("ID", SwingConstants.CENTER);
		
		JLabel metros = new JLabel("Metros cuadrados", SwingConstants.CENTER);
		JLabel voltaje = new JLabel("Voltaje AC", SwingConstants.CENTER);
		JLabel aire = new JLabel("Aire acondicionado", SwingConstants.CENTER);
		JLabel calefaccion = new JLabel("Calefaccion", SwingConstants.CENTER);
		JLabel cafetera = new JLabel("Cafetera", SwingConstants.CENTER);
		JLabel sabanas = new JLabel("Sabanas/tapetes", SwingConstants.CENTER);
		JLabel plancha = new JLabel("Plancha", SwingConstants.CENTER);
		JLabel secador = new JLabel("Secador", SwingConstants.CENTER);
		JLabel usbA = new JLabel("USB-A", SwingConstants.CENTER);
		JLabel usbC = new JLabel("USB-C", SwingConstants.CENTER);
		JLabel desayuno = new JLabel("Desayuno", SwingConstants.CENTER);
		JLabel cama = new JLabel("Tamaño de la cama", SwingConstants.CENTER);

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
		grupoCocina.add(botonNoCocina);

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
		capacidadTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarCapacidad.add(capacidadTextField);
		
		// tamaño
		JPanel auxiliarMetrosCuadrados = new JPanel();
		auxiliarMetrosCuadrados.setLayout(new FlowLayout());
		auxiliarMetrosCuadrados.setBackground(parametros.getColorCuerpo());
		JTextField metrosCuadradosTextField = new JTextField();
		metrosCuadradosTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarMetrosCuadrados.add(metrosCuadradosTextField);
		
		// aire
		ButtonGroup grupoAire = new ButtonGroup();
		JRadioButton botonSiAire = new JRadioButton("Sí");
		botonSiAire.setBackground(parametros.getColorCuerpo());
		botonSiAire.setActionCommand("Sí");
		grupoAire.add(botonSiAire);
		JRadioButton botonNoAire = new JRadioButton("No");
		botonNoAire.setBackground(parametros.getColorCuerpo());
		botonNoAire.setActionCommand("No");
		grupoAire.add(botonNoAire);

		JPanel auxiliarAire = new JPanel();
		auxiliarAire.setLayout(new FlowLayout());
		auxiliarAire.setBackground(parametros.getColorCuerpo());
		auxiliarAire.add(botonSiAire);
		auxiliarAire.add(botonNoAire);
		
		// calefaccion
		ButtonGroup grupoCalefaccion = new ButtonGroup();
		JRadioButton botonSiCalefaccion = new JRadioButton("Sí");
		botonSiCalefaccion.setBackground(parametros.getColorCuerpo());
		botonSiCalefaccion.setActionCommand("Sí");
		grupoCalefaccion.add(botonSiCalefaccion);
		JRadioButton botonNoCalefaccion = new JRadioButton("No");
		botonNoCalefaccion.setBackground(parametros.getColorCuerpo());
		botonNoCalefaccion.setActionCommand("No");
		grupoCalefaccion.add(botonNoCalefaccion);

		JPanel auxiliarCalefaccion = new JPanel();
		auxiliarCalefaccion.setLayout(new FlowLayout());
		auxiliarCalefaccion.setBackground(parametros.getColorCuerpo());
		auxiliarCalefaccion.add(botonSiCalefaccion);
		auxiliarCalefaccion.add(botonNoCalefaccion);
		
		// cafetera
		ButtonGroup grupoCafetera = new ButtonGroup();
		JRadioButton botonSiCafetera = new JRadioButton("Sí");
		botonSiCafetera.setBackground(parametros.getColorCuerpo());
		botonSiCafetera.setActionCommand("Sí");
		grupoCafetera.add(botonSiCafetera);
		JRadioButton botonNoCafetera = new JRadioButton("No");
		botonNoCafetera.setBackground(parametros.getColorCuerpo());
		botonNoCafetera.setActionCommand("No");
		grupoCafetera.add(botonNoCafetera);

		JPanel auxiliarCafetera = new JPanel();
		auxiliarCafetera.setLayout(new FlowLayout());
		auxiliarCafetera.setBackground(parametros.getColorCuerpo());
		auxiliarCafetera.add(botonSiCafetera);
		auxiliarCafetera.add(botonNoCafetera);
		
		// sabanas y tapetes
		ButtonGroup grupoSabanasTapetes = new ButtonGroup();
		JRadioButton botonSiSabanasTapetes = new JRadioButton("Sí");
		botonSiSabanasTapetes.setBackground(parametros.getColorCuerpo());
		botonSiSabanasTapetes.setActionCommand("Sí");
		grupoSabanasTapetes.add(botonSiSabanasTapetes);
		JRadioButton botonNoSabanasTapetes = new JRadioButton("No");
		botonNoSabanasTapetes.setBackground(parametros.getColorCuerpo());
		botonNoSabanasTapetes.setActionCommand("No");
		grupoSabanasTapetes.add(botonNoSabanasTapetes);

		JPanel auxiliarSabanasTapetes = new JPanel();
		auxiliarSabanasTapetes.setLayout(new FlowLayout());
		auxiliarSabanasTapetes.setBackground(parametros.getColorCuerpo());
		auxiliarSabanasTapetes.add(botonSiSabanasTapetes);
		auxiliarSabanasTapetes.add(botonNoSabanasTapetes);
		
		// plancha
		ButtonGroup grupoPlancha = new ButtonGroup();
		JRadioButton botonSiPlancha = new JRadioButton("Sí");
		botonSiPlancha.setBackground(parametros.getColorCuerpo());
		botonSiPlancha.setActionCommand("Sí");
		grupoPlancha.add(botonSiPlancha);
		JRadioButton botonNoPlancha = new JRadioButton("No");
		botonNoPlancha.setBackground(parametros.getColorCuerpo());
		botonNoPlancha.setActionCommand("No");
		grupoPlancha.add(botonNoPlancha);

		JPanel auxiliarPlancha = new JPanel();
		auxiliarPlancha.setLayout(new FlowLayout());
		auxiliarPlancha.setBackground(parametros.getColorCuerpo());
		auxiliarPlancha.add(botonSiPlancha);
		auxiliarPlancha.add(botonNoPlancha);
		
		// secador
		ButtonGroup grupoSecador = new ButtonGroup();
		JRadioButton botonSiSecador = new JRadioButton("Sí");
		botonSiSecador.setBackground(parametros.getColorCuerpo());
		botonSiSecador.setActionCommand("Sí");
		grupoSecador.add(botonSiSecador);
		JRadioButton botonNoSecador = new JRadioButton("No");
		botonNoSecador.setBackground(parametros.getColorCuerpo());
		botonNoSecador.setActionCommand("No");
		grupoSecador.add(botonNoSecador);

		JPanel auxiliarSecador = new JPanel();
		auxiliarSecador.setLayout(new FlowLayout());
		auxiliarSecador.setBackground(parametros.getColorCuerpo());
		auxiliarSecador.add(botonSiSecador);
		auxiliarSecador.add(botonNoSecador);
		
		// USB-A
		ButtonGroup grupoUsbA = new ButtonGroup();
		JRadioButton botonSiUsbA = new JRadioButton("Sí");
		botonSiUsbA.setBackground(parametros.getColorCuerpo());
		botonSiUsbA.setActionCommand("Sí");
		grupoUsbA.add(botonSiUsbA);
		JRadioButton botonNoUsbA = new JRadioButton("No");
		botonNoUsbA.setBackground(parametros.getColorCuerpo());
		botonNoUsbA.setActionCommand("No");
		grupoUsbA.add(botonNoUsbA);

		JPanel auxiliarUsbA = new JPanel();
		auxiliarUsbA.setLayout(new FlowLayout());
		auxiliarUsbA.setBackground(parametros.getColorCuerpo());
		auxiliarUsbA.add(botonSiUsbA);
		auxiliarUsbA.add(botonNoUsbA);
		
		// USB-A
		ButtonGroup grupoUsbC = new ButtonGroup();
		JRadioButton botonSiUsbC = new JRadioButton("Sí");
		botonSiUsbC.setBackground(parametros.getColorCuerpo());
		botonSiUsbC.setActionCommand("Sí");
		grupoUsbC.add(botonSiUsbC);
		JRadioButton botonNoUsbC = new JRadioButton("No");
		botonNoUsbC.setBackground(parametros.getColorCuerpo());
		botonNoUsbC.setActionCommand("No");
		grupoUsbC.add(botonNoUsbC);

		JPanel auxiliarUsbC = new JPanel();
		auxiliarUsbC.setLayout(new FlowLayout());
		auxiliarUsbC.setBackground(parametros.getColorCuerpo());
		auxiliarUsbC.add(botonSiUsbC);
		auxiliarUsbC.add(botonNoUsbC);
		
		// Desayuno
		ButtonGroup grupoDesayuno = new ButtonGroup();
		JRadioButton botonSiDesayuno = new JRadioButton("Sí");
		botonSiDesayuno.setBackground(parametros.getColorCuerpo());
		botonSiDesayuno.setActionCommand("Sí");
		grupoDesayuno.add(botonSiDesayuno);
		JRadioButton botonNoDesayuno = new JRadioButton("No");
		botonNoDesayuno.setBackground(parametros.getColorCuerpo());
		botonNoDesayuno.setActionCommand("No");
		grupoDesayuno.add(botonNoDesayuno);

		JPanel auxiliarDesayuno = new JPanel();
		auxiliarDesayuno.setLayout(new FlowLayout());
		auxiliarDesayuno.setBackground(parametros.getColorCuerpo());
		auxiliarDesayuno.add(botonSiDesayuno);
		auxiliarDesayuno.add(botonNoDesayuno);
		
		// VoltajeAC
		JPanel auxiliarVoltajeAC = new JPanel();
		auxiliarVoltajeAC.setLayout(new FlowLayout());
		auxiliarVoltajeAC.setBackground(parametros.getColorCuerpo());
		JTextField voltajeACTextField = new JTextField();
		voltajeACTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarVoltajeAC.add(voltajeACTextField);
		
		// tipo de cama
		ButtonGroup grupoCama = new ButtonGroup();
		JRadioButton botonCamaPequenia = new JRadioButton("Pequeña");
		botonCamaPequenia.setBackground(parametros.getColorCuerpo());
		botonCamaPequenia.setActionCommand("Pequeña");
		grupoCama.add(botonCamaPequenia);
		JRadioButton botonCamaMediana = new JRadioButton("Mediana");
		botonCamaMediana.setBackground(parametros.getColorCuerpo());
		botonCamaMediana.setActionCommand("Mediana");
		grupoCama.add(botonCamaMediana);
		JRadioButton botonCamaGrande = new JRadioButton("Grande");
		botonCamaGrande.setBackground(parametros.getColorCuerpo());
		botonCamaGrande.setActionCommand("Grande");
		grupoCama.add(botonCamaGrande);

		JPanel auxiliarCama = new JPanel();
		auxiliarCama.setLayout(new FlowLayout());
		auxiliarCama.setBackground(parametros.getColorCuerpo());
		auxiliarCama.add(botonCamaPequenia);
		auxiliarCama.add(botonCamaMediana);
		auxiliarCama.add(botonCamaGrande);

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
		tarifaTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarTarifa.add(tarifaTextField);

		// ID
		JPanel auxiliarId = new JPanel();
		auxiliarId.setLayout(new FlowLayout());
		auxiliarId.setBackground(parametros.getColorCuerpo());
		JTextField idTextField = new JTextField();
		idTextField.setPreferredSize(new Dimension(200, 20));
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
		
		panel.add(metros);
		panel.add(auxiliarMetrosCuadrados);
		panel.add(aire);
		panel.add(auxiliarAire);
		panel.add(calefaccion);
		panel.add(auxiliarCalefaccion);
		panel.add(cama);
		panel.add(auxiliarCama);
		panel.add(cafetera);
		panel.add(auxiliarCafetera);
		panel.add(sabanas);
		panel.add(auxiliarSabanasTapetes);
		panel.add(plancha);
		panel.add(auxiliarPlancha);
		panel.add(secador);
		panel.add(auxiliarSecador);
		panel.add(voltaje);
		panel.add(auxiliarVoltajeAC);
		panel.add(usbA);
		panel.add(auxiliarUsbA);
		panel.add(usbC);
		panel.add(auxiliarUsbC);
		panel.add(desayuno);
		panel.add(auxiliarDesayuno);
		
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
			ButtonModel opcionAire = grupoAire.getSelection();
			String opAire = opcionAire.getActionCommand();
			boolean air = false;
			if (opAire.equals("Sí")) {
				air = true;
			}
			ButtonModel opcionCalefaccion = grupoCalefaccion.getSelection();
			String opCalefaccion = opcionCalefaccion.getActionCommand();
			boolean cale = false;
			if (opCalefaccion.equals("Sí")) {
				cale = true;
			}
			ButtonModel opcionCafetera = grupoCafetera.getSelection();
			String opCafetera = opcionCafetera.getActionCommand();
			boolean cafe = false;
			if (opCafetera.equals("Sí")) {
				cafe = true;
			}
			ButtonModel opcionSabanasTapetes = grupoSabanasTapetes.getSelection();
			String opSabanasTapetes = opcionSabanasTapetes.getActionCommand();
			boolean sabt = false;
			if (opSabanasTapetes.equals("Sí")) {
				sabt = true;
			}
			ButtonModel opcionPlancha = grupoPlancha.getSelection();
			String opPlancha = opcionPlancha.getActionCommand();
			boolean plan = false;
			if (opPlancha.equals("Sí")) {
				plan = true;
			}
			ButtonModel opcionSecador = grupoSecador.getSelection();
			String opSecador = opcionSecador.getActionCommand();
			boolean seca = false;
			if (opSecador.equals("Sí")) {
				seca = true;
			}
			ButtonModel opcionUsbA = grupoUsbA.getSelection();
			String opUsbA = opcionUsbA.getActionCommand();
			boolean usba = false;
			if (opUsbA.equals("Sí")) {
				usba = true;
			}
			ButtonModel opcionUsbC = grupoUsbC.getSelection();
			String opUsbC = opcionUsbC.getActionCommand();
			boolean usbc = false;
			if (opUsbC.equals("Sí")) {
				usbc = true;
			}
			ButtonModel opcionDesayuno = grupoDesayuno.getSelection();
			String opDesayuno = opcionDesayuno.getActionCommand();
			boolean desa = false;
			if (opDesayuno.equals("Sí")) {
				desa = true;
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
			ButtonModel opcionCama = grupoCama.getSelection();
			String opCama = opcionCama.getActionCommand();
			String cami = "";
			if (opCama.equals("Pequeña")) {
				cami = "p";
			}
			else if (opCama.equals("Mediana")) {
				cami = "m";
			}
			else if (opCama.equals("Grande")) {
				cami = "g";
			}
			
			String opCapacidad = capacidadTextField.getText();
			int capa = Integer.parseInt(opCapacidad);			
			
			String opTarifa = tarifaTextField.getText();
			double tari = Double.parseDouble(opTarifa);
			String opTamanio = metrosCuadradosTextField.getText();
			double tama = Double.parseDouble(opTarifa);
			String opVoltaje = voltajeACTextField.getText();
			double volt = Double.parseDouble(opTarifa);
			
			String propiedades = capa + "," + balc + "," + vent + "," + coci + "," + tama + "," +
								air + "," + cale + "," + cami + "," + cafe + "," + sabt + "," +
								plan + "," + seca + "," + volt + "," + usba + "," + usbc + "," +
								desa;
			
			String opId = idTextField.getText();
			controlador.crearHabitacion(opId, tipi, propiedades, tari, true, hotel);
			JOptionPane.showMessageDialog(null, "Operación realizada con éxito.");
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

//	public adminPestaniaCargarHabitacion() {
//
//		/// CONFIGURACION
//		// setPreferredSize(parametros.getDimensionCuerpo());
//		setBackground(parametros.getColorCuerpo());
//		setLayout(new GridLayout(7, 2, 10, 5));
//
//		/// ELEMENTOS
//		JLabel balcon = new JLabel("Balcon", SwingConstants.CENTER);
//		JLabel cocina = new JLabel("Cocina", SwingConstants.CENTER);
//		JLabel ventana = new JLabel("Ventana", SwingConstants.CENTER);
//		JLabel capacidad = new JLabel("Capacidad", SwingConstants.CENTER);
//		JLabel tipo = new JLabel("Tipo", SwingConstants.CENTER);
//		JLabel tarifa = new JLabel("Tarifa", SwingConstants.CENTER);
//		JLabel id = new JLabel("ID", SwingConstants.CENTER);
//
//		// balcon
//		ButtonGroup grupoBalcon = new ButtonGroup();
//		JRadioButton botonSiBalcon = new JRadioButton("Sí");
//		botonSiBalcon.setBackground(parametros.getColorCuerpo());
//		grupoBalcon.add(botonSiBalcon);
//		JRadioButton botonNoBalcon = new JRadioButton("No");
//		botonNoBalcon.setBackground(parametros.getColorCuerpo());
//		grupoBalcon.add(botonNoBalcon);
//
//		JPanel auxiliarBalcon = new JPanel();
//		auxiliarBalcon.setLayout(new FlowLayout());
//		auxiliarBalcon.setBackground(parametros.getColorCuerpo());
//		auxiliarBalcon.add(botonSiBalcon);
//		auxiliarBalcon.add(botonNoBalcon);
//
//		// cocina
//		ButtonGroup grupoCocina = new ButtonGroup();
//		JRadioButton botonSiCocina = new JRadioButton("Sí");
//		botonSiCocina.setBackground(parametros.getColorCuerpo());
//		grupoCocina.add(botonSiCocina);
//		JRadioButton botonNoCocina = new JRadioButton("No");
//		botonNoCocina.setBackground(parametros.getColorCuerpo());
//		grupoBalcon.add(botonNoCocina);
//
//		JPanel auxiliarCocina = new JPanel();
//		auxiliarCocina.setLayout(new FlowLayout());
//		auxiliarCocina.setBackground(parametros.getColorCuerpo());
//		auxiliarCocina.add(botonSiCocina);
//		auxiliarCocina.add(botonNoCocina);
//
//		// ventana
//		ButtonGroup grupoVentana = new ButtonGroup();
//		JRadioButton botonSiVentana = new JRadioButton("Sí");
//		botonSiVentana.setBackground(parametros.getColorCuerpo());
//		grupoVentana.add(botonSiVentana);
//		JRadioButton botonNoVentana = new JRadioButton("No");
//		botonNoVentana.setBackground(parametros.getColorCuerpo());
//		grupoVentana.add(botonNoVentana);
//
//		JPanel auxiliarVentana = new JPanel();
//		auxiliarVentana.setLayout(new FlowLayout());
//		auxiliarVentana.setBackground(parametros.getColorCuerpo());
//		auxiliarVentana.add(botonSiVentana);
//		auxiliarVentana.add(botonNoVentana);
//
//		// Capacidad
//		JPanel auxiliarCapacidad = new JPanel();
//		auxiliarCapacidad.setLayout(new FlowLayout());
//		auxiliarCapacidad.setBackground(parametros.getColorCuerpo());
//		JTextField capacidadTextField = new JTextField();
//		capacidadTextField.setPreferredSize(new Dimension(200, 58));
//		auxiliarCapacidad.add(capacidadTextField);
//
//		// tipo
//		ButtonGroup grupoTipo = new ButtonGroup();
//		JRadioButton botonTipoEstandar = new JRadioButton("Estándar");
//		botonTipoEstandar.setBackground(parametros.getColorCuerpo());
//		grupoTipo.add(botonTipoEstandar);
//		JRadioButton botonTipoSuite = new JRadioButton("Suite");
//		botonTipoSuite.setBackground(parametros.getColorCuerpo());
//		grupoTipo.add(botonTipoSuite);
//		JRadioButton botonTipoSuiteDoble = new JRadioButton("Suite Doble");
//		botonTipoSuiteDoble.setBackground(parametros.getColorCuerpo());
//		grupoTipo.add(botonTipoSuiteDoble);
//
//		JPanel auxiliarTipo = new JPanel();
//		auxiliarTipo.setLayout(new FlowLayout());
//		auxiliarTipo.setBackground(parametros.getColorCuerpo());
//		auxiliarTipo.add(botonTipoEstandar);
//		auxiliarTipo.add(botonTipoSuite);
//		auxiliarTipo.add(botonTipoSuiteDoble);
//
//		// Tarifa
//		JPanel auxiliarTarifa = new JPanel();
//		auxiliarTarifa.setLayout(new FlowLayout());
//		auxiliarTarifa.setBackground(parametros.getColorCuerpo());
//		JTextField tarifaTextField = new JTextField();
//		tarifaTextField.setPreferredSize(new Dimension(200, 58));
//		auxiliarTarifa.add(tarifaTextField);
//		
//		// ID
//		JPanel auxiliarId = new JPanel();
//		auxiliarId.setLayout(new FlowLayout());
//		auxiliarId.setBackground(parametros.getColorCuerpo());
//		JTextField idTextField = new JTextField();
//		idTextField.setPreferredSize(new Dimension(200, 58));
//		auxiliarId.add(idTextField);
//
//		/// ADD
//
//		add(id);
//		add(auxiliarId);
//		add(balcon);
//		add(auxiliarBalcon);
//		add(cocina);
//		add(auxiliarCocina);
//		add(ventana);
//		add(auxiliarVentana);
//		add(capacidad);
//		add(auxiliarCapacidad);
//		add(tipo);
//		add(auxiliarTipo);
//		add(tarifa);
//		add(auxiliarTarifa);
//
//	}
}
