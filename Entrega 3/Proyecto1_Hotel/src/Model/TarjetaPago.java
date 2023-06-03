package Model;

public class TarjetaPago {

	private double saldoDisponible;
	private String numeroDeCuenta;
	private String contrasenia;
	
	public TarjetaPago(double saldo, String numero, String contrasenia) {
		this.saldoDisponible = saldo;
		this.numeroDeCuenta = numero;
		this.contrasenia = contrasenia;
	}
	
	public String getNumeroDeCuenta() {
		return numeroDeCuenta;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public double getSaldo() {
		return saldoDisponible;
	}
	
}
