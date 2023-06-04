package Model;

public class Servicio {

	private String nombre;
	private double precio;
	private String descripcion;
	private boolean enGrupo;
	private int vecesOfrecido;
	
	public Servicio(String nombre, double precio, String descripcion,boolean enGrupo, int veces) {
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.enGrupo = enGrupo;
		this.vecesOfrecido = veces;
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
	
	public void ofrecido() {
		this.vecesOfrecido += 1;
	}
	
	public int getVecesOfrecido() {
		return vecesOfrecido;
	}
	
}
