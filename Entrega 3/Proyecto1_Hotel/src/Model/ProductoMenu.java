package Model;

public class ProductoMenu extends Servicio{
	
	private static final boolean enGrupo = false;
	private boolean servicioACuarto;
	private int horaInicioDisponibilidad;
	private int horaFinDisponibilidad;
	
	public ProductoMenu(String nombre, double precio, String descripcion, boolean servicioACuarto,
			int horaInicioDisponibilidad, int horaFinDisponibilidad) {
		super(nombre, precio, descripcion, enGrupo);
		this.servicioACuarto = servicioACuarto;
		this.horaInicioDisponibilidad = horaInicioDisponibilidad;
		this.horaFinDisponibilidad = horaFinDisponibilidad;	
	}

	public boolean getServicioACuarto() {
		return servicioACuarto;
	}
	
	public int getHoraInicioDisponibilidad() {
		return horaInicioDisponibilidad;
	}
	
	public int getHoraFinDisponibilidad() {
		return horaFinDisponibilidad;
	}
	
	public void setServicioACuarto(boolean servicioACuarto) {
		this.servicioACuarto = servicioACuarto;
	}
	
	public void setHoraInicioDisponibilidad(int horaInicioDisponibilidad) {
		this.horaInicioDisponibilidad = horaInicioDisponibilidad;
	}
	
	public void setHoraFinDisponibilidad(int horaFinDisponibilidad) {
		this.horaFinDisponibilidad = horaFinDisponibilidad;
	}
	
}
