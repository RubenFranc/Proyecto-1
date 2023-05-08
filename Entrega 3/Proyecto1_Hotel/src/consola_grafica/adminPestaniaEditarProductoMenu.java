package consola_grafica;

import javax.swing.*;

import Controlador.ControladorAdministrador;
import Model.Hotel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class adminPestaniaEditarProductoMenu extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

        ControladorAdministrador controlador = new ControladorAdministrador();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(5, 2, 10, 10));

		/// ELEMENTOS
		JLabel producto = new JLabel("Producto", SwingConstants.CENTER);
		JLabel servicioCuarto = new JLabel("¿Tiene servicio al cuarto?", SwingConstants.CENTER);
		JLabel horaInicio = new JLabel("Hora de inicio (mmHH, 24h)", SwingConstants.CENTER);
		JLabel horaFin = new JLabel("Hora de fin (mmHH, 24h)", SwingConstants.CENTER);
		JLabel tarifa = new JLabel("Nueva tarifa", SwingConstants.CENTER);

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

		// Servicio al cuarto
		ButtonGroup grupoServicioCuarto = new ButtonGroup();
		JRadioButton botonSi = new JRadioButton("Sí");
		botonSi.setBackground(parametros.getColorCuerpo());
		botonSi.setActionCommand("Sí");
		grupoServicioCuarto.add(botonSi);
		JRadioButton botonNo = new JRadioButton("No");
		botonNo.setBackground(parametros.getColorCuerpo());
		botonNo.setActionCommand("No");
		grupoServicioCuarto.add(botonNo);

		JPanel auxiliarServicioCuarto = new JPanel();
		auxiliarServicioCuarto.setLayout(new FlowLayout());
		auxiliarServicioCuarto.setBackground(parametros.getColorCuerpo());
		auxiliarServicioCuarto.add(botonSi);
		auxiliarServicioCuarto.add(botonNo);

		// Hora Inicio
		JPanel auxiliarHoraInicio = new JPanel();
		auxiliarHoraInicio.setLayout(new FlowLayout());
		auxiliarHoraInicio.setBackground(parametros.getColorCuerpo());
		JTextField horaInicioTextField = new JTextField();
		horaInicioTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarHoraInicio.add(horaInicioTextField);

		// Hora Fin
		JPanel auxiliarHoraFin = new JPanel();
		auxiliarHoraFin.setLayout(new FlowLayout());
		auxiliarHoraFin.setBackground(parametros.getColorCuerpo());
		JTextField horaFinTextField = new JTextField();
		horaFinTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarHoraFin.add(horaFinTextField);

		// Tarifa
		JPanel auxiliarTarifa = new JPanel();
		auxiliarTarifa.setLayout(new FlowLayout());
		auxiliarTarifa.setBackground(parametros.getColorCuerpo());
		JTextField tarifaTextField = new JTextField();
		tarifaTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarTarifa.add(tarifaTextField);

		/// ADD

		panel.add(producto);
		panel.add(auxiliarProductos);
		panel.add(servicioCuarto);
		panel.add(auxiliarServicioCuarto);
		panel.add(horaInicio);
		panel.add(auxiliarHoraInicio);
		panel.add(horaFin);
		panel.add(auxiliarHoraFin);
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
			ButtonModel servicioACuarto = grupoServicioCuarto.getSelection();
			String servicio = servicioACuarto.getActionCommand();
			boolean serv = false;
			if (servicio.equals("Sí")) {
				serv = true;
			}
			String nombre = (String) comboProductos.getSelectedItem();
			String horaIni = horaInicioTextField.getText();
			int ini = Integer.parseInt(horaIni);
			String horaFina = horaFinTextField.getText();
			int fina = Integer.parseInt(horaFina);
			String nuevoPrecio = tarifaTextField.getText();
			double tari = Double.parseDouble(nuevoPrecio);
			String mssg = controlador.cambiarInfoProductoRestaurante(nombre, tari, serv, ini, fina, hotel);
			JOptionPane.showMessageDialog(null, "Operación realizada con éxito.");
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

//	public adminPestaniaEditarProductoMenu() {
//
//		/// CONFIGURACION
//		setPreferredSize(parametros.getDimensionCuerpo());
//		setBackground(parametros.getColorCuerpo());
//		setLayout(new GridLayout(5, 2, 10, 10));
//
//		/// ELEMENTOS
//		JLabel producto = new JLabel("Producto", SwingConstants.CENTER);
//		JLabel servicioCuarto = new JLabel("¿Tiene servicio al cuarto?", SwingConstants.CENTER);
//		JLabel horaInicio = new JLabel("Hora de inicio", SwingConstants.CENTER);
//		JLabel horaFin = new JLabel("Hora de fin", SwingConstants.CENTER);
//		JLabel tarifa = new JLabel("Nueva tarifa", SwingConstants.CENTER);
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
//		// Servicio al cuarto
//		ButtonGroup grupoServicioCuarto = new ButtonGroup();
//		JRadioButton botonSi = new JRadioButton("Sí");
//		botonSi.setBackground(parametros.getColorCuerpo());
//		grupoServicioCuarto.add(botonSi);
//		JRadioButton botonNo = new JRadioButton("No");
//		botonNo.setBackground(parametros.getColorCuerpo());
//		grupoServicioCuarto.add(botonNo);
//
//		JPanel auxiliarServicioCuarto = new JPanel();
//		auxiliarServicioCuarto.setLayout(new FlowLayout());
//		auxiliarServicioCuarto.setBackground(parametros.getColorCuerpo());
//		auxiliarServicioCuarto.add(botonSi);
//		auxiliarServicioCuarto.add(botonNo);
//
//		// Hora Inicio
//		JPanel auxiliarHoraInicio = new JPanel();
//		auxiliarHoraInicio.setLayout(new FlowLayout());
//		auxiliarHoraInicio.setBackground(parametros.getColorCuerpo());
//		JTextField horaInicioTextField = new JTextField();
//		horaInicioTextField.setPreferredSize(new Dimension(200, 75));
//		auxiliarHoraInicio.add(horaInicioTextField);
//
//		// Hora Fin
//		JPanel auxiliarHoraFin = new JPanel();
//		auxiliarHoraFin.setLayout(new FlowLayout());
//		auxiliarHoraFin.setBackground(parametros.getColorCuerpo());
//		JTextField horaFinTextField = new JTextField();
//		horaFinTextField.setPreferredSize(new Dimension(200, 75));
//		auxiliarHoraFin.add(horaFinTextField);
//
//		// Tarifa
//		JPanel auxiliarTarifa = new JPanel();
//		auxiliarTarifa.setLayout(new FlowLayout());
//		auxiliarTarifa.setBackground(parametros.getColorCuerpo());
//		JTextField tarifaTextField = new JTextField();
//		tarifaTextField.setPreferredSize(new Dimension(200, 75));
//		auxiliarTarifa.add(tarifaTextField);
//
//		/// ADD
//
//		add(producto);
//		add(auxiliarProductos);
//		add(servicioCuarto);
//		add(auxiliarServicioCuarto);
//		add(horaInicio);
//		add(auxiliarHoraInicio);
//		add(horaFin);
//		add(auxiliarHoraFin);
//		add(tarifa);
//		add(auxiliarTarifa);
//
//	}

}