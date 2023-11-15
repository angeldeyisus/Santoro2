<%@page import="conexion.Conexion"%>
<%@page import="Modelo.ModeloProducto"%>
<%@page import="Modelo.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
Usuario usuario = (Usuario) request.getSession().getAttribute("auth");
if (usuario != null) {
    request.setAttribute("person", usuario);
}
ModeloProducto mp = new ModeloProducto(Conexion.getConnection());
List<Producto> productos = mp.getAllProductos();
ArrayList<Carrito> carritoLista = (ArrayList<Carrito>) session.getAttribute("cart-list");
if (carritoLista != null) {
	request.setAttribute("cart_list", carritoLista);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>Santoro Carniceria</title>
</head>
<body>
    
	<%@include file="/includes/navbar.jsp"%>
    
	<div class="container">
            
            <img src="img/banner.jpg" alt=""/>
		<div class="card-header my-3">Todos los productos</div>
		<div class="row">
			<%
			if (!productos.isEmpty()) {
				for (Producto p : productos) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="img/gallery/<%=p.getImg() %>"
						alt="Card img">
					<div class="card-body">
						<h5 class="card-title"><%=p.getNombre() %></h5>
						<h6 class="price">Price: $<%=p.getPrecio() %></h6>
						<h6 class="category">Category: <%=p.getCategoria() %></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a class="btn btn-dark" href="addCart?id=<%=p.getProductoId()%>">Al Carrito</a> <a
								class="btn btn-primary" href="ordenar?cantidad=1&id=<%=p.getProductoId()%>">Comprar</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("Lo lamento no tenemos productos disponibles");
			}
			%>

		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>