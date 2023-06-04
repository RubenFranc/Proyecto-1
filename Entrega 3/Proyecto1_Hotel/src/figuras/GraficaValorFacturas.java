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

public class GraficaValorFacturas {
	
    public GraficaValorFacturas(Hotel hotel) {
        CategoryChart chart = new CategoryChartBuilder()
                .width(800)
                .height(600)
                .title("Valor de las facturas a lo largo del año")
                .xAxisTitle("Meses del año")
                .yAxisTitle("Valor total de las facturas")
                .build();

        Set<String> llaves =  hotel.getRegistroFacturas().keySet();
        ArrayList<String> meses = new ArrayList<>();
        ArrayList<Double> valores = new ArrayList<>();
        for (String mes: llaves) {
        	meses.add(mes);
        	valores.add(hotel.getRegistroFacturas().get(mes));
        }
        
        chart.addSeries("Hotel DPOO", meses, valores);

        try {
            BitmapEncoder.saveBitmap(chart, "../baseDeDatosHotel/Figuras/valorFacturasPorMes.png", BitmapFormat.PNG);
//            System.out.println("El gráfico se guardó exitosamente como scatter_plot.png");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
//        new SwingWrapper<>(chart).displayChart();
        // TOCA GUARDARLAS
    }
    
}