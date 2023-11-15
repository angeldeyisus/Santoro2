<%@page import="java.text.DecimalFormat"%>
<%@page import="conexion.Conexion"%>
<%@page import="Modelo.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf);
	Usuario usuario = (Usuario) request.getSession().getAttribute("auth");
	List<Orden> ordenes = null;
	if (usuario != null) {
	    request.setAttribute("person", usuario);
            ModeloOrden mo  = new ModeloOrden(Conexion.getConnection());
		ordenes = mo.ordenUsuario(usuario.getUsuarioId());
	}else{
		response.sendRedirect("login.jsp");
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
		<div class="card-header my-3">Todas las ordenes</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Fecha</th>
					<th scope="col">Nombre</th>
					<th scope="col">Categoria</th>
					<th scope="col">Cantidad</th>
					<th scope="col">Precio</th>
					<th scope="col">Cancelar</th>
				</tr>
			</thead>
			<tbody>
			
			<%
			if(ordenes != null){
				for(Orden o:ordenes){%>
					<tr>
						<td><%=o.getFecha() %></td>
						<td><%=o.getNombre() %></td>
						<td><%=o.getCategoria() %></td>
						<td><%=o.getCantidad() %></td>
						<td><%=dcf.format(o.getPrecio()) %></td>
						<td><a class="btn btn-sm btn-danger" href="cancelarOrden?id=<%=o.getOrdenId()%>">Cancelar orden</a></td>
					</tr>
				<%}
			}
			%>
			
			</tbody>
		</table>
	</div>
	<%@include file="/includes/footer.jsp"%>
</body>
</html>