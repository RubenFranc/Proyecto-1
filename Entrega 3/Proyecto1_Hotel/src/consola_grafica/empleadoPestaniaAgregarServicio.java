package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class empleadoPestaniaAgregarServicio extends JPanel {

	public static JPanel getPestania() {

		JPanel panel = new JPanel();

		/// CONFIGURACION
		panel.setPreferredSize(parametros.getDimensionCuerpo());
		panel.setBackground(parametros.getColorCuerpo());
		panel.setLayout(new GridLayout(4, 2, 10, 10));

		/// ELEMENTOS
		JLabel servicio = new JLabel("Servicio", SwingConstants.CENTER);
		JLabel cuentaHabitacion = new JLabel("¿Cargar a la cuenta de la habitación?", SwingConstants.CENTER);
		JLabel documento = new JLabel("Documento huesped", SwingConstants.CENTER);
		JLabel idHabitacion = new JLabel("ID de la habitación", SwingConstants.CENTER);

		// Servicio
		String[] servicios = { "a", "b", "c", "d", "e" };
		// TODO agregar los productos correctos!!!
		JComboBox comboServicios = new JComboBox(servicios);

		JPanel auxiliarServicios = new JPanel();
		auxiliarServicios.setLayout(new BoxLayout(auxiliarServicios, BoxLayout.X_AXIS));
		auxiliarServicios.setBackground(parametros.getColorCuerpo());
		auxiliarServicios.add(comboServicios, SwingConstants.CENTER);

		// Cuenta de Habitacion
		ButtonGroup grupoCuentaHabitacion = new ButtonGroup();
		JRadioButton botonSi = new JRadioButton("Sí");
		botonSi.setBackground(parametros.getColorCuerpo());
		grupoCuentaHabitacion.add(botonSi);
		JRadioButton botonNo = new JRadioButton("No");
		botonNo.setBackground(parametros.getColorCuerpo());
		grupoCuentaHabitacion.add(botonNo);

		JPanel auxiliarCuentaHabitacion = new JPanel();
		auxiliarCuentaHabitacion.setLayout(new BoxLayout(auxiliarCuentaHabitacion, BoxLayout.X_AXIS));
		auxiliarCuentaHabitacion.setBackground(parametros.getColorCuerpo());
		auxiliarCuentaHabitacion.add(Box.createHorizontalGlue());
		auxiliarCuentaHabitacion.add(botonSi);
		auxiliarCuentaHabitacion.add(botonNo);
		auxiliarCuentaHabitacion.add(Box.createHorizontalGlue());

		// Documento
		JPanel auxiliarDocumento = new JPanel();
		auxiliarDocumento.setLayout(new FlowLayout());
		auxiliarDocumento.setBackground(parametros.getColorCuerpo());
		JTextField documentoInicioTextField = new JTextField();
		documentoInicioTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarDocumento.add(documentoInicioTextField);

		// ID Habitacion
		JPanel auxiliarIdHabitacion = new JPanel();
		auxiliarIdHabitacion.setLayout(new FlowLayout());
		auxiliarIdHabitacion.setBackground(parametros.getColorCuerpo());
		JTextField idHabitacionFinTextField = new JTextField();
		idHabitacionFinTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarIdHabitacion.add(idHabitacionFinTextField);

		/// ADD

		panel.add(servicio);
		panel.add(auxiliarServicios);
		panel.add(cuentaHabitacion);
		panel.add(auxiliarCuentaHabitacion);
		panel.add(documento);
		panel.add(auxiliarDocumento);
		panel.add(idHabitacion);
		panel.add(auxiliarIdHabitacion);

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

	public empleadoPestaniaAgregarServicio() {

		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
		setBackground(parametros.getColorCuerpo());
		setLayout(new GridLayout(4, 2, 10, 10));

		/// ELEMENTOS
		JLabel servicio = new JLabel("Servicio", SwingConstants.CENTER);
		JLabel cuentaHabitacion = new JLabel("¿Cargar a la cuenta de la habitación?", SwingConstants.CENTER);
		JLabel documento = new JLabel("Documento huesped", SwingConstants.CENTER);
		JLabel idHabitacion = new JLabel("ID de la habitación", SwingConstants.CENTER);

		// Servicio
		String[] servicios = { "a", "b", "c", "d", "e" };
		// TODO agregar los productos correctos!!!
		JComboBox comboServicios = new JComboBox(servicios);

		JPanel auxiliarServicios = new JPanel();
		auxiliarServicios.setLayout(new BoxLayout(auxiliarServicios, BoxLayout.X_AXIS));
		auxiliarServicios.setBackground(parametros.getColorCuerpo());
		auxiliarServicios.add(comboServicios, SwingConstants.CENTER);

		// Cuenta de Habitacion
		ButtonGroup grupoCuentaHabitacion = new ButtonGroup();
		JRadioButton botonSi = new JRadioButton("Sí");
		botonSi.setBackground(parametros.getColorCuerpo());
		grupoCuentaHabitacion.add(botonSi);
		JRadioButton botonNo = new JRadioButton("No");
		botonNo.setBackground(parametros.getColorCuerpo());
		grupoCuentaHabitacion.add(botonNo);

		JPanel auxiliarCuentaHabitacion = new JPanel();
		auxiliarCuentaHabitacion.setLayout(new BoxLayout(auxiliarCuentaHabitacion, BoxLayout.X_AXIS));
		auxiliarCuentaHabitacion.setBackground(parametros.getColorCuerpo());
		auxiliarCuentaHabitacion.add(Box.createHorizontalGlue());
		auxiliarCuentaHabitacion.add(botonSi);
		auxiliarCuentaHabitacion.add(botonNo);
		auxiliarCuentaHabitacion.add(Box.createHorizontalGlue());

		// Documento
		JPanel auxiliarDocumento = new JPanel();
		auxiliarDocumento.setLayout(new FlowLayout());
		auxiliarDocumento.setBackground(parametros.getColorCuerpo());
		JTextField documentoInicioTextField = new JTextField();
		documentoInicioTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarDocumento.add(documentoInicioTextField);

		// ID Habitacion
		JPanel auxiliarIdHabitacion = new JPanel();
		auxiliarIdHabitacion.setLayout(new FlowLayout());
		auxiliarIdHabitacion.setBackground(parametros.getColorCuerpo());
		JTextField idHabitacionFinTextField = new JTextField();
		idHabitacionFinTextField.setPreferredSize(new Dimension(200, 75));
		auxiliarIdHabitacion.add(idHabitacionFinTextField);

		/// ADD

		add(servicio);
		add(auxiliarServicios);
		add(cuentaHabitacion);
		add(auxiliarCuentaHabitacion);
		add(documento);
		add(auxiliarDocumento);
		add(idHabitacion);
		add(auxiliarIdHabitacion);

	}

}
