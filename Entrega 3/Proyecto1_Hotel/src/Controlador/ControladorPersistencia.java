package Controlador;

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

import Model.Habitacion;
import Model.HabitacionOcupada;
import Model.Hotel;
import Model.Huesped;
import Model.ProductoMenu;
import Model.Reserva;
import Model.Servicio;
import Model.TarjetaPago;
import Model.Usuario;

public class ControladorPersistencia {

	public void cargarHabitacionesOcupadas(Hotel hotel, String archivoHabitacioneOcupadas) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoHabitacioneOcupadas));
		String linea = br.readLine();
		if (linea != null) {
			while (linea != null) {
				String[] partes = linea.split(";");
				String tipo = partes[0];
				String propiedades = partes[1];
				String tarif = partes[2];
				String id = partes[3];
				String disponib= partes[4];
				String fechaInicio = partes[5];
				String fechaFinal = partes[6];
				String[] ocups = partes[7].split(",");
				String documento = partes[8];
				String cuenta = partes[9].replace("\n", "");
//				int capacidad = Integer.parseInt(capac);
//				boolean balcon = Boolean.parseBoolean(balc);
//				boolean ventana = Boolean.parseBoolean(vent);
//				boolean cocina = Boolean.parseBoolean(coci);
				boolean disponibilidad = Boolean.parseBoolean(disponib);
				double tarifa = Double.parseDouble(tarif);
				double cuentaPendiente = Double.parseDouble(cuenta);
				HabitacionOcupada habOcup = new HabitacionOcupada(tipo, propiedades, tarifa, id, disponibilidad);//, fechaInicio, fechaFinal, ocups, documento);
				habOcup.setFechaInicio(fechaInicio);
				habOcup.setFechaFinal(fechaFinal);
				habOcup.setOcupantes();
				habOcup.setDocumentoHuesped(documento);
				habOcup.addToCuentaPendiente(cuentaPendiente);
				for (String ocup: ocups) {
					habOcup.addOcupante(ocup);
				}
				if (hotel.getHabitacionesOcupadasHotel().containsKey(habOcup.getTipoHabitacion())) {
					if (hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).containsKey(habOcup.getId())) {
						hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).get(habOcup.getId()).add(habOcup);
					}
					else {
						ArrayList<HabitacionOcupada> array = new ArrayList<>();
						array.add(habOcup);
						hotel.getHabitacionesOcupadasHotel().get(habOcup.getTipoHabitacion()).put(habOcup.getId(),array);
					}
				}
				else {
					Map<String, ArrayList<HabitacionOcupada>> mapa = new HashMap<>();			
					mapa.put(habOcup.getId(), new ArrayList<>());
					mapa.get(habOcup.getId()).add(habOcup);
					hotel.getHabitacionesOcupadasHotel().put(habOcup.getTipoHabitacion(), mapa);
				}
				linea = br.readLine();
			}
			br.close();
		}	
	}
	
	public void guardarArchivoHabitacionesOcupadas(Hotel hotel, String archivoHabitacioneOcupadas) throws IOException {
		File file = new File(archivoHabitacioneOcupadas);
		FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter wr = new PrintWriter(bw);  
        String doc = "";
        Map<String, Map<String, ArrayList<HabitacionOcupada>>> habsOcups = hotel.getHabitacionesOcupadasHotel();
        for (String tipo: habsOcups.keySet()) {
        	for (String id: habsOcups.get(tipo).keySet()) {
        		for (HabitacionOcupada hab: habsOcups.get(tipo).get(id)) {
        			String linea = "";
        			linea += tipo + ";" + hab.getPropiedades() + ";" + hab.getTarifa() + ";" + hab.getId() + ";" + hab.getDisponibilidad() + ";" +
	        			hab.getFechaInicio() + ";" + hab.getFechaFinal() + ";";
        			ArrayList<String> ocupantes = hab.getOcupantes();
        			for (String ocup: ocupantes) {
        				linea += ocup + ",";
        			}
        			String lineaHab = linea.substring(0, linea.length()-1) + ";";
        			lineaHab += hab.getDocumentoHuesped() + ";" + hab.getCuentaPendiente() + "\n";
        			doc += lineaHab;
        		}
        	}
        }
        wr.write(doc);
        wr.close();
        bw.close();
	}
	
	public void cargarHabitacionesDisponibles(Hotel hotel, String archivoHabitacionesDisponibles) throws IOException {				
		hotel.getHabitacionesDisponiblesHotel().put("e", new HashMap<>());			
		hotel.getHabitacionesDisponiblesHotel().put("s", new HashMap<>());			
		hotel.getHabitacionesDisponiblesHotel().put("sd", new HashMap<>());
		BufferedReader br = new BufferedReader(new FileReader(archivoHabitacionesDisponibles));
		String linea = br.readLine();
		if (linea != null) {
			while (linea != null) {
				String[] partes = linea.split(";");
				String id = partes[0];
				String tipo = partes[1];
				String prop = partes[2];
//				String capac = partes[2];
//				String balc = partes[3];
//				String vent = partes[4];
//				String coci = partes[5];
				String tarif = partes[3];
//				System.out.println(tarif);
				String disponib= partes[4].replace("\n", "");
//				int capacidad = Integer.parseInt(capac);
//				boolean balcon = Boolean.parseBoolean(balc);
//				boolean ventana = Boolean.parseBoolean(vent);
//				boolean cocina = Boolean.parseBoolean(coci);
				boolean disponibilidad = Boolean.parseBoolean(disponib);
				double tarifa = Double.parseDouble(tarif);
				Habitacion hab = new Habitacion(tipo, prop, tarifa, id, disponibilidad);//, fechaInicio, fechaFinal, ocups, documento);
				if (hotel.getHabitacionesDisponiblesHotel().containsKey(tipo)) {
					hotel.getHabitacionesDisponiblesHotel().get(tipo).put(id, hab);
				}
				linea = br.readLine();
			}
			br.close();
		}	
	}
	
	public void guardarArchivoHabitacionesDisponibles(Hotel hotel, String archivoHabitacionesDisponibles) throws IOException {
		File file = new File(archivoHabitacionesDisponibles);
		FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter wr = new PrintWriter(bw);  
        String doc = "";
        Map<String, Map<String, Habitacion>> habs = hotel.getHabitacionesDisponiblesHotel();
        for (String tipo: habs.keySet()) {
        	for (String id: habs.get(tipo).keySet()) {
        		Habitacion hab = hotel.getHabitacionesDisponiblesHotel().get(tipo).get(id);
    			String lineaHab = "";
    			lineaHab += hab.getId() + ";" + tipo + ";" + hab.getPropiedades() + ";" + hab.getTarifa() + ";" + hab.getDisponibilidad() + "\n";
        		doc += lineaHab;
        	}
        }
        wr.write(doc);
        wr.close();
        bw.close();
	}
	
	public void cargarModificacionesTarifasHabitaciones(Hotel hotel, String archivoModificacionesTarifaHabitaciones) throws IOException {				
		hotel.getModificacionesHabitaciones().put("e", new HashMap<>());			
		hotel.getModificacionesHabitaciones().put("s", new HashMap<>());			
		hotel.getModificacionesHabitaciones().put("sd", new HashMap<>());
		BufferedReader br = new BufferedReader(new FileReader(archivoModificacionesTarifaHabitaciones));
		String linea = br.readLine();
		if (linea != null) {
			while (linea != null) {
				String[] partes = linea.split(";");
				String tipo = partes[0];
				String fecha = partes[1];
				String tarif = partes[2].replace("\n", "");
				double tarifa = Double.parseDouble(tarif);
				hotel.getModificacionesHabitaciones().get(tipo).put(fecha, tarifa);
				linea = br.readLine();
			}
			br.close();
		}
	}
	
	public void guardarModificacionesTarifasHabitaciones(Hotel hotel, String archivoModificacionesTarifaHabitaciones) throws IOException {
		File file = new File(archivoModificacionesTarifaHabitaciones);
		FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter wr = new PrintWriter(bw);  
        String doc = "";
		Map<String, Map<String, Double>> modificaciones = hotel.getModificacionesHabitaciones();
		for (String tipo: modificaciones.keySet()) {
        	for (String fecha: modificaciones.get(tipo).keySet()) {
        		double tarifa = modificaciones.get(tipo).get(fecha);
        		String lineaMod = tipo + ";" + fecha + ";" + tarifa + "\n";
        		doc += lineaMod;
        	}
		}
		wr.write(doc);
        wr.close();
        bw.close();
	}
	
	public void guardarUsuariosArchivo(Hotel hotel, String archivoUsuarios) throws IOException { // SE AGREGÓ ESTE MÉTODO
		File file = new File(archivoUsuarios);
		FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter wr = new PrintWriter(bw);  
        String doc = "";
        Map<String, Usuario> usuarios = hotel.getUsuarios();
		for (String login: usuarios.keySet()) {
        	Usuario usuario=usuarios.get(login);
        	String lineaMod = usuario.getlogIn() + ";" +usuario.getpassword()+ ";" + usuario.getCargo() + "\n";
        	doc += lineaMod;
        	
		}
		wr.write(doc);
        wr.close();
        bw.close();
	}
	
	public void cargarReservas(Hotel hotel, String archivoReservas) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoReservas));
		String linea = br.readLine();
		if (linea != null) {
			while (linea != null) {
				String[] partes = linea.split(";");
//				for (String i : partes) {
//					System.out.println(i);
//				}
				String documento = partes[0];
				String fechaInicio = partes[1];
				String fechaFinal = partes[2];
				String nombre = partes[3];
				String correo = partes[4];
				String celular = partes[5];
				String[] acomps = partes[6].split(",");
				String[] habs = partes[7].split(",");
				String pago = partes[8];
				String numeroTarjeta = partes[9];
				String saldo = partes[10];
				String contrasenia = partes[11].replace("\n", "");
				double saldi = Double.parseDouble(saldo);
				TarjetaPago tarjeta = new TarjetaPago(saldi, numeroTarjeta, contrasenia);
				boolean pagi = Boolean.parseBoolean(pago);
//				System.out.println(partes[7].replace("\n", "").split(",")[0]);
				Huesped huesped = new Huesped(nombre, documento, correo, celular, tarjeta);
				for (String acomp: acomps) {
					huesped.addAcompañante(acomp);
				}
				ArrayList<HabitacionOcupada> habsReserva = new ArrayList<>();
				for (String infoHab: habs) {
					String[] info = infoHab.split("-");
//					System.out.println(info[0]);
					String id = info[1];
					String tipo = info[0];
					System.out.println(id +" "+tipo);
					ArrayList<HabitacionOcupada> habsOcup = hotel.getHabitacionesOcupadasHotel().get(tipo).get(id);
					boolean encontroHabitacion = false;
					int i = 0;
					while (encontroHabitacion == false & i < habsOcup.size()) {
						HabitacionOcupada habOcup = habsOcup.get(i);
						if (habOcup.getDocumentoHuesped().equals(documento) & habOcup.getFechaInicio().equals(fechaInicio) & 
								habOcup.getFechaFinal().equals(fechaFinal)) {
							habsReserva.add(habOcup);
							encontroHabitacion = true;
						}
						i += 1;
					}
				}
				Reserva reserva = new Reserva(huesped, fechaInicio, fechaFinal, pagi);
				for (HabitacionOcupada habReserva: habsReserva) {
					reserva.addHabitacionReserva(habReserva);
				}
				if (hotel.getReservas().containsKey(documento)) {
					hotel.getReservas().get(documento).add(reserva);
				}
				else {
					ArrayList<Reserva> array = new ArrayList<>();
					array.add(reserva);
					hotel.getReservas().put(documento, array);
				}
				linea = br.readLine();
			}
			br.close();
		}
	}
	
	public void guardarReservas(Hotel hotel, String archivoReservas) throws IOException {
		File file = new File(archivoReservas);
		FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter wr = new PrintWriter(bw);  
        String doc = "";
        Map<String, ArrayList<Reserva>> reservas = hotel.getReservas();
        for (String documento: reservas.keySet()) {
        	for (Reserva it: reservas.get(documento)) {
        		Huesped huesped = it.getHuesped();
        		String linea = documento + ";" + it.getfechaInicio() + ";" + it.getfechaFinal() + ";" +
        				huesped.getnombre() + ";" + huesped.getCorreo() + ";" + huesped.getCelular() + ";";
        		ArrayList<String> acomps = huesped.getAcompañantes();
        		if (acomps.size() == 0) {
        			linea += " ";
        		}
        		else {
            		for (String acomp: acomps) {
            			linea += acomp + ",";
            		}	
        		}
        		String linea1 = linea.substring(0, linea.length()-1) + ";";
        		for (HabitacionOcupada habOcup: it.getHabitacionesReserva()) {
        			linea1 += habOcup.getTipoHabitacion() + "-" + habOcup.getId() + ",";
        		}
        		String lineaReserv = linea1.substring(0, linea1.length()-1) + ";" + it.pagoInmediato();
        		doc += lineaReserv + ";" + it.getHuesped().getTarjeta().getNumeroDeCuenta() + ";" +
        				it.getHuesped().getTarjeta().getSaldo() + ";" + it.getHuesped().getTarjeta().getContrasenia() + "\n";
        	}
		}
        wr.write(doc);
        wr.close();
        bw.close();
	}
	
	public void cargarProductosMenuArchivo(Hotel hotel, String archivoProductos) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoProductos));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String costo = partes[1];
			String descripcion = partes[2];
			String servicioCuarto = partes[3];
			String horaInicio = partes[4];
			String horaFin = partes[5].replace("\n", "");
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
	
	public void guardarProductosMenuArchivo(Hotel hotel, String archivoProductos) throws IOException {
		File file = new File(archivoProductos);
		FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter wr = new PrintWriter(bw);  
        String doc = "";
		Map<String, ProductoMenu> menu = hotel.getMenuHotel();
		for (String nombreProd: menu.keySet()) {
			ProductoMenu prod = menu.get(nombreProd);
			String linea = prod.getNombre() + ";" + prod.getPrecio() + ";" + prod.getDescripcion() + 
				";" + prod.getServicioACuarto() + ";" + prod.getHoraInicioDisponibilidad() + 
				";" + prod.getHoraFinDisponibilidad() + ";" + prod.getUnidadesVendidas() + "\n";
			doc += linea;
		}
		wr.write(doc);
        wr.close();
        bw.close();
	}
	
	public void cargarServiciosArchivo(Hotel hotel, String archivoServicios) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoServicios));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombre = partes[0];
			String costo = partes[1];
			String grupo = partes[2];
			String descripcion = partes[3].replace("\n", "");
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
	
	public void guardarServiciosArchivo(Hotel hotel, String archivoServicios) throws IOException {
		File file = new File(archivoServicios);
		FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter wr = new PrintWriter(bw);  
        String doc = "";
		Map<String, Servicio> servicios = hotel.getServiciosHotel();
		for (String nombreServ: servicios.keySet()) {
			Servicio serv = servicios.get(nombreServ);
			String linea = serv.getNombre() + ";" + serv.getPrecio() + ";" + serv.getEnGrupo() + 
				";" + serv.getDescripcion() + ";" + serv.getVecesOfrecido() + "\n";
			doc += linea;
		}
		wr.write(doc);
        wr.close();
        bw.close();
	}
	
	public void cargarValoresFacturas(Hotel hotel, String archivoFacturas) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoFacturas));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String mes = partes[0];
			String valor = partes[1].replace("\n", "");
			double precio = Double.parseDouble(valor);
			hotel.getRegistroFacturas().put(mes, precio);
			linea = br.readLine();
		}
		br.close();
	}
	
	public void guardarValoresFacturasArchivo(Hotel hotel, String archivoFacturas) throws IOException {
		File file = new File(archivoFacturas);
		FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter wr = new PrintWriter(bw);  
        String doc = "";
		Map<String, Double> valoresFacturas = hotel.getRegistroFacturas();
		for (String mes: valoresFacturas.keySet()) {
			String linea = mes + ";" + valoresFacturas.get(mes) + "\n";
			doc += linea;
		}
		wr.write(doc);
        wr.close();
        bw.close();
	}
	
	public void cargarRelacionRestauranteTarifa(Hotel hotel, String archivoRelaciones) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoRelaciones));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String tarifa = partes[0];
			String restaurante = partes[1].replace("\n", "");
			double precio = Double.parseDouble(tarifa);
			double consumo = Double.parseDouble(restaurante);
			hotel.getRelacion().put(precio, consumo);
			linea = br.readLine();
		}
		br.close();
	}
	
	public void guardarRelacionRestauranteTarifaArchivo(Hotel hotel, String archivoRelaciones) throws IOException {
		File file = new File(archivoRelaciones);
		FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter wr = new PrintWriter(bw);  
        String doc = "";
		Map<Double, Double> relaciones = hotel.getRelacion();
		for (double tarifa: relaciones.keySet()) {
			String linea = tarifa + ";" + relaciones.get(tarifa) + "\n";
			doc += linea;
		}
		wr.write(doc);
        wr.close();
        bw.close();
	}
	
	public void cargarRelacionServiciosTarifa(Hotel hotel, String archivoRelaciones) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivoRelaciones));
		String linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String tarifa = partes[0];
			String servicio = partes[1].replace("\n", "");
			double precio = Double.parseDouble(tarifa);
			double consumo = Double.parseDouble(servicio);
			hotel.getRelacionServicio().put(precio, consumo);
			linea = br.readLine();
		}
		br.close();
	}
	
	public void guardarRelacionServiciosTarifaArchivo(Hotel hotel, String archivoRelaciones) throws IOException {
		File file = new File(archivoRelaciones);
		FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter wr = new PrintWriter(bw);  
        String doc = "";
		Map<Double, Double> relaciones = hotel.getRelacionServicio();
		for (double tarifa: relaciones.keySet()) {
			String linea = tarifa + ";" + relaciones.get(tarifa) + "\n";
			doc += linea;
		}
		wr.write(doc);
        wr.close();
        bw.close();
	}
	
}
