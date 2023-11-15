package servlet;

import Modelo.Usuario;
import Modelo.Carrito;
import Modelo.Orden;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import conexion.Conexion;
import Modelo.ModeloOrden;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/checkOut")
public class CheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
			ArrayList<Carrito> carritoLista = (ArrayList<Carrito>) request.getSession().getAttribute("cart-list");
			Usuario usuario = (Usuario) request.getSession().getAttribute("auth");
			if(carritoLista != null && usuario!=null) {
				for(Carrito c:carritoLista) {
					Orden orden = new Orden();
					orden.setProductoId(c.getProductoId());
					orden.setUsuarioId(usuario.getUsuarioId());
					orden.setCantidad(c.getCantidad());
					orden.setFecha(formato.format(date));
					
					ModeloOrden mo = new ModeloOrden(Conexion.getConnection());
					boolean result = mo.insertOrder(orden);
					if(!result) break;
				}
				carritoLista.clear();
				response.sendRedirect("ordenes.jsp");
			}else {
				if(usuario==null) {
					response.sendRedirect("login.jsp");
				}
				response.sendRedirect("carrito.jsp");
			}
		} catch (ClassNotFoundException|SQLException e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
