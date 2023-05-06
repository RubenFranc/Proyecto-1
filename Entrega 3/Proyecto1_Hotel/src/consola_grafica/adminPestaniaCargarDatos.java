package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminPestaniaCargarDatos extends JFrame implements ActionListener{
	private static JPanel pestania = new JPanel();
	
	public static JPanel getPestania (){
		
		/// CONFIGURACION
		pestania.setPreferredSize(parametros.getDimensionCuerpo());
	    pestania.setBackground(parametros.getColorCuerpo());
	    pestania.setLayout(new BorderLayout());
	    
	    /// ELEMENTOS
        JLabel pregunta = new JLabel("¿Desea cargar las habitaciones desde la base de datos?", SwingConstants.CENTER);
                
        ButtonGroup grupo = new ButtonGroup();        
        JRadioButton botonSi = new JRadioButton("Sí");
        botonSi.setBackground(parametros.getColorCuerpo());
        grupo.add(botonSi);
        JRadioButton botonNo = new JRadioButton("No");
        botonNo.setBackground(parametros.getColorCuerpo());
        grupo.add(botonNo);
        
        /// ADD
        
        pestania.add(pregunta, BorderLayout.NORTH);
        JPanel auxiliar = new JPanel();
        auxiliar.setLayout(new FlowLayout());
        auxiliar.setBackground(parametros.getColorCuerpo());
        auxiliar.add(botonSi);
        auxiliar.add(botonNo);
        pestania.add(auxiliar, BorderLayout.CENTER);
        
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
