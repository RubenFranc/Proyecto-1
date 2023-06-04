package figuras;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.knowm.xchart.*;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.Marker;
import org.knowm.xchart.style.markers.SeriesMarkers;

import Model.Hotel;

public class GraficaRelacionServiciosTarifa {
	
    public GraficaRelacionServiciosTarifa(Hotel hotel) {
    	
    	Set<Double> llaves =  hotel.getRelacionServicio().keySet();
        ArrayList<Double> tarifas = new ArrayList<>();
        tarifas.add(0.0);
        ArrayList<Double> consumos = new ArrayList<>();
        consumos.add(0.0);
        
        for (double tarifa: llaves) {
        	tarifas.add(tarifa);
        	consumos.add(hotel.getRelacion().get(tarifa));
        }
        
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.setTitle("Relación entre la tarifa por noche y el consumo de servicios\n(no incluye el restaurante)");
        chart.setXAxisTitle("Tarifa habitación por noche");
        chart.setYAxisTitle("Consumo servicios del hotel");

        XYSeries series = chart.addSeries("Hotel DPOO", tarifas, consumos);

        series.setLineStyle(SeriesLines.NONE);
        series.setMarker(SeriesMarkers.CIRCLE);

        try {
            BitmapEncoder.saveBitmap(chart, "../baseDeDatosHotel/Figuras/relacionServiciosTarifa.png", BitmapFormat.PNG);
//            System.out.println("El gráfico se guardó exitosamente como scatter_plot.png");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
//        new SwingWrapper<>(chart).displayChart();
    }
}