package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminPestaniaEditarProductoMenu extends JPanel{
	
	
	
	public adminPestaniaEditarProductoMenu (){
		
		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
	    setBackground(parametros.getColorCuerpo());
	    setLayout(new GridLayout(5,2, 10, 10));
	    
	    /// ELEMENTOS
        JLabel producto = new JLabel("Producto", SwingConstants.CENTER);
        JLabel servicioCuarto = new JLabel("¿Tiene servicio al cuarto?", SwingConstants.CENTER);
        JLabel horaInicio = new JLabel("Hora de inicio", SwingConstants.CENTER);
        JLabel horaFin = new JLabel("Hora de fin", SwingConstants.CENTER);
        JLabel tarifa = new JLabel("Nueva tarifa", SwingConstants.CENTER);
                
        // Producto
        String[] productos = { "a", "b", "c", "d", "e" };
        // TODO agregar los productos correctos!!!
        JComboBox comboProductos = new JComboBox(productos);
        
        JPanel auxiliarProductos = new JPanel();
        auxiliarProductos.setLayout(new BoxLayout(auxiliarProductos, BoxLayout.X_AXIS));
        auxiliarProductos.setBackground(parametros.getColorCuerpo());
        auxiliarProductos.add(comboProductos, SwingConstants.CENTER);
        
        // Servicio al cuarto
        ButtonGroup grupoServicioCuarto = new ButtonGroup();        
        JRadioButton botonSi = new JRadioButton("Sí");
        botonSi.setBackground(parametros.getColorCuerpo());
        grupoServicioCuarto.add(botonSi);
        JRadioButton botonNo = new JRadioButton("No");
        botonNo.setBackground(parametros.getColorCuerpo());
        grupoServicioCuarto.add(botonNo);
        
        JPanel auxiliarServicioCuarto = new JPanel();
        auxiliarServicioCuarto.setLayout(new FlowLayout());
        auxiliarServicioCuarto.setBackground(parametros.getColorCuerpo());
        auxiliarServicioCuarto.add(botonSi);
        auxiliarServicioCuarto.add(botonNo);
        
        // Hora Inicio
        JPanel auxiliarHoraInicio = new JPanel();
        auxiliarHoraInicio.setLayout(new FlowLayout());
        auxiliarHoraInicio.setBackground(parametros.getColorCuerpo());
        JTextField horaInicioTextField = new JTextField();
        horaInicioTextField.setPreferredSize(new Dimension(200, 75));
        auxiliarHoraInicio.add(horaInicioTextField);
        
        // Hora Fin
        JPanel auxiliarHoraFin = new JPanel();
        auxiliarHoraFin.setLayout(new FlowLayout());
        auxiliarHoraFin.setBackground(parametros.getColorCuerpo());
        JTextField horaFinTextField = new JTextField();
        horaFinTextField.setPreferredSize(new Dimension(200, 75));
        auxiliarHoraFin.add(horaFinTextField);
        
        // Tarifa
        JPanel auxiliarTarifa = new JPanel();
        auxiliarTarifa.setLayout(new FlowLayout());
        auxiliarTarifa.setBackground(parametros.getColorCuerpo());
        JTextField tarifaTextField = new JTextField();
        tarifaTextField.setPreferredSize(new Dimension(200, 75));
        auxiliarTarifa.add(tarifaTextField);
        
        /// ADD
        
        add(producto);
        add(auxiliarProductos);
        add(servicioCuarto);
        add(auxiliarServicioCuarto);
        add(horaInicio);
        add(auxiliarHoraInicio);
        add(horaFin);
        add(auxiliarHoraFin);
        add(tarifa);
        add(auxiliarTarifa);
        
        
	}
	
			
	

}