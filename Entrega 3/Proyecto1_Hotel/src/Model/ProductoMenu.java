package Model;

public class ProductoMenu extends Servicio{
	
	private static final boolean enGrupo = false;
	private boolean servicioACuarto;
	private int horaInicioDisponibilidad;
	private int horaFinDisponibilidad;
	private int unidadesVendidas;
	
	public ProductoMenu(String nombre, double precio, String descripcion, boolean servicioACuarto,
			int horaInicioDisponibilidad, int horaFinDisponibilidad, int unidades) {
		super(nombre, precio, descripcion, enGrupo, unidades);
		this.servicioACuarto = servicioACuarto;
		this.horaInicioDisponibilidad = horaInicioDisponibilidad;
		this.horaFinDisponibilidad = horaFinDisponibilidad;	
		this.unidadesVendidas = unidades;
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
	
	public void unidadVendida() {
		this.unidadesVendidas += 1;
	}
	
	public int getUnidadesVendidas() {
		return unidadesVendidas;
	}
	
}
