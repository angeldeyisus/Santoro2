package Modelo;

import java.sql.*;

public class ModeloUsuario {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public ModeloUsuario(Connection con) {
		this.con = con;
	}
	
	public Usuario login(String email, String pass) {
		Usuario usuario = null;
        try {
            query = "select * from usuarios where email=? and pass=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            if(rs.next()){
            	usuario = new Usuario();
            	usuario.setUsuarioId(rs.getInt("usuario_id"));
            	usuario.setNombre(rs.getString("nombre"));
            	usuario.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return usuario;
    }
        
        public Usuario registra(String nombre, String email, String pass) {
		Usuario usuario = null;
        try {
            query = "insert into usuarios values (?,?,?);";
            pst = this.con.prepareStatement(query);
            pst.setString(1, nombre);
            pst.setString(2, email);
            pst.setString(3, pass);
            rs = pst.executeQuery();
            if(rs.next()){
            	usuario = new Usuario();
            	usuario.setUsuarioId(rs.getInt("usuario_id"));
            	usuario.setNombre(rs.getString("nombre"));
            	usuario.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return usuario;
    }
}
