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
import Controlador.ControladorRecepcionista;
import Model.Habitacion;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.ProductoMenu;
import Model.Reserva;
import Model.Servicio;
import Model.TarjetaPago;
import Model.Usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class test_reservas {

	@Before
	void setUp() {
		
		}
	
	@After
	void tearDown() {
		
	}
	
	// Reservas Predeterminadas

	
	@Test
	void test_reservas_1() throws IOException {
		Hotel hotel_test = new Hotel();		
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
		controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");

		controladorPersistencia.cargarReservas(hotel_test, "../baseDeDatosHotel/archivoReservas.txt");
		
		//1002031703;09/09;12/09;Ruben;fgdsfds;23432;;e-15;false
		
		Collection<ArrayList<Reserva>> collection_test = hotel_test.getReservas().values();
		java.util.Iterator<ArrayList<Reserva>>  iterator = collection_test.iterator();
		ArrayList<Reserva> valor = iterator.next();
		Reserva reserva_test = valor.get(0);
		System.out.print(reserva_test.getHabitacionesReserva().get(0).getId());
		
		Assertions.assertEquals("15", reserva_test.getHabitacionesReserva().get(0).getId());
		}
	
	@Test
	void test_reservas_2() throws IOException {
		Hotel hotel_test = new Hotel();		
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
		controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");

		controladorPersistencia.cargarReservas(hotel_test, "../baseDeDatosHotel/archivoReservas.txt");
		
		//1002031703;09/09;12/09;Ruben;fgdsfds;23432;;e-15;false
		
		Collection<ArrayList<Reserva>> collection_test = hotel_test.getReservas().values();
		java.util.Iterator<ArrayList<Reserva>>  iterator = collection_test.iterator();
		ArrayList<Reserva> valor = iterator.next();
		Reserva reserva_test = valor.get(0);
		///
		
		Collection<Map<String, ArrayList<HabitacionOcupada>>> collection_hab = hotel_test.getHabitacionesOcupadasHotel().values();
		java.util.Iterator<Map<String, ArrayList<HabitacionOcupada>>>  iterator_hab = collection_hab.iterator();
		//System.out.println(collection_test.size());
		Map<String, ArrayList<HabitacionOcupada>> valor_hab = iterator_hab.next();
		ArrayList<HabitacionOcupada> list_hab_test = valor_hab.get("15");
		HabitacionOcupada hab_test = list_hab_test.get(0);
		
		///
		reserva_test.addHabitacionReserva(hab_test);
		ArrayList<HabitacionOcupada> array_hab_test = new ArrayList<HabitacionOcupada>();
		array_hab_test.add(hab_test);
		
		Assertions.assertEquals("1002031703", reserva_test.getHabitacionesReserva().get(0).getDocumentoHuesped());
		}
	
	@Test
	void test_reservas_3() throws IOException {
		Hotel hotel_test = new Hotel();		
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
		controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");

		controladorPersistencia.cargarReservas(hotel_test, "../baseDeDatosHotel/archivoReservas.txt");
		
		//1002031703;09/09;12/09;Ruben;fgdsfds;23432;;e-15;false
		
		Collection<ArrayList<Reserva>> collection_test = hotel_test.getReservas().values();
		java.util.Iterator<ArrayList<Reserva>>  iterator = collection_test.iterator();
		ArrayList<Reserva> valor = iterator.next();
		Reserva reserva_test = valor.get(0);
		///
		
		Collection<Map<String, ArrayList<HabitacionOcupada>>> collection_hab = hotel_test.getHabitacionesOcupadasHotel().values();
		java.util.Iterator<Map<String, ArrayList<HabitacionOcupada>>>  iterator_hab = collection_hab.iterator();
		//System.out.println(collection_test.size());
		Map<String, ArrayList<HabitacionOcupada>> valor_hab = iterator_hab.next();
		ArrayList<HabitacionOcupada> list_hab_test = valor_hab.get("15");
		HabitacionOcupada hab_test = list_hab_test.get(0);
		
		///
		reserva_test.addHabitacionReserva(hab_test);
		ArrayList<HabitacionOcupada> array_hab_test = new ArrayList<HabitacionOcupada>();
		array_hab_test.add(hab_test);
		
		Assertions.assertEquals("09/09", reserva_test.getHabitacionesReserva().get(0).getFechaInicio());
		}
	
	@Test
	void test_reservas_4() throws IOException {
		Hotel hotel_test = new Hotel();		
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
		controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");

		controladorPersistencia.cargarReservas(hotel_test, "../baseDeDatosHotel/archivoReservas.txt");
		
		//1002031703;09/09;12/09;Ruben;fgdsfds;23432;;e-15;false
		
		Collection<ArrayList<Reserva>> collection_test = hotel_test.getReservas().values();
		java.util.Iterator<ArrayList<Reserva>>  iterator = collection_test.iterator();
		ArrayList<Reserva> valor = iterator.next();
		Reserva reserva_test = valor.get(0);
		///
		
		Collection<Map<String, ArrayList<HabitacionOcupada>>> collection_hab = hotel_test.getHabitacionesOcupadasHotel().values();
		java.util.Iterator<Map<String, ArrayList<HabitacionOcupada>>>  iterator_hab = collection_hab.iterator();
		//System.out.println(collection_test.size());
		Map<String, ArrayList<HabitacionOcupada>> valor_hab = iterator_hab.next();
		ArrayList<HabitacionOcupada> list_hab_test = valor_hab.get("15");
		HabitacionOcupada hab_test = list_hab_test.get(0);
		
		///
		reserva_test.addHabitacionReserva(hab_test);
		ArrayList<HabitacionOcupada> array_hab_test = new ArrayList<HabitacionOcupada>();
		array_hab_test.add(hab_test);
		
		Assertions.assertEquals("12/09", reserva_test.getHabitacionesReserva().get(0).getFechaFinal());
		}
	
	/// Nuevas reservas
	@Test
	void test_reservas_crear_1() throws IOException {
		Hotel hotel_test = new Hotel();		
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
		controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");
		
		ControladorRecepcionista contRecep = new ControladorRecepcionista();
		TarjetaPago tarj = new TarjetaPago(123456789,"9999999999","1234");
		contRecep.crearReserva(hotel_test, "Mario", "1000471000", null, null, "03/06", "07/06", null, true, tarj);
		
		Collection<ArrayList<Reserva>> collection_test = hotel_test.getReservas().values();
		java.util.Iterator<ArrayList<Reserva>>  iterator = collection_test.iterator();
		ArrayList<Reserva> valor = iterator.next();
		Reserva reserva_test = valor.get(0);
		
		Assertions.assertEquals("Mario", reserva_test.getHuesped().getnombre());
		}
	
	@Test
	void test_reservas_crear_2() throws IOException {
		Hotel hotel_test = new Hotel();		
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
		controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");
		
		ControladorRecepcionista contRecep = new ControladorRecepcionista();
		TarjetaPago tarj = new TarjetaPago(123456789,"9999999999","1234");
		contRecep.crearReserva(hotel_test, "Mario", "1000471000", null, null, "03/06", "07/06", null, true, tarj);
		
		Collection<ArrayList<Reserva>> collection_test = hotel_test.getReservas().values();
		java.util.Iterator<ArrayList<Reserva>>  iterator = collection_test.iterator();
		ArrayList<Reserva> valor = iterator.next();
		Reserva reserva_test = valor.get(0);
		
		Assertions.assertEquals("03/06", reserva_test.getfechaInicio());
		}
	
	@Test
	void test_reservas_crear_3() throws IOException {
		Hotel hotel_test = new Hotel();		
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
		controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");
		
		ControladorRecepcionista contRecep = new ControladorRecepcionista();
		TarjetaPago tarj = new TarjetaPago(123456789,"9999999999","1234");
		contRecep.crearReserva(hotel_test, "Mario", "1000471000", null, null, "03/06", "07/06", null, true, tarj);
		
		Collection<ArrayList<Reserva>> collection_test = hotel_test.getReservas().values();
		java.util.Iterator<ArrayList<Reserva>>  iterator = collection_test.iterator();
		ArrayList<Reserva> valor = iterator.next();
		Reserva reserva_test = valor.get(0);
		
		Assertions.assertEquals("07/06", reserva_test.getfechaFinal());
		}
	
	@Test
	void test_reservas_crear_4() throws IOException {
		Hotel hotel_test = new Hotel();		
		ControladorPersistencia controladorPersistencia= new ControladorPersistencia();	
		controladorPersistencia.cargarHabitacionesOcupadas(hotel_test, "../baseDeDatosHotel/archivoHabitacionesOcupadas.txt");
		controladorPersistencia.cargarHabitacionesDisponibles(hotel_test, "../baseDeDatosHotel/archivoHabitaciones.txt");
		controladorPersistencia.cargarModificacionesTarifasHabitaciones(hotel_test, "../baseDeDatosHotel/archivoModificacionesTarifaHabitaciones.txt");
		
		ControladorRecepcionista contRecep = new ControladorRecepcionista();
		TarjetaPago tarj = new TarjetaPago(123456789,"9999999999","1234");
		contRecep.crearReserva(hotel_test, "Mario", "1000471000", null, null, "03/06", "07/06", null, true, tarj);
		
		Collection<ArrayList<Reserva>> collection_test = hotel_test.getReservas().values();
		java.util.Iterator<ArrayList<Reserva>>  iterator = collection_test.iterator();
		ArrayList<Reserva> valor = iterator.next();
		Reserva reserva_test = valor.get(0);
		
		Assertions.assertEquals("1000471000", reserva_test.getHuesped().getDocumento());
		}
	
}
