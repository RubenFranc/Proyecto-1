package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class empleadoPestaniaServiciosHotel extends JFrame implements ActionListener{
	
	private static JPanel pestania = new JPanel();
	
	public static JPanel getPestania (){
		
		/// CONFIGURACION
		pestania.setPreferredSize(parametros.getDimensionCuerpo());
	    pestania.setBackground(parametros.getColorCuerpo());
	    pestania.setLayout(new GridLayout(3,2, 10, 10));
	    
	    /// ELEMENTOS
        JLabel servicio = new JLabel("Servicio", SwingConstants.CENTER);
        JLabel precio = new JLabel("Precio", SwingConstants.CENTER);
        JLabel descripcion = new JLabel("Descripción", SwingConstants.CENTER);
                
        // Servicio
        String[] servicios = { "a", "b", "c", "d", "e" };
        // TODO agregar los productos correctos!!!
        JComboBox comboServicios = new JComboBox(servicios);
        
        JPanel auxiliarServicios = new JPanel();
        auxiliarServicios.setLayout(new BoxLayout(auxiliarServicios, BoxLayout.X_AXIS));
        auxiliarServicios.setBackground(parametros.getColorCuerpo());
        auxiliarServicios.add(comboServicios, SwingConstants.CENTER);
        
        // Precio
        JLabel infoPrecio = new JLabel("Info Precio");
        // TODO hacer que este label cambie dependiendo del servicio
        
        // Descripción
        JLabel infoDescripcion = new JLabel("Info Precio");
        // TODO hacer que este label cambie dependiendo del servicio
        
        /// ADD
        
        pestania.add(servicio);
        pestania.add(auxiliarServicios);
        pestania.add(precio);
        pestania.add(infoPrecio);
        pestania.add(descripcion);
        pestania.add(infoDescripcion);
        
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

