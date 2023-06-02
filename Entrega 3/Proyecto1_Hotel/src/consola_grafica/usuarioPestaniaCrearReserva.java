
package consola_grafica;

import javax.swing.*;

import Controlador.ControladorUsuario;
import Model.Hotel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class usuarioPestaniaCrearReserva extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

		ControladorUsuario controlador = new ControladorUsuario();
		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(8, 2, 10, 10));

		/// ELEMENTOS
		JLabel nombre = new JLabel("Nombre del titular", SwingConstants.CENTER);
		JLabel documento = new JLabel("Documento", SwingConstants.CENTER);
		JLabel telefono = new JLabel("Número de teléfono", SwingConstants.CENTER);
		JLabel correo = new JLabel("Correo electrónico", SwingConstants.CENTER);
		JLabel fechaInicio = new JLabel("Fecha de inicio (DD/MM)", SwingConstants.CENTER);
		JLabel fechaFin = new JLabel("Fecha de fin (DD/MM)", SwingConstants.CENTER);
		JLabel acompaniantes = new JLabel("Nombre de acompañantes (separados por , 'coma')", SwingConstants.CENTER);
//		JLabel numeroHabitaciones = new JLabel("Número de habitaciones", SwingConstants.CENTER);

		// Nombre
		JPanel auxiliarNombre = new JPanel();
		auxiliarNombre.setLayout(new FlowLayout());
		auxiliarNombre.setBackground(parametros.getColorCuerpo());
		JTextField nombreTextField = new JTextField();
		nombreTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarNombre.add(nombreTextField);

		// Documento
		JPanel auxiliarDocumento = new JPanel();
		auxiliarDocumento.setLayout(new FlowLayout());
		auxiliarDocumento.setBackground(parametros.getColorCuerpo());
		JTextField documentoTextField = new JTextField();
		documentoTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarDocumento.add(documentoTextField);

		// Telefono
		JPanel auxiliarTelefono = new JPanel();
		auxiliarTelefono.setLayout(new FlowLayout());
		auxiliarTelefono.setBackground(parametros.getColorCuerpo());
		JTextField telefonoTextField = new JTextField();
		telefonoTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarTelefono.add(telefonoTextField);

		// Correo
		JPanel auxiliarCorreo = new JPanel();
		auxiliarCorreo.setLayout(new FlowLayout());
		auxiliarCorreo.setBackground(parametros.getColorCuerpo());
		JTextField correoTextField = new JTextField();
		correoTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarCorreo.add(correoTextField);

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

		// Acompañantes
		JPanel auxiliarAcompaniantes = new JPanel();
		auxiliarAcompaniantes.setLayout(new FlowLayout());
		auxiliarAcompaniantes.setBackground(parametros.getColorCuerpo());
		JTextField acompanientesTextField = new JTextField();
		acompanientesTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarAcompaniantes.add(acompanientesTextField);



		/// ADD

		panel.add(nombre);
		panel.add(auxiliarNombre);
		panel.add(documento);
		panel.add(auxiliarDocumento);
		panel.add(telefono);
		panel.add(auxiliarTelefono);
		panel.add(correo);
		panel.add(auxiliarCorreo);
		panel.add(fechaInicio);
		panel.add(auxiliarFechaInicio);
		panel.add(fechaFin);
		panel.add(auxiliarFechaFin);
		panel.add(acompaniantes);
		panel.add(auxiliarAcompaniantes);
//		panel.add(numeroHabitaciones);
//		panel.add(auxiliarNumeroHabitaciones);

		// FINAL

		JPanel panelFinal = new JPanel();

		panelFinal.setPreferredSize(parametros.getDimensionCuerpo());
		panelFinal.setBackground(parametros.getColorCuerpo());
		panelFinal.setLayout(new BorderLayout());

		JButton botonContinuarYCerrar = new JButton("Continuar y cerrar");
		botonContinuarYCerrar.setPreferredSize(parametros.getDimensionBotonArriba());
		botonContinuarYCerrar.addActionListener(event -> {
			String nom = nombreTextField.getText(); // falta agregar lo del pboton de pago inmediato
			String doc = documentoTextField.getText();
			String num = telefonoTextField.getText();
			String cor = correoTextField.getText();
			String fIn = fechaInicioTextField.getText();
			String fFi = fechaFinTextField.getText();
			String acomp = acompanientesTextField.getText();
			String[] partes = acomp.split(",");
			ArrayList<String> aco = new ArrayList<String>(Arrays.asList(partes));
			if (!(nom.equals("") || doc.equals("") || num.equals("") || cor.equals("") || fIn.equals("") || fFi.equals(""))) {
//				System.out.println("ENtró");
				controlador.crearReserva(hotel, nom, doc, cor, num, fIn, fFi, aco, false);
				
	        	JPanel pestaniaAgregarHabitacion = usuarioPestaniaContinuarAgregarHabitacion.getPestania(hotel, doc, fIn, fFi, nom, false);
	        	panelFinal.removeAll();
	        	panelFinal.add(pestaniaAgregarHabitacion, BorderLayout.CENTER);
	        	panelFinal.revalidate();
	        	panelFinal.repaint();
				
			}
            
         });
		
		
		JButton botonContinuarYPagar = new JButton("Continuar y pagar");
		botonContinuarYPagar.setPreferredSize(parametros.getDimensionBotonArriba());
		botonContinuarYPagar.addActionListener(event -> {
			String nom = nombreTextField.getText(); // falta agregar lo del pboton de pago inmediato
			String doc = documentoTextField.getText();
			String num = telefonoTextField.getText();
			String cor = correoTextField.getText();
			String fIn = fechaInicioTextField.getText();
			String fFi = fechaFinTextField.getText();
			String acomp = acompanientesTextField.getText();
			String[] partes = acomp.split(",");
			ArrayList<String> aco = new ArrayList<String>(Arrays.asList(partes));
			if (!(nom.equals("") || doc.equals("") || num.equals("") || cor.equals("") || fIn.equals("") || fFi.equals(""))) {
//				System.out.println("ENtró");
				controlador.crearReserva(hotel, nom, doc, cor, num, fIn, fFi, aco, true);
				
	        	JPanel pestaniaAgregarHabitacion = usuarioPestaniaContinuarAgregarHabitacion.getPestania(hotel, doc, fIn, fFi, nom, true);
	        	panelFinal.removeAll();
	        	panelFinal.add(pestaniaAgregarHabitacion, BorderLayout.CENTER);
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
		continuarPanel.add(botonContinuarYCerrar);
		continuarPanel.add(botonContinuarYPagar);
		continuarPanel.add(Box.createVerticalGlue());
		continuarPanel.add(Box.createHorizontalGlue());

		panelFinal.add(panel, BorderLayout.CENTER);
		panelFinal.add(continuarPanel, BorderLayout.SOUTH);

		return panelFinal;
	}