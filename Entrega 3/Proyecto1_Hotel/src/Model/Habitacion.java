package Model;

import java.util.ArrayList;

public class Habitacion {

	private String id;
	private String tipoHabitacion;
	private int capacidad;
	private boolean balcon;
	private boolean ventana;
	private boolean cocina;
	private ArrayList<String> ocupantes;
	private double cuentaPendiente;
	private double tarifa;
	private boolean disponibilidad;
	
	public Habitacion(String tipoHabitacion, int capacidad, boolean balcon, boolean ventana, boolean cocina, 
			double tarifa, String id, boolean disponibilidad) {
		this.balcon = balcon;
		this.capacidad = capacidad;
		this.cocina = cocina;
		this.ventana = ventana;
		this.cuentaPendiente = 0.0;
		this.id = id;
		this.tarifa = tarifa;
		this.tipoHabitacion = tipoHabitacion;
		this.ocupantes = new ArrayList<>();
		this.disponibilidad = disponibilidad;	
	}
	
	public void addOcupante(String ocupante) {
		ocupantes.add(ocupante);
	}
	
	public void addToCuentaPendiente(double precio) {
		cuentaPendiente += precio;
	}
	
	public void setDisponibilidad(boolean disponible) {
		this.disponibilidad = disponible;
	}
	
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	public double getTarifa() {
		return tarifa;
	}
	
	public double getCuentaPendiente() {
		return cuentaPendiente;
	}
	
	public String getId() {
		return id;
	}
	
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public boolean hasVentana() {
		return ventana;
	}
	
	public boolean hasCocina() {
		return cocina;
	}
	
	public boolean hasBalcon() {
		return balcon;
	}
	
	public boolean getDisponibilidad() {
		return disponibilidad;
	}
	
}
