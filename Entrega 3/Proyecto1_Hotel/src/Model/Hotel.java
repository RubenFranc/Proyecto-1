package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	private Map<String, Double> registroValorFacturas;
	private Map<Double, Double> relacionPrecioRestauranteHabitacion;
	private Map<Double, Double> relacionPrecioServiciosHabitacion;
	
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
		this.registroValorFacturas = new HashMap<>();
		for (int i=1; i<13;i++) {
			if (i<=9) {
				this.registroValorFacturas.put("0" + Integer.toString(i), 0.0);
			}
			else {
				this.registroValorFacturas.put(Integer.toString(i), 0.0);
			}
			
		}
		this.relacionPrecioRestauranteHabitacion = new HashMap<>();
		this.relacionPrecioServiciosHabitacion = new HashMap<>();
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
	
	public Map<String, Double> getRegistroFacturas(){
		return registroValorFacturas;
	}
	
	public Map<Double, Double> getRelacion(){
		return relacionPrecioRestauranteHabitacion;
	}

	public Map<Double, Double> getRelacionServicio(){
		return relacionPrecioServiciosHabitacion;
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
	
	public void registrarValorFactura(String mes, double valor) {
		this.registroValorFacturas.put(mes, registroValorFacturas.get(mes) + valor);
	}
	
	public void registrarRelacion(double tarifa, double consumo) {
		this.relacionPrecioRestauranteHabitacion.put(tarifa, consumo);
	}
	
	public void registrarRelacionServicio(double tarifa, double precioServicio) {
		this.relacionPrecioServiciosHabitacion.put(tarifa, precioServicio);
	}
	
	public String escogerPasarela(String nombrePasarela) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("../baseDeDatosHotel/pasarelasDePago.txt"));
		String linea = br.readLine();
		String clasePasarela = "";
		if (linea != null) {
			boolean cent = false;
			while (linea != null & !cent) {
				if (linea.contains(nombrePasarela)) {
					clasePasarela = linea.replace("\n", "");
					cent = true;
				}
				linea = br.readLine();
			}
		}
		return clasePasarela;
	}
	
	public void guardarRegistroTransaccion(String nombrePasarela, String resultado, TarjetaPago tarjeta, 
			String documentoHuesped, String cantidadPagar) throws IOException {
		File archivo = new File("../baseDeDatosHotel/registros" + nombrePasarela + ".txt");
		FileReader lectorArchivo = new FileReader(archivo);
		BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
		String linea;
		StringBuilder contenidoArchivo = new StringBuilder();

		while ((linea = bufferLectura.readLine()) != null) {
		    contenidoArchivo.append(linea).append("\n");
		}
		contenidoArchivo.append(nombrePasarela + ";" + documentoHuesped + ";" + resultado + ";" + tarjeta.getNumeroDeCuenta() + ";" +
								cantidadPagar + "\n");

		bufferLectura.close();
		
		FileWriter escritorArchivo = new FileWriter(archivo, false);
		escritorArchivo.write(contenidoArchivo.toString());
		escritorArchivo.close();
	}
			
}
