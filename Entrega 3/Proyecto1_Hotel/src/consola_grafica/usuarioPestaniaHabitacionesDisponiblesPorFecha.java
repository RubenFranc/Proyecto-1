package consola_grafica;

import javax.swing.*;

import Controlador.ControladorUsuario;
import Model.Habitacion;
import Model.Hotel;
import Model.HabitacionOcupada;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class usuarioPestaniaHabitacionesDisponiblesPorFecha extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

		ControladorUsuario controlador = new ControladorUsuario();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(2, 1, 20, 20));

		/// ELEMENTOS
		JLabel fechaInicio = new JLabel("Fecha de inicio (DD/MM)", SwingConstants.CENTER);
		JLabel fechaFin = new JLabel("Fecha de fin (DD/MM)", SwingConstants.CENTER);
		
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
		
		//ADD
		panel.add(fechaInicio);
		panel.add(auxiliarFechaInicio);
		panel.add(fechaFin);
		panel.add(auxiliarFechaFin);

		// Botones
		JButton estandaresDisponibles = new JButton("Estandares Disponibles");
		JButton suitesDisponibles = new JButton("Suites Disponibles");
		JButton suitesDoblesDisponibles = new JButton("Suites Dobles Disponibles");

		estandaresDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
		suitesDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
		suitesDoblesDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
		
		estandaresDisponibles.addActionListener(event -> {
			String fIn = fechaInicioTextField.getText();
			String fFi = fechaFinTextField.getText();
			Map<String , ArrayList<Habitacion>> habitacionesDisponibles = controlador.consultarHabitacionesDisponiblesporFecha(hotel,fIn, fFi);
			String mssg = "*Estándar:";
			ArrayList<Habitacion> habitacionesTipo = habitacionesDisponibles.get("e");
			for (Habitacion habitacion: habitacionesTipo) {
				String propiedades = habitacion.getPropiedades();
				String[] partes = propiedades.split(",");
				mssg += "\n\n    -Habitación " + habitacion.getId() + ":";
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
			JOptionPane.showMessageDialog(null, mssg);
		});
		suitesDisponibles.addActionListener(event -> {
			String fIn = fechaInicioTextField.getText();
			String fFi = fechaFinTextField.getText();
			Map<String , ArrayList<Habitacion>> habitacionesDisponibles = controlador.consultarHabitacionesDisponiblesporFecha(hotel,fIn, fFi);
			String mssg = "*Suites:";
			ArrayList<Habitacion> habitacionesTipo = habitacionesDisponibles.get("s");
			for (Habitacion habitacion: habitacionesTipo) {
				String propiedades = habitacion.getPropiedades();
				String[] partes = propiedades.split(",");
				mssg += "\n\n    -Habitación " + habitacion.getId() + ":";
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
			JOptionPane.showMessageDialog(null, mssg);
		});
		suitesDoblesDisponibles.addActionListener(event -> {
			String fIn = fechaInicioTextField.getText();
			String fFi = fechaFinTextField.getText();
			Map<String , ArrayList<Habitacion>> habitacionesDisponibles = controlador.consultarHabitacionesDisponiblesporFecha(hotel,fIn, fFi);
			String mssg = "*Suites dobles:";
			ArrayList<Habitacion> habitacionesTipo = habitacionesDisponibles.get("sd");
			for (Habitacion habitacion: habitacionesTipo) {
				mssg += "\n    -Habitación " + habitacion.getId() + ":";
				String propiedades = habitacion.getPropiedades();
				String[] partes = propiedades.split(",");
				mssg += "\n\n    -Habitación " + habitacion.getId() + ":";
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
			JOptionPane.showMessageDialog(null, mssg);
		});

		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new BoxLayout(auxiliar, BoxLayout.Y_AXIS));
		auxiliar.setBackground(parametros.getColorCuerpo());

		auxiliar.add(Box.createVerticalGlue());
		auxiliar.add(estandaresDisponibles);
		auxiliar.add(suitesDisponibles);
		auxiliar.add(suitesDoblesDisponibles);
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

}
