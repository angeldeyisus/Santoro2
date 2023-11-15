<%@page import="Modelo.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	Usuario usuario = (Usuario) request.getSession().getAttribute("auth");
	if (usuario != null) {
		response.sendRedirect("index.jsp");
	}
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
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">Iniciar Sesion</div>
			<div class="card-body">
				<form action="login" method="post">
					<div class="form-group">
						<label></label> 
						<input type="email" name="login-email" class="form-control" placeholder="Ingresa tu email">
					</div>
					<div class="form-group">
						<label></label> 
						<input type="password" name="login-password" class="form-control" placeholder="contraseña">
					</div>
					<div class="text-center">
						<button type="submit" class="tm-btn tm-btn-success tm-btn-right">Iniciar Sesion</button>
					</div>
				</form>
                            <div class="text-center">
                            <div class="signup-section">No tienes cuenta? <a href="registro.jsp" class="text-info"> Registrate</a>.</div>
                            </div>
			</div>
		</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>