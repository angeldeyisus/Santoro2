package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class ModeloOrden {
	
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    

	public ModeloOrden(Connection con) {
		super();
		this.con = con;
	}

	public boolean insertOrder(Orden orden) {
        boolean result = false;
        try {
            query = "insert into ordenes (producto_id, usuario_id, cantidad, fecha) values(?,?,?,?)";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, orden.getProductoId());
            pst.setInt(2, orden.getUsuarioId());
            pst.setInt(3, orden.getCantidad());
            pst.setString(4, orden.getFecha());
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
	

    public List<Orden> ordenUsuario(int id) {
        List<Orden> lista = new ArrayList<>();
        try {
            query = "select * from ordenes where usuario_id=? order by ordenes.orden_id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Orden orden = new Orden();
                ModeloProducto productDao = new ModeloProducto(this.con);
                int pId = rs.getInt("producto_id");
                Producto product = productDao.getProducto(pId);
                orden.setOrdenId(rs.getInt("orden_id"));
                orden.setProductoId(pId);
                orden.setNombre(product.getNombre());
                orden.setCategoria(product.getCategoria());
                orden.setPrecio(product.getPrecio()*rs.getInt("precio"));
                orden.setCantidad(rs.getInt("cantidad"));
                orden.setFecha(rs.getString("fecha"));
                lista.add(orden);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public void cancelOrder(int id) {
        //boolean result = false;
        try {
            query = "delete from ordenes where orden_id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }
}
