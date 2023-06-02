package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import Consola.AplicacionPrincipal;
import Controlador.ControladorAdministrador;
import Controlador.ControladorPersistencia;
import Model.Hotel;
import Model.Usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class test_carga_y_persitencia {
	
	@Before
	void setUp() {
		}
	
	@After
	void tearDown() {
		
	}
	
	//controladores (se espera que no haya ningún error)

	@Test
	void test_controlador_habitaciones_ocupadas() {
		Hotel hotel_test = new Hotel();
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
		
		try {
			controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void test_controlador_habitaciones_disponibles() {
		Hotel hotel_test = new Hotel();
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	

		try {
			controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	@Test
	void test_controlador_tarifas() {
		Hotel hotel_test = new Hotel();
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	

		try {
			controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	@Test
	void test_controlador_reservas() throws IOException {
		Hotel hotel_test = new Hotel();		
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
		controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");
		

		try {
			controladorPersistencia.cargarReservas(hotel_test, "../baseDeDatosHotel/archivoReservas.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error de excepción en cargar Reservas");
		}
		}
	
	@Test
	void test_controlador_productos_menu() {
		Hotel hotel_test = new Hotel();
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	

		try {
			controladorPersistencia.cargarProductosMenuArchivo(hotel_test, "../baseDeDatosHotel/archivoMenuRestaurante.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	@Test
	void test_controlador_servicios() {
		Hotel hotel_test = new Hotel();
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	

		try {
			controladorPersistencia.cargarServiciosArchivo(hotel_test, "../baseDeDatosHotel/archivoServicios.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	//////
	// Controladores malas direcciones (se espera que haya una excepción de archivo no encontrado)
	
	//controladores

		@Test
		void test_controlador_dir_habitaciones_ocupadas() {
			Hotel hotel_test = new Hotel();
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
		
			Assertions.assertThrows(java.io.FileNotFoundException.class, () -> {
				controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadasTEST.txt");
			}, "no debió funcionar: el archivo buscado NO existe");
			
		}
		
		@Test
		void test_controlador_dir_habitaciones_disponibles() {
			Hotel hotel_test = new Hotel();
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	

			Assertions.assertThrows(java.io.FileNotFoundException.class, () -> {
				controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitacionesTEST.txt");
			}, "no debió funcionar: el archivo buscado NO existe");
			}
		
		@Test
		void test_controlador_dir_tarifas() {
			Hotel hotel_test = new Hotel();
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	

			Assertions.assertThrows(java.io.FileNotFoundException.class, () -> {
				controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitacionesTEST.txt");
				}, "no debió funcionar: el archivo buscado NO existe");
			}
		
		@Test
		void test_controlador_dir_reservas() throws IOException {
			Hotel hotel_test = new Hotel();		
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
			controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
			controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
			controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");

			Assertions.assertThrows(java.io.FileNotFoundException.class, () -> {
				controladorPersistencia.cargarReservas(hotel_test, "../baseDeDatosHotel/archivoReservasTEST.txt");
				}, "no debió funcionar: el archivo buscado NO existe");
			}
		
		@Test
		void test_controlador_dir_productos_menu() {
			Hotel hotel_test = new Hotel();
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	

			Assertions.assertThrows(java.io.FileNotFoundException.class, () -> {
				controladorPersistencia.cargarProductosMenuArchivo(hotel_test, "../baseDeDatosHotel/archivoMenuRestauranteTEST.txt");
				}, "no debió funcionar: el archivo buscado NO existe");
			}
		
		@Test
		void test_controlador_dir_servicios() {
			Hotel hotel_test = new Hotel();
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	

			Assertions.assertThrows(java.io.FileNotFoundException.class, () -> {
				controladorPersistencia.cargarServiciosArchivo(hotel_test, "../baseDeDatosHotel/archivoServiciosTEST.txt");
				}, "no debió funcionar: el archivo buscado NO existe");
			}
		
		///

}
