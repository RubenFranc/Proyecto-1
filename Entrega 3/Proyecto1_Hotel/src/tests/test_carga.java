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
import Model.Habitacion;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.ProductoMenu;
import Model.Servicio;
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
			//System.out.println(collection_test.size());
			Map<String, ArrayList<HabitacionOcupada>> valor = iterator.next();
			while (iterator.hasNext()) {
				//System.out.println(valor);
				Map<String, ArrayList<HabitacionOcupada>> valor2 = iterator.next();
			}
			ArrayList<HabitacionOcupada> list_hab_test = valor.get("15");
			HabitacionOcupada hab_test = list_hab_test.get(0);
			
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
			//System.out.println(collection_test.size());
			Map<String, ArrayList<HabitacionOcupada>> valor = iterator.next();
			while (iterator.hasNext()) {
				//System.out.println(valor);
				Map<String, ArrayList<HabitacionOcupada>> valor2 = iterator.next();
			}
			ArrayList<HabitacionOcupada> list_hab_test = valor.get("15");
			HabitacionOcupada hab_test = list_hab_test.get(0);
			
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
			//System.out.println(collection_test.size());
			Map<String, ArrayList<HabitacionOcupada>> valor = iterator.next();
			while (iterator.hasNext()) {
				//System.out.println(valor);
				Map<String, ArrayList<HabitacionOcupada>> valor2 = iterator.next();
			}
			ArrayList<HabitacionOcupada> list_hab_test = valor.get("15");
			HabitacionOcupada hab_test = list_hab_test.get(0);
			
			Assertions.assertEquals("12/09", hab_test.getFechaFinal());
		}
		
		/// Pruebas Cargar Habitacion Desocupada
		
		@Test
		void test_habitacion_1() throws IOException {
			Hotel hotel_test = new Hotel();
			
			String linea1 = "17;sd;2,true,true,true,27.0,true,true,g,true,true,true,true,220.0,true,true,true;70000.0;false";
			String linea2 = "16;s;2,true,true,true,27.0,true,true,g,true,true,true,true,220.0,true,true,true;40000.0;false";
			
			/// Prueba
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
			controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
			Collection<Map<String, Habitacion>> collection_test = hotel_test.getHabitacionesDisponiblesHotel().values();
			java.util.Iterator<Map<String, Habitacion>>  iterator = collection_test.iterator();
			//System.out.println(collection_test.size());
			Map<String, Habitacion> valor = iterator.next();
			while (iterator.hasNext()) {
				//System.out.println(valor);
				Map<String, Habitacion> valor2 = iterator.next();
			}
			Habitacion hab_test = valor.get("17");
			//System.out.print(valor);
			
			Assertions.assertEquals(70000.0, hab_test.getTarifa());
		}
		
		@Test
		void test_habitacion_2() throws IOException {
			Hotel hotel_test = new Hotel();
			
			String linea1 = "17;sd;2,true,true,true,27.0,true,true,g,true,true,true,true,220.0,true,true,true;70000.0;false";
			String linea2 = "16;s;2,true,true,true,27.0,true,true,g,true,true,true,true,220.0,true,true,true;40000.0;false";
			
			/// Prueba
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
			controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
			Collection<Map<String, Habitacion>> collection_test = hotel_test.getHabitacionesDisponiblesHotel().values();
			java.util.Iterator<Map<String, Habitacion>>  iterator = collection_test.iterator();
			//System.out.println(collection_test.size());
			Map<String, Habitacion> valor = iterator.next();
			while (iterator.hasNext()) {
				//System.out.println(valor);
				Map<String, Habitacion> valor2 = iterator.next();
			}
			//System.out.print(valor);
			Habitacion hab_test = valor.get("17");
			
			
			Assertions.assertEquals("sd", hab_test.getTipoHabitacion());
		}
		
		@Test
		void test_habitacion_3() throws IOException {
			Hotel hotel_test = new Hotel();
			
			String linea1 = "17;sd;2,true,true,true,27.0,true,true,g,true,true,true,true,220.0,true,true,true;70000.0;false";
			String linea2 = "16;s;2,true,true,true,27.0,true,true,g,true,true,true,true,220.0,true,true,true;40000.0;false";
			
			/// Prueba
			ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
			controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
			Collection<Map<String, Habitacion>> collection_test = hotel_test.getHabitacionesDisponiblesHotel().values();
			java.util.Iterator<Map<String, Habitacion>>  iterator = collection_test.iterator();
			//System.out.println(collection_test.size());
			Map<String, Habitacion> valor = iterator.next();
			while (iterator.hasNext()) {
				//System.out.println(valor);
				Map<String, Habitacion> valor2 = iterator.next();
			}
			//System.out.print(valor);
			Habitacion hab_test = valor.get("17");
			
			
			Assertions.assertEquals("2,true,true,true,27.0,true,true,g,true,true,true,true,220.0,true,true,true", hab_test.getPropiedades());
		}
		
		/// Pruebas Cargar Menu
		
				@Test
				void test_menu_1() throws IOException {
					Hotel hotel_test = new Hotel();
					
					String linea1 = "desayuno;9000.0;1000 cal;true;230;1030";
					String linea2 = "gaseosa;5500.0;800 cal;false;1000;1200";
					
					/// Prueba
					ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
					controladorPersistencia.cargarProductosMenuArchivo(hotel_test, "../baseDeDatosHotel/archivoMenuRestaurante.txt");
					Collection<ProductoMenu> collection_test = hotel_test.getMenuHotel().values();
					java.util.Iterator<ProductoMenu>  iterator = collection_test.iterator();
					//System.out.println(collection_test.size());
					ProductoMenu valor = iterator.next();
					//System.out.print(valor);
					
					Assertions.assertEquals(9000.0, valor.getPrecio());
				}
				
				@Test
				void test_menu_2() throws IOException {
					Hotel hotel_test = new Hotel();
					
					String linea1 = "desayuno;9000.0;1000 cal;true;230;1030";
					String linea2 = "gaseosa;5500.0;800 cal;false;1000;1200";
					
					/// Prueba
					ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
					controladorPersistencia.cargarProductosMenuArchivo(hotel_test, "../baseDeDatosHotel/archivoMenuRestaurante.txt");
					Collection<ProductoMenu> collection_test = hotel_test.getMenuHotel().values();
					java.util.Iterator<ProductoMenu>  iterator = collection_test.iterator();
					//System.out.println(collection_test.size());
					ProductoMenu valor = iterator.next();
					//System.out.print(valor);
					
					Assertions.assertEquals(230, valor.getHoraInicioDisponibilidad());
				}
				
				@Test
				void test_menu_3() throws IOException {
					Hotel hotel_test = new Hotel();
					
					String linea1 = "desayuno;9000.0;1000 cal;true;230;1030";
					String linea2 = "gaseosa;5500.0;800 cal;false;1000;1200";
					
					/// Prueba
					ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
					controladorPersistencia.cargarProductosMenuArchivo(hotel_test, "../baseDeDatosHotel/archivoMenuRestaurante.txt");
					Collection<ProductoMenu> collection_test = hotel_test.getMenuHotel().values();
					java.util.Iterator<ProductoMenu>  iterator = collection_test.iterator();
					//System.out.println(collection_test.size());
					ProductoMenu valor = iterator.next();
					//System.out.print(valor);
					
					Assertions.assertEquals(1030, valor.getHoraFinDisponibilidad());
				}
				
				/// Pruebas Cargar Servicios
				
				@Test
				void test_servicios_1() throws IOException {
					Hotel hotel_test = new Hotel();
					
					String linea1 = "spa;14000.0;false;descripcionSpa";
					String linea2 = "guia turistica;45000.0;true;descripcionGuiaTuristica";
					
					/// Prueba
					ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
					controladorPersistencia.cargarServiciosArchivo(hotel_test, "../baseDeDatosHotel/archivoServicios.txt");
					Collection<Servicio> collection_test = hotel_test.getServiciosHotel().values();
					java.util.Iterator<Servicio>  iterator = collection_test.iterator();
					//System.out.println(collection_test.size());
					Servicio valor = iterator.next();
					//System.out.print(valor);
					
					Assertions.assertEquals(14000.0, valor.getPrecio());
				}

				@Test
				void test_servicios_2() throws IOException {
					Hotel hotel_test = new Hotel();
					
					String linea1 = "spa;14000.0;false;descripcionSpa";
					String linea2 = "guia turistica;45000.0;true;descripcionGuiaTuristica";
					
					/// Prueba
					ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
					controladorPersistencia.cargarServiciosArchivo(hotel_test, "../baseDeDatosHotel/archivoServicios.txt");
					Collection<Servicio> collection_test = hotel_test.getServiciosHotel().values();
					java.util.Iterator<Servicio>  iterator = collection_test.iterator();
					//System.out.println(collection_test.size());
					Servicio valor = iterator.next();
					//System.out.print(valor);
					
					Assertions.assertEquals("descripcionSpa", valor.getDescripcion());
				}
				
				@Test
				void test_servicios_3() throws IOException {
					Hotel hotel_test = new Hotel();
					
					String linea1 = "spa;14000.0;false;descripcionSpa";
					String linea2 = "guia turistica;45000.0;true;descripcionGuiaTuristica";
					
					/// Prueba
					ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
					controladorPersistencia.cargarServiciosArchivo(hotel_test, "../baseDeDatosHotel/archivoServicios.txt");
					Collection<Servicio> collection_test = hotel_test.getServiciosHotel().values();
					java.util.Iterator<Servicio>  iterator = collection_test.iterator();
					//System.out.println(collection_test.size());
					Servicio valor = iterator.next();
					//System.out.print(valor);
					
					Assertions.assertEquals("spa", valor.getNombre());
				}
				
				@Test
				void test_servicios_4() throws IOException {
					Hotel hotel_test = new Hotel();
					
					String linea1 = "spa;14000.0;false;descripcionSpa";
					String linea2 = "guia turistica;45000.0;true;descripcionGuiaTuristica";
					
					/// Prueba
					ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
					controladorPersistencia.cargarServiciosArchivo(hotel_test, "../baseDeDatosHotel/archivoServicios.txt");
					Collection<Servicio> collection_test = hotel_test.getServiciosHotel().values();
					java.util.Iterator<Servicio>  iterator = collection_test.iterator();
					//System.out.println(collection_test.size());
					Servicio valor = iterator.next();
					//System.out.print(valor);
					
					Assertions.assertEquals(false, valor.getEnGrupo());
				}
}
