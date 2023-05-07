package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class recepcionPestaniaGenerarFactura extends JPanel {

	public static JPanel getPestania() {

		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new BorderLayout());

		/// ELEMENTOS
		JLabel titulo = new JLabel("Generar Factura", SwingConstants.CENTER);
		JLabel documento = new JLabel("Documento", SwingConstants.CENTER);
		JLabel fechaInicio = new JLabel("Fecha de inicio", SwingConstants.CENTER);
		JLabel fechaFin = new JLabel("Fecha de fin", SwingConstants.CENTER);

		// Documento
		JPanel auxiliarDocumento = new JPanel();
		auxiliarDocumento.setLayout(new FlowLayout());
		auxiliarDocumento.setBackground(parametros.getColorCuerpo());
		JTextField documentoTextField = new JTextField();
		documentoTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarDocumento.add(documentoTextField);

		// Fecha Inicio
		JPanel auxiliarFechaInicio = new JPanel();
		auxiliarFechaInicio.setLayout(new FlowLayout());
		auxiliarFechaInicio.setBackground(parametros.getColorCuerpo());
		JTextField fechaInicioTextField = new JTextField();
		fechaInicioTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarFechaInicio.add(fechaInicioTextField);

		// Hora Fin
		JPanel auxiliarFechaFin = new JPanel();
		auxiliarFechaFin.setLayout(new FlowLayout());
		auxiliarFechaFin.setBackground(parametros.getColorCuerpo());
		JTextField fechaFinTextField = new JTextField();
		fechaFinTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarFechaFin.add(fechaFinTextField);

		/// ADD

		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new GridLayout(3, 2, 10, 10));
		auxiliar.setBackground(parametros.getColorCuerpo());

		auxiliar.add(documento);
		auxiliar.add(auxiliarDocumento);
		auxiliar.add(fechaInicio);
		auxiliar.add(auxiliarFechaInicio);
		auxiliar.add(fechaFin);
		auxiliar.add(auxiliarFechaFin);

		panel.add(auxiliar);
		panel.add(titulo, BorderLayout.NORTH);

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

	public recepcionPestaniaGenerarFactura() {

		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
		setBackground(parametros.getColorCuerpo());
		setLayout(new BorderLayout());

		/// ELEMENTOS
		JLabel titulo = new JLabel("Generar Factura", SwingConstants.CENTER);
		JLabel documento = new JLabel("Documento", SwingConstants.CENTER);
		JLabel fechaInicio = new JLabel("Fecha de inicio", SwingConstants.CENTER);
		JLabel fechaFin = new JLabel("Fecha de fin", SwingConstants.CENTER);

		// Documento
		JPanel auxiliarDocumento = new JPanel();
		auxiliarDocumento.setLayout(new FlowLayout());
		auxiliarDocumento.setBackground(parametros.getColorCuerpo());
		JTextField documentoTextField = new JTextField();
		documentoTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarDocumento.add(documentoTextField);

		// Fecha Inicio
		JPanel auxiliarFechaInicio = new JPanel();
		auxiliarFechaInicio.setLayout(new FlowLayout());
		auxiliarFechaInicio.setBackground(parametros.getColorCuerpo());
		JTextField fechaInicioTextField = new JTextField();
		fechaInicioTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarFechaInicio.add(fechaInicioTextField);

		// Hora Fin
		JPanel auxiliarFechaFin = new JPanel();
		auxiliarFechaFin.setLayout(new FlowLayout());
		auxiliarFechaFin.setBackground(parametros.getColorCuerpo());
		JTextField fechaFinTextField = new JTextField();
		fechaFinTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarFechaFin.add(fechaFinTextField);

		/// ADD

		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new GridLayout(3, 2, 10, 10));
		auxiliar.setBackground(parametros.getColorCuerpo());

		auxiliar.add(documento);
		auxiliar.add(auxiliarDocumento);
		auxiliar.add(fechaInicio);
		auxiliar.add(auxiliarFechaInicio);
		auxiliar.add(fechaFin);
		auxiliar.add(auxiliarFechaFin);

		add(auxiliar);
		add(titulo, BorderLayout.NORTH);

	}

}
