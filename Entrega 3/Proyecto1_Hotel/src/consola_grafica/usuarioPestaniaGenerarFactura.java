package consola_grafica;

import javax.swing.*;

import Controlador.ControladorUsuario;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.Reserva;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class usuarioPestaniaGenerarFactura extends JPanel {

	public static JPanel getPestania(Hotel hotel) {

		ControladorUsuario controlador = new ControladorUsuario();
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
		JLabel No_Tarjeta = new JLabel("No. Tarjeta Crédito:", SwingConstants.CENTER);
		JLabel ClavedeSeguridad= new JLabel("Clave de Seguridad:", SwingConstants.CENTER);
		
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
		
		// No. Tarjeta
		JPanel auxiliarNoTarjetaCredito = new JPanel();
		auxiliarNoTarjetaCredito.setLayout(new FlowLayout());
		auxiliarNoTarjetaCredito.setBackground(parametros.getColorCuerpo());
		JTextField NoTarjetaCreditoTextField = new JTextField();
		NoTarjetaCreditoTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarNoTarjetaCredito.add(NoTarjetaCreditoTextField);

		// Clave de Seguridad
		JPanel auxiliarClavedeSeguridad = new JPanel();
		auxiliarClavedeSeguridad.setLayout(new FlowLayout());
		auxiliarClavedeSeguridad.setBackground(parametros.getColorCuerpo());
		JTextField ClavedeSeguridadTextField = new JTextField();
		ClavedeSeguridadTextField.setPreferredSize(new Dimension(200, 20));
		auxiliarClavedeSeguridad.add(ClavedeSeguridadTextField);
		
		
		
		
		/// ADD

		JPanel auxiliar = new JPanel();
		auxiliar.setLayout(new GridLayout(3, 2, 10, 80));
		auxiliar.setBackground(parametros.getColorCuerpo());

		auxiliar.add(documento);
		auxiliar.add(auxiliarDocumento);
		auxiliar.add(fechaInicio);
		auxiliar.add(auxiliarFechaInicio);
		auxiliar.add(fechaFin);
		auxiliar.add(auxiliarFechaFin);
		auxiliar.add(No_Tarjeta);
		auxiliar.add(auxiliarNoTarjetaCredito);
		auxiliar.add(ClavedeSeguridad);
		auxiliar.add(auxiliarClavedeSeguridad);
		

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
			if (hotel.getReservas().containsKey(doc)) {
				ArrayList<Reserva> reservasHuesped = hotel.getReservas().get(doc);
				Reserva reserva = null;
				for (int index = 0; index < reservasHuesped.size(); index++) {
					if (reservasHuesped.get(index).getfechaInicio().equals(fIn) & reservasHuesped.get(index).getfechaFinal().equals(fFi)) {
						reserva = reservasHuesped.get(index);
						break;
					}
				}
				String facturaFinal = controlador.generarFacturaReserva(reserva, hotel, true);
				JOptionPane.showMessageDialog(null, facturaFinal);
				for (HabitacionOcupada hab: reserva.getHabitacionesReserva()) {
					controlador.desocuparHabitaciones(hotel, hab);
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



}
