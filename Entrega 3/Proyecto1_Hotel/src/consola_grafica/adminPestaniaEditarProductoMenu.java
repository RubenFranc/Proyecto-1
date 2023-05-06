package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class adminPestaniaEditarProductoMenu extends JFrame implements ActionListener{
	
	private static JPanel pestania = new JPanel();
	
	public static JPanel getPestania (){
		
		/// CONFIGURACION
		pestania.setPreferredSize(parametros.getDimensionCuerpo());
	    pestania.setBackground(parametros.getColorCuerpo());
	    pestania.setLayout(new GridLayout(5,2, 10, 10));
	    
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
        
        pestania.add(producto);
        pestania.add(auxiliarProductos);
        pestania.add(servicioCuarto);
        pestania.add(auxiliarServicioCuarto);
        pestania.add(horaInicio);
        pestania.add(auxiliarHoraInicio);
        pestania.add(horaFin);
        pestania.add(auxiliarHoraFin);
        pestania.add(tarifa);
        pestania.add(auxiliarTarifa);
        
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