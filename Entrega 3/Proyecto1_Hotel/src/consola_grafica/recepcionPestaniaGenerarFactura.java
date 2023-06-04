package consola_grafica;

import javax.swing.*;

import Controlador.ControladorRecepcionista;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.Reserva;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class recepcionPestaniaGenerarFactura extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

		ControladorRecepcionista controlador = new ControladorRecepcionista();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new BorderLayout());

		/// ELEMENTOS
//		JLabel titulo = new JLabel("Generar Factura", SwingConstants.CENTER);
		JLabel documento = new JLabel("Documento del huésped", SwingConstants.CENTER);
		JLabel fechaInicio = new JLabel("Fecha de inicio (DD/MM)", SwingConstants.CENTER);
		JLabel fechaFin = new JLabel("Fecha de fin (DD/MM)", SwingConstants.CENTER);
		JLabel pasarelaDePago = new JLabel("PasarelaDePago", SwingConstants.CENTER);
		

		// Documento
		JPanel auxiliarDocumento = new JPanel();
		auxiliarDocumento.setLayout(new FlowLayout());
		auxiliarDocumento.setBackground(parametros.getColorCuerpo());
		JTextField documentoTextField = new JTextField();
		documentoTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarDocumento.add(documentoTextField);

		// Fecha Inicio
		JPanel auxiliarFechaInicio = new JPanel();
		auxiliarFechaInicio.setLayout(new FlowLayout());
		auxiliarFechaInicio.setBackground(parametros.getColorCuerpo());
		JTextField fechaInicioTextField = new JTextField();
		fechaInicioTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarFechaInicio.add(fechaInicioTextField);

		// Hora Fin
		JPanel auxiliarFechaFin = new JPanel();
		auxiliarFechaFin.setLayout(new FlowLayout());
		auxiliarFechaFin.setBackground(parametros.getColorCuerpo());
		JTextField fechaFinTextField = new JTextField();
		fechaFinTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarFechaFin.add(fechaFinTextField);
		
		// Pasarela
		ButtonGroup grupoPasarela = new ButtonGroup();
		JRadioButton botonPayPal = new JRadioButton("PayPal");
		botonPayPal.setBackground(parametros.getColorCuerpo());
		botonPayPal.setActionCommand("PayPal");
		grupoPasarela.add(botonPayPal);
		JRadioButton botonPayU = new JRadioButton("PayU");
		botonPayU.setBackground(parametros.getColorCuerpo());
		botonPayU.setActionCommand("PayU");
		grupoPasarela.add(botonPayU);
		JRadioButton botonSire = new JRadioButton("Sire");
		botonSire.setBackground(parametros.getColorCuerpo());
		botonSire.setActionCommand("Sire");
		grupoPasarela.add(botonSire);

		JPanel auxiliarPasarela = new JPanel();
		auxiliarPasarela.setLayout(new FlowLayout());
		auxiliarPasarela.setBackground(parametros.getColorCuerpo());
		auxiliarPasarela.add(botonPayPal);
		auxiliarPasarela.add(botonPayU);
		auxiliarPasarela.add(botonSire);

		/// ADD

		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new GridLayout(4, 2, 10, 20));
		auxiliar.setBackground(parametros.getColorCuerpo());

		auxiliar.add(documento);
		auxiliar.add(auxiliarDocumento);
		auxiliar.add(fechaInicio);
		auxiliar.add(auxiliarFechaInicio);
		auxiliar.add(fechaFin);
		auxiliar.add(auxiliarFechaFin);
		auxiliar.add(pasarelaDePago);
		auxiliar.add(auxiliarPasarela);
		

		panel.add(auxiliar);
