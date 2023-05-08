package consola_grafica;

import javax.swing.*;

import Model.Hotel;

import java.awt.*;
import java.awt.event.*;

public class menu_empleado extends JFrame implements ActionListener {
    
    public menu_empleado(Hotel hotel) {
        JFrame frame = new JFrame("Menu Empleado");
        JPanel encabezado = new JPanel();
        JPanel cuerpo = new JPanel();
        JPanel pieDePagina = new JPanel();
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        // Colores
        Color colorCuerpo = parametros.getColorCuerpo();
        Color colorColumna = parametros.getColorColumna();
    	Color colorDerecha = parametros.getColorDerecha();
        Color colorIzquierda = parametros.getColorIzquierda();
        Color colorTitulo = parametros.getColorTitulo();
        Color colorSubtitulo = parametros.getColorSubtitulo();
        
        // Dimensiones
        Dimension dimensionVentana = parametros.getDimensionVentana();
    	Dimension dimensionCuerpo = parametros.getDimensionCuerpo();
    	Dimension dimensionColumna = parametros.getDimensionColumna();
    	Dimension dimensionDerecha = parametros.getDimensionDerecha();
        Dimension dimensionIzquierda = parametros.getDimensionIzquierda(); 
        Dimension dimensionTitulo = parametros.getDimensionTitulo();
        Dimension dimensionSubtitulo = parametros.getDimensionSubtitulo();
        Dimension dimensionBotonBarra = parametros.getDimensionBotonBarra();
        Dimension dimensionBotonArriba = parametros.getDimensionBotonArriba();
        
        // Fuentes
        Font fuenteTitulo = parametros.getFuenteTitulo();
    	Font fuenteBotonBarra = parametros.getFuenteTitulo();
    	Font fuenteGeneral = parametros.getFuenteTitulo();
    	
    	// Set Ventana
        frame.setSize(dimensionVentana);
        frame.setLocationRelativeTo(null);
        
        // Contenido



        // Layout
        cuerpo.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());
        
