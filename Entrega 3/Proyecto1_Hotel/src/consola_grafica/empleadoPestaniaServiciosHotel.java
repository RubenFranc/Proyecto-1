package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class empleadoPestaniaServiciosHotel extends JPanel {

	public static JPanel getPestania() {

		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(3, 2, 10, 10));

		/// ELEMENTOS
		JLabel servicio = new JLabel("Servicio", SwingConstants.CENTER);
		JLabel precio = new JLabel("Precio", SwingConstants.CENTER);
		JLabel descripcion = new JLabel("Descripción", SwingConstants.CENTER);

		// Servicio
		String[] servicios = { "a", "b", "c", "d", "e" };
		// TODO agregar los productos correctos!!!
		JComboBox comboServicios = new JComboBox(servicios);

		JPanel auxiliarServicios = new JPanel();
		auxiliarServicios.setLayout(new BoxLayout(auxiliarServicios, BoxLayout.X_AXIS));
		auxiliarServicios.setBackground(parametros.getColorCuerpo());
		auxiliarServicios.add(comboServicios, SwingConstants.CENTER);

		// Precio
		JLabel infoPrecio = new JLabel("Info Precio");
		// TODO hacer que este label cambie dependiendo del servicio

		// Descripción
		JLabel infoDescripcion = new JLabel("Info Precio");
		// TODO hacer que este label cambie dependiendo del servicio

		/// ADD

		panel.add(servicio);
		panel.add(auxiliarServicios);
		panel.add(precio);
		panel.add(infoPrecio);
		panel.add(descripcion);
		panel.add(infoDescripcion);

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

	public empleadoPestaniaServiciosHotel() {

		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
		setBackground(parametros.getColorCuerpo());
		setLayout(new GridLayout(3, 2, 10, 10));

		/// ELEMENTOS
		JLabel servicio = new JLabel("Servicio", SwingConstants.CENTER);
		JLabel precio = new JLabel("Precio", SwingConstants.CENTER);
		JLabel descripcion = new JLabel("Descripción", SwingConstants.CENTER);

		// Servicio
		String[] servicios = { "a", "b", "c", "d", "e" };
		// TODO agregar los productos correctos!!!
		JComboBox comboServicios = new JComboBox(servicios);

		JPanel auxiliarServicios = new JPanel();
		auxiliarServicios.setLayout(new BoxLayout(auxiliarServicios, BoxLayout.X_AXIS));
		auxiliarServicios.setBackground(parametros.getColorCuerpo());
		auxiliarServicios.add(comboServicios, SwingConstants.CENTER);

		// Precio
		JLabel infoPrecio = new JLabel("Info Precio");
		// TODO hacer que este label cambie dependiendo del servicio

		// Descripción
		JLabel infoDescripcion = new JLabel("Info Precio");
		// TODO hacer que este label cambie dependiendo del servicio

		/// ADD

		add(servicio);
		add(auxiliarServicios);
		add(precio);
		add(infoPrecio);
		add(descripcion);
		add(infoDescripcion);

	}

}
