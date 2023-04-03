package Consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import Controlador.ControladorEmpleado;
import Model.Habitacion;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.ProductoMenu;
import Model.Servicio;

public class AplicacionEmpleado {
	
	public void ejecutarAplicacionEmpleado(Hotel hotel) throws IOException {
		boolean continuarEjecutando = true;
		ControladorEmpleado controlador = new ControladorEmpleado();
		while (continuarEjecutando) {
			mostrarMenuAplicacion("E");
			String opcionSeleccionadaE = input("\nPor favor seleccione una opción");
			if (opcionSeleccionadaE.equals("1")) {
				String id = input("\nIngrese el id de la habitación");
				String documento = input("\nIngrese el documento del titular de la reserva");
				boolean cargarALaCuenta = Boolean.parseBoolean(input("\nDigite true si el servicio se cargará a la cuenta, false de lo contrario"));
				String fechaActual = input("\nIngrese la fecha actual");
				String nombre = input("\nIngrese el nombre del servicio");
				String factura = controlador.registrarServicio(hotel, id, documento, cargarALaCuenta, nombre, fechaActual);
				System.out.println(factura);
				
			}
			else if (opcionSeleccionadaE.equals("2")) {
				String id = input("\nIngrese el id de la habitación");
				String documento = input("\nIngrese el documento del titular de la reserva");
				boolean cargarALaCuenta = Boolean.parseBoolean(input("\nDigite true si el servicio se cargará a la cuenta, false de lo contrario"));
				String fechaActual = input("\nIngrese la fecha actual en el formato dd/MM");
				int horaActual = Integer.parseInt(input("\nIngrese la hora actual en formato 24h (HHmm)"));
				ArrayList<String> productos = new ArrayList<>();
				boolean agregarProducto = true;
				while (agregarProducto) {
					mostrarMenuAplicacion("prod");
					String opcionSeleccionada6 = input("\nPor favor seleccione una opción");
					if (opcionSeleccionada6.equals("1")) {
						String nombreProducto = input("\nIngrese el nombre del producto");
						if (hotel.getMenuHotel().containsKey(nombreProducto)) {
							productos.add(nombreProducto);	
						}
						else {
							System.out.println("\nEl producto " + nombreProducto + "no se encuentra en el menú");
						}
					}
					else {
						agregarProducto = false;
					}
				}
				String factura = controlador.registrarConsumoRestaurante(hotel, id, documento, cargarALaCuenta, productos, fechaActual, horaActual);
				System.out.println(factura);
			}
			else if (opcionSeleccionadaE.equals("3")) {
				Map<String, Map<String, Habitacion>> habitacionesDisponibles = controlador.consultarHabitacionesDisponibles(hotel);
				Set<String> tipos = habitacionesDisponibles.keySet(); 
				for (String tipo: tipos) {
					if (tipo.equals("e")) {
						System.out.println("\n*Estándar:");
					}
					else if (tipo.equals("s")) {
						System.out.println("\n*Suites:");
					}
					else if (tipo.equals("sd")) {
						System.out.println("\n*Suites dobles:");
					}
					Set<String> habitacionesTipo = habitacionesDisponibles.get(tipo).keySet();
					for (String id: habitacionesTipo) {
						Habitacion habitacion =  habitacionesDisponibles.get(tipo).get(id);
						System.out.println("    -Habitación " + id + ":");
						System.out.println("       Capacidad: " + habitacion.getCapacidad());
						System.out.println("       Con balcón: " + habitacion.hasBalcon());
						System.out.println("       Con ventana: " + habitacion.hasVentana());
						System.out.println("       Con cocina: " + habitacion.hasCocina());
					}
				}
			}

			else if (opcionSeleccionadaE.equals("4")) {
				Map<String, Map<String, ArrayList<HabitacionOcupada>>> habitacionesOcupadas = controlador.consultarHabitacionesOcupadas(hotel);
				Set<String> tipos = habitacionesOcupadas.keySet(); 
				for (String tipo: tipos) {
					if (tipo.equals("e")) {
						System.out.println("\n*Estándar:");
					}
					else if (tipo.equals("s")) {
						System.out.println("\n*Suites:");
					}
					else if (tipo.equals("sd")) {
						System.out.println("\n*Suites dobles:");
					}
					Set<String> habitacionesTipo = habitacionesOcupadas.get(tipo).keySet();
					for (String id: habitacionesTipo) {
						for (HabitacionOcupada hab: habitacionesOcupadas.get(tipo).get(id)) {
							System.out.println("    -Habitación " + id + ": " + hab.getFechaInicio() + " - " + hab.getFechaFinal());
							System.out.println("       Ocupantes: " + hab.getOcupantes());
							System.out.println("       Capacidad: " + hab.getCapacidad());
							System.out.println("       Con balcón: " + hab.hasBalcon());
							System.out.println("       Con ventana: " + hab.hasVentana());
							System.out.println("       Con cocina: " + hab.hasCocina());
						}
					}
				}
			}
			else if (opcionSeleccionadaE.equals("5")) {
				Map<String, Servicio> servicios = controlador.consultarServicios(hotel);
				for (String nomb: servicios.keySet()) {
					Servicio servicio = servicios.get(nomb);
					System.out.println("    -" + nomb + ":");
					System.out.println("       Precio: $" + servicio.getPrecio());
					System.out.println("       Descripción: " + servicio.getDescripcion());
					}
				}
			
			else if (opcionSeleccionadaE.equals("6")) {
				Map<String, ProductoMenu> prods = controlador.consultarProductosMenu(hotel);
				for (String nomb: prods.keySet()) {
					ProductoMenu prod = prods.get(nomb);
					System.out.println("    -" + nomb + ":");
					System.out.println("       Precio: $" + prod.getPrecio());
					System.out.println("       Descripción: " + prod.getDescripcion());
					System.out.println("       Servicio a cuarto: " + prod.getServicioACuarto());
					System.out.println("       Disponibilidad horaria: " + prod.getHoraInicioDisponibilidad() + "h -> " + prod.getHoraFinDisponibilidad() + "h");
					}
				}
			else if (opcionSeleccionadaE.equals("7")) {
				continuarEjecutando = false;
			}
		}
	}
	
	public static void mostrarMenuAplicacion(String mssg) {
		System.out.println("\nOpciones:");
		if (mssg.equals("E")) {
			System.out.println("1. Registrar servicio");
			System.out.println("2. Registrar consumo en restaurante");
			System.out.println("3. Consultar habitaciones disponibles");
			System.out.println("4. Consultar habitaciones ocupadas");
			System.out.println("5. Consultar servicios del hotel");
			System.out.println("6. Consultar productos del menú");
			System.out.println("7. Cerrar aplicación empleado");
		}
		else if (mssg.equals("prod")) {
			System.out.println("1. Agregar producto");
			System.out.println("2. Dejar de agregar productos");
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
