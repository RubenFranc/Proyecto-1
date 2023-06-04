package consola_grafica;

import javax.swing.*;

import Model.Hotel;

import java.awt.*;
import java.awt.event.*;

public class menu_administrador extends JFrame {

    public menu_administrador(Hotel hotel) {
        JFrame frame = new JFrame("Menu Administrador");
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
        JLabel titulo = new JLabel("MENÚ ADMINISTRADOR", SwingConstants.CENTER);
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
        
     // Cuerpo
        cuerpo.setLayout(new BorderLayout());
        cuerpo.setBackground(colorCuerpo);
        cuerpo.setPreferredSize(dimensionCuerpo);
        
        
        
        //Pestañas
        JButton botonPestaniaCargarDatos = new JButton("Cargar Habitaciones");
        botonPestaniaCargarDatos.addActionListener(event -> {
        	JPanel pestaniaCargarDatos = adminPestaniaCargarDatos.getPestania(hotel);
        	//pestaniaCargarDatos.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaCargarDatos.setLocation(0,0);
        	//pestaniaCargarDatos.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaCargarDatos, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        
        JButton botonPestaniaCrearHabitacion = new JButton("Crear Habitación");
        botonPestaniaCrearHabitacion.addActionListener(event -> {
        	JPanel pestaniaCargarHabitacion= adminPestaniaCargarHabitacion.getPestania(hotel);
        	//pestaniaCargarHabitacion.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaCargarHabitacion.setLocation(0,0);
        	//pestaniaCargarHabitacion.setSize(dimensionCuerpo);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaCargarHabitacion, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
        });
        
        JButton botonPestaniaCargarMenu = new JButton("Cargar Menú");
        botonPestaniaCargarMenu.addActionListener(event -> {
        	JPanel pestaniaCargarMenu= adminPestaniaCargarMenu.getPestania(hotel);
        	//pestaniaCargarMenu.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaCargarMenu.setLocation(0,0);
        	//pestaniaCargarMenu.setSize(500, 200);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaCargarMenu, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
        });
        
        JButton botonPestaniaCargarServicios = new JButton("Cargar Servicios");
        botonPestaniaCargarServicios.addActionListener(event -> {
        	JPanel pestaniaCargarServicios= adminPestaniaCargarServicios.getPestania(hotel);
        	//pestaniaCargarServicios.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaCargarServicios.setLocation(0,0);
        	//pestaniaCargarServicios.setSize(500, 200);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaCargarServicios, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
        });
        JButton botonPestaniaCambiarTarifaServicio = new JButton("Cambiar Tarifa Servicio");
        botonPestaniaCambiarTarifaServicio.addActionListener(event -> {
        	JPanel pestaniaCambiarTarifaServicio= adminPestaniaCambiarTarifaServicio.getPestania(hotel);
        	//pestaniaCambiarTarifaServicio.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaCambiarTarifaServicio.setLocation(0,0);
        	//pestaniaCambiarTarifaServicio.setSize(500, 200);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaCambiarTarifaServicio, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
        });
        JButton botonPestaniaAsignarTarifaHabitacionFecha = new JButton("Asignar Tarifa Habitación por Fecha");
        botonPestaniaAsignarTarifaHabitacionFecha.addActionListener(event -> {
        	JPanel pestaniaAsignarTarifaHabitacionFecha= adminPestaniaAsignarTarifaHabitacionFecha.getPestania(hotel);
        	//pestaniaAsignarTarifaHabitacionFecha.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaAsignarTarifaHabitacionFecha.setLocation(0,0);
        	//pestaniaAsignarTarifaHabitacionFecha.setSize(500, 200);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaAsignarTarifaHabitacionFecha, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
        });
        JButton botonPestaniaEditarProductoMenu = new JButton("Editar Producto Menú");
        botonPestaniaEditarProductoMenu.addActionListener(event -> {
        	JPanel pestaniaEditarProductoMenu= adminPestaniaEditarProductoMenu.getPestania(hotel);
        	//pestaniaEditarProductoMenu.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaEditarProductoMenu.setLocation(0,0);
        	//pestaniaEditarProductoMenu.setSize(500, 200);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaEditarProductoMenu, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
        });
        JButton botonPestaniaConsultarFiguras= new JButton("Generar gráficas");
        botonPestaniaConsultarFiguras.addActionListener(event -> {
        	JPanel pestaniaConsultarFiguras= adminPestaniaConsultarFiguras.getPestania(hotel);
        	//pestaniaCambiarTarifaServicio.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaCambiarTarifaServicio.setLocation(0,0);
        	//pestaniaCambiarTarifaServicio.setSize(500, 200);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaConsultarFiguras, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
        });
        
        botonPestaniaCargarDatos.setPreferredSize(dimensionBotonBarra);
        botonPestaniaCrearHabitacion.setPreferredSize(dimensionBotonBarra);
        botonPestaniaCargarMenu.setPreferredSize(dimensionBotonBarra);
        botonPestaniaCargarServicios.setPreferredSize(dimensionBotonBarra);
        botonPestaniaCambiarTarifaServicio.setPreferredSize(dimensionBotonBarra);
        botonPestaniaAsignarTarifaHabitacionFecha.setPreferredSize(dimensionBotonBarra);
        botonPestaniaEditarProductoMenu.setPreferredSize(dimensionBotonBarra);
        botonPestaniaConsultarFiguras.setPreferredSize(dimensionBotonBarra);
        
        //Izquierda
        izquierda.setLayout(new FlowLayout());
        izquierda.setBackground(colorIzquierda);
        izquierda.setPreferredSize(dimensionIzquierda);
        
        izquierda.add(botonPestaniaCargarDatos);
        izquierda.add(botonPestaniaCrearHabitacion);
        izquierda.add(botonPestaniaCargarMenu);
        izquierda.add(botonPestaniaCargarServicios);
        izquierda.add(botonPestaniaCambiarTarifaServicio);
        izquierda.add(botonPestaniaAsignarTarifaHabitacionFecha);
        izquierda.add(botonPestaniaEditarProductoMenu);
        izquierda.add(botonPestaniaConsultarFiguras);
        
        
        // Derecha
         
        derecha.setBackground(colorDerecha);
        derecha.setPreferredSize(dimensionDerecha);
        
        
        
        
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
	
}