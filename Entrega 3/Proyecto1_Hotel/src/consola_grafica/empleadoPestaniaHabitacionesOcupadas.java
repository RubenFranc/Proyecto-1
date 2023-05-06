package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class empleadoPestaniaHabitacionesOcupadas  extends JFrame implements ActionListener{
	
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
        JButton estandaresOcupadas = new JButton("Estandares Ocupadas");
        JButton suitesOcupadas = new JButton("Suites Ocupadas");
        JButton suitesDoblesOcupadas = new JButton("Suites Dobles Ocupadas");
        
        estandaresOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
        suitesOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
        suitesDoblesOcupadas.setPreferredSize(parametros.getDimensionBotonBarra());
        
        JPanel auxiliar = new JPanel();
        auxiliar.setLayout(new BoxLayout(auxiliar, BoxLayout.Y_AXIS));
        auxiliar.setBackground(parametros.getColorCuerpo());
        
        auxiliar.add(Box.createVerticalGlue());
        auxiliar.add(estandaresOcupadas);
        auxiliar.add(suitesOcupadas);
        auxiliar.add(suitesDoblesOcupadas);
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
