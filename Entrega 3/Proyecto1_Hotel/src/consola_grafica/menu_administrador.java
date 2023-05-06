package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu_administrador extends JFrame implements ActionListener {
    
    public static void main(String[] args) {
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
        cuerpo.setLayout(new GridLayout(2, 2));
        frame.setLayout(new BorderLayout());
        
        // Botones Varios
        JButton botonAtras = new JButton("<- Atrás");
        botonAtras.setPreferredSize(dimensionBotonArriba);
        
        JButton botonLogout = new JButton("Logout");
        botonLogout.setPreferredSize(dimensionBotonArriba);
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
        
        //Pestañas
        JButton botonPestaniaCargarDatos = new JButton("Cargar Datos");
        JButton botonPestaniaCrearHabitacion = new JButton("Crear Habitación");
        JButton botonPestaniaCargarMenu = new JButton("Cargar Menú");
        JButton botonPestaniaCargarServicios = new JButton("Cargar Servicios");
        JButton botonPestaniaCambiarTarifaServicio = new JButton("Cambiar Tarifa Servicio");
        JButton botonPestaniaAsignarTarifaHabitacionFecha = new JButton("Asignar Tarifa Habitación por Fecha");
        JButton botonPestaniaEditarProductoMenu = new JButton("Editar Producto Menú");
        
        botonPestaniaCargarDatos.setPreferredSize(dimensionBotonBarra);
        botonPestaniaCrearHabitacion.setPreferredSize(dimensionBotonBarra);
        botonPestaniaCargarMenu.setPreferredSize(dimensionBotonBarra);
        botonPestaniaCargarServicios.setPreferredSize(dimensionBotonBarra);
        botonPestaniaCambiarTarifaServicio.setPreferredSize(dimensionBotonBarra);
        botonPestaniaAsignarTarifaHabitacionFecha.setPreferredSize(dimensionBotonBarra);
        botonPestaniaEditarProductoMenu.setPreferredSize(dimensionBotonBarra);
        
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
        
        
        // Derecha
         
        derecha.setBackground(colorDerecha);
        derecha.setPreferredSize(dimensionDerecha);
        

        // Cuerpo
        cuerpo.setLayout(new BorderLayout());
        cuerpo.setBackground(colorCuerpo);
        cuerpo.setPreferredSize(dimensionCuerpo);
        
        cuerpo.add(adminPestaniaCargarDatos.getPestania(),  BorderLayout.CENTER);
        cuerpo.add(adminPestaniaCargarHabitacion.getPestania(),  BorderLayout.CENTER);
        cuerpo.add(adminPestaniaCargarMenu.getPestania(),  BorderLayout.CENTER);
        cuerpo.add(adminPestaniaCargarServicios.getPestania(),  BorderLayout.CENTER);
        cuerpo.add(adminPestaniaCambiarTarifaServicio.getPestania(),  BorderLayout.CENTER);
        cuerpo.add(adminPestaniaAsignarTarifaHabitacionFecha.getPestania(),  BorderLayout.CENTER);
        cuerpo.add(adminPestaniaEditarProductoMenu.getPestania(), BorderLayout.CENTER);
        
        cuerpo.add(confirmarPanel, BorderLayout.SOUTH);
        
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