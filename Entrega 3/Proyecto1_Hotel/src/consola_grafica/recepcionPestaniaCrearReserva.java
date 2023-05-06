package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class recepcionPestaniaCrearReserva extends JFrame implements ActionListener{
	
	private static JPanel pestania = new JPanel();
	
	public static JPanel getPestania (){
		
		/// CONFIGURACION
		pestania.setPreferredSize(parametros.getDimensionCuerpo());
	    pestania.setBackground(parametros.getColorCuerpo());
	    pestania.setLayout(new GridLayout(4,2, 10, 10));
	    
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
        
        pestania.add(documento);
        pestania.add(auxiliarDocumento);
        pestania.add(fechaInicio);
        pestania.add(auxiliarFechaInicio);
        pestania.add(fechaFin);
        pestania.add(auxiliarFechaFin);
        pestania.add(acompaniantes);
        pestania.add(auxiliarAcompaniantes);
        
        /// RETURN
		return pestania;
	}
	
			
	public static void main(String[] args) {
        JFrame frame = new JFrame("PRUEBA");
        frame.setSize(parametros.getDimensionCuerpo());
        frame.setBackground(parametros.getColorCuerpo());

        JPanel panel = getPestania();
        
        frame.add(panel);
        

        // Set Close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make visible
        frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
