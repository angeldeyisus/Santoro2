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

@WebServlet("/cantidad")
public class Cantidad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			ArrayList<Carrito> carritoLista = (ArrayList<Carrito>) request.getSession().getAttribute("cart-list");

			if (action != null && id >= 1) {
				if (action.equals("inc")) {
					for (Carrito carrito : carritoLista) {
						if (carrito.getProductoId() == id) {
							int cantidad = carrito.getCantidad();
							cantidad++;
							carrito.setCantidad(cantidad);
							response.sendRedirect("carrito.jsp");
						}
					}
				}

				if (action.equals("dec")) {
					for (Carrito carrito : carritoLista) {
						if (carrito.getProductoId() == id && carrito.getCantidad() > 1) {
							int cantidad = carrito.getCantidad();
							cantidad--;
							carrito.setCantidad(cantidad);
							break;
						}
					}
					response.sendRedirect("carrito.jsp");
				}
			} else {
				response.sendRedirect("carrito.jsp");
			}
		}
	}

}
