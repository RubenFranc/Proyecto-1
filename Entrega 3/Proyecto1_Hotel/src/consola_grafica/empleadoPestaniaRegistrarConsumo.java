package consola_grafica;

import javax.swing.*;

import Controlador.ControladorEmpleado;
import Model.Hotel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class empleadoPestaniaRegistrarConsumo extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

		ControladorEmpleado controlador = new ControladorEmpleado();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(6, 2, 10, 10));

		/// ELEMENTOS
		JLabel producto = new JLabel("Producto", SwingConstants.CENTER);
		JLabel cuentaHabitacion = new JLabel("¿Cargar a la cuenta de la habitación?", SwingConstants.CENTER);
		JLabel documento = new JLabel("Documento huesped", SwingConstants.CENTER);
		JLabel idHabitacion = new JLabel("ID de la habitación", SwingConstants.CENTER);
		JLabel fechaActual = new JLabel("Fecha actual (DD/MM)", SwingConstants.CENTER);
		JLabel horaActual = new JLabel("Hora actual (HHmm, 24h)", SwingConstants.CENTER);

		// Producto
		ArrayList<String> arregloProductos = new ArrayList();
		for (String producto1: hotel.getMenuHotel().keySet()) {
			arregloProductos.add(producto1);
		}
		String [] productos = arregloProductos.toArray(new String[0]);
		// TODO agregar los productos correctos!!!
		JComboBox comboProductos = new JComboBox(productos);

		JPanel auxiliarProductos = new JPanel();
		auxiliarProductos.setLayout(new BoxLayout(auxiliarProductos, BoxLayout.X_AXIS));
		auxiliarProductos.setBackground(parametros.getColorCuerpo());
		auxiliarProductos.add(comboProductos, SwingConstants.CENTER);

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
				
		// Fecha Actual
		JPanel auxiliarHoraActual = new JPanel();
		auxiliarHoraActual.setLayout(new FlowLayout());
		auxiliarHoraActual.setBackground(parametros.getColorCuerpo());
		JTextField horaActualTextField = new JTextField();
		horaActualTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarHoraActual.add(horaActualTextField);
		
		/// ADD

		panel.add(producto);
		panel.add(auxiliarProductos);
		panel.add(cuentaHabitacion);
		panel.add(auxiliarCuentaHabitacion);
		panel.add(documento);
		panel.add(auxiliarDocumento);
		panel.add(idHabitacion);
		panel.add(auxiliarIdHabitacion);
		panel.add(fechaActual);
		panel.add(auxiliarFechaActual);
		panel.add(horaActual);
		panel.add(auxiliarHoraActual);

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
			String nombre = (String) comboProductos.getSelectedItem();
			ArrayList<String> products = new ArrayList<>();
			products.add(nombre);
			String doc = documentoInicioTextField.getText();
			String id = idHabitacionFinTextField.getText();
			String fAc = fechaActualTextField.getText();
			String horaAct = horaActualTextField.getText();
			int hAc = Integer.parseInt(horaAct);
			boolean cargar = false;
			if (aCuenta.equals("Sí")) {
				cargar = true;
			}
			String factura = controlador.registrarConsumoRestaurante(hotel, id, doc, cargar, products, fAc, hAc);
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

//	public empleadoPestaniaRegistrarConsumo() {
//
//		/// CONFIGURACION
//		setPreferredSize(parametros.getDimensionCuerpo());
//		setBackground(parametros.getColorCuerpo());
//		setLayout(new GridLayout(4, 2, 10, 10));
//
//		/// ELEMENTOS
//		JLabel producto = new JLabel("Producto", SwingConstants.CENTER);
//		JLabel cuentaHabitacion = new JLabel("¿Cargar a la cuenta de la habitación?", SwingConstants.CENTER);
//		JLabel documento = new JLabel("Documento huesped", SwingConstants.CENTER);
//		JLabel idHabitacion = new JLabel("ID de la habitación", SwingConstants.CENTER);
//
//		// Producto
//		String[] productos = { "a", "b", "c", "d", "e" };
//		// TODO agregar los productos correctos!!!
//		JComboBox comboProductos = new JComboBox(productos);
//
//		JPanel auxiliarProductos = new JPanel();
//		auxiliarProductos.setLayout(new BoxLayout(auxiliarProductos, BoxLayout.X_AXIS));
//		auxiliarProductos.setBackground(parametros.getColorCuerpo());
//		auxiliarProductos.add(comboProductos, SwingConstants.CENTER);
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
//		add(producto);
//		add(auxiliarProductos);
//		add(cuentaHabitacion);
//		add(auxiliarCuentaHabitacion);
//		add(documento);
//		add(auxiliarDocumento);
//		add(idHabitacion);
//		add(auxiliarIdHabitacion);
//
//	}

}
