package Model;

import java.util.ArrayList;

public class Huesped {
	
	private String nombre;
	private String documento;
	private String correo;
	private String celular;
	private ArrayList<String> acompañantes;
	
	public Huesped(String nombre, String documento, String correo, String celular) {
		this.nombre = nombre;
		this.documento = documento;
		this.correo = correo;
		this.celular = celular;
		this.acompañantes = new ArrayList<>();
	}
	
	public String getnombre() {
		return nombre;
	}
	
	public String getDocumento() {
		return documento;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public String getCelular() {
		return celular;
	}
	
	public ArrayList<String> getAcompañantes() {
		return acompañantes;
	}
	
	public void setAcompañantes(ArrayList<String> acompañantes) {
		this.acompañantes = acompañantes;
	}
	
	public void addAcompañante(String acomp) {
		this.acompañantes.add(acomp);
	}

}
