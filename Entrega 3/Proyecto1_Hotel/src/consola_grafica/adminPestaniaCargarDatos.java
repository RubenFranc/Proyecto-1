package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminPestaniaCargarDatos extends JPanel {
	
	public adminPestaniaCargarDatos(){
		
		/// CONFIGURACION
	    setBackground(parametros.getColorCuerpo());
	    setLayout(new BorderLayout());
	    
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
        
        add(pregunta, BorderLayout.NORTH);
        JPanel auxiliar = new JPanel();
        auxiliar.setLayout(new FlowLayout());
        auxiliar.setBackground(parametros.getColorCuerpo());
        auxiliar.add(botonSi);
        auxiliar.add(botonNo);
        add(auxiliar, BorderLayout.CENTER);
        
        
        
	}
			

	

}
