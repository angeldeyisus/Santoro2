package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;



import conexion.Conexion;
import Modelo.ModeloOrden;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cancelarOrden")
public class CancelarOrden extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");
			if(id != null) {
				ModeloOrden mo = new ModeloOrden(Conexion.getConnection());
				mo.cancelOrder(Integer.parseInt(id));
			}
			response.sendRedirect("ordenes.jsp");
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
