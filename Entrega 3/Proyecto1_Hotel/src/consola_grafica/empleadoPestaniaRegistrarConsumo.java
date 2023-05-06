package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class empleadoPestaniaRegistrarConsumo extends JFrame implements ActionListener{
	
	private static JPanel pestania = new JPanel();
	
	public static JPanel getPestania (){
		
		/// CONFIGURACION
		pestania.setPreferredSize(parametros.getDimensionCuerpo());
	    pestania.setBackground(parametros.getColorCuerpo());
	    pestania.setLayout(new GridLayout(4,2, 10, 10));
	    
	    /// ELEMENTOS
        JLabel producto = new JLabel("Producto", SwingConstants.CENTER);
        JLabel cuentaHabitacion = new JLabel("¿Cargar a la cuenta de la habitación?", SwingConstants.CENTER);
        JLabel documento = new JLabel("Documento huesped", SwingConstants.CENTER);
        JLabel idHabitacion = new JLabel("ID de la habitación", SwingConstants.CENTER);
                
        // Producto
        String[] productos = { "a", "b", "c", "d", "e" };
        // TODO agregar los productos correctos!!!
        JComboBox comboProductos = new JComboBox(productos);
        
        JPanel auxiliarProductos = new JPanel();
        auxiliarProductos.setLayout(new BoxLayout(auxiliarProductos, BoxLayout.X_AXIS));
        auxiliarProductos.setBackground(parametros.getColorCuerpo());
        auxiliarProductos.add(comboProductos, SwingConstants.CENTER);
        
        // Cuenta de Habitacion
        ButtonGroup grupoCuentaHabitacion = new ButtonGroup();        
        JRadioButton botonSi = new JRadioButton("Sí");
        botonSi.setBackground(parametros.getColorCuerpo());
        grupoCuentaHabitacion.add(botonSi);
        JRadioButton botonNo = new JRadioButton("No");
        botonNo.setBackground(parametros.getColorCuerpo());
        grupoCuentaHabitacion.add(botonNo);
        
        JPanel auxiliarCuentaHabitacion = new JPanel();
        auxiliarCuentaHabitacion.setLayout(new BoxLayout(auxiliarCuentaHabitacion, BoxLayout.X_AXIS));
        auxiliarCuentaHabitacion.setBackground(parametros.getColorCuerpo());
        auxiliarCuentaHabitacion.add(Box.createHorizontalGlue());
        auxiliarCuentaHabitacion.add(botonSi);
        auxiliarCuentaHabitacion.add(botonNo);
        auxiliarCuentaHabitacion.add(Box.createHorizontalGlue());
        
        // Documento
        JPanel auxiliarDocumento = new JPanel();
        auxiliarDocumento.setLayout(new FlowLayout());
        auxiliarDocumento.setBackground(parametros.getColorCuerpo());
        JTextField documentoInicioTextField = new JTextField();
        documentoInicioTextField.setPreferredSize(new Dimension(200, 75));
        auxiliarDocumento.add(documentoInicioTextField);
        
        // ID Habitacion
        JPanel auxiliarIdHabitacion = new JPanel();
        auxiliarIdHabitacion.setLayout(new FlowLayout());
        auxiliarIdHabitacion.setBackground(parametros.getColorCuerpo());
        JTextField idHabitacionFinTextField = new JTextField();
        idHabitacionFinTextField.setPreferredSize(new Dimension(200, 75));
        auxiliarIdHabitacion.add(idHabitacionFinTextField);
        
        /// ADD
        
        pestania.add(producto);
        pestania.add(auxiliarProductos);
        pestania.add(cuentaHabitacion);
        pestania.add(auxiliarCuentaHabitacion);
        pestania.add(documento);
        pestania.add(auxiliarDocumento);
        pestania.add(idHabitacion);
        pestania.add(auxiliarIdHabitacion);
        
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
