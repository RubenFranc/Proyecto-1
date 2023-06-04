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
import Model.TarjetaPago;

public class ControladorRecepcionista {
	
	public String fechaADias(String fecha) {
		String[] partes = fecha.split("/");
		int dia = Integer.parseInt(partes[0]);
		int mes = Integer.parseInt(partes[1]);
		int fechaADias = dia + mes*30;
		return Integer.toString(fechaADias);
	}
	
	public ArrayList<String> fechasEnRango(String fechaInicio, String fechaFinal){
		ArrayList<String> fechas = new ArrayList<>();
		String fechaI = fechaInicio;
		fechas.add(fechaI);
		while (! fechaI.equals(fechaFinal)) {
			String[] partes = fechaI.split("/");
			int dia = Integer.parseInt(partes[0]) + 1;
			int mes = Integer.parseInt(partes[1]);
			if (dia > 30) {
				dia = 1;
				mes ++;
			}
			String nDia = Integer.toString(dia);
			String nMes = Integer.toString(mes);
			if (dia < 10) {
				nDia = "0" + Integer.toString(dia);
			}
			else {
				nDia = Integer.toString(dia);
			}
			if (mes < 10) {
				nMes = "0" + Integer.toString(mes);
			}
			else {
				nMes = Integer.toString(mes);
			}
			fechaI = nDia + "/" + nMes;
			fechas.add(fechaI);
		}
		return fechas;
	}
	
	public String cancelarReserva(Hotel hotel, String documento, String fechaActual, 
			String fechaInicio, String fechaFinal) {
		ArrayList<Reserva> reservas = hotel.getReservas().get(documento);
		boolean cancelada = false;
		String mensaje = "";
		Reserva reservaCancelada = null;
		try {
			ArrayList<String> noches = fechasEnRango(fechaActual, reservas.get(0).getfechaInicio());
			int diasAnticipacion = noches.size();
			for (Reserva reserva: reservas) {
				if (reserva.getfechaInicio().equals(fechaInicio) & diasAnticipacion >=3) {
					cancelada = true;
					reservaCancelada = reserva;
				}	
			}
			if (cancelada == true) {
				boolean remove = hotel.getReservas().get(documento).remove(reservaCancelada);
				mensaje = "La reserva se canceló con éxito";
				for (HabitacionOcupada hab: reservaCancelada.getHabitacionesReserva()) {
					desocuparHabitaciones(hotel, hab);
				}
				if (hotel.getReservas().get(documento).size() == 0) {
					ArrayList<Reserva> reservaRemovida = hotel.getReservas().remove(documento);
				}
			}
			else if (cancelada == false & diasAnticipacion < 3) {
				mensaje = "No se puede cancelar la reserva menos de 48 horas antes de la fecha de inicio";
			}
		}
		catch (NullPointerException e) {
			mensaje = "No hay ninguna reserva registrada con el documento " + documento + " para las fechas indicadas";
		}
		return mensaje;
		
	}
	
	public void crearReserva(Hotel hotel, String nombre, String documento, String correo, String celular,  //AQUÍ SE AGREGÓ EL BOOLEANO PARA SABER SI SE HIZO PAGO INMEDIATO DE LA RESERVA
			String fechaInicio, String fechaFinal, ArrayList<String> acompañantes, boolean pagoInmediato, TarjetaPago tarjeta) {
		Huesped huesped = new Huesped(nombre, documento, correo, celular, tarjeta);
		huesped.setAcompañantes(acompañantes);
		Reserva reserva = new Reserva(huesped, fechaInicio, fechaFinal, pagoInmediato);
		if (hotel.getReservas().containsKey(documento)){
			hotel.getReservas().get(documento).add(reserva);
		}
		else {
			ArrayList<Reserva> array = new ArrayList<>();
			array.add(reserva);
			hotel.getReservas().put(documento, array);
		}
	}
	
