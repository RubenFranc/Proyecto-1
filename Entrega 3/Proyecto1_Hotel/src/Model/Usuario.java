package Model;

public class Usuario {
	
	private String logIn;
	private String password;
	private String cargo;
	
	public Usuario(String logIn, String password, String cargo) {
		this.cargo = cargo;
		this.logIn = logIn;
		this.password = password;
	}
	
	public String getCargo() {
		return cargo;
	}

	public String getlogIn() { // SE AGREGÓ ESTE MÉTODO
		return logIn;
	}
	
	public String getpassword() { // SE AGREGÓ ESTE MÉTODO
		return password;
	}

	public boolean verificarIdentificacion(String contrasenia) {
		if (password.equals(contrasenia)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
