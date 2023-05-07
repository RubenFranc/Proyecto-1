package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class recepcionPestaniaCrearReserva extends JPanel{
	
	
	public recepcionPestaniaCrearReserva (){
		
		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
	    setBackground(parametros.getColorCuerpo());
	    setLayout(new GridLayout(4,2, 10, 10));
	    
	    /// ELEMENTOS
        JLabel documento = new JLabel("Documento", SwingConstants.CENTER);
        JLabel fechaInicio = new JLabel("Fecha de inicio", SwingConstants.CENTER);
        JLabel fechaFin = new JLabel("Fecha de fin", SwingConstants.CENTER);
        JLabel acompaniantes = new JLabel("Acompañantes", SwingConstants.CENTER);
                
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
        
        // Acompañantes
        JPanel auxiliarAcompaniantes = new JPanel();
        auxiliarAcompaniantes.setLayout(new FlowLayout());
        auxiliarAcompaniantes.setBackground(parametros.getColorCuerpo());
        JTextField acompanientesTextField = new JTextField();
        acompanientesTextField.setPreferredSize(new Dimension(200, 75));
        auxiliarAcompaniantes.add(acompanientesTextField);
        
        /// ADD
        
        add(documento);
        add(auxiliarDocumento);
        add(fechaInicio);
        add(auxiliarFechaInicio);
        add(fechaFin);
        add(auxiliarFechaFin);
        add(acompaniantes);
        add(auxiliarAcompaniantes);
        
        
	}
	
			

}
