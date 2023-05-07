package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class empleadoPestaniaAgregarServicio extends JPanel{
	
	
	
	public empleadoPestaniaAgregarServicio (){
		
		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
	    setBackground(parametros.getColorCuerpo());
	    setLayout(new GridLayout(4,2, 10, 10));
	    
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
