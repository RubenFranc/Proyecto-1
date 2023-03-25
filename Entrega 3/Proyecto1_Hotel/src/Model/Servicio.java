package Model;

public class Servicio {

	private String nombre;
	private double precio;
	private String descripcion;
	private boolean enGrupo;
	
	public Servicio(String nombre, double precio, String descripcion,boolean enGrupo) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.enGrupo = enGrupo;
	}
	
	public void setPrecio(double nuevoPrecio) {
		this.precio = nuevoPrecio;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public boolean getEnGrupo() {
		return enGrupo;
	}
	
}
