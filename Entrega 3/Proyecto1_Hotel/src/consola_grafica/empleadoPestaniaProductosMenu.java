package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class empleadoPestaniaProductosMenu extends JPanel{
	
	public empleadoPestaniaProductosMenu(){
		
		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
	    setBackground(parametros.getColorCuerpo());
	    setLayout(new GridLayout(5,2, 10, 10));
	    
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
        
        add(productos);
        add(auxiliarProducto);
        add(precio);
        add(infoPrecio);
        add(horaInicio);
        add(infoHoraInicio);
        add(horaFin);
        add(infoHoraFin);
        add(descripcion);
        add(infoDescripcion);
        
        
	}
	
			
	

}
