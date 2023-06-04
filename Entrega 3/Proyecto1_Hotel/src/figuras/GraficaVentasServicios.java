package figuras;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;

import Model.Hotel;
import Model.ProductoMenu;

public class GraficaVentasServicios {
	
    public GraficaVentasServicios(Hotel hotel) {
        CategoryChart chart = new CategoryChartBuilder()
                .width(800)
                .height(600)
                .title("Ventas Servicios")
                .xAxisTitle("Servicio")
                .yAxisTitle("Veces ofrecido")
                .build();

        Set<String> nombres =  hotel.getServiciosHotel().keySet();
        ArrayList<String> productos = new ArrayList<>();
        ArrayList<Integer> valores = new ArrayList<>();
        for (String nombre: nombres) {
        	productos.add(nombre);
        	valores.add(hotel.getServiciosHotel().get(nombre).getVecesOfrecido());
        }
        
        chart.addSeries("Restaurante DPOO", productos, valores);

        try {
            BitmapEncoder.saveBitmap(chart, "../baseDeDatosHotel/Figuras/serviciosOfrecidos.png", BitmapFormat.PNG);
//            System.out.println("El gráfico se guardó exitosamente como scatter_plot.png");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
//        new SwingWrapper<>(chart).displayChart();
        // TOCA GUARDARLAS
    }
    
}