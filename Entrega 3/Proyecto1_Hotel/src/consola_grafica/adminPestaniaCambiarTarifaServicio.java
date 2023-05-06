package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminPestaniaCambiarTarifaServicio extends JFrame implements ActionListener{
	
	private static JPanel pestania = new JPanel();
	
	public static JPanel getPestania (){
		
		/// CONFIGURACION
		pestania.setPreferredSize(parametros.getDimensionCuerpo());
	    pestania.setBackground(parametros.getColorCuerpo());
	    pestania.setLayout(new GridLayout(2,2, 10, 10));
	    
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

        pestania.add(servicioLabel);
        pestania.add(auxiliarServicios);
        pestania.add(nuevaTarifaLabel);
        pestania.add(auxiliarNuevaTarifa);
        
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

