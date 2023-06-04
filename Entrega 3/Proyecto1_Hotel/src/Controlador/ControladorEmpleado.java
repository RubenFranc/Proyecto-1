package Controlador;

import java.util.ArrayList;
import java.util.Map;

import Model.Habitacion;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.ProductoMenu;
import Model.Reserva;
import Model.Servicio;

public class ControladorEmpleado {
	
	public String fechaADias(String fecha) {
		String[] partes = fecha.split("/");
		int dia = Integer.parseInt(partes[0]);
		int mes = Integer.parseInt(partes[1]);
		int fechaADias = dia + mes*30;
		return Integer.toString(fechaADias);
	}
	
	public HabitacionOcupada buscarHabitacionPorId(Hotel hotel, double precioServicio, String idHabitacion, 
			boolean cargarALaCuenta, String documentoHuesped, String fechaActual) {
//		ArrayList<HabitacionOcupada> habsOcup= hotel.getHabitacionesOcupadasHotel().get(tipoHabitacion).get(idHabitacion);
//		Reserva reserva = null;
//		String documentoHuesped = null;
//		for (HabitacionOcupada habOcup: habsOcup) {
//			System.out.println(habOcup.getFechaInicio());
//			System.out.println(habOcup.getFechaFinal());
//			System.out.println(fechaActual);
//			if (habOcup.getFechaInicio().compareTo(fechaActual) >= 0 & habOcup.getFechaFinal().compareTo(fechaActual) <= 0) {
//				System.out.println("EUREKA");
//				ArrayList<Reserva> reservas = hotel.getReservas().get(documentoHuesped);
//				for (Reserva reserv: reservas) {
//					System.out.println(reserv.getfechaInicio());
//					if (reserv.getfechaInicio().compareTo(fechaActual) >= 0 & reserv.getfechaFinal().compareTo(fechaActual) <= 0){
//						reserva = reserv;
//						hotel.getReservas().get(documentoHuesped).remove(reserv);
//						System.out.println(reserva.getHuesped().getnombre());
//					}
//				}
//			}
//		}
		ArrayList<Reserva> reservasHuesped = hotel.getReservas().get(documentoHuesped);
		Reserva reserva = null;
		for (Reserva reserv: reservasHuesped) {
			String fechaIni = fechaADias(reserv.getfechaInicio());
			String fechaFin = fechaADias(reserv.getfechaFinal());
			String actual = fechaADias(fechaActual);
			if (fechaIni.compareTo(actual) <= 0 & fechaFin.compareTo(actual) >= 0){
				reserva = reserv;
				hotel.getReservas().get(documentoHuesped).remove(reserv);
				break;
			}
		}
		ArrayList<HabitacionOcupada> habitacionesReserva = reserva.getHabitacionesReserva(); 
		HabitacionOcupada habitacion = null;
		for (HabitacionOcupada hab: habitacionesReserva) {
			if (hab.getId().equals(idHabitacion)) {
				habitacion = hab;
				reserva.getHabitacionesReserva().remove(hab);
				break;
			}
		}
		if (cargarALaCuenta == true) {
			habitacion.addToCuentaPendiente(precioServicio);
		}
		reserva.addHabitacionReserva(habitacion);
		hotel.getReservas().get(documentoHuesped).add(reserva);
		
		
		return habitacion;
	}
	
	public String registrarServicio(Hotel hotel, String idHabitacion, String documentoHuesped, 
			boolean cargarALaCuenta, String nombre, String fechaActual) {
		Servicio servicio = hotel.getServiciosHotel().get(nombre);
		HabitacionOcupada habitacion = buscarHabitacionPorId(hotel, servicio.getPrecio(), idHabitacion, cargarALaCuenta, 
				documentoHuesped, fechaActual);
		String factura = "HOTEL DPOO" + "\n****************************************\n";
		factura += "Habitación " + habitacion.getId() + "\n";
		factura += "---------------------------------------\n";
		factura += "Fecha: " + fechaActual + "\n";
		factura += "Servicio: " + servicio.getNombre() + "\n";
		factura += servicio.getDescripcion() + "\n";
		factura += "---------------------------------------\n";
		factura += "Total a pagar: $" + servicio.getPrecio();
		
		double tarifa = habitacion.getTarifa();
		if (hotel.getModificacionesHabitaciones().keySet().contains(habitacion.getTipoHabitacion())) {
			if (hotel.getModificacionesHabitaciones().get(habitacion.getTipoHabitacion()).containsKey(habitacion.getFechaInicio())) {
				hotel.getServiciosHotel().get(nombre).ofrecido();
				tarifa = hotel.getModificacionesHabitaciones().get(habitacion.getTipoHabitacion()).get(habitacion.getFechaInicio());
			}
		}
		hotel.registrarRelacionServicio(tarifa, servicio.getPrecio());
		
		return factura;
	}
	
	public String registrarConsumoRestaurante(Hotel hotel, String idHabitacion, String documento, 
			boolean cargarALaCuenta, ArrayList<String> nombres, String fechaActual, int horaActual) {
		double total = 0.0;
		String factura = "No se pudo registrar ningún consumo en la franja horaria";
		String detalleConsumo = "";
		for (String nombre: nombres) {
			ProductoMenu producto = hotel.getMenuHotel().get(nombre);
			if (producto.getHoraInicioDisponibilidad() <= horaActual & producto.getHoraFinDisponibilidad() >= horaActual) {
				hotel.getMenuHotel().get(nombre).unidadVendida();
				total += producto.getPrecio();
				detalleConsumo += "*" + nombre + " -> $" + producto.getPrecio() + "\n";
				}
			}
		if (total > 0) {
			HabitacionOcupada habitacion = buscarHabitacionPorId(hotel, total, idHabitacion, cargarALaCuenta, documento, fechaActual);
			factura = "HOTEL DPOO" + "\n****************************************\n";
			factura += "Habitación " + habitacion.getId() + "\n";
			factura += "---------------------------------------\n";
			factura += "Fecha: " + fechaActual + "\n";
			factura += "Servicio: Restaurante\n";
			factura += detalleConsumo;
			factura += "---------------------------------------\n";
			factura += "Total a pagar: $" + total;
			
			//Encontrar tarifa habitación
			double tarifa = habitacion.getTarifa();
			if (hotel.getModificacionesHabitaciones().keySet().contains(habitacion.getTipoHabitacion())) {
				if (hotel.getModificacionesHabitaciones().get(habitacion.getTipoHabitacion()).containsKey(habitacion.getFechaInicio())) {
					tarifa = hotel.getModificacionesHabitaciones().get(habitacion.getTipoHabitacion()).get(habitacion.getFechaInicio());
				}
			}
			hotel.registrarRelacion(tarifa, total);
		}
		
		return factura;
	}
	
	public Map<String, Map<String, Habitacion>> consultarHabitacionesDisponibles(Hotel hotel){
		return hotel.getHabitacionesDisponiblesHotel();
	}
	
	public Map<String, Map<String, ArrayList<HabitacionOcupada>>> consultarHabitacionesOcupadas(Hotel hotel){
		return hotel.getHabitacionesOcupadasHotel();
	}
	
	public Map<String, Servicio> consultarServicios(Hotel hotel){
		return hotel.getServiciosHotel();
	}
	
	public Map<String, ProductoMenu> consultarProductosMenu(Hotel hotel){
		return hotel.getMenuHotel();
	}

}

