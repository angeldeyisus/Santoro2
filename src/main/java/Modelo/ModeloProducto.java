package Modelo;

import java.sql.*;
import java.util.*;


public class ModeloProducto {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    

	public ModeloProducto(Connection con) {
		super();
		this.con = con;
	}
	
	
	public List<Producto> getAllProductos() {
        List<Producto> productos = new ArrayList<>();
        try {

            query = "select * from productos";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
            	Producto producto = new Producto();
                producto.setProductoId(rs.getInt("producto_id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCategoria(rs.getString("categoria"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setImg(rs.getString("img"));

                productos.add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return productos;
    }
	
	
	 public Producto getProducto(int id) {
		 Producto row = null;
	        try {
	            query = "select * from productos where producto_id=? ";

	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, id);
	            ResultSet rs = pst.executeQuery();

	            while (rs.next()) {
	            	row = new Producto();
	                row.setProductoId(rs.getInt("producto_id"));
	                row.setNombre(rs.getString("nombre"));
	                row.setCategoria(rs.getString("categoria"));
	                row.setPrecio(rs.getDouble("precio"));
	                row.setImg(rs.getString("img"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }

	        return row;
	    }
	
	public double getCarritoTotal(ArrayList<Carrito> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Carrito item : cartList) {
                    query = "select precio from productos where producto_id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getProductoId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        sum+=rs.getDouble("precio")*item.getCantidad();
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return sum;
    }

    
    public List<Carrito> getProductosCarrito(ArrayList<Carrito> lista) {
        List<Carrito> carritoLista = new ArrayList<>();
        try {
            if (lista.size() > 0) {
                for (Carrito item : lista) {
                    query = "select * from productos where producto_id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getProductoId());
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        Carrito carrito = new Carrito();
                        carrito.setProductoId(rs.getInt("producto_id"));
                        carrito.setNombre(rs.getString("nombre"));
                        carrito.setCategoria(rs.getString("categoria"));
                        carrito.setPrecio(rs.getDouble("precio")*item.getCantidad());
                        carrito.setCantidad(item.getCantidad());
                        carritoLista.add(carrito);
                    }

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return carritoLista;
    }
}
