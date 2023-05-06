package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class empleadoPestaniaHabitacionesDisponibles  extends JFrame implements ActionListener{
	
	private static JPanel pestania = new JPanel();
	
	public static JPanel getPestania (){
		
		/// CONFIGURACION
		pestania.setPreferredSize(parametros.getDimensionCuerpo());
	    pestania.setBackground(parametros.getColorCuerpo());
	    pestania.setLayout(new GridLayout(2,1, 20, 20));
	    
	    /// ELEMENTOS
        JLabel informacion = new JLabel("Información", SwingConstants.CENTER);
        // TODO Poner la información de las habitaciones
                
        // Botones
        JButton estandaresDisponibles = new JButton("Estandares Disponibles");
        JButton suitesDisponibles = new JButton("Suites Disponibles");
        JButton suitesDoblesDisponibles = new JButton("Suites Dobles Disponibles");
        
        estandaresDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
        suitesDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
        suitesDoblesDisponibles.setPreferredSize(parametros.getDimensionBotonBarra());
        
        JPanel auxiliar = new JPanel();
        auxiliar.setLayout(new BoxLayout(auxiliar, BoxLayout.Y_AXIS));
        auxiliar.setBackground(parametros.getColorCuerpo());
        
        auxiliar.add(Box.createVerticalGlue());
        auxiliar.add(estandaresDisponibles);
        auxiliar.add(suitesDisponibles);
        auxiliar.add(suitesDoblesDisponibles);
        auxiliar.add(Box.createVerticalGlue());
        
        /// ADD
        
        pestania.add(auxiliar);
        pestania.add(informacion);
        
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
