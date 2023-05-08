package consola_grafica;

import javax.swing.*;

import Controlador.ControladorEmpleado;
import Model.Hotel;
import Model.Servicio;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;

public class empleadoPestaniaServiciosHotel extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

		ControladorEmpleado controlador = new ControladorEmpleado();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(5, 2, 10, 10));

		/// ELEMENTOS
		JLabel servicio = new JLabel("Servicio", SwingConstants.CENTER);
//		JLabel precio = new JLabel("Precio", SwingConstants.CENTER);
//		JLabel descripcion = new JLabel("Descripción", SwingConstants.CENTER);

		// Servicio
		ArrayList<String> arregloServicios = new ArrayList();
		for (String servicio1: hotel.getServiciosHotel().keySet()) {
			arregloServicios.add(servicio1);
		}
		String [] servicios = arregloServicios.toArray(new String[0]);
		// TODO agregar los servicios correctos!!!
		JComboBox comboServicios = new JComboBox(servicios);


		JPanel auxiliarServicios = new JPanel();
		auxiliarServicios.setLayout(new BoxLayout(auxiliarServicios, BoxLayout.X_AXIS));
		auxiliarServicios.setBackground(parametros.getColorCuerpo());
		auxiliarServicios.add(comboServicios, SwingConstants.CENTER);

		// Precio
//		JLabel infoPrecio = new JLabel("Info Precio");
		// TODO hacer que este label cambie dependiendo del servicio

		// Descripción
//		JLabel infoDescripcion = new JLabel("Info Precio");
		// TODO hacer que este label cambie dependiendo del servicio

		/// ADD

		panel.add(servicio);
		panel.add(auxiliarServicios);
//		panel.add(precio);
//		panel.add(infoPrecio);
//		panel.add(descripcion);
//		panel.add(infoDescripcion);

		// FINAL

		JPanel panelFinal = new JPanel();

		panelFinal.setPreferredSize(parametros.getDimensionCuerpo());
		panelFinal.setBackground(parametros.getColorCuerpo());
		panelFinal.setLayout(new BorderLayout());

		JButton botonContinuar = new JButton("Consultar información");
		botonContinuar.setPreferredSize(new Dimension(200,20));
		botonContinuar.addActionListener(event -> {
			String mssg = "";
			String nombre = (String) comboServicios.getSelectedItem();
			Map<String, Servicio> services = controlador.consultarServicios(hotel);
			Servicio service = services.get(nombre);
			mssg += "    -" + nombre + ":";
			mssg += "\n       Precio: $" + service.getPrecio();
			mssg += "\n       En grupo: " + service.getEnGrupo();
			mssg += "\n       Descripción: " + service.getDescripcion();
			JOptionPane.showMessageDialog(null, mssg);
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

//	public empleadoPestaniaServiciosHotel() {
//
//		/// CONFIGURACION
//		setPreferredSize(parametros.getDimensionCuerpo());
//		setBackground(parametros.getColorCuerpo());
//		setLayout(new GridLayout(3, 2, 10, 10));
//
//		/// ELEMENTOS
//		JLabel servicio = new JLabel("Servicio", SwingConstants.CENTER);
//		JLabel precio = new JLabel("Precio", SwingConstants.CENTER);
//		JLabel descripcion = new JLabel("Descripción", SwingConstants.CENTER);
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
//		// Precio
//		JLabel infoPrecio = new JLabel("Info Precio");
//		// TODO hacer que este label cambie dependiendo del servicio
//
//		// Descripción
//		JLabel infoDescripcion = new JLabel("Info Precio");
//		// TODO hacer que este label cambie dependiendo del servicio
//
//		/// ADD
//
//		add(servicio);
//		add(auxiliarServicios);
//		add(precio);
//		add(infoPrecio);
//		add(descripcion);
//		add(infoDescripcion);
//
//	}

}
