package Controlador;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import Model.Habitacion;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.Huesped;
import Model.PasarelaDePagos;
import Model.Reserva;
import Model.Usuario;

public class ControladorUsuario extends ControladorRecepcionista{
	
	public ControladorUsuario() {
		
		super();
	}
	
	public String fechaADias(String fecha) {
		String[] partes = fecha.split("/");
		int dia = Integer.parseInt(partes[0]);
		int mes = Integer.parseInt(partes[1]);
		int fechaADias = dia + mes*30;
		return Integer.toString(fechaADias);
	}
	
	public void cargarUsuario(String correo, String contrasena, Hotel hotel) {
		
		Usuario usuario = new Usuario (correo, contrasena, "U");
		hotel.getUsuarios().put(correo, usuario);
		
	}

	public Map<String , ArrayList<Habitacion>> consultarHabitacionesDisponiblesporFecha(Hotel hotel,String fechaInicio, String fechaFinal){
		Map<String , ArrayList<Habitacion>> habsenFechas= new HashMap<>();
		habsenFechas.put("e", new ArrayList<>());			
		habsenFechas.put("s", new ArrayList<>());			
		habsenFechas.put("sd", new ArrayList<>());
		Map<String, Map<String, Habitacion>> habsDispo= hotel.getHabitacionesDisponiblesHotel();
		Map<String, Map<String, ArrayList<HabitacionOcupada>>> habsOcupa= hotel.getHabitacionesOcupadasHotel();
		Set<String> keys = hotel.getHabitacionesDisponiblesHotel().keySet();
		ArrayList<String> tipos = new ArrayList<>(keys);
		for (String tipo: tipos) {
			Set<String> ids = habsDispo.get(tipo).keySet();
			if (hotel.getHabitacionesDisponiblesHotel().get(tipo).size() != 0) {
			for (String id: ids) {
				
				Habitacion habitacion = habsDispo.get(tipo).get(id);
				habsenFechas.get(tipo).add(habitacion);
				
			}
		}
			
			else if (habsOcupa.get(tipo).keySet().size() > 0) {
				for (String id: habsOcupa.get(tipo).keySet()) {
					boolean cruzada = false;
					for (HabitacionOcupada habitacion: habsOcupa.get(tipo).get(id)) {
						String fechaInicio1 = fechaADias(fechaInicio);
						String fechaFinal1 = fechaADias(fechaFinal);
						String fechaIni = fechaADias(habitacion.getFechaInicio());
						String fechaFin = fechaADias(habitacion.getFechaFinal());
						if ((fechaInicio1.compareTo(habitacion.getFechaFinal()) < 0 & fechaInicio1.compareTo(fechaIni) > 0)|| 
							(fechaFinal1.compareTo(fechaIni) > 0 & fechaFinal1.compareTo(fechaFin) < 0)|| 
							(fechaIni.compareTo(fechaInicio1) > 0 & fechaIni.compareTo(fechaFinal1) < 0)|| 
							(fechaFin.compareTo(fechaInicio1) > 0 & fechaFin.compareTo(fechaFinal1) < 0)||
							(fechaIni.equals(fechaInicio1) & fechaFin.equals(fechaFinal1))) {
							cruzada = true;
						}
						else {
							habsenFechas.get(tipo).add(habitacion);
						}
					}
					
				}
			}
			
		}
		
		return habsenFechas;
	}
	
	
	public String[] generarFacturaReserva(Reserva reserva, Hotel hotel, String clasePasarela) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		ArrayList<String> noches = fechasEnRango(reserva.getfechaInicio(), reserva.getfechaFinal());
		int numeroNoches = noches.size();
		double totalTotal = 0.0;
		String factura = "\nHOTEL DPOO" + "\n****************************************\n";
		factura += "Huésped: " + reserva.getHuesped().getnombre() + "\n";
		factura += "Fecha de ingreso: " + reserva.getfechaInicio() + "\n";
		factura += "Fecha de salida: " + reserva.getfechaFinal() + "\n";
		factura += "Número de noches: " + numeroNoches + "\n";
		factura += "---------------------------------------\n";
		factura += "Consumo por habitación:\n";
		for (HabitacionOcupada habitacion: reserva.getHabitacionesReserva()) {
			ArrayList<String> fechasEnRango = fechasEnRango(reserva.getfechaInicio(), reserva.getfechaFinal());
			double tarifaTotalNochesHabitacion = 0.0;
			if (hotel.getModificacionesHabitaciones().containsKey(habitacion.getTipoHabitacion())) {
				for (String fecha: fechasEnRango) {
					if (hotel.getModificacionesHabitaciones().get(habitacion.getTipoHabitacion()).containsKey(fecha)) {
						tarifaTotalNochesHabitacion += hotel.getModificacionesHabitaciones().get(habitacion.getTipoHabitacion()).get(fecha);
					}
					else {
						tarifaTotalNochesHabitacion += habitacion.getTarifa();
					}
				}
			}
			else {
				tarifaTotalNochesHabitacion = habitacion.getTarifa()*numeroNoches;
			}
			String consumoHabitacion = "Habitación " + habitacion.getId() + " Tarifa total: $" + tarifaTotalNochesHabitacion + "\n";
			factura += consumoHabitacion;
			totalTotal += tarifaTotalNochesHabitacion;
		}
		if (reserva.pagoInmediato()) {
			 totalTotal=totalTotal*(1-(10/100));
		}
		
		factura += "---------------------------------------\n";
		factura += "TOTAL A PAGAR: " + totalTotal;
		factura += "\n****************************************\n\n¡Gracias por su pago temprano de la reserva!";
		
		Class clase = Class.forName(clasePasarela);
		PasarelaDePagos pasarela = (PasarelaDePagos) clase.getDeclaredConstructor(null).newInstance(null);
		String mensajeTransaccion = pasarela.validarPago(reserva.getHuesped().getTarjeta(), totalTotal);
		
		if (mensajeTransaccion.equals("Transacción exitosa")) {
			String[] rta = {factura, (Double.toString(totalTotal)), mensajeTransaccion};
			return rta;
		}
		else {
			String[] rta = {mensajeTransaccion};
			return rta;
		}
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
}