package consola_grafica;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Iniciar Sescion HOTEL");
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
        
        // Fuentes
        Font fuenteTitulo = parametros.getFuenteTitulo();
    	Font fuenteBotonBarra = parametros.getFuenteTitulo();
    	Font fuenteGeneral = parametros.getFuenteTitulo();
    	
    	// Set Ventana
        frame.setSize(dimensionVentana);
        frame.setLocationRelativeTo(null);
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
        
        panel1.setBackground(colorCuerpo);
        panel2.setBackground(colorCuerpo);
        panel3.setBackground(colorCuerpo);
        panel4.setBackground(colorCuerpo);

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setFont(fuenteBotonBarra);
        usuarioLabel.setPreferredSize(new Dimension(250, 150));
        usuarioLabel.setMaximumSize(new Dimension(250, 150));
        JLabel contraseniaLabel = new JLabel("Contraseña");
        contraseniaLabel.setFont(fuenteBotonBarra);
        contraseniaLabel.setPreferredSize(new Dimension(250, 150));
        contraseniaLabel.setMaximumSize(new Dimension(250, 150));

        JTextField usuarioTextField = new JTextField();
        usuarioTextField.setPreferredSize(new Dimension(200, 75));
        usuarioTextField.setMaximumSize(new Dimension(200, 75));
        JTextField contraseniaTextField = new JPasswordField();
        contraseniaTextField.setPreferredSize(new Dimension(200, 75));
        contraseniaTextField.setMaximumSize(new Dimension(200, 75));

        // Botón
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(dimensionBotonBarra);
        //loginButton.setMinimumSize(dimensionSubtitulo);

        // Cuerpo
        panel1.add(usuarioLabel, SwingConstants.CENTER);
        panel2.add(usuarioTextField, SwingConstants.CENTER);
        panel3.add(contraseniaLabel, BorderLayout.SOUTH,SwingConstants.CENTER);
        panel4.add(contraseniaTextField, BorderLayout.SOUTH,SwingConstants.CENTER);
        cuerpo.add(panel1);
        cuerpo.add(panel2);
        cuerpo.add(panel3);
        cuerpo.add(panel4);
        cuerpo.setBackground(colorCuerpo);
        cuerpo.setPreferredSize(dimensionCuerpo);

        // Layout
        cuerpo.setLayout(new GridLayout(2, 2));
        frame.setLayout(new BorderLayout());
        
        // Encabezado
        encabezado.setLayout(new BorderLayout());
        JLabel titulo = new JLabel("HOTEL DPOO - Bienvenido", SwingConstants.CENTER);
        titulo.setFont(fuenteTitulo);
        titulo.setPreferredSize(dimensionTitulo);
        encabezado.add(titulo, BorderLayout.CENTER);   
        encabezado.setBackground(colorTitulo);
        encabezado.setPreferredSize(dimensionTitulo);
        
        
        // Pie de Página
        pieDePagina.setLayout(new BoxLayout(pieDePagina, BoxLayout.X_AXIS));
        pieDePagina.add(Box.createVerticalGlue());
        pieDePagina.add(Box.createHorizontalGlue());
        pieDePagina.add(loginButton);
        pieDePagina.add(Box.createHorizontalGlue());
        pieDePagina.add(Box.createVerticalGlue());
        pieDePagina.setBackground(colorSubtitulo);
        pieDePagina.setPreferredSize(dimensionSubtitulo);
        
        // Izquierda 
        izquierda.setBackground(colorColumna);
        izquierda.setPreferredSize(dimensionColumna);
        
        // Derecha
         
        derecha.setBackground(colorColumna);
        derecha.setPreferredSize(dimensionColumna);
        
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

