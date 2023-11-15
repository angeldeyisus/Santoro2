package Modelo;

public class Orden extends Producto{
	private int ordenId;
	private int usuarioId;
	private int cantidad;
	private String fecha;
	
	public Orden() {
	}
	
	public Orden(int ordenId, int usuarioId, int cantidad, String fecha) {
		super();
		this.ordenId = ordenId;
		this.usuarioId = usuarioId;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public Orden(int usuariId, int cantidad, String fecha) {
		super();
		this.usuarioId = usuariId;
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public int getOrdenId() {
		return ordenId;
	}
	public void setOrdenId(int ordenId) {
		this.ordenId = ordenId;
	}
	
	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
