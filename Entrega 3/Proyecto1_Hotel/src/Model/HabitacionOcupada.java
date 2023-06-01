package Model;

import java.util.ArrayList;

public class HabitacionOcupada extends Habitacion{
	
	private String fechaInicio;
	private String fechaFinal;
	private ArrayList<String> ocupantes;
	private String documentoHuesped;

	public HabitacionOcupada(String tipoHabitacion, String propiedades,
			double tarifa, String id, boolean disponibilidad) {
		super(tipoHabitacion, propiedades, tarifa, id, disponibilidad);
		this.ocupantes = new ArrayList<>();
	}
	
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	public void setOcupantes() {
		this.ocupantes = new ArrayList<>();
	}
	
	public void setDocumentoHuesped(String documento) {
		this.documentoHuesped = documento;
	}
	
	public void addOcupante(String ocupante) {
		ocupantes.add(ocupante);
	}
	
	public void addOcupantes(ArrayList<String> ocupantes) {
		this.ocupantes = ocupantes;
	}
	
	public ArrayList<String> getOcupantes(){
		return ocupantes;
	}
	
	public String getFechaInicio() {
		return fechaInicio;
	}
	
	public String getFechaFinal() {
		return fechaFinal;
	}
	
	public String getDocumentoHuesped() {
		return documentoHuesped;
	}

}
