package consola_grafica;

import javax.swing.*;

import Controlador.ControladorEmpleado;
import Model.Habitacion;
import Model.HabitacionOcupada;
import Model.Hotel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class empleadoPestaniaHabitacionesOcupadas extends JPanel {

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
		JButton estandaresOcupadas = new JButton("Estandares Ocupadas");
		JButton suitesOcupadas = new JButton("Suites Ocupadas");
		JButton suitesDoblesOcupadas = new JButton("Suites Dobles Ocupadas");

		estandaresOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
		suitesOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
		suitesDoblesOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());

		estandaresOcupadas.addActionListener(event -> {
			Map<String, Map<String, ArrayList<HabitacionOcupada>>> habitacionesOcupadas = controlador.consultarHabitacionesOcupadas(hotel);
			String mssg = "*Estándar:";
			try {
				Set<String> habitacionesTipo = habitacionesOcupadas.get("e").keySet();
				for (String id: habitacionesTipo) {
					for (HabitacionOcupada hab: habitacionesOcupadas.get("e").get(id)) {
						mssg += "\n\n    -Habitación " + id + ": " + hab.getFechaInicio() + " -> " + hab.getFechaFinal();
						mssg += "\n       Ocupantes: " + hab.getOcupantes();
						String propiedades = hab.getPropiedades();
						String[] partes = propiedades.split(",");
						mssg += "\n       Capacidad: " + partes[0];
						mssg += "\n       Con balcón: " + partes[1];
						mssg += "\n       Con ventana: " + partes[2];
						mssg += "\n       Con cocina: " + partes[3];
						
						mssg += "\n       Metros cuadrados: " + partes[4] + "m2";
						mssg += "\n       Con aire acondicionado: " + partes[5];
						mssg += "\n       Con calefacción: " + partes[6];
						mssg += "\n       Tamaño cama: " + partes[7];
						
						mssg += "\n       Con cafetera: " + partes[8];
						mssg += "\n       Con ropa de cama y tapetes hipoalergénicos: " + partes[9];
						mssg += "\n       Con plancha: " + partes[10];
						mssg += "\n       Con secador de pelo: " + partes[11];
						
						mssg += "\n       Voltaje AC: " + partes[12];
						mssg += "\n       Con conexión USB-A: " + partes[13];
						mssg += "\n       Con conexión USB-C: " + partes[14];
						mssg += "\n       Incluye desayuno: " + partes[15];
						
						String[] partesHotel = hotel.getPropiedadesHotel().split(",");
						
						mssg += "\n\n    -Hotel ";
						
						mssg += "\n       Con parqueadero pago: " + partesHotel[0];
						mssg += "\n       Con parqueadero gratuito: " + partesHotel[1];
						mssg += "\n       Con piscina: " + partesHotel[2];
						mssg += "\n       Con zonas húmedas: " + partesHotel[3];
						
						mssg += "\n       Con BBQ: " + partesHotel[4];
						mssg += "\n       Con WiFi gratis: " + partesHotel[5];
						mssg += "\n       Recepción 24 horas: " + partesHotel[6];
						mssg += "\n       Admite mascotas: " + partesHotel[7];
					}
				}
			}
			catch (NullPointerException e){
				mssg += "";
			}
			JOptionPane.showMessageDialog(null, mssg);
		});
		suitesOcupadas.addActionListener(event -> {
			Map<String, Map<String, ArrayList<HabitacionOcupada>>> habitacionesOcupadas = controlador.consultarHabitacionesOcupadas(hotel);
			String mssg = "*Suites:";
			try {
				Set<String> habitacionesTipo = habitacionesOcupadas.get("s").keySet();
				for (String id: habitacionesTipo) {
					for (HabitacionOcupada hab: habitacionesOcupadas.get("s").get(id)) {
						mssg += "\n\n    -Habitación " + id + ": " + hab.getFechaInicio() + " - " + hab.getFechaFinal();
						mssg += "\n       Ocupantes: " + hab.getOcupantes();
						String propiedades = hab.getPropiedades();
						String[] partes = propiedades.split(",");
						mssg += "\n       Capacidad: " + partes[0];
						mssg += "\n       Con balcón: " + partes[1];
						mssg += "\n       Con ventana: " + partes[2];
						mssg += "\n       Con cocina: " + partes[3];
						
						mssg += "\n       Metros cuadrados: " + partes[4] + "m2";
						mssg += "\n       Con aire acondicionado: " + partes[5];
						mssg += "\n       Con calefacción: " + partes[6];
						mssg += "\n       Tamaño cama: " + partes[7];
						
						mssg += "\n       Con cafetera: " + partes[8];
						mssg += "\n       Con ropa de cama y tapetes hipoalergénicos: " + partes[9];
						mssg += "\n       Con plancha: " + partes[10];
						mssg += "\n       Con secador de pelo: " + partes[11];
						
						mssg += "\n       Voltaje AC: " + partes[12];
						mssg += "\n       Con conexión USB-A: " + partes[13];
						mssg += "\n       Con conexión USB-C: " + partes[14];
						mssg += "\n       Incluye desayuno: " + partes[15];
						
						String[] partesHotel = hotel.getPropiedadesHotel().split(",");
						
						mssg += "\n\n    -Hotel ";
						
						mssg += "\n       Con parqueadero pago: " + partesHotel[0];
						mssg += "\n       Con parqueadero gratuito: " + partesHotel[1];
						mssg += "\n       Con piscina: " + partesHotel[2];
						mssg += "\n       Con zonas húmedas: " + partesHotel[3];
						
						mssg += "\n       Con BBQ: " + partesHotel[4];
						mssg += "\n       Con WiFi gratis: " + partesHotel[5];
						mssg += "\n       Recepción 24 horas: " + partesHotel[6];
						mssg += "\n       Admite mascotas: " + partesHotel[7];
					}
				}
			}
			catch (NullPointerException e){
				mssg += "";
			}
			
			JOptionPane.showMessageDialog(null, mssg);
		});
		suitesDoblesOcupadas.addActionListener(event -> {
			Map<String, Map<String, ArrayList<HabitacionOcupada>>> habitacionesOcupadas = controlador.consultarHabitacionesOcupadas(hotel);
			String mssg = "*Suites dobles:";
			try {
				Set<String> habitacionesTipo = habitacionesOcupadas.get("sd").keySet();
				for (String id: habitacionesTipo) {
					for (HabitacionOcupada hab: habitacionesOcupadas.get("sd").get(id)) {
						mssg += "\n\n    -Habitación " + id + ": " + hab.getFechaInicio() + " - " + hab.getFechaFinal();
						mssg += "\n       Ocupantes: " + hab.getOcupantes();
						String propiedades = hab.getPropiedades();
						String[] partes = propiedades.split(",");
						mssg += "\n       Capacidad: " + partes[0];
						mssg += "\n       Con balcón: " + partes[1];
						mssg += "\n       Con ventana: " + partes[2];
						mssg += "\n       Con cocina: " + partes[3];
						
						mssg += "\n       Metros cuadrados: " + partes[4] + "m2";
						mssg += "\n       Con aire acondicionado: " + partes[5];
						mssg += "\n       Con calefacción: " + partes[6];
						mssg += "\n       Tamaño cama: " + partes[7];
						
						mssg += "\n       Con cafetera: " + partes[8];
						mssg += "\n       Con ropa de cama y tapetes hipoalergénicos: " + partes[9];
						mssg += "\n       Con plancha: " + partes[10];
						mssg += "\n       Con secador de pelo: " + partes[11];
						
						mssg += "\n       Voltaje AC: " + partes[12];
						mssg += "\n       Con conexión USB-A: " + partes[13];
						mssg += "\n       Con conexión USB-C: " + partes[14];
						mssg += "\n       Incluye desayuno: " + partes[15];
						
						String[] partesHotel = hotel.getPropiedadesHotel().split(",");
						
						mssg += "\n\n    -Hotel ";
						
						mssg += "\n       Con parqueadero pago: " + partesHotel[0];
						mssg += "\n       Con parqueadero gratuito: " + partesHotel[1];
						mssg += "\n       Con piscina: " + partesHotel[2];
						mssg += "\n       Con zonas húmedas: " + partesHotel[3];
						
						mssg += "\n       Con BBQ: " + partesHotel[4];
						mssg += "\n       Con WiFi gratis: " + partesHotel[5];
						mssg += "\n       Recepción 24 horas: " + partesHotel[6];
						mssg += "\n       Admite mascotas: " + partesHotel[7];
					}
				}
			}
			catch (NullPointerException e){
				mssg += "";
			}
			JOptionPane.showMessageDialog(null, mssg);
		});
		
		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new BoxLayout(auxiliar, BoxLayout.Y_AXIS));
		auxiliar.setBackground(parametros.getColorCuerpo());

		auxiliar.add(Box.createVerticalGlue());
		auxiliar.add(estandaresOcupadas);
		auxiliar.add(suitesOcupadas);
		auxiliar.add(suitesDoblesOcupadas);
		auxiliar.add(Box.createVerticalGlue());

		/// ADD

		panel.add(auxiliar);
//		panel.add(informacion);

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

//	public empleadoPestaniaHabitacionesOcupadas() {
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
//		JButton estandaresOcupadas = new JButton("Estandares Ocupadas");
//		JButton suitesOcupadas = new JButton("Suites Ocupadas");
//		JButton suitesDoblesOcupadas = new JButton("Suites Dobles Ocupadas");
//
//		estandaresOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
//		suitesOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
//		suitesDoblesOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
//
//		JPanel auxiliar = new JPanel();
//		auxiliar.setLayout(new BoxLayout(auxiliar, BoxLayout.Y_AXIS));
//		auxiliar.setBackground(parametros.getColorCuerpo());
//
//		auxiliar.add(Box.createVerticalGlue());
//		auxiliar.add(estandaresOcupadas);
//		auxiliar.add(suitesOcupadas);
//		auxiliar.add(suitesDoblesOcupadas);
//		auxiliar.add(Box.createVerticalGlue());
//
//		/// ADD
//
//		add(auxiliar);
//		add(informacion);
//
//	}

}
