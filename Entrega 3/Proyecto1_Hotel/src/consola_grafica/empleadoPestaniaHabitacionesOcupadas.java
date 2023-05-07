package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class empleadoPestaniaHabitacionesOcupadas  extends JPanel{
	
	
	
	public empleadoPestaniaHabitacionesOcupadas (){
		
		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
	    setBackground(parametros.getColorCuerpo());
	    setLayout(new GridLayout(2,1, 20, 20));
	    
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
        
        add(auxiliar);
        add(informacion);
        
      
	}
	
			

}
