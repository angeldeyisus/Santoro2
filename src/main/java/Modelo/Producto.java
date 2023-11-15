package Modelo;

public class Producto {
	private int productoId;
	private String nombre;
	private String categoria;
	private Double precio;
	private String img;
	
	
	public Producto() {
	}

	
	public Producto(int productoId, String nombre, String categoria, Double precio, String img) {
		super();
		this.productoId = productoId;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.img = img;
	}


	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Product [id=" + productoId + ", name=" + nombre + ", category=" + categoria + ", price=" + precio + ", image="
				+ img + "]";
	}
	
	
}
