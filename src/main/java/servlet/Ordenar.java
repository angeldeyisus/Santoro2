package servlet;

import Modelo.Usuario;
import Modelo.Carrito;
import Modelo.Orden;
import Modelo.ModeloOrden;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;
import java.text.SimpleDateFormat;



import conexion.Conexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ordenar")
public class Ordenar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = new Date();

            Usuario usuario = (Usuario) request.getSession().getAttribute("auth");

            if (usuario != null) {
                String productId = request.getParameter("producto_id");
                int productQuantity = Integer.parseInt(request.getParameter("cantidad"));
                if (productQuantity <= 0) {
                	productQuantity = 1;
                }
                Orden orden = new Orden();
                orden.setProductoId(Integer.parseInt(productId));
                orden.setUsuarioId(usuario.getUsuarioId());
                orden.setCantidad(productQuantity);
                orden.setFecha(formato.format(fecha));

                ModeloOrden mo = new ModeloOrden(Conexion.getConnection());
                boolean result = mo.insertOrder(orden);
                if (result) {
                    ArrayList<Carrito> carritoLista = (ArrayList<Carrito>) request.getSession().getAttribute("cart-list");
                    if (carritoLista != null) {
                        for (Carrito carrito : carritoLista) {
                            if (carrito.getProductoId() == Integer.parseInt(productId)) {
                                carritoLista.remove(carritoLista.indexOf(carrito));
                                break;
                            }
                        }
                    }
                    response.sendRedirect("ordenes.jsp");
                } else {
                    out.println("orden fallida");
                }
            } else {
                response.sendRedirect("login.jsp");
            }

        } catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
