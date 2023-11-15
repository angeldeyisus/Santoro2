<%@page import="conexion.Conexion"%>
<%@page import="Modelo.ModeloProducto"%>
<%@page import="Modelo.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
DecimalFormat dcf = new DecimalFormat("#.##");
request.setAttribute("dcf", dcf);
Usuario usuario = (Usuario) request.getSession().getAttribute("auth");
if (usuario != null) {
    request.setAttribute("persona", usuario);
}
ArrayList<Carrito> carritoLista = (ArrayList<Carrito>) session.getAttribute("cart-list");
List<Carrito> productosCarrito = null;
if (carritoLista != null) {
	ModeloProducto mp = new ModeloProducto(Conexion.getConnection());
	productosCarrito = mp.getProductosCarrito(carritoLista);
	double total = mp.getCarritoTotal(carritoLista);
	request.setAttribute("total", total);
	request.setAttribute("cart_list", carritoLista);
}
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>Santoro Carniceria</title>
<style type="text/css">

.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body>
	<%@include file="/includes/navbar.jsp"%>

	<div class="container my-3">
		<div class="d-flex py-3"><h3>Total: $ ${(total>0)?dcf.format(total):0} </h3> <a class="mx-3 btn btn-primary" href="checkOut"></a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Nombre</th>
					<th scope="col">Categoria</th>
					<th scope="col">Precio</th>
					<th scope="col">Comprar</th>
					<th scope="col">Cancelar</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (carritoLista != null) {
					for (Carrito c : productosCarrito) {
				%>
				<tr>
					<td><%=c.getNombre()%></td>
					<td><%=c.getCategoria()%></td>
					<td><%= dcf.format(c.getPrecio())%></td>
					<td>
						<form action="ordenar" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getProductoId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="cantidad?action=inc&id=<%=c.getProductoId()%>"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="cantidad" class="form-control"  value="<%=c.getCantidad()%>" readonly> 
								<a class="btn btn-sm btn-decre" href="cantidad?action=dec&id=<%=c.getProductoId()%>"><i class="fas fa-minus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">comprar</button>
						</form>
					</td>
					<td><a href="removerCarrito?id=<%=c.getProductoId() %>" class="btn btn-sm btn-danger">Remover</a></td>
				</tr>

				<%
				}}%>
			</tbody>
		</table>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>