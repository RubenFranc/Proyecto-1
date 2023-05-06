package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class empleadoPestaniaProductosMenu extends JFrame implements ActionListener{
	
	private static JPanel pestania = new JPanel();
	
	public static JPanel getPestania (){
		
		/// CONFIGURACION
		pestania.setPreferredSize(parametros.getDimensionCuerpo());
	    pestania.setBackground(parametros.getColorCuerpo());
	    pestania.setLayout(new GridLayout(5,2, 10, 10));
	    
	    /// ELEMENTOS
        JLabel productos = new JLabel("Producto", SwingConstants.CENTER);
        JLabel precio = new JLabel("Precio", SwingConstants.CENTER);
        JLabel horaInicio = new JLabel("Hora inicio", SwingConstants.CENTER);
        JLabel horaFin = new JLabel("Hora fin", SwingConstants.CENTER);
        JLabel descripcion = new JLabel("Descripción", SwingConstants.CENTER);
                
        // Servicio
        String[] servicios = { "a", "b", "c", "d", "e" };
        // TODO agregar los productos correctos!!!
        JComboBox comboServicios = new JComboBox(servicios);
        
        JPanel auxiliarProducto = new JPanel();
        auxiliarProducto.setLayout(new BoxLayout(auxiliarProducto, BoxLayout.X_AXIS));
        auxiliarProducto.setBackground(parametros.getColorCuerpo());
        auxiliarProducto.add(comboServicios, SwingConstants.CENTER);
        
        // Precio
        JLabel infoPrecio = new JLabel("Info Precio");
        // TODO hacer que este label cambie dependiendo del servicio
        
        // Hora Inicio
        JLabel infoHoraInicio = new JLabel("Info Precio");
        // TODO hacer que este label cambie dependiendo del servicio
        
        // Hora Fin
        JLabel infoHoraFin = new JLabel("Info Precio");
        // TODO hacer que este label cambie dependiendo del servicio
        
        // Descripción
        JLabel infoDescripcion = new JLabel("Info Precio");
        // TODO hacer que este label cambie dependiendo del servicio
        
        /// ADD
        
        pestania.add(productos);
        pestania.add(auxiliarProducto);
        pestania.add(precio);
        pestania.add(infoPrecio);
        pestania.add(horaInicio);
        pestania.add(infoHoraInicio);
        pestania.add(horaFin);
        pestania.add(infoHoraFin);
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