        // Botones Varios
        JButton botonAtras = new JButton("<- Atrás");
        botonAtras.setPreferredSize(dimensionBotonArriba);
        botonAtras.addActionListener(event -> {
        	
        	cuerpo.removeAll();
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        
        JButton botonLogout = new JButton("Logout");
        botonLogout.setPreferredSize(dimensionBotonArriba);
        botonLogout.addActionListener(event -> {
        	
        	cuerpo.removeAll();
        	frame.removeAll();
        	frame.dispose();
        	JFrame login= new login();
        	login.setVisible(true);
        	
            
         });
        JButton botonConfirmar = new JButton("Confirmar");   
        botonConfirmar.setPreferredSize(dimensionBotonArriba);
        
        JPanel atrasPanel = new JPanel();
        atrasPanel.setLayout(new BoxLayout(atrasPanel, BoxLayout.X_AXIS));
        atrasPanel.setPreferredSize(dimensionBotonArriba);
        atrasPanel.setBackground(colorTitulo);
        atrasPanel.add(botonAtras);
        JPanel logoutPanel = new JPanel();
        logoutPanel.setLayout(new BoxLayout(logoutPanel, BoxLayout.X_AXIS));
        logoutPanel.setPreferredSize(dimensionBotonArriba);
        logoutPanel.setBackground(colorTitulo);
        logoutPanel.add(botonLogout);
        JPanel confirmarPanel = new JPanel();
        confirmarPanel.setLayout(new BoxLayout(confirmarPanel, BoxLayout.X_AXIS));
        confirmarPanel.setPreferredSize(dimensionBotonBarra);
        confirmarPanel.setBackground(colorCuerpo);
        confirmarPanel.add(Box.createVerticalGlue());
        confirmarPanel.add(Box.createHorizontalGlue());
        confirmarPanel.add(botonConfirmar);
        confirmarPanel.add(Box.createVerticalGlue());
        confirmarPanel.add(Box.createHorizontalGlue());
                
        
        // Encabezado
        encabezado.setLayout(new BorderLayout());
        JLabel titulo = new JLabel("MENÚ EMPLEADO", SwingConstants.CENTER);
        titulo.setFont(fuenteTitulo);
        titulo.setPreferredSize(dimensionTitulo);
        encabezado.add(titulo, BorderLayout.CENTER);
        encabezado.add(atrasPanel, BorderLayout.WEST);
        encabezado.add(logoutPanel, BorderLayout.EAST);
        encabezado.setBackground(colorTitulo);
        encabezado.setPreferredSize(dimensionTitulo);
        
        
        // Pie de Página
        pieDePagina.setBackground(colorSubtitulo);
        pieDePagina.setPreferredSize(dimensionSubtitulo);
        
        // Barra Iquierda
        
        //Pestañas
        JButton botonPestaniaAgregarServicio = new JButton("Registrar Servicio");
        botonPestaniaAgregarServicio.addActionListener(event -> {
        	JPanel pestaniaAgregarServicio= empleadoPestaniaAgregarServicio.getPestania(hotel);
        	//pestaniaAgregarServicio.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaAgregarServicio.setLocation(0,0);
        	//pestaniaAgregarServicio.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaAgregarServicio, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        JButton botonPestaniaRegistrarConsumo = new JButton("Registrar Consumo En Restaurante");
        botonPestaniaRegistrarConsumo.addActionListener(event -> {
        	JPanel pestaniaRegistrarConsumo= empleadoPestaniaRegistrarConsumo.getPestania(hotel);
        	//pestaniaRegistrarConsumo.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaRegistrarConsumo.setLocation(0,0);
        	//pestaniaRegistrarConsumo.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaRegistrarConsumo, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        JButton botonPestaniaHabitacionesDisponibles = new JButton("Habitaciones Disponibles");
        botonPestaniaHabitacionesDisponibles.addActionListener(event -> {
        	JPanel pestaniaHabitacionesDisponibles= empleadoPestaniaHabitacionesDisponibles.getPestania(hotel);
        	//pestaniaHabitacionesDisponibles.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaHabitacionesDisponibles.setLocation(0,0);
        	//pestaniaHabitacionesDisponibles.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaHabitacionesDisponibles, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        JButton botonPestaniaHabitacionesOcupadas = new JButton("Habitaciones Ocupadas");
        botonPestaniaHabitacionesOcupadas.addActionListener(event -> {
        	JPanel pestaniaHabitacionesOcupadas= empleadoPestaniaHabitacionesOcupadas.getPestania(hotel);
        	//pestaniaHabitacionesOcupadas.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaHabitacionesOcupadas.setLocation(0,0);
        	//pestaniaHabitacionesOcupadas.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaHabitacionesOcupadas, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        JButton botonPestaniaServiciosHotel = new JButton("Servicios del Hotel");
        botonPestaniaServiciosHotel.addActionListener(event -> {
        	JPanel pestaniaServiciosHotel= empleadoPestaniaServiciosHotel.getPestania(hotel);
        	//pestaniaServiciosHotel.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaServiciosHotel.setLocation(0,0);
        	//pestaniaServiciosHotel.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaServiciosHotel, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        JButton botonPestaniaProductoMenu = new JButton("Productos del Menu");
        botonPestaniaProductoMenu.addActionListener(event -> {
        	JPanel pestaniaProductoMenu= empleadoPestaniaProductosMenu.getPestania(hotel);
        	//pestaniaProductoMenu.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaProductoMenu.setLocation(0,0);
        	//pestaniaProductoMenu.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaProductoMenu, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        
        botonPestaniaAgregarServicio.setPreferredSize(dimensionBotonBarra);
        botonPestaniaRegistrarConsumo.setPreferredSize(dimensionBotonBarra);
        botonPestaniaHabitacionesDisponibles.setPreferredSize(dimensionBotonBarra);
        botonPestaniaHabitacionesOcupadas.setPreferredSize(dimensionBotonBarra);
        botonPestaniaServiciosHotel.setPreferredSize(dimensionBotonBarra);
        botonPestaniaProductoMenu.setPreferredSize(dimensionBotonBarra);
        
        //Izquierda
        izquierda.setLayout(new FlowLayout());
        izquierda.setBackground(colorIzquierda);
        izquierda.setPreferredSize(dimensionIzquierda);
        
        izquierda.add(botonPestaniaAgregarServicio);
        izquierda.add(botonPestaniaRegistrarConsumo);
        izquierda.add(botonPestaniaHabitacionesDisponibles);
        izquierda.add(botonPestaniaHabitacionesOcupadas);
        izquierda.add(botonPestaniaServiciosHotel);
        izquierda.add(botonPestaniaProductoMenu);
                
        // Derecha         
        derecha.setBackground(colorDerecha);
        derecha.setPreferredSize(dimensionDerecha);
        
        // Cuerpo
        cuerpo.setBackground(colorCuerpo);
        cuerpo.setPreferredSize(dimensionCuerpo);
        cuerpo.setLayout(new BorderLayout());
        
        
        // Frame
        frame.add(encabezado, BorderLayout.NORTH);
        frame.add(cuerpo, BorderLayout.CENTER);
        frame.add(pieDePagina, BorderLayout.SOUTH);
        frame.add(izquierda, BorderLayout.WEST);
        frame.add(derecha, BorderLayout.EAST);

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
