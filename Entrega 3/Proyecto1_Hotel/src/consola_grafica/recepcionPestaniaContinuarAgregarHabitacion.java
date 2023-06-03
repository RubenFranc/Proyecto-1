package consola_grafica;

import javax.swing.*;

import Controlador.ControladorRecepcionista;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.Reserva;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class recepcionPestaniaContinuarAgregarHabitacion extends JPanel {

	public static JPanel getPestania(Hotel hotel, String doc, String fIn, String fFi, String nom, boolean pag) {

		ControladorRecepcionista controlador = new ControladorRecepcionista();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		// setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(2, 2, 10, 190));

		/// ELEMENTOS
		JLabel numeroOcupantes = new JLabel("Nombre de ocupantes (separados por , 'coma')", SwingConstants.CENTER);
		JLabel tipo = new JLabel("Tipo de habitación", SwingConstants.CENTER);
		
//		JLabel titulo = new JLabel("Habitación #");
//		// TODO Poner lógica para que se identifique qué # de habitación es	dentro de la reserva
//		JPanel auxiliarTitulo = new JPanel();
//		auxiliarTitulo.setBackground(parametros.getColorCuerpo());
//		auxiliarTitulo.add(titulo);


		// Capacidad
		JPanel auxiliarNumeroOcupantes = new JPanel();
		auxiliarNumeroOcupantes.setLayout(new FlowLayout());
		auxiliarNumeroOcupantes.setBackground(parametros.getColorCuerpo());
		JTextField capacidadTextField = new JTextField();
		capacidadTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarNumeroOcupantes.add(capacidadTextField);

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

		/// ADD

		panel.add(tipo);
		panel.add(auxiliarTipo);
		panel.add(numeroOcupantes);
		panel.add(auxiliarNumeroOcupantes);

		// FINAL

		JPanel panelFinal = new JPanel();

		panelFinal.setPreferredSize(parametros.getDimensionCuerpo());
		panelFinal.setBackground(parametros.getColorCuerpo());
		panelFinal.setLayout(new BorderLayout());
		
		ArrayList<Integer> indexi = new ArrayList<>();

		JButton botonContinuar = new JButton("Agregar habitación");
		botonContinuar.setPreferredSize(new Dimension(200,100));
		botonContinuar.addActionListener(event -> {
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
			String ocup = capacidadTextField.getText();
			String[] partes = ocup.split(",");
			ArrayList<String> ocu = new ArrayList<String>(Arrays.asList(partes));
			HabitacionOcupada habOcup = controlador.ocuparHabitacion(hotel, fIn, fFi, tipi, doc);
			if (habOcup.getId().equals("")) {
				JOptionPane.showMessageDialog(null, "No hay habitaciones disponibles del tipo seleccionado para las fechas de la reserva.");
			}
			else {
				String mssg = "";
				mssg += "\nSe encontró una habitación: habitación " + habOcup.getId() + "\nCapacidad: " + habOcup.getPropiedades().split(",")[0] + "\n";
				ArrayList<String> fechasEnRango = controlador.fechasEnRango(fIn, fFi);
				double tarifa = 0.0;
				double totalTarifa = 0.0;
				mssg += "\nTarifa habitación por día:\n";
				for (String fecha: fechasEnRango) {
					if (hotel.getModificacionesHabitaciones().containsKey(habOcup.getTipoHabitacion())) {
						if (hotel.getModificacionesHabitaciones().get(habOcup.getTipoHabitacion()).containsKey(fecha)) {
							tarifa = hotel.getModificacionesHabitaciones().get(habOcup.getTipoHabitacion()).get(fecha);
						}
						else {
							tarifa = habOcup.getTarifa();
						}
					
					}
					else {
						tarifa = habOcup.getTarifa();
					}
					totalTarifa += tarifa;
					mssg += fecha + ": $" + tarifa + "\n";
				}
				mssg += "\nTarifa total habitación: $" + totalTarifa;
				JOptionPane.showMessageDialog(null,mssg);
				
				int last = hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).lastIndexOf(habOcup);
				hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).get(last).addOcupantes(ocu);
				ArrayList<Reserva> reservasHuesped = hotel.getReservas().get(doc);
				int indexReserva = 10000000;
				if (indexReserva == 10000000) {
					for (int index = 0; index < reservasHuesped.size(); index++) {
						ArrayList<String> acomp = reservasHuesped.get(index).getHuesped().getAcompañantes();
						Collections.sort(acomp);
						if (reservasHuesped.get(index).getfechaInicio().equals(fIn)) {
							controlador.agregarHabitacionAReserva(hotel.getReservas().get(doc).get(index), hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).get(last));
							indexReserva = index;
							break;
						}
					}
				}
				else {
					if (reservasHuesped.get(indexReserva).getfechaInicio().equals(fIn)) {// & acomp == acompañantes) {
						controlador.agregarHabitacionAReserva(hotel.getReservas().get(doc).get(indexReserva), hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).get(last));
					}
				}
				indexi.add(indexReserva);
			}
			
		});
		
		JButton botonTerminar = new JButton("Dejar de agregar habitaciones");
		botonTerminar.setPreferredSize(new Dimension(200,100));
		botonTerminar.addActionListener(event -> {
			if (pag) {
				int indexReserva = indexi.get(0);
				JPanel pestaniaCambiarTarjeta = recepcionPestaniaCambiarInfoTarjeta.getPestania(hotel, hotel.getReservas().get(doc).get(indexReserva),pag);
	        	panelFinal.removeAll();
	        	panelFinal.add(pestaniaCambiarTarjeta, BorderLayout.CENTER);
	        	panelFinal.revalidate();
	        	panelFinal.repaint();
			}
//			JOptionPane.showMessageDialog(null, "Reserva a nombre de " + nom + " creada.");
//			JPanel pestaniaCrearReserva= recepcionPestaniaCrearReserva.getPestania(hotel);
//        	panelFinal.removeAll();
//        	panelFinal.add(pestaniaCrearReserva, BorderLayout.CENTER);
//        	panelFinal.revalidate();
//        	panelFinal.repaint();
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
		continuarPanel.add(botonTerminar);
		continuarPanel.add(Box.createVerticalGlue());
		continuarPanel.add(Box.createHorizontalGlue());

		panelFinal.add(panel, BorderLayout.CENTER);
		panelFinal.add(continuarPanel, BorderLayout.SOUTH);
//		panelFinal.add(auxiliarTitulo, BorderLayout.NORTH);

		return panelFinal;
	}

//	public recepcionPestaniaContinuarAgregarHabitacion() {
//
//		/// CONFIGURACION
//		setPreferredSize(parametros.getDimensionCuerpo());
//		setBackground(parametros.getColorCuerpo());
//		setLayout(new GridLayout(2, 2, 10, 190));
//
//		/// ELEMENTOS
//		JLabel numeroOcupantes = new JLabel("Número de acompañantes en esta habitación", SwingConstants.CENTER);
//		JLabel tipo = new JLabel("Tipo de habitación", SwingConstants.CENTER);
//		
////		JLabel titulo = new JLabel("Habitación #");
////		// TODO Poner lógica para que se identifique qué # de habitación es	dentro de la reserva
////		JPanel auxiliarTitulo = new JPanel();
////		auxiliarTitulo.setBackground(parametros.getColorCuerpo());
////		auxiliarTitulo.add(titulo);
//
//
//		// Capacidad
//		JPanel auxiliarNumeroOcupantes = new JPanel();
//		auxiliarNumeroOcupantes.setLayout(new FlowLayout());
//		auxiliarNumeroOcupantes.setBackground(parametros.getColorCuerpo());
//		JTextField capacidadTextField = new JTextField();
//		capacidadTextField.setPreferredSize(new Dimension(200, 20));
//		auxiliarNumeroOcupantes.add(capacidadTextField);
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
//		/// ADD
//
//		add(numeroOcupantes);
//		add(auxiliarNumeroOcupantes);
//		add(tipo);
//		add(auxiliarTipo);
//
//	}
	
}