//		panel.add(titulo, BorderLayout.NORTH);

		// FINAL

		JPanel panelFinal = new JPanel();

		panelFinal.setPreferredSize(parametros.getDimensionCuerpo());
		panelFinal.setBackground(parametros.getColorCuerpo());
		panelFinal.setLayout(new BorderLayout());

		JButton botonContinuar = new JButton("Continuar");
		botonContinuar.setPreferredSize(parametros.getDimensionBotonArriba());
		botonContinuar.addActionListener(event -> {
			String doc = documentoTextField.getText();
			String fIn = fechaInicioTextField.getText();
			String fFi = fechaFinTextField.getText();
			ButtonModel opcionPasarela = grupoPasarela.getSelection();
			String opPasarela = opcionPasarela.getActionCommand();
			String pasa = "Model.PayPal";
			try {
				pasa = hotel.escogerPasarela(opPasarela);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (hotel.getReservas().containsKey(doc)) {
				ArrayList<Reserva> reservasHuesped = hotel.getReservas().get(doc);
				Reserva reserva = null;
				for (int index = 0; index < reservasHuesped.size(); index++) {
					if (reservasHuesped.get(index).getfechaInicio().equals(fIn) & reservasHuesped.get(index).getfechaFinal().equals(fFi)) {
						reserva = reservasHuesped.get(index);
						break;
					}
				}
				String[] facturaFinal = {};
				try {
					facturaFinal = controlador.generarFacturaFinal(reserva, hotel, pasa);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, facturaFinal[2]);
				if (facturaFinal[2].equals("Transacción exitosa")) {
					for (HabitacionOcupada hab: reserva.getHabitacionesReserva()) {
						controlador.desocuparHabitaciones(hotel, hab);
					}
					hotel.getReservas().get(reserva.getHuesped().getDocumento()).remove(reserva);
					try {
						hotel.guardarRegistroTransaccion(opPasarela, facturaFinal[2], reserva.getHuesped().getTarjeta(), doc, facturaFinal[1]);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, facturaFinal[0]);
					JPanel pestaniaGenerarFactura = recepcionPestaniaGenerarFactura.getPestania(hotel);
		        	panelFinal.removeAll();
		        	panelFinal.add(pestaniaGenerarFactura, BorderLayout.CENTER);
		        	panelFinal.revalidate();
		        	panelFinal.repaint();
				}
				else {
					try {
						hotel.guardarRegistroTransaccion(opPasarela, facturaFinal[2], reserva.getHuesped().getTarjeta(), doc, facturaFinal[1]);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JPanel pestaniaCambiarTarjeta = recepcionPestaniaCambiarInfoTarjeta.getPestania(hotel, reserva, false);
		        	panelFinal.removeAll();
		        	panelFinal.add(pestaniaCambiarTarjeta, BorderLayout.CENTER);
		        	panelFinal.revalidate();
		        	panelFinal.repaint();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "No hay ninguna factura pendiente registrada\nbajo el número de documento\n"+ doc +" en las fechas ingresadas");
			}
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

//	public recepcionPestaniaGenerarFactura() {
//
//		/// CONFIGURACION
//		setPreferredSize(parametros.getDimensionCuerpo());
//		setBackground(parametros.getColorCuerpo());
//		setLayout(new BorderLayout());
//
//		/// ELEMENTOS
//		JLabel titulo = new JLabel("Generar Factura", SwingConstants.CENTER);
//		JLabel documento = new JLabel("Documento", SwingConstants.CENTER);
//		JLabel fechaInicio = new JLabel("Fecha de inicio", SwingConstants.CENTER);
//		JLabel fechaFin = new JLabel("Fecha de fin", SwingConstants.CENTER);
//
//		// Documento
//		JPanel auxiliarDocumento = new JPanel();
//		auxiliarDocumento.setLayout(new FlowLayout());
//		auxiliarDocumento.setBackground(parametros.getColorCuerpo());
//		JTextField documentoTextField = new JTextField();
//		documentoTextField.setPreferredSize(new Dimension(200, 75));
//		auxiliarDocumento.add(documentoTextField);
//
//		// Fecha Inicio
//		JPanel auxiliarFechaInicio = new JPanel();
//		auxiliarFechaInicio.setLayout(new FlowLayout());
//		auxiliarFechaInicio.setBackground(parametros.getColorCuerpo());
//		JTextField fechaInicioTextField = new JTextField();
//		fechaInicioTextField.setPreferredSize(new Dimension(200, 75));
//		auxiliarFechaInicio.add(fechaInicioTextField);
//
//		// Hora Fin
//		JPanel auxiliarFechaFin = new JPanel();
//		auxiliarFechaFin.setLayout(new FlowLayout());
//		auxiliarFechaFin.setBackground(parametros.getColorCuerpo());
//		JTextField fechaFinTextField = new JTextField();
//		fechaFinTextField.setPreferredSize(new Dimension(200, 75));
//		auxiliarFechaFin.add(fechaFinTextField);
//
//		/// ADD
//
//		JPanel auxiliar = new JPanel();
//		auxiliar.setLayout(new GridLayout(3, 2, 10, 10));
//		auxiliar.setBackground(parametros.getColorCuerpo());
//
//		auxiliar.add(documento);
//		auxiliar.add(auxiliarDocumento);
//		auxiliar.add(fechaInicio);
//		auxiliar.add(auxiliarFechaInicio);
//		auxiliar.add(fechaFin);
//		auxiliar.add(auxiliarFechaFin);
//
//		add(auxiliar);
//		add(titulo, BorderLayout.NORTH);
//
//	}

}
