package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminPestaniaCambiarTarifaServicio extends JPanel{
	
	
	public adminPestaniaCambiarTarifaServicio(){
		
		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
	    setBackground(parametros.getColorCuerpo());
	    setLayout(new GridLayout(2,2, 10, 10));
	    
	    /// ELEMENTOS
        JLabel servicioLabel = new JLabel("Servicio", SwingConstants.CENTER);
        JLabel nuevaTarifaLabel = new JLabel("Nueva Tarifa", SwingConstants.CENTER);
               
        // Servicios
        String[] servicios = { "a", "b", "c", "d", "e" };
        // TODO agregar los servicios correctos!!!
        JComboBox comboServicios = new JComboBox(servicios);
        
        JPanel auxiliarServicios = new JPanel();
        auxiliarServicios.setLayout(new BoxLayout(auxiliarServicios, BoxLayout.X_AXIS));
        auxiliarServicios.setBackground(parametros.getColorCuerpo());
        auxiliarServicios.add(comboServicios, SwingConstants.CENTER);
        
        // Fecha Inicio
        JPanel auxiliarNuevaTarifa = new JPanel();
        auxiliarNuevaTarifa.setLayout(new BoxLayout(auxiliarNuevaTarifa, BoxLayout.X_AXIS));
        auxiliarNuevaTarifa.setBackground(parametros.getColorCuerpo());
        JTextField nuevaTarifaTextField = new JTextField();
        nuevaTarifaTextField.setPreferredSize(new Dimension(200, 75));
        auxiliarNuevaTarifa.add(nuevaTarifaTextField);
        
        /// ADD

        add(servicioLabel);
        add(auxiliarServicios);
        add(nuevaTarifaLabel);
        add(auxiliarNuevaTarifa);
        
	}
	
			


}