	public HabitacionOcupada habitacionDisponible(Hotel hotel, String fechaInicio, String fechaFinal, 
			String tipoHabitacion, String documentoHuesped) {
		if (hotel.getHabitacionesDisponiblesHotel().get(tipoHabitacion).size() != 0) {
//			System.out.println("ENTRÖ AQUÏ");
			Set<String> keys = hotel.getHabitacionesDisponiblesHotel().get(tipoHabitacion).keySet();
			ArrayList<String> ids = new ArrayList<>(keys);
			Habitacion habitacion = hotel.getHabitacionesDisponiblesHotel().get(tipoHabitacion).get(ids.get(0));
			HabitacionOcupada habOcup = new HabitacionOcupada(habitacion.getTipoHabitacion(), habitacion.getPropiedades(), habitacion.getTarifa(), 
					habitacion.getId(), habitacion.getDisponibilidad());
			habOcup.setDisponibilidad(false);
			habOcup.setFechaInicio(fechaInicio);
			habOcup.setFechaFinal(fechaFinal);
			habOcup.setDocumentoHuesped(documentoHuesped);
			habOcup.setOcupantes();
			
			return habOcup;
		}
		else if (hotel.getHabitacionesOcupadasHotel().get(tipoHabitacion).keySet().size() > 0) {
			for (String id: hotel.getHabitacionesOcupadasHotel().get(tipoHabitacion).keySet()) {
				boolean cruzada = false;
				HabitacionOcupada habOcup1 = null;
				for (HabitacionOcupada habitacion: hotel.getHabitacionesOcupadasHotel().get(tipoHabitacion).get(id)) {
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
//						System.out.println("POR FIN");
//						System.out.println(fechaInicio+"-"+fechaFinal);
//						System.out.println(habitacion.getFechaInicio()+"-"+habitacion.getFechaFinal());
						break;
					}
					else {
						habOcup1 = new HabitacionOcupada(habitacion.getTipoHabitacion(), habitacion.getPropiedades(), 
								habitacion.getTarifa(), habitacion.getId(), habitacion.getDisponibilidad());;
					}
				}
				if (cruzada == false) {				
					habOcup1.setDisponibilidad(false);
					habOcup1.setFechaInicio(fechaInicio);
					habOcup1.setFechaFinal(fechaFinal);
					habOcup1.setDocumentoHuesped(documentoHuesped);
					habOcup1.setOcupantes();
					return habOcup1;
				}
			}
		}
		HabitacionOcupada habOcup2 = new HabitacionOcupada("", "", 0, "", false);
		return habOcup2;
	}
	
	public HabitacionOcupada ocuparHabitacion(Hotel hotel, String fechaInicio, String fechaFinal, 
			String tipoHabitacion, String documentoHuesped) {
		HabitacionOcupada habOcup = habitacionDisponible(hotel, fechaInicio, fechaFinal, tipoHabitacion, documentoHuesped);
		if (hotel.getHabitacionesOcupadasHotel().containsKey(habOcup.getTipoHabitacion())) {
			if (hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).containsKey(habOcup.getId())) {
				hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).add(habOcup);
			}
			else {
				ArrayList<HabitacionOcupada> array = new ArrayList<>();
				array.add(habOcup);
				hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).put(habOcup.getId(),array);
			}
		}
		else if (! habOcup.getId().equals("")) {
			Map<String, ArrayList<HabitacionOcupada>> mapa = new HashMap<>();			
			mapa.put(habOcup.getId(), new ArrayList<>());
			mapa.get(habOcup.getId()).add(habOcup);
			Set<String> keys = hotel.getHabitacionesDisponiblesHotel().get(tipoHabitacion).keySet();
			ArrayList<String> ids = new ArrayList<>(keys);
			hotel.getHabitacionesOcupadasHotel().put(habOcup.getTipoHabitacion(), mapa);
			hotel.getHabitacionesDisponiblesHotel().get(habOcup.getTipoHabitacion()).remove(ids.get(0));
		}
//		System.out.println(habOcup.getId());
		return habOcup;
	}
	
	public void agregarHabitacionAReserva(Reserva reserva, HabitacionOcupada habOcup) {
		reserva.addHabitacionReserva(habOcup);
	}
	
	public double consumoHabitacionesReserva(Reserva reserva) {
		double consumoTotal = 0.0;
		for (HabitacionOcupada habitacion: reserva.getHabitacionesReserva()) {
			consumoTotal += habitacion.getCuentaPendiente();
			consumoTotal += habitacion.getTarifa();
		}
		return consumoTotal;
	}
	
	public String[] generarFacturaFinal(Reserva reserva, Hotel hotel, String clasePasarela) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
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
			String consumoHabitacion = "Habitación " + habitacion.getId() + " (Tarifa total: $" + tarifaTotalNochesHabitacion + "),\n consumo servicios: $" + habitacion.getCuentaPendiente() + "\n";
			factura += consumoHabitacion;
			if (! reserva.pagoInmediato() ) {
				totalTotal += tarifaTotalNochesHabitacion;
				totalTotal += habitacion.getCuentaPendiente();
			}
			else {
				totalTotal += tarifaTotalNochesHabitacion;
				reserva.setPago(false);
			}
		}
		factura += "---------------------------------------\n";
		factura += "TOTAL A PAGAR: " + totalTotal;
		factura += "\n****************************************\n\n¡Vuelva pronto!";
		
		hotel.registrarValorFactura(reserva.getfechaInicio().split("/")[1], totalTotal);
		
		Class clase = Class.forName(clasePasarela);
		PasarelaDePagos pasarela = (PasarelaDePagos) clase.getDeclaredConstructor(null).newInstance(null);
		String mensajeTransaccion = pasarela.validarPago(reserva.getHuesped().getTarjeta(), totalTotal);
		if (mensajeTransaccion.equals("Transacción exitosa")) {
			String[] rta = {factura, (Double.toString(totalTotal)), mensajeTransaccion};
			return rta;
		}
		else {
			String[] rta = {factura, (Double.toString(totalTotal)), mensajeTransaccion};
			return rta;
		}
		
		
	}
	
	public void desocuparHabitaciones(Hotel hotel, HabitacionOcupada habOcup) {
		hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).remove(habOcup);
		if (hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).size() == 0) {
			Habitacion habitacion = new Habitacion(habOcup.getTipoHabitacion(), habOcup.getPropiedades(), habOcup.getTarifa(), habOcup.getId(), habOcup.getDisponibilidad());
			hotel.getHabitacionesDisponiblesHotel().get(habitacion.getTipoHabitacion()).put(habitacion.getId(), habitacion);
		}
	}
	
	public Map<String, Map<String, Habitacion>> consultarHabitacionesDisponibles(Hotel hotel){
		return hotel.getHabitacionesDisponiblesHotel();
	}
	
	public Map<String, Map<String, ArrayList<HabitacionOcupada>>> consultarHabitacionesOcupadas(Hotel hotel){
		return hotel.getHabitacionesOcupadasHotel();
	}
	
}
