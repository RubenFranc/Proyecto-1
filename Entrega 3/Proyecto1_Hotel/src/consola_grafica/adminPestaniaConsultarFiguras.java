package consola_grafica;

import javax.swing.*;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.SwingWrapper;

import Controlador.ControladorEmpleado;
import Model.Habitacion;
import Model.Hotel;
import figuras.GraficaRelacionRestauranteTarifa;
import figuras.GraficaRelacionServiciosTarifa;
import figuras.GraficaValorFacturas;
import figuras.GraficaVentasRestaurante;
import figuras.GraficaVentasServicios;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.Set;

public class adminPestaniaConsultarFiguras extends JPanel {

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
		JButton ventasRestaurante = new JButton("Ventas restaurante");
		JButton ventasServicios = new JButton("Servicios ofrecidos");
		JButton valorFacturas = new JButton("Suma Total de las facturas a lo largo del tiempo");
		JButton relacionRestauranteTarifa = new JButton("Relación tarifaHabitación/consumoRestaurante");
		JButton relacionServicioTarifa = new JButton("Relación tarifaHabitación/consumoServicios");

		ventasRestaurante.setPreferredSize(parametros.getDimensionBotonBarra());
		valorFacturas.setPreferredSize(parametros.getDimensionBotonBarra());
		relacionRestauranteTarifa.setPreferredSize(parametros.getDimensionBotonBarra());
		relacionServicioTarifa.setPreferredSize(parametros.getDimensionBotonBarra());
		ventasServicios.setPreferredSize(parametros.getDimensionBotonBarra());

		ventasRestaurante.addActionListener(event -> {
			new GraficaVentasRestaurante(hotel);
			JOptionPane.showMessageDialog(null, "Consulte la carpeta 'Figuras' de la base de datos");
		});
		ventasServicios.addActionListener(event -> {
			new GraficaVentasServicios(hotel);
			JOptionPane.showMessageDialog(null, "Consulte la carpeta 'Figuras' de la base de datos");
		});
		valorFacturas.addActionListener(event -> {
			new GraficaValorFacturas(hotel);
			JOptionPane.showMessageDialog(null, "Consulte la carpeta 'Figuras' de la base de datos");
		});
		relacionRestauranteTarifa.addActionListener(event -> {
			new GraficaRelacionRestauranteTarifa(hotel);
			JOptionPane.showMessageDialog(null, "Consulte la carpeta 'Figuras' de la base de datos");
		});
		relacionServicioTarifa.addActionListener(event -> {
			new GraficaRelacionServiciosTarifa(hotel);
			JOptionPane.showMessageDialog(null, "Consulte la carpeta 'Figuras' de la base de datos");
		});

		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new BoxLayout(auxiliar, BoxLayout.Y_AXIS));
		auxiliar.setBackground(parametros.getColorCuerpo());

		auxiliar.add(Box.createVerticalGlue());
		auxiliar.add(ventasRestaurante);
		auxiliar.add(Box.createVerticalGlue());
		auxiliar.add(ventasServicios);
		auxiliar.add(Box.createVerticalGlue());
		auxiliar.add(valorFacturas);
		auxiliar.add(Box.createVerticalGlue());
		auxiliar.add(relacionRestauranteTarifa);
		auxiliar.add(Box.createVerticalGlue());
		auxiliar.add(relacionServicioTarifa);
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
