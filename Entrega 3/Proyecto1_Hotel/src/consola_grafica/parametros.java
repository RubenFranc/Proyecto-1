package consola_grafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class parametros {

	// Colores
	private static Color colorCuerpo = new Color(220, 220, 255); //(220, 220, 255)
	private static Color colorColumna = new Color(240, 240, 240); //(240, 240, 240)
	private static Color colorDerecha = new Color(240, 240, 240); 
    private static Color colorIzquierda = new Color(250, 150, 150); 
    private static Color colorTitulo = new Color(80, 150, 220); // (80, 150, 220)
    private static Color colorSubtitulo = new Color(150, 200, 250); // (150, 200, 250)
	
	public static Color getColorCuerpo() {
		return colorCuerpo;
	}
	public static Color getColorColumna() {
		return colorColumna;
	}
	public static Color getColorDerecha() {
		return colorDerecha;
	}
	public static Color getColorIzquierda() {
		return colorIzquierda;
	}
	public static Color getColorTitulo() {
		return colorTitulo;
	}
	public static Color getColorSubtitulo() {
		return colorSubtitulo;
	}
	
	// Dimensiones
	private static Dimension dimensionVentana = new Dimension(1000, 700);
	private static Dimension dimensionCuerpo = new Dimension(500, 400);
	private static Dimension dimensionColumna = new Dimension(150, 0);
	private static Dimension dimensionDerecha = new Dimension(25, 0); 
    private static Dimension dimensionIzquierda = new Dimension(300, 0); 
    private static Dimension dimensionTitulo = new Dimension(0, 60);
    private static Dimension dimensionSubtitulo = new Dimension(0, 25);
    private static Dimension dimensionBotonBarra = new Dimension(250, 40);
    private static Dimension dimensionBotonArriba = new Dimension(100, 100);
	
    public static Dimension getDimensionVentana() {
		return dimensionVentana;
	}
    public static Dimension getDimensionCuerpo() {
		return dimensionCuerpo;
	}
    public static Dimension getDimensionColumna() {
		return dimensionColumna;
	}
	public static Dimension getDimensionDerecha() {
		return dimensionDerecha;
	}
	public static Dimension getDimensionIzquierda() {
		return dimensionIzquierda;
	}
	public static Dimension getDimensionTitulo() {
		return dimensionTitulo;
	}
	public static Dimension getDimensionSubtitulo() {
		return dimensionSubtitulo;
	}
	public static Dimension getDimensionBotonBarra() {
		return dimensionBotonBarra;
	}
	public static Dimension getDimensionBotonArriba() {
		return dimensionBotonArriba;
	}
	
	// Fuentes
	private static Font fuenteTitulo = new Font("Arial", Font.PLAIN, 40);
	private static Font fuenteBotonBarra = new Font("Arial", Font.PLAIN, 22);
	private static Font fuenteGeneral = new Font("Arial", Font.PLAIN, 18);
	
	public static Font getFuenteTitulo () {
		return fuenteTitulo;
	}
	public static Font getFuenteBotonBarra () {
		return fuenteBotonBarra;
	}
	public static Font getFuenteGeneral () {
		return fuenteGeneral;
	}
}
