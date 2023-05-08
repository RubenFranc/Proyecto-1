package consola_grafica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Model.Hotel;

public class menu_recepcionista extends JFrame implements ActionListener {
    
    public menu_recepcionista(Hotel hotel) {
        JFrame frame = new JFrame("Menu Recepcionista");
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
        JLabel titulo = new JLabel("MENÚ RECEPCIONISTA", SwingConstants.CENTER);
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
        JButton botonPestaniaHotel = new JButton("Hotel");
        botonPestaniaHotel.addActionListener(event -> {
        	JPanel pestaniaHotel= recepcionPestaniaHotel.getPestania(hotel);
        	//pestaniaHotel.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaHotel.setLocation(0,0);
        	//pestaniaHotel.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaHotel, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        JButton botonPestaniaCrearReserva = new JButton("Crear Reserva");
        botonPestaniaCrearReserva.addActionListener(event -> {
        	JPanel pestaniaCrearReserva= recepcionPestaniaCrearReserva.getPestania(hotel);
        	//pestaniaCrearReserva.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaCrearReserva.setLocation(0,0);
        	//pestaniaCrearReserva.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaCrearReserva, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        JButton botonPestaniaCancelarReserva = new JButton("Cancelar Reserva");
        botonPestaniaCancelarReserva.addActionListener(event -> {
        	JPanel pestaniaCancelarReserva= recepcionPestaniaCancelarReserva.getPestania(hotel);
        	//pestaniaCancelarReserva.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaCancelarReserva.setLocation(0,0);
        	//pestaniaCancelarReserva.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaCancelarReserva, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        JButton botonPestaniaGenerarFactura = new JButton("Generar Factura");
        botonPestaniaGenerarFactura.addActionListener(event -> {
        	JPanel pestaniaGenerarFactura= recepcionPestaniaGenerarFactura.getPestania(hotel);
        	//pestaniaGenerarFactura.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaGenerarFactura.setLocation(0,0);
        	//pestaniaGenerarFactura.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaGenerarFactura, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        
        botonPestaniaHotel.setPreferredSize(dimensionBotonBarra);
        botonPestaniaCrearReserva.setPreferredSize(dimensionBotonBarra);
        botonPestaniaCancelarReserva.setPreferredSize(dimensionBotonBarra);
        botonPestaniaGenerarFactura.setPreferredSize(dimensionBotonBarra);
        
        //Izquierda
        izquierda.setLayout(new FlowLayout());
        izquierda.setBackground(colorIzquierda);
        izquierda.setPreferredSize(dimensionIzquierda);
        
        izquierda.add(botonPestaniaHotel);
        izquierda.add(botonPestaniaCrearReserva);
        izquierda.add(botonPestaniaCancelarReserva);
        izquierda.add(botonPestaniaGenerarFactura);        
        
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

