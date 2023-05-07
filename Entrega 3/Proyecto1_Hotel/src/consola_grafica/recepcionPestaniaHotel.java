package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class recepcionPestaniaHotel extends JPanel{
	 
	
	public recepcionPestaniaHotel (){
		
		/// CONFIGURACION
		setPreferredSize(parametros.getDimensionCuerpo());
	    setBackground(parametros.getColorCuerpo());
	    setLayout(new BorderLayout());
	    
	    /// ELEMENTOS
        JLabel hotelLabel = new JLabel("Reservas del Hotel", SwingConstants.CENTER);
        
        /// ADD
        
        add(hotelLabel, BorderLayout.NORTH);
        add(CalendarFrame.getCalendar());
        
      
	}
	
	
}