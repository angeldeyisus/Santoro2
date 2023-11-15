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
		<div class="card-header my-3">Contactanos</div>
		<div class="tm-container-inner-2 tm-contact-section">
				<div class="row">
					<div class="col-md-6">
						<form action="mailto:santoro.carniceria@gmail.com" enctype="text/plain" method="get" class="tm-contact-form">
					        <div class="form-group">
					          <input type="text" name="name" class="form-control" placeholder="Nombre" required="" />
					        </div>
					        
					        <div class="form-group">
					          <input type="email" name="email" class="form-control" placeholder="Email" required="" />
					        </div>
				
					        <div class="form-group">
					          <textarea rows="5" name="message" class="form-control" placeholder="Mensaje" required=""></textarea>
					        </div>
					
					        <div class="form-group tm-d-flex">
					          <button type="submit" class="tm-btn tm-btn-success tm-btn-right">
					            Enviar
					          </button>
					        </div>
						</form>
					</div>
					<div class="col-md-6">
						<div class="tm-address-box">
							<h4 class="tm-info-title tm-text-success">Encuentranos en</h4>
							<address class="tm-contact-link">
								Matamoros Esquina con Zaragoza Col. Centro, Huatabampo, Mexico
							</address>
							<a href="tel:647-426-5290" class="tm-contact-link">
								<i class="fas fa-phone tm-contact-icon"></i>647-426-5290
							</a>
							<a href="mailto:info@company.co" class="tm-contact-link">
								<i class="fas fa-envelope tm-contact-icon"></i>santoro.carniceria@gmail.com
							</a>
							<div class="tm-contact-social">
								<a href="https://www.facebook.com/people/Santoro-Carniceria/100047549776807/?locale=es_LA" class="tm-social-link"><i class="fab fa-facebook tm-social-icon"></i></a>
								<a href="#" class="tm-social-link"><i class="fab fa-twitter tm-social-icon"></i></a>
								<a href="#" class="tm-social-link"><i class="fab fa-instagram tm-social-icon"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
            
<!-- How to change your own map point
	1. Go to Google Maps
	2. Click on your location point
	3. Click "Share" and choose "Embed map" tab
	4. Copy only URL and paste it within the src="" field below
-->
			<div class="tm-container-inner-2 tm-map-section">
				<div class="row">
					<div class="col-12">
						<div class="tm-map">
							<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d890.1297540150804!2d-109.64175341390252!3d26.823439669414114!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x86b78b2f6381d413%3A0xb858032a055981cc!2sSantoro%20Carnicer%C3%ADa!5e0!3m2!1ses-419!2smx!4v1697565550670!5m2!1ses-419!2smx" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
						</div>
					</div>
				</div>
			</div>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>