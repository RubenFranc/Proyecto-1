package Consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Controlador.ControladorAdministrador;
import Model.Hotel;

public class AplicacionAdministrador {
	
	public void ejecutarAplicacionAdministrador(Hotel hotel) throws IOException {
		boolean continuarEjecutandoA = true;
		ControladorAdministrador controlador = new ControladorAdministrador();
		while (continuarEjecutandoA) {
			mostrarMenuAplicacion("A");
			String opcionSeleccionadaA = input("\nPor favor seleccione una opción");
			if (opcionSeleccionadaA.equals("1")) {
				System.out.println("\nCargando habitaciones...");
				controlador.cargarHabitacionesArchivo("../baseDeDatosHotel/archivoHabitaciones.txt", hotel);
				System.out.println("Habitaciones cargadas con éxito\n");
			}
			else if (opcionSeleccionadaA.equals("2")) {
				String id = input("\nIngrese el id de la nueva habitación");
				mostrarMenuAplicacion("tipo");
				String tipoHabitacion = input("\nDigite el número de la opción");
				String tipo = "";
				if (tipoHabitacion.equals("1")) {
					tipo = "e";
				}
				else if (tipoHabitacion.equals("2")) {
					tipo = "s";
				}
				else if (tipoHabitacion.equals("3")) {
					tipo = "sd";
				}
				int capacidad = Integer.parseInt(input("\nIngrese la capacidad de la nueva habitación"));
				boolean balcon = Boolean.parseBoolean(input("\nDigite true si la habitación tendrá balcón, false de lo contrario"));
				boolean cocina = Boolean.parseBoolean(input("\nDigite true si la habitación tendrá cocina, false de lo contrario"));
				boolean ventana = Boolean.parseBoolean(input("\nDigite true si la habitación tendrá ventana, false de lo contrario"));
				double tarifa = Double.parseDouble(input("\nIngrese la tarifa de la nueva habitación"));
				controlador.crearHabitacion(id, tipo, capacidad, balcon, cocina, ventana, tarifa, true, hotel);
				System.out.println("\nHabitacion creada con éxito\n");
			}
			else if (opcionSeleccionadaA.equals("3")) {
				System.out.println("\nCargando menú del restaurante...");
				controlador.cargarProductosMenuArchivo("../baseDeDatosHotel/archivoMenuRestaurante.txt", hotel);
				System.out.println("Menú cargado con éxito\n");
			}
			else if (opcionSeleccionadaA.equals("4")) {
				System.out.println("\nCargando servicios...");
				controlador.cargarServiciosArchivo("../baseDeDatosHotel/archivoServicios.txt", hotel);
				System.out.println("Servicios cargados con éxito\n");
			}
			else if (opcionSeleccionadaA.equals("5")) {
				mostrarMenuAplicacion("tipo");
				String tipoHabitacion = input("\nDigite el número de la opción");
				String tipo = "";
				if (tipoHabitacion.equals("1")) {
					tipo = "e";
				}
				else if (tipoHabitacion.equals("2")) {
					tipo = "s";
				}
				else if (tipoHabitacion.equals("3")) {
					tipo = "sd";
				}
				else {
					System.out.println("\nIngrese una opción válida");
				}
				if (tipo.equals("e") || tipo.equals("s") || tipo.equals("sd")) {
					double nuevaTarifa = Double.parseDouble(input("\nIngrese la nueva tarifa del tipo de habitación"));
					String fechaInicio = input("\nIngrese la fecha de inicio de la nueva tarifa en el formato dd/MM");
					String fechaFinal = input("\nIngrese la fecha final de la nueva tarifa en el formato dd/MM");
					controlador.asignarTarifasHabitaciones(tipo, fechaInicio, fechaFinal, nuevaTarifa, hotel);
				}
			}
			else if (opcionSeleccionadaA.equals("6")) {
				String nombre = input("\nIngrese el nombre del servicio");
				double nuevoPrecio = Double.parseDouble(input("\nIngrese el nuevo precio del servicio"));
				String mssg = controlador.cambiarTarifaServicio(nombre, nuevoPrecio, hotel);
				System.out.println(mssg);
			}
			else if (opcionSeleccionadaA.equals("7")) {
				String nombre = input("\nIngrese el nombre del producto");
				double nuevoPrecio = Double.parseDouble(input("\nIngrese el nuevo precio del producto"));
				boolean servicioACuarto = Boolean.parseBoolean(input("\nDigite true si el producto tendrá servicio a cuarto, false de lo contrario"));
				int horaInicio = Integer.parseInt(input("\nIngrese la hora inicial de la disponibiliad del producto en formato 24h (HHmm)"));
				int horaFinal = Integer.parseInt(input("\nIngrese la hora final de la disponibiliad del producto en formato 24h (HHmm)"));
				String mssg = controlador.cambiarInfoProductoRestaurante(nombre, nuevoPrecio, servicioACuarto, horaInicio, horaFinal, hotel);
				System.out.println(mssg);
			}
			else if (opcionSeleccionadaA.equals("8")) {
				continuarEjecutandoA = false;
			}
			else {
				System.out.println("\nIngrese una opcion válida\n");
			}
		}
	}

	public static void mostrarMenuAplicacion(String mssg) {
		System.out.println("\nOpciones:");
		if (mssg.equals("A")) {
			System.out.println("1. Cargar habitaciones");
			System.out.println("2. Crear habitación");
			System.out.println("3. Cargar productos del menú");
			System.out.println("4. Cargar servicios del hotel");
			System.out.println("5. Asignar tarifa por tipo de habitación en rango de fechas");
			System.out.println("6. Cambiar tarifa de un servicio");
			System.out.println("7. Cambiar información de un plato/bebida del menú");
			System.out.println("8. Cerrar aplicación administrador");
		}
		else if (mssg.equals("tipo")) {
			System.out.println("\nIngrese el tipo de habitación de interés:");
			System.out.println("\t1.Estándar");
			System.out.println("\t2.Suite");
			System.out.println("\t3.Suite doble");
		}
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
	
}
