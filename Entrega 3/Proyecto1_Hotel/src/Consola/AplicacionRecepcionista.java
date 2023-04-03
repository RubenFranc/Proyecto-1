package Consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import Controlador.ControladorRecepcionista;
import Model.Habitacion;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.Reserva;

public class AplicacionRecepcionista {

	public void ejecutarAplicacionRecepcionista(Hotel hotel) throws IOException {
		boolean continuarEjecutando = true;
		ControladorRecepcionista controlador = new ControladorRecepcionista();
		while (continuarEjecutando) {
			mostrarMenuAplicacion("R");
			String opcionSeleccionadaR = input("\nPor favor seleccione una opción");
			if (opcionSeleccionadaR.equals("1")) {
				String fechaInicio = input("\nIngrese la fecha de inicio deseada para la reserva en el formato dd/MM");
				String fechaFinal = input("\nIngrese la fecha final deseada para la reserva en el formato dd/MM");
				String nombre = input("\nIngrese el nombre del titular de la reserva");
				String documento = input("\nIngrese el número de documento del titular de la reserva");
				String correo = input("\nIngrese el correo electrónico del titular de de la reserva");
				String celular = input("\nIngrese el número celular del titular la reserva");
				ArrayList<String> acompañantes = new ArrayList<>();
				acompañantes.add(nombre);
				boolean agregarAcompañante = true;
				while (agregarAcompañante) {
					mostrarMenuAplicacion("acomp");
					String opcionSeleccionada1 = input("\nPor favor seleccione una opción");
					if (opcionSeleccionada1.equals("1")) {
						String acompañante = input("\nPor favor ingrese el nombre del acompañante");
						acompañantes.add(acompañante);
					}
					else if (opcionSeleccionada1.equals("2")) {
						agregarAcompañante = false;
					}
					else { 
						System.out.println("\nIngrese una opcion válida\n");
					}
				}
				controlador.crearReserva(hotel, nombre, documento, correo, celular, fechaInicio, fechaFinal, acompañantes);	
				boolean agregarHabitacionAReserva = true;
				int indexReserva = 10000000;
				while (agregarHabitacionAReserva) {
					mostrarMenuAplicacion("hab");
					String opcionSeleccionada2 = input("\nPor favor seleccione una opción");
					if (opcionSeleccionada2.equals("1")) {
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
							try {
								HabitacionOcupada habOcup = controlador.ocuparHabitacion(hotel, fechaInicio, fechaFinal, tipo, documento);
								if (! habOcup.getId().equals("")){
									System.out.println("\nSe encontró una habitación: habitación " + habOcup.getId() + "\nCapacidad: " + habOcup.getCapacidad() + "\n");
									ArrayList<String> fechasEnRango = controlador.fechasEnRango(fechaInicio, fechaFinal);
									double tarifa = 0.0;
									double totalTarifa = 0.0;
									System.out.println("\nTarifa habitación por día:");
									for (String fecha: fechasEnRango) {
										if (hotel.getModificacionesHabitaciones().containsKey(habOcup.getTipoHabitacion())) {
											if (hotel.getModificacionesHabitaciones().get(habOcup.getTipoHabitacion()).containsKey(fecha)) {
												tarifa = hotel.getModificacionesHabitaciones().get(habOcup.getTipoHabitacion()).get(fecha);
											}
											else {
												tarifa = habOcup.getTarifa();
											}
										
										}
										else {
											tarifa = habOcup.getTarifa();
										}
										totalTarifa += tarifa;
										System.out.println(fecha + ": $" + tarifa);
									}
									System.out.println("\nTarifa total habitación: $" + totalTarifa);
									int last = hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).lastIndexOf(habOcup);
									boolean agregarOcupante = true;
									int cont = 0;
									while (agregarOcupante & cont < hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).get(last).getCapacidad()) {
										mostrarMenuAplicacion("ocup");
										String opcionSeleccionada3 = input("\nPor favor seleccione una opción");
										if (opcionSeleccionada3.equals("1") & acompañantes.size() > 0) {
											int n = 1;
											System.out.println("\nPersonas de la reserva sin habitación asignada:");
											for (String acomp: acompañantes) {
												System.out.println(n + "." + acomp);
												n++;
											}
											String num = input("\nPor favor seleccione una opción");
											String ocupante = acompañantes.get(Integer.parseInt(num) - 1);
											System.out.println(ocupante);
											hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).get(last).addOcupante(ocupante);
											cont++;
											acompañantes.remove(Integer.parseInt(num) - 1);
											if (acompañantes.size() == 0) {
												agregarOcupante = false;
												agregarHabitacionAReserva = false;
												System.out.println("\nReserva a nombre de " + nombre + " creada");
											}
										}
										else if (opcionSeleccionada3.equals("2") & hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).get(last).getOcupantes().size() > 0) {
											agregarOcupante = false;
										}
										else if (opcionSeleccionada3.equals("2") & hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).get(last).getOcupantes().size() == 0) {
											System.out.println("\nAsigne por lo menos un ocupante a la habitación\n");
										}
									}
									ArrayList<Reserva> reservasHuesped = hotel.getReservas().get(documento);
									if (indexReserva == 10000000) {
										for (int index = 0; index < reservasHuesped.size(); index++) {
											ArrayList<String> acomp = reservasHuesped.get(index).getHuesped().getAcompañantes();
											Collections.sort(acomp);
											if (reservasHuesped.get(index).getfechaInicio().equals(fechaInicio)) {// & acomp == acompañantes) {
												controlador.agregarHabitacionAReserva(hotel.getReservas().get(documento).get(index), hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).get(last));
												indexReserva = index;
												break;
											}
										}
									}
									else {
										if (reservasHuesped.get(indexReserva).getfechaInicio().equals(fechaInicio)) {// & acomp == acompañantes) {
											controlador.agregarHabitacionAReserva(hotel.getReservas().get(documento).get(indexReserva), hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).get(last));
										}
									}
									
								}
								else {
									System.out.println("\nNo hay habitaciones disponibles de ese tipo");
								}
							}
							catch (IndexOutOfBoundsException e) {
								System.out.println("\nNo hay habitaciones disponibles de ese tipo para el rango de fechas ingresado,\nse cruza con las fechas de otra reserva del hotel");
							}
						}
					}
					if (indexReserva != 10000000) {
						if (opcionSeleccionada2.equals("2") & acompañantes.size() == 0) {
							agregarHabitacionAReserva = false;
							System.out.println("\nReserva a nombre de " + nombre + " creada");
						}
						else if (opcionSeleccionada2.equals("2")) {
							System.out.println("\nAún faltan personas de la reserva por ser asignadas a una habitación");
						}
						else if (! opcionSeleccionada2.equals("1")){ 
							System.out.println("\nIngrese una opcion válida\n");
						}
					}
					else {
						System.out.println("\nAún no se agrega ninguna habitación a la reserva\n");
					}
				}
			}
			else if (opcionSeleccionadaR.equals("2")) {
				String fechaInicio = input("\nIngrese la fecha de inicio de la reserva en el formato dd/MM");
				String documento = input("\nIngrese el número de documento del titular de la reserva");
				ArrayList<Reserva> reservasHuesped = hotel.getReservas().get(documento);
				Reserva reserva = null;
				for (int index = 0; index < reservasHuesped.size(); index++) {
					if (reservasHuesped.get(index).getfechaInicio().equals(fechaInicio)) {// & acomp == acompañantes) {
						reserva = reservasHuesped.get(index);
						break;
					}
				}
				String facturaFinal = controlador.generarFacturaFinal(reserva, hotel);
				System.out.println(facturaFinal);
				for (HabitacionOcupada hab: reserva.getHabitacionesReserva()) {
					controlador.desocuparHabitaciones(hotel, hab);
				}
			}
			else if (opcionSeleccionadaR.equals("3")) {
				String documento = input("\nIngrese el número de documento del titular de la reserva");
				String fechaInicio = input("\nIngrese la fecha de inicio de la reserva en el formato dd/MM");
				String fechaFinal = input("\nIngrese la fecha final de la reserva en el formato dd/MM");
				String fechaActual = input("\nIngrese la fecha actual");
				String mssg = controlador.cancelarReserva(hotel, documento, fechaActual, fechaInicio, fechaFinal);
				System.out.println(mssg);
			}
			else if (opcionSeleccionadaR.equals("4")) {
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
			else if (opcionSeleccionadaR.equals("5")) {
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
			else if (opcionSeleccionadaR.equals("6")) {
				continuarEjecutando = false;
			}
			else { 
				System.out.println("\nIngrese una opcion válida\n");
			}
		}
	}
	
	public static void mostrarMenuAplicacion(String mssg) {
		System.out.println("\nOpciones:");
		if (mssg.equals("R")) {
			System.out.println("1. Crear reserva");
			System.out.println("2. Hacer check-out");
			System.out.println("3. Cancelar reserva");
			System.out.println("4. Consultar habitaciones disponibles");
			System.out.println("5. Consultar habitaciones ocupadas");
			System.out.println("6. Cerrar aplicación recepcionista");
		}
		else if (mssg.equals("acomp")) {
			System.out.println("1. Agregar nombre acompañante");
			System.out.println("2. Dejar de agregar acompañantes");
		}
		else if (mssg.equals("hab")) {
			System.out.println("1. Agregar habitación");
			System.out.println("2. Dejar de agregar habitaciones");
		}
		else if (mssg.equals("tipo")) {
			System.out.println("\nIngrese el tipo de habitación de interés:");
			System.out.println("\t1.Estándar");
			System.out.println("\t2.Suite");
			System.out.println("\t3.Suite doble");
		}
		else if (mssg.equals("ocup")) {
			System.out.println("1. Agregar ocupante");
			System.out.println("2. Dejar de agregar ocupantes");
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
