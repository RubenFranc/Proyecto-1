package Model;

import java.util.ArrayList;

public class Reserva {
	
	private Huesped huesped;
	private ArrayList<HabitacionOcupada> habitacionesReserva;
	private String fechaInicio;
	private String fechaFinal;
	
	public Reserva(Huesped huesped, String fechaInicio, String fechaFinal) {
		this.habitacionesReserva = new ArrayList<>();
		this.fechaFinal = fechaFinal;
		this.fechaInicio = fechaInicio;
		this.huesped = huesped;
	}
	
	public void addHabitacionReserva(HabitacionOcupada habitacion) {
		habitacionesReserva.add(habitacion);
	}
	
	public ArrayList<HabitacionOcupada> getHabitacionesReserva(){
		return habitacionesReserva;
	}
	
	public String getfechaInicio() {
		return fechaInicio;
	}
	
	public String getfechaFinal() {
		return fechaFinal;
	}
	
	public Huesped getHuesped() {
		return huesped;
	}

}
