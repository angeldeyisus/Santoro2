package Modelo;

public class Usuario {
	private int usuarioId;
	private String nombre;
	private String email;
	private String pass;

	public Usuario() {
	}

	public Usuario(int usuarioId, String nombre, String email, String pass) {
		this.usuarioId = usuarioId;
		this.nombre = nombre;
		this.email = email;
		this.pass = pass;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User [id=" + usuarioId + ", name=" + nombre + ", email=" + email + ", password=" + pass + "]";
	}
	
}
