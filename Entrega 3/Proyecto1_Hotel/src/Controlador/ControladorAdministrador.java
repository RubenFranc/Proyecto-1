package Controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Model.Habitacion;
import Model.Hotel;
import Model.ProductoMenu;
import Model.Servicio;

public class ControladorAdministrador {

	public void cargarHabitacionesArchivo(String archivoHabitaciones, Hotel hotel) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoHabitaciones));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String id = partes[0];
			String tipo = partes[1];
			String prop = partes[2];
//			String balc = partes[3];
//			String vent = partes[4];
//			String coci = partes[5];
			String tarif = partes[6];
			String disponib = partes[7].replace("\n", "");
//			int capacidad = Integer.parseInt(capac);
//			boolean balcon = Boolean.parseBoolean(balc);
//			boolean ventana = Boolean.parseBoolean(vent);
//			boolean cocina = Boolean.parseBoolean(coci);
			boolean disponibilidad = Boolean.parseBoolean(disponib);
			double tarifa = Double.parseDouble(tarif);
			Habitacion habitacion = new Habitacion(tipo, prop, tarifa, id, disponibilidad);
			if (hotel.getHabitacionesDisponiblesHotel().containsKey(tipo)) {
				hotel.getHabitacionesDisponiblesHotel().get(tipo).put(id, habitacion);
			}
			else {
				Map<String, Habitacion> mapa = new HashMap<>();
				mapa.put(id, habitacion);
				hotel.getHabitacionesDisponiblesHotel().put(tipo, mapa);
			}
			linea = br.readLine();
		}
		br.close();
	}
	
	public void crearHabitacion(String id, String tipo, String propiedades, double tarifa, 
			boolean disponibilidad, Hotel hotel) {
		Habitacion habitacion = new Habitacion(tipo, propiedades, tarifa, id, disponibilidad);
		if (hotel.getHabitacionesDisponiblesHotel().containsKey(tipo)) {
			hotel.getHabitacionesDisponiblesHotel().get(tipo).put(id, habitacion);
		}
		else {
			Map<String, Habitacion> mapa = new HashMap<>();
			mapa.put(id, habitacion);
			hotel.getHabitacionesDisponiblesHotel().put(tipo, mapa);
		}
	}
	
	public void cargarProductosMenuArchivo(String archivoProductos, Hotel hotel) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoProductos));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String costo = partes[1];
			String descripcion = partes[2];
			String servicioCuarto = partes[3];
			String horaInicio = partes[4];
			String horaFin = partes[5];
			String unidades = partes[6].replace("\n", "");
			double precio = Double.parseDouble(costo);
			boolean servicioACuarto = Boolean.parseBoolean(servicioCuarto);
			int horaInicioDisponibilidad = Integer.parseInt(horaInicio);
			int horaFinDisponibilidad = Integer.parseInt(horaFin);
			int unidadesVendidas = Integer.parseInt(unidades);
			ProductoMenu producto = new ProductoMenu(nombre, precio, descripcion, servicioACuarto,
					horaInicioDisponibilidad, horaFinDisponibilidad, unidadesVendidas);
			hotel.getMenuHotel().put(nombre, producto);
			linea = br.readLine();
		}
		br.close();
	}
	
	public void cargarServiciosArchivo(String archivoServicios, Hotel hotel) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoServicios));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String costo = partes[1];
			String grupo = partes[2];
			String descripcion = partes[3];
			String vecesOfrecido = partes[4].replace("\n", "");
			double precio = Double.parseDouble(costo);
			boolean enGrupo = Boolean.parseBoolean(grupo);
			int veces = Integer.parseInt(vecesOfrecido);
			Servicio servicio = new Servicio(nombre, precio, descripcion, enGrupo, veces);
			hotel.getServiciosHotel().put(nombre, servicio);
			linea = br.readLine();
		}
		br.close();
	}
	
	public ArrayList<String> fechasEnRango(String fechaInicio, String fechaFinal){
		ArrayList<String> fechas = new ArrayList<>();
		String fechaI = fechaInicio;
		fechas.add(fechaI);
		while (! fechaI.equals(fechaFinal)) {
			String[] partes = fechaI.split("/");
			int dia = Integer.parseInt(partes[0]) + 1;
			int mes = Integer.parseInt(partes[1]);
			if (dia > 30) {
				dia = 1;
				mes ++;
			}
			String nDia = Integer.toString(dia);
			String nMes = Integer.toString(mes);
			if (dia < 10) {
				nDia = "0" + Integer.toString(dia);
			}
			else {
				nDia = Integer.toString(dia);
			}
			if (mes < 10) {
				nMes = "0" + Integer.toString(mes);
			}
			else {
				nMes = Integer.toString(mes);
			}
			fechaI = nDia + "/" + nMes;
			fechas.add(fechaI);
		}
		return fechas;
	}
	
	public void asignarTarifasHabitaciones(String tipoHabitacion, String fechaInicio, String fechaFinal,
			double nuevaTarifa, Hotel hotel) {
		ArrayList<String> fechas = fechasEnRango(fechaInicio, fechaFinal);
		if (hotel.getModificacionesHabitaciones().containsKey(tipoHabitacion)) {
			for (String fecha: fechas) {
				if (hotel.getModificacionesHabitaciones().get(tipoHabitacion).containsKey(fecha)) {
					if (hotel.getModificacionesHabitaciones().get(tipoHabitacion).get(fecha) < nuevaTarifa) {
						hotel.getModificacionesHabitaciones().get(tipoHabitacion).put(fecha, nuevaTarifa);
					}	
				}
				else {
					hotel.getModificacionesHabitaciones().get(tipoHabitacion).put(fecha, nuevaTarifa);
				}
			}
		}
		else {
			hotel.getModificacionesHabitaciones().put(tipoHabitacion, new HashMap<>());
			for (String fecha1: fechas) {
				hotel.getModificacionesHabitaciones().get(tipoHabitacion).put(fecha1, nuevaTarifa);
			}
		}
	}
	
	public String cambiarTarifaServicio(String nombre, double nuevoPrecio, Hotel hotel) {
		if (hotel.getServiciosHotel().containsKey(nombre)) {
			hotel.getServiciosHotel().get(nombre).setPrecio(nuevoPrecio);
			return "La nueva tarifa del servicio de " + nombre + " es " + nuevoPrecio;
		}
		else {
			return "El servicio de " + nombre + " no se encuentra en los ofrecidos por el hotel";
		}
	}
	
	public String cambiarInfoProductoRestaurante(String nombre, double nuevoPrecio, boolean servicioACuarto,
			int horaInicio, int horaFinal, Hotel hotel) {
		if (hotel.getMenuHotel().containsKey(nombre)) {
			hotel.getMenuHotel().get(nombre).setPrecio(nuevoPrecio);
			hotel.getMenuHotel().get(nombre).setServicioACuarto(servicioACuarto);
			hotel.getMenuHotel().get(nombre).setHoraInicioDisponibilidad(horaInicio);
			hotel.getMenuHotel().get(nombre).setHoraFinDisponibilidad(horaFinal);
			return "Se actualizó la información del producto " + nombre + " del menú";
		}
		else {
			return "El producto " + nombre + " no se encuentra entre los productos del restaurante";
		}
	}
	
}
