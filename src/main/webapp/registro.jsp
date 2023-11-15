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
		<div class="card-header my-3">Crea un usuario</div>
		<div class="row">
                                <br>
                                <form action="nuevoUsuario" method="post">

                                    <input class="form-control" type="text" name="nombre" placeholder="nombre de usuario"><br>
                                    <input class="form-control" type="email" name="email" placeholder="email"><br>
                                    <input class="form-control" type="password" name="pass" placeholder="contraseña"><br>
                                    <input class="btn btn-primary" type="submit" value="Registrar usuario">
                                </form>

		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>