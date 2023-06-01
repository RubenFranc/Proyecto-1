package Model;

import java.util.ArrayList;

public class Habitacion {

	private String id;
	private String tipoHabitacion;
	private String propiedades;
//	private int capacidad;
//	private boolean balcon;
//	private boolean ventana;
//	private boolean cocina;
//	private double metrosCuadrados;
//	private boolean aire;
//	private boolean calefaccion;
//	private String tamanioCama;
//	private boolean cafetera;
//	private boolean sabanasTapetes;
//	private boolean plancha;
//	private boolean secador;
//	private float voltaje;
//	private boolean usbA;
//	private boolean usbC;
//	private boolean incluyeDesayuno;
	private ArrayList<String> ocupantes;
	private double cuentaPendiente;
	private double tarifa;
	private boolean disponibilidad;
	
	public Habitacion(String tipoHabitacion, String propiedades, double tarifa, String id, boolean disponibilidad) {
		this.propiedades = propiedades;
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
	
	public String getPropiedades() {
		return propiedades;
	}
	
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}
//	
//	public int getCapacidad() {
//		return capacidad;
//	}
//	
//	public boolean hasVentana() {
//		return ventana;
//	}
//	
//	public boolean hasCocina() {
//		return cocina;
//	}
//	
//	public boolean hasBalcon() {
//		return balcon;
//	}
	
	public boolean getDisponibilidad() {
		return disponibilidad;
	}
	
}
