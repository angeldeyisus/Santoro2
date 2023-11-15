package servlet;

import Modelo.Carrito;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "AddCart", urlPatterns = "/addCart")
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
//        	out.print("add to cart servlet");

            ArrayList<Carrito> carritoLista = new ArrayList<>();
            int id = Integer.parseInt(request.getParameter("id"));
            Carrito carrito = new Carrito();
            carrito.setProductoId(id);
            carrito.setCantidad(1);
            HttpSession session = request.getSession();
            ArrayList<Carrito> cart_list = (ArrayList<Carrito>) session.getAttribute("cart-list");
            if (cart_list == null) {
                carritoLista.add(carrito);
                session.setAttribute("cart-list", carritoLista);
                response.sendRedirect("index.jsp");
            } else {
                carritoLista = cart_list;

                boolean exist = false;
                for (Carrito c : cart_list) {
                    if (c.getProductoId() == id) {
                        exist = true;
                        out.println("<h3 style='color:crimson; text-align: center'>El producto ya esta en el carrito. <a href='cart.jsp'>Al carrito</a></h3>");
                    }
                }

                if (!exist) {
                    carritoLista.add(carrito);
                    response.sendRedirect("index.jsp");
                }
            }
        }
	}

}
