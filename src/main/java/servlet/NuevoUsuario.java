package servlet;

import Modelo.Usuario;
import Modelo.ModeloUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;



import conexion.Conexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author acost
 */
@WebServlet(name = "NuevoUsuario", urlPatterns = {"/nuevoUsuario"})
public class NuevoUsuario extends HttpServlet {
private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
                        String nombre = request.getParameter("nombre");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");

			ModeloUsuario mu = new ModeloUsuario(Conexion.getConnection());
                        
			Usuario usuario = mu.login(email, pass);
			if (usuario != null) {
				request.getSession().setAttribute("auth", usuario);
				response.sendRedirect("index.jsp");
			} else {
				out.println("Usuario no valido");
			}

		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		} 

	}
}
