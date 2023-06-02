package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import Consola.AplicacionPrincipal;
import Controlador.ControladorAdministrador;
import Controlador.ControladorPersistencia;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.Usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class test_carga {
	
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
		
		/// Pruebas Cargar Habitacion Ocupada
		
		@Test
		void test_ocupada_1() throws IOException {
			Hotel hotel_test = new Hotel();
			
			String linea = "e;2,true,ture,true,27.0,true,true,g,true,true,true,true,220.0,true,true,true;30000.0;15;false;09/09;12/09;Ruben;1002031703;0.0";
			
			/// Prueba
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
			controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
			Collection<Map<String, ArrayList<HabitacionOcupada>>> collection_test = hotel_test.getHabitacionesOcupadasHotel().values();
			java.util.Iterator<Map<String, ArrayList<HabitacionOcupada>>>  iterator = collection_test.iterator();
			System.out.println(collection_test.size());
			Map<String, ArrayList<HabitacionOcupada>> valor = iterator.next();
			while (iterator.hasNext()) {
				//System.out.println(valor);
				Map<String, ArrayList<HabitacionOcupada>> valor2 = iterator.next();
			}
			ArrayList<HabitacionOcupada> list_hab_test = valor.get("15");
			HabitacionOcupada hab_test = list_hab_test.get(0);
			//System.out.print(hab_test);
			//ArrayList<HabitacionOcupada> test = hotel_test.getHabitacionesOcupadasHotel().get("15").get("15");
			//System.out.print(test);
			
			Assertions.assertEquals("1002031703", hab_test.getDocumentoHuesped());
		}
		
		void test_ocupada_2() throws IOException {
			Hotel hotel_test = new Hotel();
			
			String linea = "e;2,true,ture,true,27.0,true,true,g,true,true,true,true,220.0,true,true,true;30000.0;15;false;09/09;12/09;Ruben;1002031703;0.0";
			
			/// Prueba
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
			controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
			Collection<Map<String, ArrayList<HabitacionOcupada>>> collection_test = hotel_test.getHabitacionesOcupadasHotel().values();
			java.util.Iterator<Map<String, ArrayList<HabitacionOcupada>>>  iterator = collection_test.iterator();
			System.out.println(collection_test.size());
			Map<String, ArrayList<HabitacionOcupada>> valor = iterator.next();
			while (iterator.hasNext()) {
				//System.out.println(valor);
				Map<String, ArrayList<HabitacionOcupada>> valor2 = iterator.next();
			}
			ArrayList<HabitacionOcupada> list_hab_test = valor.get("15");
			HabitacionOcupada hab_test = list_hab_test.get(0);
			//System.out.print(hab_test);
			//ArrayList<HabitacionOcupada> test = hotel_test.getHabitacionesOcupadasHotel().get("15").get("15");
			//System.out.print(test);
			
			Assertions.assertEquals("09/09", hab_test.getFechaInicio());
		}
		
		void test_ocupada_3() throws IOException {
			Hotel hotel_test = new Hotel();
			
			String linea = "e;2,true,ture,true,27.0,true,true,g,true,true,true,true,220.0,true,true,true;30000.0;15;false;09/09;12/09;Ruben;1002031703;0.0";
			
			/// Prueba
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
			controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
			Collection<Map<String, ArrayList<HabitacionOcupada>>> collection_test = hotel_test.getHabitacionesOcupadasHotel().values();
			java.util.Iterator<Map<String, ArrayList<HabitacionOcupada>>>  iterator = collection_test.iterator();
			System.out.println(collection_test.size());
			Map<String, ArrayList<HabitacionOcupada>> valor = iterator.next();
			while (iterator.hasNext()) {
				//System.out.println(valor);
				Map<String, ArrayList<HabitacionOcupada>> valor2 = iterator.next();
			}
			ArrayList<HabitacionOcupada> list_hab_test = valor.get("15");
			HabitacionOcupada hab_test = list_hab_test.get(0);
			//System.out.print(hab_test);
			//ArrayList<HabitacionOcupada> test = hotel_test.getHabitacionesOcupadasHotel().get("15").get("15");
			//System.out.print(test);
			
			Assertions.assertEquals("12/09", hab_test.getFechaFinal());
		}

}
