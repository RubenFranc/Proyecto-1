package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hotel {
	
	private Map<String, Usuario> usuarios;
	private Map<String, Servicio> servicios;
	private Map<String, Map<String, Habitacion>> habitacionesDisponibles;
	private Map<String, Map<String, ArrayList<HabitacionOcupada>>> habitacionesOcupadas;
	private Map<String, ProductoMenu> menu;
	private Map<String, ArrayList<Reserva>> reservas;
	private Map<String, Map<String, Double>> modificacionesTarifasHabitaciones;
	private Map<String, ArrayList<Huesped>> huespedes;
	
	private String propiedades = "true,true,true,true,true,true,true,true";
	
	public Hotel() {
		this.habitacionesDisponibles = new HashMap<>();
		this.habitacionesOcupadas = new HashMap<>();
		this.servicios = new HashMap<>();
		this.usuarios = new HashMap<>();
		this.menu = new HashMap<>();
		this.reservas = new HashMap<>();
		this.modificacionesTarifasHabitaciones = new HashMap<>();	
		this.huespedes = new HashMap<>();
	}
	
	public Map<String, Map<String, Habitacion>> getHabitacionesDisponiblesHotel(){
		return habitacionesDisponibles;
	}
	
	public Map<String, Map<String, ArrayList<HabitacionOcupada>>> getHabitacionesOcupadasHotel(){
		return habitacionesOcupadas;
	}
	
	public Map<String, Servicio> getServiciosHotel(){
		return servicios;
	}
	
	public Map<String, ProductoMenu> getMenuHotel(){
		return menu;
	}
	
	public Map<String, ArrayList<Reserva>> getReservas(){
		return reservas;
	}
	
	public Map<String, Usuario> getUsuarios(){
		return usuarios;
	}
	
	public Map<String, Map<String, Double>> getModificacionesHabitaciones(){
		return modificacionesTarifasHabitaciones;
	}
	
	public Map<String, ArrayList<Huesped>> getHuespedes(){
		return huespedes;
	}
	
	public String getPropiedadesHotel() {
		return propiedades;
	}
			
}
