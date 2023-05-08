package consola_grafica;

import javax.swing.*;

import Controlador.ControladorRecepcionista;
import Model.Hotel;

import java.awt.*;
import java.awt.event.*;

public class recepcionPestaniaCancelarReserva extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

		ControladorRecepcionista controlador = new ControladorRecepcionista();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(4, 2, 10, 45));

		/// ELEMENTOS
		JLabel documento = new JLabel("Documento del huésped", SwingConstants.CENTER);
		JLabel fechaInicio = new JLabel("Fecha de inicio de la reserva (DD/MM)", SwingConstants.CENTER);
		JLabel fechaFin = new JLabel("Fecha final de la reserva (DD/MM)", SwingConstants.CENTER);
		JLabel fechaActual = new JLabel("Fecha actual (DD/MM)", SwingConstants.CENTER);

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

		// Fecha Fin
		JPanel auxiliarFechaFin = new JPanel();
		auxiliarFechaFin.setLayout(new FlowLayout());
		auxiliarFechaFin.setBackground(parametros.getColorCuerpo());
		JTextField fechaFinTextField = new JTextField();
		fechaFinTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarFechaFin.add(fechaFinTextField);
		
		// Fecha Actual
		JPanel auxiliarFechaActual = new JPanel();
		auxiliarFechaActual.setLayout(new FlowLayout());
		auxiliarFechaActual.setBackground(parametros.getColorCuerpo());
		JTextField fechaActualTextField = new JTextField();
		fechaActualTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarFechaActual.add(fechaActualTextField);

		/// ADD

		panel.add(documento);
		panel.add(auxiliarDocumento);
		panel.add(fechaInicio);
		panel.add(auxiliarFechaInicio);
		panel.add(fechaFin);
		panel.add(auxiliarFechaFin);
		panel.add(fechaActual);
		panel.add(auxiliarFechaActual);

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
			String fAc = fechaActualTextField.getText();
			String mssg = controlador.cancelarReserva(hotel, doc, fAc, fIn, fFi);
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

//	public recepcionPestaniaCancelarReserva() {
//
//		/// CONFIGURACION
//		setPreferredSize(parametros.getDimensionCuerpo());
//		setBackground(parametros.getColorCuerpo());
//		setLayout(new GridLayout(3, 2, 10, 10));
//
//		/// ELEMENTOS
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
//		add(documento);
//		add(auxiliarDocumento);
//		add(fechaInicio);
//		add(auxiliarFechaInicio);
//		add(fechaFin);
//		add(auxiliarFechaFin);
//
//	}

}
