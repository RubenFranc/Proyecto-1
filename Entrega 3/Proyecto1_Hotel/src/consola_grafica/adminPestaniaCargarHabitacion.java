package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminPestaniaCargarHabitacion extends JFrame implements ActionListener{
	
	private static JPanel pestania = new JPanel();
	
	public static JPanel getPestania (){
		
		/// CONFIGURACION
		pestania.setPreferredSize(parametros.getDimensionCuerpo());
	    pestania.setBackground(parametros.getColorCuerpo());
	    pestania.setLayout(new GridLayout(6,2, 10, 10));
	    
	    /// ELEMENTOS
        JLabel balcon = new JLabel("Balcon", SwingConstants.CENTER);
        JLabel cocina = new JLabel("Cocina", SwingConstants.CENTER);
        JLabel ventana = new JLabel("Ventana", SwingConstants.CENTER);
        JLabel capacidad = new JLabel("Capacidad", SwingConstants.CENTER);
        JLabel tipo = new JLabel("Tipo", SwingConstants.CENTER);
        JLabel tarifa = new JLabel("Tarifa", SwingConstants.CENTER);
                
        // balcon
        ButtonGroup grupoBalcon = new ButtonGroup();        
        JRadioButton botonSiBalcon = new JRadioButton("Sí");
        botonSiBalcon.setBackground(parametros.getColorCuerpo());
        grupoBalcon.add(botonSiBalcon);
        JRadioButton botonNoBalcon = new JRadioButton("No");
        botonNoBalcon.setBackground(parametros.getColorCuerpo());
        grupoBalcon.add(botonNoBalcon);
        
        JPanel auxiliarBalcon = new JPanel();
        auxiliarBalcon.setLayout(new FlowLayout());
        auxiliarBalcon.setBackground(parametros.getColorCuerpo());
        auxiliarBalcon.add(botonSiBalcon);
        auxiliarBalcon.add(botonNoBalcon);
        
        // cocina
        ButtonGroup grupoCocina = new ButtonGroup();        
        JRadioButton botonSiCocina = new JRadioButton("Sí");
        botonSiCocina.setBackground(parametros.getColorCuerpo());
        grupoCocina.add(botonSiCocina);
        JRadioButton botonNoCocina = new JRadioButton("No");
        botonNoCocina.setBackground(parametros.getColorCuerpo());
        grupoBalcon.add(botonNoCocina);
        
        JPanel auxiliarCocina = new JPanel();
        auxiliarCocina.setLayout(new FlowLayout());
        auxiliarCocina.setBackground(parametros.getColorCuerpo());
        auxiliarCocina.add(botonSiCocina);
        auxiliarCocina.add(botonNoCocina);
        
        // ventana
        ButtonGroup grupoVentana = new ButtonGroup();        
        JRadioButton botonSiVentana = new JRadioButton("Sí");
        botonSiVentana.setBackground(parametros.getColorCuerpo());
        grupoVentana.add(botonSiVentana);
        JRadioButton botonNoVentana = new JRadioButton("No");
        botonNoVentana.setBackground(parametros.getColorCuerpo());
        grupoVentana.add(botonNoVentana);
        
        JPanel auxiliarVentana = new JPanel();
        auxiliarVentana.setLayout(new FlowLayout());
        auxiliarVentana.setBackground(parametros.getColorCuerpo());
        auxiliarVentana.add(botonSiVentana);
        auxiliarVentana.add(botonNoVentana);
        
        // Capacidad
        JPanel auxiliarCapacidad = new JPanel();
        auxiliarCapacidad.setLayout(new FlowLayout());
        auxiliarCapacidad.setBackground(parametros.getColorCuerpo());
        JTextField capacidadTextField = new JTextField();
        capacidadTextField.setPreferredSize(new Dimension(200, 75));
        auxiliarCapacidad.add(capacidadTextField);
        
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
        auxiliarTipo.setLayout(new FlowLayout());
        auxiliarTipo.setBackground(parametros.getColorCuerpo());
        auxiliarTipo.add(botonTipoEstandar);
        auxiliarTipo.add(botonTipoSuite);
        auxiliarTipo.add(botonTipoSuiteDoble);
        
        // Tarifa
        JPanel auxiliarTarifa = new JPanel();
        auxiliarTarifa.setLayout(new FlowLayout());
        auxiliarTarifa.setBackground(parametros.getColorCuerpo());
        JTextField tarifaTextField = new JTextField();
        tarifaTextField.setPreferredSize(new Dimension(200, 75));
        auxiliarTarifa.add(tarifaTextField);
        
        /// ADD
        
        pestania.add(balcon);
        pestania.add(auxiliarBalcon);
        pestania.add(cocina);
        pestania.add(auxiliarCocina);
        pestania.add(ventana);
        pestania.add(auxiliarVentana);
        pestania.add(capacidad);
        pestania.add(auxiliarCapacidad);
        pestania.add(tipo);
        pestania.add(auxiliarTipo);
        pestania.add(tarifa);
        pestania.add(auxiliarTarifa);
        
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

