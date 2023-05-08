package consola_grafica;

import javax.swing.*;

import Controlador.ControladorEmpleado;
import Model.Hotel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class empleadoPestaniaAgregarServicio extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

		ControladorEmpleado controlador = new ControladorEmpleado();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(5, 2, 10, 10));

		/// ELEMENTOS
		JLabel servicio = new JLabel("Servicio", SwingConstants.CENTER);
		JLabel cuentaHabitacion = new JLabel("¿Cargar a la cuenta de la habitación?", SwingConstants.CENTER);
		JLabel documento = new JLabel("Documento huesped", SwingConstants.CENTER);
		JLabel idHabitacion = new JLabel("ID de la habitación", SwingConstants.CENTER);
		JLabel fechaActual = new JLabel("Fecha actual (DD/MM)", SwingConstants.CENTER);

		// Servicio
		ArrayList<String> arregloServicios = new ArrayList();
		for (String servic: hotel.getServiciosHotel().keySet()) {
			arregloServicios.add(servic);
		}
		String [] servicios = arregloServicios.toArray(new String[0]);
		// TODO agregar los servicios correctos!!!
		JComboBox comboServicios = new JComboBox(servicios);

		JPanel auxiliarServicios = new JPanel();
		auxiliarServicios.setLayout(new BoxLayout(auxiliarServicios, BoxLayout.X_AXIS));
		auxiliarServicios.setBackground(parametros.getColorCuerpo());
		auxiliarServicios.add(comboServicios, SwingConstants.CENTER);

		// Cuenta de Habitacion
		ButtonGroup grupoCuentaHabitacion = new ButtonGroup();
		JRadioButton botonSi = new JRadioButton("Sí");
		botonSi.setBackground(parametros.getColorCuerpo());
		botonSi.setActionCommand("Sí");
		grupoCuentaHabitacion.add(botonSi);
		JRadioButton botonNo = new JRadioButton("No");
		botonNo.setBackground(parametros.getColorCuerpo());
		botonNo.setActionCommand("No");
		grupoCuentaHabitacion.add(botonNo);

		JPanel auxiliarCuentaHabitacion = new JPanel();
		auxiliarCuentaHabitacion.setLayout(new BoxLayout(auxiliarCuentaHabitacion, BoxLayout.X_AXIS));
		auxiliarCuentaHabitacion.setBackground(parametros.getColorCuerpo());
		auxiliarCuentaHabitacion.add(Box.createHorizontalGlue());
		auxiliarCuentaHabitacion.add(botonSi);
		auxiliarCuentaHabitacion.add(botonNo);
		auxiliarCuentaHabitacion.add(Box.createHorizontalGlue());

		// Documento
		JPanel auxiliarDocumento = new JPanel();
		auxiliarDocumento.setLayout(new FlowLayout());
		auxiliarDocumento.setBackground(parametros.getColorCuerpo());
		JTextField documentoInicioTextField = new JTextField();
		documentoInicioTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarDocumento.add(documentoInicioTextField);

		// ID Habitacion
		JPanel auxiliarIdHabitacion = new JPanel();
		auxiliarIdHabitacion.setLayout(new FlowLayout());
		auxiliarIdHabitacion.setBackground(parametros.getColorCuerpo());
		JTextField idHabitacionFinTextField = new JTextField();
		idHabitacionFinTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarIdHabitacion.add(idHabitacionFinTextField);

		// Fecha Actual
		JPanel auxiliarFechaActual = new JPanel();
		auxiliarFechaActual.setLayout(new FlowLayout());
		auxiliarFechaActual.setBackground(parametros.getColorCuerpo());
		JTextField fechaActualTextField = new JTextField();
		fechaActualTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarFechaActual.add(fechaActualTextField);
		
		/// ADD

		panel.add(servicio);
		panel.add(auxiliarServicios);
		panel.add(cuentaHabitacion);
		panel.add(auxiliarCuentaHabitacion);
		panel.add(documento);
		panel.add(auxiliarDocumento);
		panel.add(idHabitacion);
		panel.add(auxiliarIdHabitacion);
		panel.add(fechaActual);
		panel.add(auxiliarFechaActual);

		// FINAL

		JPanel panelFinal = new JPanel();

		panelFinal.setPreferredSize(parametros.getDimensionCuerpo());
		panelFinal.setBackground(parametros.getColorCuerpo());
		panelFinal.setLayout(new BorderLayout());

		JButton botonContinuar = new JButton("Continuar");
		botonContinuar.setPreferredSize(parametros.getDimensionBotonArriba());
		botonContinuar.addActionListener(event -> {
			ButtonModel pendiente = grupoCuentaHabitacion.getSelection();
			String aCuenta = pendiente.getActionCommand();
			String nombre = (String) comboServicios.getSelectedItem();
			String doc = documentoInicioTextField.getText();
			String id = idHabitacionFinTextField.getText();
			String fAc = fechaActualTextField.getText();
			boolean cargar = false;
			if (aCuenta.equals("Sí")) {
				cargar = true;
			}
			String factura = controlador.registrarServicio(hotel, id, doc, cargar, nombre, fAc);
			JOptionPane.showMessageDialog(null, factura);
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

//	public empleadoPestaniaAgregarServicio() {
//
//		/// CONFIGURACION
//		setPreferredSize(parametros.getDimensionCuerpo());
//		setBackground(parametros.getColorCuerpo());
//		setLayout(new GridLayout(4, 2, 10, 10));
//
//		/// ELEMENTOS
//		JLabel servicio = new JLabel("Servicio", SwingConstants.CENTER);
//		JLabel cuentaHabitacion = new JLabel("¿Cargar a la cuenta de la habitación?", SwingConstants.CENTER);
//		JLabel documento = new JLabel("Documento huesped", SwingConstants.CENTER);
//		JLabel idHabitacion = new JLabel("ID de la habitación", SwingConstants.CENTER);
//
//		// Servicio
//		String[] servicios = { "a", "b", "c", "d", "e" };
//		// TODO agregar los productos correctos!!!
//		JComboBox comboServicios = new JComboBox(servicios);
//
//		JPanel auxiliarServicios = new JPanel();
//		auxiliarServicios.setLayout(new BoxLayout(auxiliarServicios, BoxLayout.X_AXIS));
//		auxiliarServicios.setBackground(parametros.getColorCuerpo());
//		auxiliarServicios.add(comboServicios, SwingConstants.CENTER);
//
//		// Cuenta de Habitacion
//		ButtonGroup grupoCuentaHabitacion = new ButtonGroup();
//		JRadioButton botonSi = new JRadioButton("Sí");
//		botonSi.setBackground(parametros.getColorCuerpo());
//		grupoCuentaHabitacion.add(botonSi);
//		JRadioButton botonNo = new JRadioButton("No");
//		botonNo.setBackground(parametros.getColorCuerpo());
//		grupoCuentaHabitacion.add(botonNo);
//
//		JPanel auxiliarCuentaHabitacion = new JPanel();
//		auxiliarCuentaHabitacion.setLayout(new BoxLayout(auxiliarCuentaHabitacion, BoxLayout.X_AXIS));
//		auxiliarCuentaHabitacion.setBackground(parametros.getColorCuerpo());
//		auxiliarCuentaHabitacion.add(Box.createHorizontalGlue());
//		auxiliarCuentaHabitacion.add(botonSi);
//		auxiliarCuentaHabitacion.add(botonNo);
//		auxiliarCuentaHabitacion.add(Box.createHorizontalGlue());
//
//		// Documento
//		JPanel auxiliarDocumento = new JPanel();
//		auxiliarDocumento.setLayout(new FlowLayout());
//		auxiliarDocumento.setBackground(parametros.getColorCuerpo());
//		JTextField documentoInicioTextField = new JTextField();
//		documentoInicioTextField.setPreferredSize(new Dimension(200, 75));
//		auxiliarDocumento.add(documentoInicioTextField);
//
//		// ID Habitacion
//		JPanel auxiliarIdHabitacion = new JPanel();
//		auxiliarIdHabitacion.setLayout(new FlowLayout());
//		auxiliarIdHabitacion.setBackground(parametros.getColorCuerpo());
//		JTextField idHabitacionFinTextField = new JTextField();
//		idHabitacionFinTextField.setPreferredSize(new Dimension(200, 75));
//		auxiliarIdHabitacion.add(idHabitacionFinTextField);
//
//		/// ADD
//
//		add(servicio);
//		add(auxiliarServicios);
//		add(cuentaHabitacion);
//		add(auxiliarCuentaHabitacion);
//		add(documento);
//		add(auxiliarDocumento);
//		add(idHabitacion);
//		add(auxiliarIdHabitacion);
//
//	}

}
