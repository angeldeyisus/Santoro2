package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Modelo.Carrito;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/removerCarrito")
public class RemoverCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");
			if (id != null) {
				ArrayList<Carrito> carritoLista = (ArrayList<Carrito>) request.getSession().getAttribute("cart-list");
				if (carritoLista != null) {
					for (Carrito carrito : carritoLista) {
						if (carrito.getProductoId() == Integer.parseInt(id)) {
							carritoLista.remove(carritoLista.indexOf(carrito));
							break;
						}
					}
				}
				response.sendRedirect("carrito.jsp");

			} else {
				response.sendRedirect("carrito.jsp");
			}

		}
	}

}
