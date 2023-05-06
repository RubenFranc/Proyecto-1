package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminPestaniaAsignarTarifaHabitacionFecha extends JFrame implements ActionListener{
	
	private static JPanel pestania = new JPanel();
	
	public static JPanel getPestania (){
		
		/// CONFIGURACION
		pestania.setPreferredSize(parametros.getDimensionCuerpo());
	    pestania.setBackground(parametros.getColorCuerpo());
	    pestania.setLayout(new GridLayout(3,2, 10, 10));
	    
	    /// ELEMENTOS
        JLabel tipo = new JLabel("Tipo", SwingConstants.CENTER);
        JLabel fechaInicio = new JLabel("Fecha de inicio", SwingConstants.CENTER);
        JLabel fechaFin = new JLabel("Fecha de fin", SwingConstants.CENTER);
               
        // tipo
        ButtonGroup grupoTipo = new ButtonGroup();        
        JRadioButton botonTipoEstandar = new JRadioButton("Estándar");
        botonTipoEstandar.setBackground(parametros.getColorCuerpo());
        grupoTipo.add(botonTipoEstandar);
        JRadioButton botonTipoSuite = new JRadioButton("Suite");
        botonTipoSuite.setBackground(parametros.getColorCuerpo());
        grupoTipo.add(botonTipoSuite);
        JRadioButton botonTipoSuiteDoble = new JRadioButton("Suite Doble");
        botonTipoSuiteDoble.setBackground(parametros.getColorCuerpo());
        grupoTipo.add(botonTipoSuiteDoble);
        
        JPanel auxiliarTipo = new JPanel();
        auxiliarTipo.setLayout(new BoxLayout(auxiliarTipo, BoxLayout.X_AXIS));
        auxiliarTipo.setBackground(parametros.getColorCuerpo());
        auxiliarTipo.add(botonTipoEstandar);
        auxiliarTipo.add(botonTipoSuite);
        auxiliarTipo.add(botonTipoSuiteDoble);
        
        // Fecha Inicio
        JPanel auxiliarFechaInicio = new JPanel();
        auxiliarFechaInicio.setLayout(new FlowLayout());
        auxiliarFechaInicio.setBackground(parametros.getColorCuerpo());
        JTextField fechaInicioTextField = new JTextField();
        fechaInicioTextField.setPreferredSize(new Dimension(200, 75));
        auxiliarFechaInicio.add(fechaInicioTextField);
        
        // Fecha Fin
        JPanel auxiliarFechaFin = new JPanel();
        auxiliarFechaFin.setLayout(new FlowLayout());
        auxiliarFechaFin.setBackground(parametros.getColorCuerpo());
        JTextField fechaFinTextField = new JTextField();
        fechaFinTextField.setPreferredSize(new Dimension(200, 75));
        auxiliarFechaFin.add(fechaFinTextField);
        
        /// ADD

        pestania.add(tipo);
        pestania.add(auxiliarTipo);
        pestania.add(fechaInicio);
        pestania.add(auxiliarFechaInicio);
        pestania.add(fechaFin);
        pestania.add(auxiliarFechaFin);
        
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

