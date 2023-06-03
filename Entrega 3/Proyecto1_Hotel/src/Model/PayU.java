package Model;

public class PayU  extends PasarelaDePagos {
	
	@Override
	public String validarPago(TarjetaPago tarjeta, double cuenta) {
		String mssg = "Transacción exitosa";
		if (tarjeta.getSaldo() < cuenta) {
			return "Saldo insuficiente";
		}
		else if (tarjeta.getNumeroDeCuenta().length() != 10) {
			return "Cuenta inválida";
		}
		return mssg;
	}

}
