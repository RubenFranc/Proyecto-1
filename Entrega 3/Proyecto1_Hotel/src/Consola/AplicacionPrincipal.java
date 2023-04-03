package Consola;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Controlador.ControladorPersistencia;
import Model.Hotel;
import Model.Usuario;

public class AplicacionPrincipal {
	
	private void ejecutarAplicacionPrincipal() throws IOException {
		System.out.println("\nBienvenido al hotel DPOO");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Hotel hotel = new Hotel();
		cargarUsuarios("../baseDeDatosHotel/archivoUsuarios.txt", hotel);
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();
		controladorPersistencia.cargarHabitacionesOcupadas(hotel, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.cargarHabitacionesDisponibles(hotel, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");
		controladorPersistencia.cargarReservas(hotel, "../baseDeDatosHotel/archivoReservas.txt");
		controladorPersistencia.cargarProductosMenuArchivo(hotel, "../baseDeDatosHotel/archivoMenuRestaurante.txt");
		controladorPersistencia.cargarServiciosArchivo(hotel, "../baseDeDatosHotel/archivoServicios.txt");
//		String mssg = "";
		boolean continuarIngreso = true;
		while (continuarIngreso) {
			mostrarMenuAplicacion();
			String opcionSeleccionada = input("\nPor favor seleccione una opción");
			if (opcionSeleccionada.equals("1")) {
				String logIn = input("\nPor favor ingrese su logIn de usuario");
				String password = input("\nPor favor ingrese su contraseña");
				String mssg = verificacionIdentidad(logIn, password, hotel);
				if (mssg.equals("A")) {
					AplicacionAdministrador appAdmin = new AplicacionAdministrador();
					appAdmin.ejecutarAplicacionAdministrador(hotel);
//					ejecutarAplicacionAdministrador(hotel);
//					continuarIngreso = false;
				}
				else if (mssg.equals("R")) {
					AplicacionRecepcionista appRecep = new AplicacionRecepcionista();
					appRecep.ejecutarAplicacionRecepcionista(hotel);
//					ejecutarAplicacionRecepcionista(hotel);
//					continuarIngreso = false;
				}
				else if (mssg.equals("E")) {
					AplicacionEmpleado appEmpl = new AplicacionEmpleado();
					appEmpl.ejecutarAplicacionEmpleado(hotel);
//					ejecutarAplicacionEmpleado(hotel);
//					continuarIngreso = false;
				}
				else {
					System.out.println(mssg);
				}
			}
			else if (opcionSeleccionada.equals("2")) {
				continuarIngreso = false;
			}
			else {
				System.out.println("\nIngrese una opcion válida\n");
			}
		}
		controladorPersistencia.guardarArchivoHabitacionesOcupadas(hotel, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.guardarArchivoHabitacionesDisponibles(hotel, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.guardarModificacionesTarifasHabitaciones(hotel, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");
		controladorPersistencia.guardarReservas(hotel, "../baseDeDatosHotel/archivoReservas.txt");
		controladorPersistencia.guardarProductosMenuArchivo(hotel, "../baseDeDatosHotel/archivoMenuRestaurante.txt");
		controladorPersistencia.guardarServiciosArchivo(hotel, "../baseDeDatosHotel/archivoServicios.txt");
	}

	public String verificacionIdentidad(String logIn, String password, Hotel hotel) {
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
	
	public void cargarUsuarios(String archivoUsuarios, Hotel hotel) throws IOException {
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
	
	public static void mostrarMenuAplicacion() {
		System.out.println("\nOpciones:");
		System.out.println("1. Ingresar al sistema");
		System.out.println("2. Cerrar aplicación");
	}
	
	public String input(String mensaje){
		try{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e){
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		AplicacionPrincipal aplicacion = new AplicacionPrincipal();
		aplicacion.ejecutarAplicacionPrincipal();
	}
	
}
