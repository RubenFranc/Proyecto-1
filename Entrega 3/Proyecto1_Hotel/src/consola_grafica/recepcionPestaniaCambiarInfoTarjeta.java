package consola_grafica;

import javax.swing.*;

import Controlador.ControladorRecepcionista;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.Reserva;
import Model.TarjetaPago;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class recepcionPestaniaCambiarInfoTarjeta extends JPanel {

	public static JPanel getPestania(Hotel hotel, Reserva reserva, boolean adelanto) {

		ControladorRecepcionista controlador = new ControladorRecepcionista();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		// setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(6, 2, 10, 10));

		/// ELEMENTOS
		JLabel numero = new JLabel("Número de la tarjeta (10 dígitos)", SwingConstants.CENTER);
		JLabel saldo = new JLabel("Saldo disponible", SwingConstants.CENTER);
		JLabel contrasenia = new JLabel("Contraseña de la tarjeta", SwingConstants.CENTER);
		JLabel pasarelaDePago = new JLabel("PasarelaDePago", SwingConstants.CENTER);

		// NumeroTarjeta
		JPanel auxiliarNumeroTarjeta = new JPanel();
		auxiliarNumeroTarjeta.setLayout(new FlowLayout());
		auxiliarNumeroTarjeta.setBackground(parametros.getColorCuerpo());
		JTextField numeroTarjetaTextField = new JTextField();
		numeroTarjetaTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarNumeroTarjeta.add(numeroTarjetaTextField);

		// Saldo
		JPanel auxiliarSaldo = new JPanel();
		auxiliarSaldo.setLayout(new FlowLayout());
		auxiliarSaldo.setBackground(parametros.getColorCuerpo());
		JTextField saldoTextField = new JTextField();
		saldoTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarSaldo.add(saldoTextField);
		
		// Contrasenia
		JPanel auxiliarContrasenia = new JPanel();
		auxiliarContrasenia.setLayout(new FlowLayout());
		auxiliarContrasenia.setBackground(parametros.getColorCuerpo());
		JTextField contraseniaTextField = new JTextField();
		contraseniaTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarContrasenia.add(contraseniaTextField);
		
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

		panel.add(numero);
		panel.add(auxiliarNumeroTarjeta);
		panel.add(saldo);
		panel.add(auxiliarSaldo);
		panel.add(contrasenia);
		panel.add(auxiliarContrasenia);
		panel.add(pasarelaDePago);
		panel.add(auxiliarPasarela);
		
		// FINAL

		JPanel panelFinal = new JPanel();

		panelFinal.setPreferredSize(parametros.getDimensionCuerpo());
		panelFinal.setBackground(parametros.getColorCuerpo());
		panelFinal.setLayout(new BorderLayout());

		JButton botonValidar = new JButton("Validar transacción");
		botonValidar.setPreferredSize(new Dimension(200,100));
		botonValidar.addActionListener(event -> {
			String numt = numeroTarjetaTextField.getText();
			String saldi = saldoTextField.getText();
			String cont = contraseniaTextField.getText();
			double sald = Double.parseDouble(saldi);
			TarjetaPago tarj = new TarjetaPago(sald, numt, cont);
			reserva.getHuesped().cambiarTarjeta(tarj);
			ButtonModel opcionPasarela = grupoPasarela.getSelection();
			String opPasarela = opcionPasarela.getActionCommand();
			String pasa = "Model.PayPal";
			try {
				pasa = hotel.escogerPasarela(opPasarela);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
				try {
					hotel.guardarRegistroTransaccion(opPasarela, facturaFinal[2], reserva.getHuesped().getTarjeta(), reserva.getHuesped().getDocumento(), facturaFinal[1]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (!adelanto) {
					for (HabitacionOcupada hab: reserva.getHabitacionesReserva()) {
						controlador.desocuparHabitaciones(hotel, hab);
					}
					hotel.getReservas().get(reserva.getHuesped().getDocumento()).remove(reserva);
					JOptionPane.showMessageDialog(null, facturaFinal[0]);
					JPanel pestaniaGenerarFactura = recepcionPestaniaGenerarFactura.getPestania(hotel);
		        	panelFinal.removeAll();
		        	panelFinal.add(pestaniaGenerarFactura, BorderLayout.CENTER);
		        	panelFinal.revalidate();
		        	panelFinal.repaint();
				}
				else {
					JOptionPane.showMessageDialog(null, "Reserva a nombre de " + reserva.getHuesped().getnombre() + " creada.");
					JOptionPane.showMessageDialog(null, facturaFinal[0]);
					JPanel pestaniaCrearReserva= recepcionPestaniaCrearReserva.getPestania(hotel);
		        	panelFinal.removeAll();
		        	panelFinal.add(pestaniaCrearReserva, BorderLayout.CENTER);
		        	panelFinal.revalidate();
		        	panelFinal.repaint();
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, facturaFinal[2]);					
				try {
					hotel.guardarRegistroTransaccion(opPasarela, facturaFinal[2], reserva.getHuesped().getTarjeta(), reserva.getHuesped().getDocumento(), facturaFinal[1]);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				JPanel pestaniaCambiarTarjeta = recepcionPestaniaCambiarInfoTarjeta.getPestania(hotel, reserva, adelanto);
	        	panelFinal.removeAll();
	        	panelFinal.add(pestaniaCambiarTarjeta, BorderLayout.CENTER);
	        	panelFinal.revalidate();
	        	panelFinal.repaint();
			}
		});		
		
		JPanel continuarPanel = new JPanel();
		continuarPanel.setLayout(new BoxLayout(continuarPanel, BoxLayout.X_AXIS));
		continuarPanel.setPreferredSize(parametros.getDimensionBotonArriba());
		continuarPanel.setBackground(parametros.getColorCuerpo());
		continuarPanel.add(Box.createVerticalGlue());
		continuarPanel.add(Box.createHorizontalGlue());
		continuarPanel.add(botonValidar);

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

