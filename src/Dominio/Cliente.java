package Dominio;

public class Cliente {

	private String correo;
	private String password;
	private String tipo;

	public Cliente(String correo, String password) {
		this.correo = correo;
		this.password = password;

	}

	public Cliente() {
		this.correo = null;
		this.password = null;
		this.tipo = null;

	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getcorreo() {
		return correo;
	}

	public void setcorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}