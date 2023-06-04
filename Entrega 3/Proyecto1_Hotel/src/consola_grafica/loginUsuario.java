package consola_grafica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Controlador.ControladorPersistencia;
import Model.Hotel;
import Model.Usuario;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class loginUsuario extends JFrame  {
	
    
	public loginUsuario(Hotel hotel){
        JFrame frame = new JFrame("Iniciar Sesión Usuario HOTEL");
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
        loginButton.addActionListener(event -> {
        	
        	String user = usuarioTextField.getText();
        	String password = contraseniaTextField.getText();
        	String mssg = verificacionIdentidad(user, password, hotel);
        	
            if (mssg.equals("U")) {
            		cuerpo.removeAll();
                	frame.removeAll();
                	frame.dispose();
                	JFrame menuUsuario = new menu_usuario(hotel);
                	menuUsuario.setVisible(true);
            	}
        	else {
        		JOptionPane.showMessageDialog(null, mssg);
        	}
            
         });
        
        //Boton Registro
        JButton signUpButton = new JButton("Sign Up");
        loginButton.setPreferredSize(dimensionBotonBarra);
        loginButton.addActionListener(event -> {
        	
            cuerpo.removeAll();
            frame.removeAll();
            frame.dispose();
            JFrame crearUsuario = new usuarioPestaniaCrearUsuario(hotel);
            crearUsuario.setVisible(true);
            	
            
         });
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
        pieDePagina.add(signUpButton);
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

    	ControladorPersistencia controladorPersistencia= new ControladorPersistencia();
        try {
			controladorPersistencia.guardarArchivoHabitacionesOcupadas(hotel, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
			controladorPersistencia.guardarArchivoHabitacionesDisponibles(hotel, "../baseDeDatosHotel/archivoHabitaciones.txt");
			controladorPersistencia.guardarModificacionesTarifasHabitaciones(hotel, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");
			controladorPersistencia.guardarReservas(hotel, "../baseDeDatosHotel/archivoReservas.txt");
			controladorPersistencia.guardarProductosMenuArchivo(hotel, "../baseDeDatosHotel/archivoMenuRestaurante.txt");
			controladorPersistencia.guardarServiciosArchivo(hotel, "../baseDeDatosHotel/archivoServicios.txt");
			controladorPersistencia.guardarUsuariosArchivo(hotel, "../baseDeDatosHotel/archivoUsuarios.txt");
			controladorPersistencia.guardarValoresFacturasArchivo(hotel, "../baseDeDatosHotel/archivoFacturas.txt");
			controladorPersistencia.guardarRelacionRestauranteTarifaArchivo(hotel, "../baseDeDatosHotel/archivoRelacionRestauranteHabitacion.txt");
			controladorPersistencia.guardarRelacionServiciosTarifaArchivo(hotel, "../baseDeDatosHotel/archivoRelacionServiciosHabitacion.txt");
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        // Set Close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make visible
        frame.setVisible(true);
    }
    
    public static void cargarUsuarios(String archivoUsuarios, Hotel hotel) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoUsuarios));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String logIn = partes[0];
			String password = partes[1];
			String cargo = partes[2].replace("\n", "");
			Usuario usuario = new Usuario(logIn, password, cargo);
			hotel.getUsuarios().put(logIn, usuario);
			linea = br.readLine();
		}
		br.close();
	}
    
    public static String verificacionIdentidad(String logIn, String password, Hotel hotel) {
		String mssg = "";
		if (hotel.getUsuarios().containsKey(logIn)) {
			Usuario usuario = hotel.getUsuarios().get(logIn);
			if (usuario.verificarIdentificacion(password)) {
				mssg = usuario.getCargo();
			}
			else {
				mssg = "Contraseña incorrecta";
			}
		}
		else { 
			mssg = "El usuario " + logIn + " no se encuentra en la base de datos";
		}
		return mssg;
	}
    
    public static void main(String[] args) throws IOException {
    	Hotel hotel = new Hotel();
    	try {
			cargarUsuarios("../baseDeDatosHotel/archivoUsuarios.txt", hotel);
		} 
    	catch (IOException e) {
			e.printStackTrace();
		}
    	ControladorPersistencia controladorPersistencia= new ControladorPersistencia();
		controladorPersistencia.cargarHabitacionesOcupadas(hotel, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.cargarHabitacionesDisponibles(hotel, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");
		controladorPersistencia.cargarReservas(hotel, "../baseDeDatosHotel/archivoReservas.txt");
		controladorPersistencia.cargarProductosMenuArchivo(hotel, "../baseDeDatosHotel/archivoMenuRestaurante.txt");
		controladorPersistencia.cargarServiciosArchivo(hotel, "../baseDeDatosHotel/archivoServicios.txt");
		controladorPersistencia.cargarValoresFacturas(hotel, "../baseDeDatosHotel/archivoFacturas.txt");
		controladorPersistencia.cargarRelacionRestauranteTarifa(hotel, "../baseDeDatosHotel/archivoRelacionRestauranteHabitacion.txt");
		controladorPersistencia.cargarRelacionServiciosTarifa(hotel, "../baseDeDatosHotel/archivoRelacionServiciosHabitacion.txt");
    	new loginUsuario(hotel);
    	//loginU.setVisible(true);
    	
    }

}
